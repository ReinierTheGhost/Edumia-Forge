package com.legends.edumia.world.chunkgen;

import com.legends.edumia.utils.noises.BlendedNoise;
import com.legends.edumia.utils.noises.SimplexNoise;
import com.legends.edumia.world.biomes.BlocksLayeringData;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.surface.EdumiaBiome;
import com.legends.edumia.world.biomes.surface.EdumiaBiomesData;
import com.legends.edumia.world.biomes.surface.ModBiomeSource;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.world.map.EdumiaMapConfigs;
import com.legends.edumia.world.map.EdumiaMapRuntime;
import com.legends.edumia.world.map.EdumiaMapUtils;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.phys.Vec2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class EdumiaChunkGenerator extends ChunkGenerator {
    public static final int MEDGON_LEVEL = -32;
    public static final int NURGON_LEVEL = 0;
    public static final int DEEPSLATE_LEVEL = 32;
    public static final int STONE_HEIGHT = 36;
    public static final int WATER_HEIGHT = 64;
    public static final int LAVA_HEIGHT = -60;
    public static final int HEIGHT = 27 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;
    public static final int CAVE_NOISE = 5;

    EdumiaMapUtils edumiaMapUtils;
    EdumiaMapRuntime edumiaMapRuntime;

    public static final int mapMultiplier = (int) Math.pow(2, EdumiaMapConfigs.MAP_ITERATION + EdumiaMapConfigs.PIXEL_WEIGHT - 2);
    public static final Vec2 mountTitleist = new Vec2 (2752.5f, 505.2f).scale(mapMultiplier);
    private static final int CAVE_STRETCH_H = 60;
    private static final int CAVE_STRETCH_V = 50;

    HolderGetter<Biome> biomeRegistry;
    public static final Codec<EdumiaChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.retrieveGetter(Registries.BIOME))
                    .apply(instance, instance.stable(EdumiaChunkGenerator::new)));

    public EdumiaChunkGenerator(HolderGetter<Biome> biomeRegistry) {
        super(new ModBiomeSource(
                new ArrayList<>(Arrays.asList(
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_VALES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_BEACH),

                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DEAD_MARSHES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DEAD_MARSHES_WATER),

                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_ELF_FOREST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GREAT_RIVER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_TUNDRA),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_OCEAN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_POND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ORC_DESERT),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_PLAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_SANDY_SHORES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_ROCKY_SHORES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OGRE_FOREST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OASIS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.POND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FAIRY_SWAMP),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_FOOTHILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_MOUNTAINS_BASE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_MOUNTAINS_PEAKS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_MOUNTAINS),

                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_VOLCANO_PLAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MOUNT_TITLEIST_CRATER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MOUNT_TITLEIST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MOUNT_TITLEIST_PEAK),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MOUNT_TITLEIST_FOOT),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN_COAST),

                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.RIVER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_REEF),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.TAIGA_FOREST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_JUNGLE),

                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.WASTE_POND),


                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.BASIC_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.LUSH_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DRIPSTONE_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MUD_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FUNGUS_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MITHRIL_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.BASALT_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MAGMA_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DRY_CAVE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ICE_CAVE)
                ))
            )
        );
        this.biomeRegistry = biomeRegistry;

        this.edumiaMapUtils = EdumiaMapUtils.getInstance();
        this.edumiaMapRuntime = EdumiaMapRuntime.getInstance();

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
                EdumiaBiome edumiaBiome = null;
                if(edumiaMapUtils.isWorldCoordinateInBorder(posX, posZ)) {
                    Holder<Biome> biome = region.getBiome(new BlockPos(posX, chunk.getMaxBuildHeight(), posZ));
                    edumiaBiome = EdumiaBiomesData.getBiomeByKey(biome);
                    if(edumiaBiome == null) {
                        edumiaBiome = EdumiaBiomesData.defaultBiome;
                    }
                } else {
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                float height = EdumiaHeightMap.getHeight(posX, posZ);

                float caveBlendNoise = (float) ((2 * CAVE_NOISE * BlendedNoise.noise((double) posX / 24,  (double) posZ / 24)) - CAVE_NOISE);
                float slopeAngle = getTerrainSlope(height, posX, posZ);
                int waterHeight = edumiaBiome.waterHeight;

                if(edumiaBiome.biome == EdumiaBiomeKeys.MOUNT_TITLEIST_CRATER) {
                    float percentage = (float) Math.sqrt(mountTitleist.distanceToSqr(new Vec2(posX, posZ))) / 50;
                    percentage = Math.min(1, Math.max(0.0f, percentage));
                    percentage = (float) Math.pow(percentage, 2.45f);
                    height = height * percentage;
                }
                if(edumiaBiome.biome == EdumiaBiomeKeys.DEAD_MARSHES || edumiaBiome.biome == EdumiaBiomeKeys.DEAD_MARSHES_WATER) {
                    float oldHeight = height;
                    height = getMarshesHeight(posX, posZ, height);
                    float percentage = Math.min(EdumiaHeightMap.getImageNoiseModifier(posX, posZ), 0.3f) / 0.3f;
                    height = EdumiaHeightMap.lerp(height, oldHeight, percentage);
                }

                chunk.setBlockState(chunk.getPos().getBlockAt(x, bottomY, z), Blocks.BEDROCK.defaultBlockState(), false);
                for(int y = bottomY + 1; y <= LAVA_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.LAVA.defaultBlockState(), false);
                }

                for(int y = bottomY + 1; y < MEDGON_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), Blocks.BLUE_WOOL.defaultBlockState());
                }
                if(Math.random() < 0.5f) chunk.setBlockState(chunk.getPos().getBlockAt(x, chunk.getMinBuildHeight() + 1, z),
                        Blocks.BEDROCK.defaultBlockState(), false);

                for(int y = MEDGON_LEVEL + (int) caveBlendNoise; y < NURGON_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), Blocks.TUFF.defaultBlockState());
                }
                for(int y = NURGON_LEVEL + (int) caveBlendNoise; y < DEEPSLATE_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockAt(x, y, z), Blocks.DEEPSLATE.defaultBlockState());
                }

                float dirtHeight = HEIGHT + height - 1;
                int currentHeight = DEEPSLATE_LEVEL + (int) caveBlendNoise;
                int totalLayersHeight = (int) (dirtHeight - currentHeight);
                for(BlocksLayeringData.LayerData layerData : edumiaBiome.blocksLayering.layers) {
                    int blocks = (int) (totalLayersHeight * layerData.percentage);
                    for(int y = 0; y <= blocks; y++) {
                        trySetBlock(chunk, chunk.getPos().getBlockAt(x, currentHeight++, z), layerData.block.defaultBlockState());
                    }
                }
                BlockState surfaceBlock = edumiaBiome.slopeMap.slopeDatas.get(0).block.defaultBlockState();
                BlockState underSurfaceBlock;


                if(DIRT_HEIGHT + height < waterHeight && surfaceBlock == Blocks.GRASS_BLOCK.defaultBlockState()) {
                    surfaceBlock = Blocks.DIRT.defaultBlockState();
                    underSurfaceBlock = surfaceBlock;
                } else {
                    surfaceBlock = edumiaBiome.slopeMap.getBlockAtAngle(slopeAngle).defaultBlockState();
                    if(surfaceBlock == Blocks.GRASS_BLOCK.defaultBlockState()) underSurfaceBlock = Blocks.DIRT.defaultBlockState();
                    else underSurfaceBlock = surfaceBlock;
                }

                chunk.setBlockState(chunk.getPos().getBlockAt(x, (int) (HEIGHT + height - 1), z), underSurfaceBlock, false);
                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), underSurfaceBlock, false);
                }
                chunk.setBlockState(chunk.getPos().getBlockAt(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);

                if(edumiaBiome.biome == EdumiaBiomeKeys.MOUNT_TITLEIST_CRATER) {
                    for(int y = (int) (DIRT_HEIGHT + height + 1); y <= 90; y++) {
                        chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.LAVA.defaultBlockState(), false);
                    }
                } else {
                    for(int y = (int) (DIRT_HEIGHT + height + 1); y <= waterHeight; y++) {
                        chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.WATER.defaultBlockState(), false);
                    }
                }


                //ProceduralStructures.generateStructures(meBiome, chunk, posX, (int) (DIRT_HEIGHT + height), posZ);
            }
        }
    }

    private float getTerrainSlope(float height, int x, int z) {
        int offset = 3;
        float eastHeight = EdumiaHeightMap.getHeight(x + offset, z);
        float southHeight = EdumiaHeightMap.getHeight(x, z + offset);

        float eastSlope = Math.abs((eastHeight - height) / offset);
        float southSlope = Math.abs((southHeight - height) / offset);
        float highestSlope = Math.max(eastSlope, southSlope);

        return (float) Math.toDegrees(Math.atan(highestSlope));
    }

    private void trySetBlock(ChunkAccess chunk, BlockPos blockPos, BlockState blockState) {
        float noise = 0;
        if(blockPos.getY() < WATER_HEIGHT) {
            noise =(float) SimplexNoise.noise(
                    (float) blockPos.getX() / CAVE_STRETCH_H, Math.tan((float) blockPos.getY() / CAVE_STRETCH_V), (float) blockPos.getZ() / CAVE_STRETCH_H);
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

    public static float getMarshesHeight(int x, int z, float height) {
        height = -2 + (2.0f * (float) BlendedNoise.noise((double) x / 19,  (double) z / 19));
        height += (float) BlendedNoise.noise((double) x / 11,  (double) z / 11);
        return height;
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
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState noiseConfig, StructureManager structureAccessor, ChunkAccess chunk)  {
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
