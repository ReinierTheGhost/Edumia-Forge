package com.legends.edumia.worldgen.map;

import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiome;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiomesData;
import net.minecraft.server.level.ServerPlayer;
import org.joml.Vector2i;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EdumiaMapRuntime {
    private static EdumiaMapRuntime single_instance = null;
    HashMap<Vector2i, EdumiaMapRegion> regions;
    HashMap<UUID, Vector2i> regionByUuids;
    private LoggerUtil loggerUtil;
    private EdumiaMapUtils middleEarthMapUtils;

    private int latestValidationTick = 0;
    private int currentValidationBlockCount = 0;

    public static synchronized EdumiaMapRuntime getInstance()
    {
        if (single_instance == null)
            single_instance = new EdumiaMapRuntime();

        return single_instance;
    }

    public EdumiaMapRuntime() {
        regions = new HashMap<>();
        regionByUuids = new HashMap<>();

        loggerUtil = LoggerUtil.getInstance();
        middleEarthMapUtils = EdumiaMapUtils.getInstance();
    }

    public EdumiaBiome getBiome(int posX, int posZ) {
        if(!middleEarthMapUtils.isWorldCoordinateInBorder(posX, posZ)) return EdumiaBiomesData.defaultBiome;

        EdumiaMapRegion region = getRegionToUse(middleEarthMapUtils.getRegionByWorldCoordinate(posX, posZ));
        if(region == null) return EdumiaBiomesData.defaultBiome;

        return region.getBiome(getImageCoordinates(posX, posZ));
    }

    public Color getHeight(int posX, int posZ) {
        if(!middleEarthMapUtils.isWorldCoordinateInBorder(posX, posZ)) return null;

        EdumiaMapRegion region = getRegionToUse(middleEarthMapUtils.getRegionByWorldCoordinate(posX, posZ));
        if(region == null) return null;

        return region.getHeightColor(getImageCoordinates(posX, posZ));
    }

    private Vector2i getImageCoordinates(int posX, int posZ){
        return new Vector2i(
                (int)((float)posX / EdumiaMapConfigs.PIXEL_WEIGHT % EdumiaMapConfigs.REGION_SIZE),
                (int)((float)posZ / EdumiaMapConfigs.PIXEL_WEIGHT % EdumiaMapConfigs.REGION_SIZE)
        );
    }

    private EdumiaMapRegion getRegionToUse(Vector2i regionCoordinate){
        purgeRegions();

        if(regions.get(regionCoordinate) != null) {
            return regions.get(regionCoordinate);
        }
        return regions.put(regionCoordinate, new EdumiaMapRegion(regionCoordinate));
    }

    private void purgeRegions() {
        // Block delay
        currentValidationBlockCount ++;
        if(currentValidationBlockCount < EdumiaMapConfigs.BIOME_VALIDATION_BLOCK_DELAY) return;
        currentValidationBlockCount = 0;

        // Tick delay
        int serverTick = middleEarthMapUtils.getTick();
        if(serverTick - latestValidationTick < EdumiaMapConfigs.BIOME_VALIDATION_TICK_DELAY) return;
        latestValidationTick = serverTick;

        // Create purge array
        java.util.List<Vector2i> toPurge = new ArrayList<>();
        List<Vector2i> playerCoordinates = new ArrayList<>();
        for(ServerPlayer player : middleEarthMapUtils.getPlayers()){
            playerCoordinates.add(new Vector2i(player.getBlockX(), player.getBlockZ()));
        }

        try{
            middleEarthMapUtils.getPlayers();
            regions.forEach((key, value) -> {
                boolean hasPlayerInRange = false;
                for(Vector2i coordinate : playerCoordinates){
                    if(value.isInRange(coordinate)){
                        hasPlayerInRange = true;
                        break;
                    }
                }
                if(!hasPlayerInRange)
                    toPurge.add(key);
            });

            // Purging
            //loggerUtil.logDebugMsg("Purging [%s] regions (tick : %s)".formatted(toPurge.size(), serverTick));
            for (Vector2i region : toPurge){
                regions.remove(region);
            }
        } catch(Exception exception){
            loggerUtil.logError("%s : %s".formatted(toString(), exception.getMessage()));
        }
    }
}
