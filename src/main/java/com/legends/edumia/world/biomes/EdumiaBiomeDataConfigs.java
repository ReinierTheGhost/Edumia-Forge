package com.legends.edumia.world.biomes;


import com.legends.edumia.blocks.blocksets.StoneSets;
import net.minecraft.world.level.block.Blocks;

public class EdumiaBiomeDataConfigs {
    // region Slopes
    // defines the surface blocks (4 blocks depth)
    private static final int MAX_ANGLE = 90;

    public static SlopeMap ashenDirt = new SlopeMap().addSlopeData(25, Blocks.GRAVEL)
            .addSlopeData(32, Blocks.DIRT)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);



    public static SlopeMap mordor = new SlopeMap().addSlopeData(30, Blocks.BLACK_WOOL)
            .addSlopeData(36, Blocks.TUFF)
            .addSlopeData(44, Blocks.BASALT)
            .addSlopeData(MAX_ANGLE, Blocks.BLACKSTONE);


    public static SlopeMap mistyMountains = new SlopeMap().addSlopeData(13, Blocks.GRASS_BLOCK)
            .addSlopeData(16, Blocks.COARSE_DIRT)
            .addSlopeData(32, Blocks.STONE)
            .addSlopeData(48, Blocks.TUFF)
            .addSlopeData(MAX_ANGLE, Blocks.BASALT);
    public static SlopeMap edumiaMountainsBase = new SlopeMap().addSlopeData(13, Blocks.GRASS_BLOCK)
            .addSlopeData(30, Blocks.GRASS_BLOCK)
            .addSlopeData(33, Blocks.COARSE_DIRT)
            .addSlopeData(34, Blocks.GRAVEL)
            .addSlopeData(37, Blocks.ANDESITE)
            .addSlopeData(40, () -> StoneSets.BROWN_STONE.block().get())
            .addSlopeData(45, Blocks.TUFF)
            .addSlopeData(47, () -> StoneSets.CYAN_STONE.block().get())
            .addSlopeData(51, () -> StoneSets.BLUE_STONE.block().get())
            .addSlopeData(MAX_ANGLE, Blocks.COBBLED_DEEPSLATE);

    public static SlopeMap edumiaMountains = new SlopeMap().addSlopeData(13, Blocks.GRASS_BLOCK)
            .addSlopeData(30, Blocks.GRASS_BLOCK)
            .addSlopeData(33, Blocks.COARSE_DIRT)
            .addSlopeData(34, Blocks.GRAVEL)
            .addSlopeData(37, Blocks.ANDESITE)
            .addSlopeData(40, () -> StoneSets.BROWN_STONE.block().get())
            .addSlopeData(45, Blocks.TUFF)
            .addSlopeData(55, () -> StoneSets.CYAN_STONE.block().get())
            .addSlopeData(67, () -> StoneSets.BLUE_STONE.block().get())
            .addSlopeData(MAX_ANGLE, Blocks.COBBLED_DEEPSLATE);

    public static SlopeMap edumiaMountainsPeaks = new SlopeMap()
            .addSlopeData(25, Blocks.SNOW_BLOCK)
            .addSlopeData(33, Blocks.STONE)
            .addSlopeData(35, Blocks.ANDESITE)
            .addSlopeData(42, Blocks.TUFF)
            .addSlopeData(50, () -> StoneSets.CYAN_STONE.block().get())
            .addSlopeData(MAX_ANGLE, Blocks.COBBLED_DEEPSLATE);






    public static SlopeMap grassPlains = new SlopeMap().addSlopeData(25, Blocks.GRASS_BLOCK)
            .addSlopeData(36, Blocks.COARSE_DIRT)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);
    public static SlopeMap sandShores = new SlopeMap().addSlopeData(27, Blocks.SAND)
            .addSlopeData(30, Blocks.SANDSTONE)
            .addSlopeData(36, Blocks.COARSE_DIRT)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);

    public static SlopeMap river = new SlopeMap().addSlopeData(30, Blocks.SAND)
            .addSlopeData(36, Blocks.DIRT)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);

    public static SlopeMap forodwaith = new SlopeMap().addSlopeData(30, Blocks.SNOW_BLOCK)
            .addSlopeData(MAX_ANGLE, Blocks.FROSTED_ICE);

    public static SlopeMap mud = new SlopeMap().addSlopeData(25, Blocks.MUD)
            .addSlopeData(32, Blocks.DIRT)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);
    public static SlopeMap nearHarad = new SlopeMap().addSlopeData(32, Blocks.GRASS_BLOCK)
            .addSlopeData(36, Blocks.SMOOTH_SANDSTONE)
            .addSlopeData(44, Blocks.SANDSTONE)
            .addSlopeData(56, Blocks.STONE)
            .addSlopeData(MAX_ANGLE, Blocks.TERRACOTTA);
    public static SlopeMap harad = new SlopeMap().addSlopeData(32, Blocks.SAND)
            .addSlopeData(45, Blocks.SANDSTONE)
            .addSlopeData(60, Blocks.STONE)
            .addSlopeData(MAX_ANGLE, Blocks.TERRACOTTA);
    public static SlopeMap ocean = new SlopeMap().addSlopeData(30, Blocks.GRAVEL)
            .addSlopeData(36, Blocks.SAND)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);
    public static SlopeMap beach = new SlopeMap().addSlopeData(30, Blocks.SAND)
            .addSlopeData(36, Blocks.SAND)
            .addSlopeData(MAX_ANGLE, Blocks.STONE);
    // endregion

    // region Blocks Layering
    // excludes the surface blocks since it's handled by Slopes blocks

    public static BlocksLayeringData stoneLayers = new BlocksLayeringData().addLayerData(1.0f, Blocks.STONE);

    public static BlocksLayeringData ashenStoneLayers = new BlocksLayeringData().addLayerData(1.0f, Blocks.BASALT);

    public static BlocksLayeringData frozenLayers = new BlocksLayeringData().addLayerData(0.5f, Blocks.STONE)
            .addLayerData(0.5f, Blocks.FROSTED_ICE);


    public static BlocksLayeringData limeStoneLayers = new BlocksLayeringData().addLayerData(0.5f, Blocks.STONE)
            .addLayerData(0.5f, Blocks.CALCITE);

    public static BlocksLayeringData sandstoneLayers = new BlocksLayeringData().addLayerData(0.9f, Blocks.STONE)
            .addLayerData(0.1f, Blocks.SANDSTONE);

    public static BlocksLayeringData gondorLayers = new BlocksLayeringData().addLayerData(0.5f, Blocks.STONE)
            .addLayerData(0.4f, Blocks.CALCITE)
            .addLayerData(0.1f, Blocks.DIORITE);


    public static BlocksLayeringData mistyMountainsLayers = new BlocksLayeringData().addLayerData(0.9f, Blocks.STONE)
            .addLayerData(0.1f, Blocks.TUFF);

    // endregion

    // region Biome Generation Data
    // Expansion weights
    private static final byte[] RIVER_WEIGHT = {2, 2};
    private static final byte[] OCEAN_WEIGHT = {2, 3};
    private static final byte[] MOUNTAIN_WEIGHT = {1, 4};
    private static final byte[] LAND_WEIGHT = {1, 4};

    // Noise Modifiers
    private static final double WATER_NOISE_MODIFIER = 0.4f;
    private static final double PLAINS_NOISE_MODIFIER = 0.31f;
    private static final double FOOTHILL_NOISE_MODIFIER = 0.6f;
    private static final double MOUNTAIN_NOISE_MODIFIER = 0.82f;
    private static final double MOUNTAIN_PEAKS_NOISE_MODIFIER = 1.5f;

    // Height Base Modifiers
    private static final double WATER_HEIGHT_MODIFIER = 0.2f;
    private static final double LAND_HEIGHT_MODIFIER = 0.3f;
    private static final double FOOTHILL_HEIGHT_MODIFIER = 0.38f;
    private static final double MOUNTAIN_HEIGHT_MODIFIER = 0.46f;
    private static final double MOUNTAIN_PEAKS_HEIGHT_MODIFIER = 0.55f;

    public static BiomeGenerationData landModifier = new BiomeGenerationData().expansionWeight(LAND_WEIGHT).noiseModifier(0.39f).heightModifier(0.33f);
    public static BiomeGenerationData plainsModifier = new BiomeGenerationData().expansionWeight(LAND_WEIGHT).noiseModifier(PLAINS_NOISE_MODIFIER).heightModifier(LAND_HEIGHT_MODIFIER);
    public static BiomeGenerationData riverModifier = new BiomeGenerationData().expansionWeight(RIVER_WEIGHT).noiseModifier(WATER_NOISE_MODIFIER).heightModifier(WATER_HEIGHT_MODIFIER);
    public static BiomeGenerationData smallRiverModifier = new BiomeGenerationData().expansionWeight(RIVER_WEIGHT).noiseModifier(0.05f).heightModifier(0.05f);
    public static BiomeGenerationData oceanModifier = new BiomeGenerationData().expansionWeight(OCEAN_WEIGHT)
            .noiseModifier(WATER_NOISE_MODIFIER).heightModifier(WATER_HEIGHT_MODIFIER);
    public static BiomeGenerationData mountainModifier = new BiomeGenerationData().expansionWeight(MOUNTAIN_WEIGHT).noiseModifier(MOUNTAIN_NOISE_MODIFIER).heightModifier(MOUNTAIN_HEIGHT_MODIFIER);
    public static BiomeGenerationData emModifier = new BiomeGenerationData().expansionWeight(MOUNTAIN_WEIGHT)
            .noiseModifier(MOUNTAIN_NOISE_MODIFIER).heightModifier(0.36f);
    public static BiomeGenerationData emPeaksModifier = new BiomeGenerationData().expansionWeight(MOUNTAIN_WEIGHT)
            .noiseModifier(1.47f).heightModifier(0.33f);

}
