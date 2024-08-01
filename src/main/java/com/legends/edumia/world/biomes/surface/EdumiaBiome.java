package com.legends.edumia.world.biomes.surface;


import com.legends.edumia.world.biomes.BiomeGenerationData;
import com.legends.edumia.world.biomes.BlocksLayeringData;
import com.legends.edumia.world.biomes.SlopeMap;
import com.legends.edumia.world.biomes.caves.CaveType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;


import java.awt.*;

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
