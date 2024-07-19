package com.legends.edumia.worldgen.chunkgen;

import com.legends.edumia.utils.noises.BlendedNoise;
import com.legends.edumia.worldgen.biome.EdumiaBiomeKeys;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiome;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiomesData;
import com.legends.edumia.worldgen.biome.surface.ModBiomeSource;
import com.legends.edumia.worldgen.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.worldgen.map.EdumiaMapRuntime;
import com.legends.edumia.worldgen.map.EdumiaMapUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraftforge.registries.DeferredRegister;
import org.joml.SimplexNoise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class EdumiaChunkGenerator extends ChunkGenerator {
    public static final int EPMOSTO_LEVEL = -32;
    public static final int DIFTOMIN_LEVEL = 0;
    public static final int DEEPSLATE_LEVEL = 32;
    public static final int STONE_HEIGHT = 36;
    public static final int WATER_HEIGHT = 64;
    public static final int LAVA_HEIGHT = -60;
    public static final int HEIGHT = 27 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;
    public static final int CAVE_NOISE = 5;

    EdumiaMapUtils middleEarthMapUtils;
    EdumiaMapRuntime middleEarthMapRuntime;

    private static final int CAVE_STRETCH_H = 60;
    private static final int CAVE_STRETCH_V = 50;
    private static float minNoise = 10000;
    private static float maxNoise = -10000;
    HolderGetter<Biome> biomeRegistry;
    public static final Codec<EdumiaChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.retrieveGetter(Registries.BIOME))
                    .apply(instance, instance.stable(EdumiaChunkGenerator::new)));

    public EdumiaChunkGenerator(HolderGetter<Biome> biomeRegistry) {
        super(new ModBiomeSource(
                        new ArrayList<>(Arrays.asList(
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_VALES),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_BEACH),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_FOOTHILLS),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_ELF_FOREST),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_TUNDRA),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_OCEAN),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_POND),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.ORC_DESERT),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_PLAINS),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.OASIS),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.POND),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.FAIRY_SWAMP),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_MOUNTAINS),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_MOUNTAINS),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_VOLCANO),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN_COAST),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_RIVER),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_REEF),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.TAIGA_FOREST),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_JUNGLE),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.WASTE_POND),
//
//
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.BASIC_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.LUSH_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.DRIPSTONE_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.MUD_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.FUNGUS_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.MITHRIL_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.BASALT_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.MAGMA_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.DRY_CAVE),
//                                biomeRegistry.getOrThrow(EdumiaBiomeKeys.ICE_CAVE)
                        ))
                )
        );
        this.biomeRegistry = biomeRegistry;

        this.middleEarthMapUtils = EdumiaMapUtils.getInstance();
        this.middleEarthMapRuntime = EdumiaMapRuntime.getInstance();

    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }



    @Override
    public void applyCarvers(WorldGenRegion chunkRegion, long seed, RandomState noiseConfig,
                      BiomeManager biomeAccess, StructureManager structureAccessor,
                      ChunkAccess chunk2, GenerationStep.Carving carverStep) {

    }



    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structures, RandomState noiseConfig, ChunkAccess chunk) {
        int bottomY = chunk.getMinBuildHeight();
        for(int x = 0; x < 16; x++) {
            for(int z = 0; z < 16; z++) {
                int posX = (chunk.getPos().x * 16) + x;
                int posZ = (chunk.getPos().z * 16) + z;
                EdumiaBiome meBiome = null;

                if(middleEarthMapUtils.isWorldCoordinateInBorder(posX, posZ)) {
                    Holder<Biome> biome = region.getBiome(new BlockPos(posX, chunk.getMaxBuildHeight(), posZ));
                    meBiome = EdumiaBiomesData.getBiomeByKey(biome);
                    if(meBiome == null) {
                        meBiome = EdumiaBiomesData.defaultBiome;
                    }
                } else {
                    meBiome = EdumiaBiomesData.defaultBiome;
                }

                float height = EdumiaHeightMap.getHeight(posX, posZ);
                float caveBlendNoise = (float) ((2 * CAVE_NOISE * BlendedNoise.noise((double) posX / 24,  (double) posZ / 24)) - CAVE_NOISE);

                chunk.setBlockState(chunk.getPos().getBlockAt(x, bottomY, z), Blocks.BEDROCK.defaultBlockState(), false);
                for(int y = bottomY + 1; y <= LAVA_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.LAVA.defaultBlockState(), false);
                }

                for(int y = bottomY + 1; y < EPMOSTO_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z),   Blocks.BLACKSTONE.defaultBlockState()); //StoneSets.GNEISS.block().getDefaultState());
                }
                if(Math.random() < 0.5f) chunk.setBlockState(chunk.getPos().getBlockAt(x, chunk.getMinBuildHeight() + 1, z),
                        Blocks.BEDROCK.defaultBlockState(), false);

                for(int y = EPMOSTO_LEVEL + (int) caveBlendNoise; y < DIFTOMIN_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z),  Blocks.TUFF.defaultBlockState());//StoneSets.BROWN_STONE.block().getDefaultState());
                }
                for(int y = DIFTOMIN_LEVEL + (int) caveBlendNoise; y < DEEPSLATE_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), Blocks.DEEPSLATE.defaultBlockState());
                }
                float dirtHeight = HEIGHT + height - 1;
                for(int y = DEEPSLATE_LEVEL + (int) caveBlendNoise; y < (dirtHeight / 2); y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), meBiome.stoneBlock.defaultBlockState());
                }
                for(int y = (int) (dirtHeight / 2); y < dirtHeight; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), meBiome.upperStoneBlock.defaultBlockState());
                }

                chunk.setBlockState(chunk.getPos().getBlockAt(x, (int) (HEIGHT + height - 1), z), meBiome.stoneBlock.defaultBlockState(), false);
                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), meBiome.underSurfaceBlock.defaultBlockState(), false);
                }

                BlockState surfaceBlock = meBiome.surfaceBlock.defaultBlockState();

                if(DIRT_HEIGHT + height < WATER_HEIGHT && meBiome.surfaceBlock == Blocks.GRASS_BLOCK) {
                    surfaceBlock = Blocks.DIRT.defaultBlockState();
                }

                chunk.setBlockState(chunk.getPos().getBlockAt(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);

                for(int y = (int) (DIRT_HEIGHT + height + 1); y <= WATER_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.WATER.defaultBlockState(), false);
                }
            }
        }

    }

    private void trySetBlock(ChunkAccess chunk, BlockPos blockPos, BlockState blockState) {
        float noise = 0;
        if(blockPos.getY() < WATER_HEIGHT) {
            noise =(float) SimplexNoise.noise(
                    (float) blockPos.getX() / CAVE_STRETCH_H, (float) Math.tan((float) blockPos.getY() / CAVE_STRETCH_V), (float) blockPos.getZ() / CAVE_STRETCH_H);
            noise += 0.5f * (float) SimplexNoise.noise(
                    (float) blockPos.getX() / (CAVE_STRETCH_H * 0.5f), (float) blockPos.getY() / (CAVE_STRETCH_V * 0.5f), (float) blockPos.getZ() / (CAVE_STRETCH_H * 0.5f));
            noise = noise / (1 + 0.5f);
        }
        float noise3 = (float) SimplexNoise.noise((float) blockPos.getX() / 90, (float) blockPos.getY() / 60, (float) blockPos.getZ() / 90);
        float miniNoise = (float) SimplexNoise.noise((float) blockPos.getX() / 40, (float) blockPos.getY() / 30, (float) blockPos.getZ() / 40);

        if(noise < 0.4f && noise3 < 0.75f && miniNoise < 0.8f) { //
            chunk.setBlockState(blockPos, blockState, false);
        }
    }

    @Override
    public void applyBiomeDecoration(WorldGenLevel world, ChunkAccess chunk, StructureManager structureAccessor) {
        super.applyBiomeDecoration(world, chunk, structureAccessor);
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion region) {
        ChunkPos chunkPos = region.getCenter();
        Holder<Biome> registryEntry = region.getBiome(chunkPos.getWorldPosition().atY(region.getMaxBuildHeight() - 1));
        WorldgenRandom chunkRandom = new WorldgenRandom(new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
        chunkRandom.setDecorationSeed(region.getSeed(), chunkPos.getMinBlockX(), chunkPos.getMinBlockZ());
        NaturalSpawner.spawnMobsForChunkGeneration(region, registryEntry, chunkPos, chunkRandom);
    }

    @Override
    public int getGenDepth() {
        return 384;
    }


    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState noiseConfig, StructureManager structureAccessor, ChunkAccess chunk) {

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return WATER_HEIGHT;
    }

    @Override
    public int getMinY() {
        return -4;
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types heightmap, LevelHeightAccessor world, RandomState noiseConfig) {
        float worldHeight = 1 + DIRT_HEIGHT + EdumiaHeightMap.getHeight(x, z);
        return (int)worldHeight;
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor world, RandomState noiseConfig) {
        return new NoiseColumn(0, new BlockState[0]);
    }

    @Override
    public void addDebugScreenInfo(List<String> text, RandomState noiseConfig, BlockPos pos) {

    }

}
