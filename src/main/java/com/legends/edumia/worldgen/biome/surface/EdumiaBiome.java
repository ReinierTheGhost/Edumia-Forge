package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.worldgen.biome.caves.CaveType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.awt.*;

public class EdumiaBiome {
    public int height;
    public Color color;
    public ResourceKey<Biome> biome;
    public Block surfaceBlock;
    public Block underSurfaceBlock;
    public Block upperStoneBlock;
    public Block stoneBlock;
    public CaveType caveType;

    public EdumiaBiome(){

    }
    public EdumiaBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, stoneBlock, stoneBlock, CaveType.DEFAULT);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock, CaveType caveType) {
        this(height, biome, surfaceBlock, underSurfaceBlock, stoneBlock, stoneBlock, caveType);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block upperStoneBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, upperStoneBlock, stoneBlock, CaveType.DEFAULT);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block upperStoneBlock, Block stoneBlock, CaveType caveType) {
        this.height = height;
        this.biome = biome;
        this.surfaceBlock = surfaceBlock;
        this.underSurfaceBlock = underSurfaceBlock;
        this.upperStoneBlock = upperStoneBlock;
        this.stoneBlock = stoneBlock;
        this.caveType = caveType;
    }
}
