package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.worldgen.biome.BiomeGenerationData;
import com.legends.edumia.worldgen.biome.BlocksLayeringData;
import com.legends.edumia.worldgen.biome.SlopeMap;
import com.legends.edumia.worldgen.biome.caves.CaveType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.awt.*;
import java.util.function.Supplier;

public class EdumiaBiome {
    public static int DEFAULT_WATER_HEIGHT = 64;
    public int height;
    public int waterHeight;
    public Color color;
    public ResourceKey<Biome> biome;
    public BiomeGenerationData biomeGenerationData;
    public SlopeMap slopeMap;
    public BlocksLayeringData blocksLayering;
    public CaveType caveType;

    public EdumiaBiome(){

    }
    public EdumiaBiome(int height, ResourceKey<Biome> biome, BiomeGenerationData biomeGenerationData, SlopeMap slopeMap, BlocksLayeringData blocksLayering) {
        this(height, DEFAULT_WATER_HEIGHT, biome, biomeGenerationData, slopeMap, blocksLayering, CaveType.DEFAULT);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, BiomeGenerationData biomeGenerationData, SlopeMap slopeMap, BlocksLayeringData blocksLayering, CaveType caveType) {
        this(height, DEFAULT_WATER_HEIGHT, biome, biomeGenerationData, slopeMap, blocksLayering, caveType);
    }

    public EdumiaBiome(int height, int waterHeight, ResourceKey<Biome> biome, BiomeGenerationData biomeGenerationData, SlopeMap slopeMap, BlocksLayeringData blocksLayering) {
        this(height, waterHeight, biome, biomeGenerationData, slopeMap, blocksLayering, CaveType.DEFAULT);
    }

    public EdumiaBiome(int height, int waterHeight, ResourceKey<Biome> biome, BiomeGenerationData biomeGenerationData, SlopeMap slopeMap, BlocksLayeringData blocksLayering, CaveType caveType) {
        this.height = height;
        this.waterHeight = waterHeight;
        this.biome = biome;
        this.biomeGenerationData = biomeGenerationData;
        this.slopeMap = slopeMap;
        this.blocksLayering = blocksLayering;
        this.caveType = caveType;
    }
}
