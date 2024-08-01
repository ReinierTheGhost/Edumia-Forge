package com.legends.edumia.utils.resources;


import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.world.biomes.surface.EdumiaBiomesData;
import com.legends.edumia.world.chunkgen.map.ImageUtils;
import com.legends.edumia.world.map.EdumiaMapConfigs;
import org.joml.Vector2i;
import org.joml.sampling.Convolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileUtils {

    private static FileUtils single_instance = null;
    private static HashMap<Integer, float[]> gaussianBlurKernels = new HashMap<>();
    private static final float GAUSSIAN_SIGMA = 3.81f;

    public static synchronized FileUtils getInstance()
    {
        if (single_instance == null)
            single_instance = new FileUtils(ClassLoader.getSystemClassLoader());

        return single_instance;
    }

    private ClassLoader classLoader;

    public FileUtils(ClassLoader classLoader){
        this.classLoader = classLoader;
    }

    public BufferedImage getResourceImage(String path) {
        try{
            return ImageUtils.fetchResourceImage(getClass().getClassLoader(), path);
        } catch (IOException e) {
            return null;
        }
    }

    public BufferedImage getRunImage(String path) {
        try{
            File f = new File(path);
            if(!f.exists())
                return null;
            return ImageIO.read(f);
        } catch (IOException e) {
            return null;
        }
    }

    private static final Vector2i[] directions = {new Vector2i(-1, 1), new Vector2i(0, 1), new Vector2i(1, 1),
                                            new Vector2i(-1, 0), new Vector2i(1, 0),
                                            new Vector2i(-1, -1), new Vector2i(0, -1), new Vector2i(1, -1)};
    public BufferedImage getRunImageWithBorders(int x, int y, int padding) {
        String basePath = EdumiaMapConfigs.BIOME_PATH.formatted(EdumiaMapConfigs.MAP_ITERATION);
        String centerPath = basePath + EdumiaMapConfigs.IMAGE_NAME.formatted(x, y);
        BufferedImage centerImage = getRunImage(centerPath);
        if(centerImage == null) return null;

        int width = centerImage.getWidth();
        int height = centerImage.getHeight();

        BufferedImage imageWithBorders = new BufferedImage(width + 2*padding, height + 2*padding, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = imageWithBorders.createGraphics();

        graphics.setColor(EdumiaBiomesData.defaultBiome.color);
        graphics.fillRect(0, 0, width + 2*padding, height + 2*padding);
        graphics.drawImage(centerImage, padding, padding, null);

        for(Vector2i direction : directions) {
            String edgePath = basePath + EdumiaMapConfigs.IMAGE_NAME.formatted(x + direction.x, y + direction.y);
            BufferedImage edgeImage = getRunImage(edgePath);
            if(edgeImage != null) {
                graphics.drawImage(edgeImage, padding + (width * direction.x), padding + (height * direction.y), null);
            }
        }
        graphics.dispose();

        return imageWithBorders;
    }

    public void saveImage(BufferedImage bufferedImage, String path, String fileName, FileType fileType) {
        try{
            new File(path).mkdirs();
            File f = new File(path + fileName);
            ImageIO.write(bufferedImage, fileType.extension, f);
        } catch(Exception e){
            LoggerUtil.getInstance().logError("Image Utils couldn't save image for {0}.".formatted(path + fileName));
        }
    }


    /**
     * TODO : Optimise this part, it the longest process in World-Gen
     */
    public static BufferedImage blur(BufferedImage image, int brushSize, boolean crop) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage imageWithBorders = image;
        if(!crop) {
            imageWithBorders = new BufferedImage(width + 2*brushSize, height + 2*brushSize, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = imageWithBorders.createGraphics();

            graphics.setColor(EdumiaBiomesData.defaultBiome.color);
            graphics.fillRect(0, 0, width + 2*brushSize, height + 2*brushSize);
            graphics.drawImage(image, brushSize, brushSize, null);
        }

        float[] blurKernel = new float[brushSize*brushSize];

        if(gaussianBlurKernels.containsKey(brushSize)) {
            blurKernel = gaussianBlurKernels.get(brushSize);
        }
        else {
            Convolution.gaussianKernel(brushSize, brushSize, GAUSSIAN_SIGMA, blurKernel);
            gaussianBlurKernels.put(brushSize, blurKernel);
        }
        Kernel kernel = new Kernel(brushSize, brushSize, blurKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);

        BufferedImage blurredImage = new BufferedImage(width, height, image.getType());
        op.filter(image, blurredImage);

        if(crop) return blurredImage.getSubimage(brushSize, brushSize, width - brushSize*2, height - brushSize*2);
        else return blurredImage;
    }
}
