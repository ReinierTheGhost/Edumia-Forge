package com.legends.edumia.worldgen.map;

import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.utils.resources.FileType;
import com.legends.edumia.utils.resources.FileUtils;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiomesData;
import com.legends.edumia.worldgen.chunkgen.map.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EdumiaMapGeneration {
    private FileUtils fileUtils;
    private LoggerUtil loggerUtil;
    private static final int WATER_BUFFER = 28;
    private static final float WATER_HEIGHT_MULTIPLIER = 1.0f;

    public EdumiaMapGeneration() throws Exception {
        fileUtils = FileUtils.getInstance();
        loggerUtil = LoggerUtil.getInstance();
        generate();
    }

    public void generate() throws Exception {
        loggerUtil.logInfoMsg("");
        loggerUtil.logInfoMsg("================ EdumiaMapGeneration ================");

        BufferedImage initialMap = getInitialImage();

        if(initialMap == null){
            throw new Exception(this + " : The image of the map in resource has created an error and operation cannot continue.");
        }

        loggerUtil.logInfoMsg("Validating BIOME generation availability;");

        int iterationToGenerate = (EdumiaMapConfigs.FORCE_GENERATION)
                ? EdumiaMapConfigs.MAP_ITERATION + 1
                : findAmountOfIterationToGenerate(initialMap);

        if(iterationToGenerate > 0){
            loggerUtil.logInfoMsg("Begin BIOME generation;");
            generateBiomes(initialMap, iterationToGenerate);
        }

        loggerUtil.logInfoMsg("Validating HEIGHT generation availability;");
        if(!validateHeightDatas(initialMap)){
            loggerUtil.logInfoMsg("Begin HEIGHT generation;");
            generateHeight(initialMap);
        }
    }

    private BufferedImage getInitialImage(){
        loggerUtil.logInfoMsg("Validating ORIGINAL image existence;");
        BufferedImage initialImage = fileUtils.getResourceImage(EdumiaMapConfigs.INITIAL_IMAGE);
        if(initialImage == null){
            loggerUtil.logError("Initial map image couldn't be found!");
            return null;
        }
        loggerUtil.logInfoMsg("Validating ORIGINAL image size;");
        if(initialImage.getWidth() % EdumiaMapConfigs.REGION_SIZE != 0 || initialImage.getHeight() % EdumiaMapConfigs.REGION_SIZE != 0){
            loggerUtil.logError("Initial map image has the wrong size!");
            return null;
        }

        return initialImage;
    }

    private int findAmountOfIterationToGenerate(BufferedImage initialMap) {
        int currentRegionAmountX = initialMap.getWidth() / EdumiaMapConfigs.REGION_SIZE;
        int currentRegionAmountY = initialMap.getHeight() / EdumiaMapConfigs.REGION_SIZE;
        int absoluteMapIteration = EdumiaMapConfigs.MAP_ITERATION + 1;

        for(int i = 0; i < absoluteMapIteration; i++){
            if(i > 0){
                currentRegionAmountX *= 2;
                currentRegionAmountY *= 2;
            }

            for(int x = 0; x < currentRegionAmountX; x ++){
                for(int y = 0; y < currentRegionAmountY; y ++) {
                    String path = EdumiaMapConfigs.BIOME_PATH.formatted(i) + EdumiaMapConfigs.IMAGE_NAME.formatted(x,y);
                    if(fileUtils.getRunImage(path) == null){
                        loggerUtil.logError("TO REMOVE - Lacking biome file at : [%s]".formatted(path));
                        return absoluteMapIteration - i;
                    }
                }
            }
        }
        return 0;
    }

    private BufferedImage[][][] generateBiomes(BufferedImage initialImage, int missingIterationAmount) {
        int startingIteration = EdumiaMapConfigs.MAP_ITERATION + 1 - missingIterationAmount;
        if(startingIteration == 0){
            generateInitialBiomes(initialImage);
            startingIteration ++;
        }

        for(int i = startingIteration; i < EdumiaMapConfigs.MAP_ITERATION + 1; i ++){
            ExecutorService executorService = Executors.newFixedThreadPool(EdumiaMapConfigs.THREAD_POOL_SIZE);

            int regionAmountX = (int) (initialImage.getWidth() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, i - 1));
            int regionAmountY = (int) (initialImage.getHeight() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, i - 1));

            for(int x = 0; x < regionAmountX; x++){
                for(int y = 0; y < regionAmountY; y++){
                    int finalI = i;
                    int finalX = x;
                    int finalY = y;
                    executorService.submit(() -> {
                        String path = EdumiaMapConfigs.BIOME_PATH.formatted(finalI - 1) + EdumiaMapConfigs.IMAGE_NAME.formatted(finalX, finalY);
                        BufferedImage[][] subidivedRegions = ImageUtils.subdivide(fileUtils.getRunImage(path));

                        for(int j = 0; j < 2; j ++){
                            for(int k = 0; k < 2; k ++){
                                fileUtils.saveImage(
                                        subidivedRegions[j][k],
                                        EdumiaMapConfigs.BIOME_PATH.formatted(finalI),
                                        EdumiaMapConfigs.IMAGE_NAME.formatted((finalX * 2) + j, (finalY * 2) + k),
                                        FileType.Png
                                );
                            }
                        }
                    });
                }
            }
            // Awaits for tasks to finish
            boolean finishedTasks = false;
            try {
                finishedTasks = executorService.awaitTermination(20, TimeUnit.MINUTES);
            } catch (Exception e) {
                loggerUtil.logError("Error while generating biomes");
            }
            if(!finishedTasks) loggerUtil.logError("Didn't finished biome map generation in time, " +
                    "please allocate more RAM, delete the /data/edumia folder and restart the game");

            // Shutdown the executor and wait for all threads to finish
            executorService.shutdown();
            if(!finishedTasks) {
                try {
                    executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                } catch (Exception e) {
                    loggerUtil.logError("Error while generating biomes");
                }
            }
        }
        return new BufferedImage[0][][];
    }

    private void generateInitialBiomes(BufferedImage initialImage){
        if(initialImage.getWidth() != EdumiaMapConfigs.REGION_SIZE || initialImage.getWidth() !=  EdumiaMapConfigs.REGION_SIZE){
            loggerUtil.logError("TO REMOVE - Need splitting for the initial image!");
            for(int i = 0; i < initialImage.getWidth() / EdumiaMapConfigs.REGION_SIZE; i++){
                for(int j = 0; j < initialImage.getHeight() / EdumiaMapConfigs.REGION_SIZE; j++){
                    BufferedImage newImage = initialImage.getSubimage(EdumiaMapConfigs.REGION_SIZE * i, EdumiaMapConfigs.REGION_SIZE * j, EdumiaMapConfigs.REGION_SIZE, EdumiaMapConfigs.REGION_SIZE);
                    fileUtils.saveImage(newImage, EdumiaMapConfigs.BIOME_PATH.formatted(0), EdumiaMapConfigs.IMAGE_NAME.formatted(i,j), FileType.Png);
                }
            }
        } else {
            fileUtils.saveImage(initialImage, EdumiaMapConfigs.BIOME_PATH.formatted(0), EdumiaMapConfigs.IMAGE_NAME.formatted(0,0), FileType.Png);
        }
    }

    private boolean validateHeightDatas(BufferedImage initialImage) {
        int regionAmountX = (int) (initialImage.getWidth() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION));
        int regionAmountY = (int) (initialImage.getHeight() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION));

        for(int x = 0; x < regionAmountX; x ++){
            for(int y = 0; y < regionAmountY; y ++) {
                String path = EdumiaMapConfigs.HEIGHT_PATH + EdumiaMapConfigs.IMAGE_NAME.formatted(x,y);
                if(fileUtils.getRunImage(path) == null){
                    return false;
                }
            }
        }
        return true;
    }

    private void generateHeight(BufferedImage initialImage) {
        ExecutorService executorService = Executors.newFixedThreadPool(EdumiaMapConfigs.THREAD_POOL_SIZE);

        int regionAmountX = (int) (initialImage.getWidth() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION));
        int regionAmountY = (int) (initialImage.getHeight() / EdumiaMapConfigs.REGION_SIZE * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION));

        for(int x = 0; x < regionAmountX; x++) {
            for (int y = 0; y < regionAmountY; y++) {
                int finalX = x;
                int finalY = y;
                executorService.submit(() -> {
                    String path = EdumiaMapConfigs.BIOME_PATH.formatted(EdumiaMapConfigs.MAP_ITERATION) + EdumiaMapConfigs.IMAGE_NAME.formatted(finalX, finalY);
                    fileUtils.saveImage(
                            FileUtils.blur(processHeightRegion(fileUtils.getRunImage(path), EdumiaMapConfigs.REGION_SIZE), 16, 1.0f / (16 * 16)),
                            EdumiaMapConfigs.HEIGHT_PATH,
                            EdumiaMapConfigs.IMAGE_NAME.formatted(finalX, finalY),
                            FileType.Png
                    );
                });
            }
        }
        // Awaits for tasks to finish
        boolean finishedTasks = false;
        try {
            finishedTasks = executorService.awaitTermination(15, TimeUnit.MINUTES);
        } catch (Exception e) {
            loggerUtil.logError("Error while generating biomes");
        }
        if(!finishedTasks) loggerUtil.logError("Didn't finished heightmap generation in time, " +
                "please allocate more RAM, delete the /data/edumia folder and restart the game");

        // Shutdown the executor and wait for all threads to finish
        executorService.shutdown();
        if(!finishedTasks) {
            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (Exception e) {
                loggerUtil.logError("Error while generating heights");
            }
        }
    }

    private static BufferedImage processHeightRegion(BufferedImage biomeImage, int size) {
        BufferedImage newHeightRegion = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                try {
                    int height = EdumiaBiomesData.getBiomeByColor(biomeImage.getRGB(x, y)).height;
                    if(height > 255){
                        height = 255;
                    }
                    int water = 0;
                    if(height < 0) {
                        water = (int) Math.abs((height * WATER_HEIGHT_MULTIPLIER) - WATER_BUFFER);
                        height = 0;
                    }
                    byte decimal = 0;

                    newHeightRegion.setRGB(x, y, new Color(Math.abs(height), decimal, water).getRGB());
                } catch (Exception e) {
                    throw new RuntimeException("EdumiaMapGeneration.processHeightRegion : Failed to create color for the height [%s]".formatted(e));
                }
            }
        }

        return newHeightRegion;
    }
}
