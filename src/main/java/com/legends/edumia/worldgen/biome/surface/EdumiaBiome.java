package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.worldgen.biome.caves.CaveType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.awt.*;
import java.util.function.Supplier;

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
    public EdumiaBiome(int height, ResourceKey<Biome> biome, Supplier<Block> surfaceBlock, Supplier<Block> underSurfaceBlock, Supplier<Block> stoneBlock) {
        this(height, biome, surfaceBlock.get(), underSurfaceBlock.get(), stoneBlock.get(), stoneBlock.get(), CaveType.DEFAULT);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, Supplier<Block> surfaceBlock, Supplier<Block> underSurfaceBlock, Supplier<Block> stoneBlock, CaveType caveType) {
        this(height, biome, surfaceBlock.get(), underSurfaceBlock.get(), stoneBlock.get(), stoneBlock.get(), caveType);
    }

    public EdumiaBiome(int height, ResourceKey<Biome> biome, Supplier<Block> surfaceBlock, Supplier<Block> underSurfaceBlock, Supplier<Block> upperStoneBlock, Supplier<Block> stoneBlock) {
        this(height, biome, surfaceBlock.get(), underSurfaceBlock.get(), upperStoneBlock.get(), stoneBlock.get(), CaveType.DEFAULT);
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
