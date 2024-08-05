package com.legends.edumia.world.biomes.surface;


import com.legends.edumia.world.biomes.BiomeColorsDTO;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.caves.ModCaveBiomes;
import com.legends.edumia.world.placedfeatures.biomes.OgreBiomePlacedFeatures;
import com.legends.edumia.world.placedfeatures.ocean.ReefPlacedFeatures;
import com.legends.edumia.world.placedfeatures.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.world.placedfeatures.trees.TropicalTreePlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModBiomes {
    public static final int defaultSky = 7907327;
    public static final int defaultFog = 12638463;
    public static final int defaultWater = 4159204;
    public static final int defaultWaterFog = 329011;
    public static final int defaultShoreWater = 4157124;
    public static final int defaultCoastWater = 4155044;
    public static final int defaultOceanWater = 3956102;
    public static final int defaultOceanWaterFog = 2309971;
    public static final int hillySky = 8233727;
    public static final int waterSky = 8103167;
    public static final int nearHaradSky = 7254527;
    public static final int nearHaradSkyFog = 12902399;

    private static List<ResourceKey<PlacedFeature>> vegetation = new ArrayList<>();;
    private static ArrayList<ResourceKey<PlacedFeature>> undergroundOres = new ArrayList<>();;

    public static void bootstrap(BootstapContext<Biome> context) {
        ModCaveBiomes.bootstrap(context);
        context.register(EdumiaBiomeKeys.EDUMIA_VALES, createEdumiaValesBiome(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8703593, 8703593)));

        context.register(EdumiaBiomeKeys.GENSAI_BEACH, createGensaiBeachBiome(context, new BiomeColorsDTO(
                nearHaradSky, defaultFog, 5212644, 333363, 12107900, 10860366)));
        context.register(EdumiaBiomeKeys.DEAD_MARSHES, createTestBiome(context, new BiomeColorsDTO(
                11908531, 7108218, 3289373, 198924, 6115374, 5794902)));
        context.register(EdumiaBiomeKeys.DEAD_MARSHES_WATER, createTestBiome(context, new BiomeColorsDTO(
                11908531, 7108218, 3289373, 198924, 6115374, 5794902)));

        context.register(EdumiaBiomeKeys.DARK_ELF_FOREST, createDarkElvenWoodBiome(context, new BiomeColorsDTO(
                7972607, defaultFog, 4293787, 338483, 3559947, 1789719)));

        context.register(EdumiaBiomeKeys.EDUMIA_TUNDRA, createTundraBiome(context, new BiomeColorsDTO(
                8364543, 10335206, 3823818, 66852, 3494723, 4478280)));
        context.register(EdumiaBiomeKeys.FROZEN_OCEAN, createFrozenOceanBiome(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));
        context.register(EdumiaBiomeKeys.FROZEN_POND, createFrozenPond(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.ORC_DESERT, createOrcDesertBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 13419633, 9615182)));

        context.register(EdumiaBiomeKeys.AVELION_PLAINS, createAvelionPlainsBiome(context, new BiomeColorsDTO(
                8827134, 12771327, defaultWater, defaultWaterFog, 6523989, 5667402)));
        context.register(EdumiaBiomeKeys.AVELION_SANDY_SHORES, createAvelionPlainsBiome(context, new BiomeColorsDTO(
                8827134, 12771327, defaultWater, defaultWaterFog, 6523989, 5667402)));
        context.register(EdumiaBiomeKeys.AVELION_ROCKY_SHORES, createAvelionPlainsBiome(context, new BiomeColorsDTO(
                8827134, 12771327, defaultWater, defaultWaterFog, 6523989, 5667402)));

        context.register(EdumiaBiomeKeys.OGRE_FOREST, createOgreForestBiome(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8240485, 7909996)));

        context.register(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, createGensaiSakuraGroveBiome(context, new BiomeColorsDTO(
                defaultSky, 13748853, defaultWater, defaultWaterFog, 12961832, 6989412)));

        context.register(EdumiaBiomeKeys.FAIRY_SWAMP, createDarkElvenSwampBiome(context, new BiomeColorsDTO(
                6981536, 8821922, 7111535, 1458241, 4546876, 4284215)));


        context.register(EdumiaBiomeKeys.GREAT_RIVER, createRiverBiome(context, new BiomeColorsDTO(
                waterSky, 12638463, 6853316, 6853316, 10995507, 7181907)));

        context.register(EdumiaBiomeKeys.EDUMIA_FOOTHILLS, createEdumiaMountainBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862),false));
        context.register(EdumiaBiomeKeys.EDUMIA_MOUNTAINS_BASE, createEdumiaMountainBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862), false));
        context.register(EdumiaBiomeKeys.EDUMIA_MOUNTAINS, createEdumiaMountainBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862), false));
        context.register(EdumiaBiomeKeys.EDUMIA_MOUNTAINS_PEAKS, createEdumiaMountainBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862), true));



        context.register(EdumiaBiomeKeys.GENSAI_VOLCANO_PLAINS, createGensaiVolcanoBiome(context, new BiomeColorsDTO(
                5460048, 4999240, 5860962, 731161, 6252369, 4735297)));
        context.register(EdumiaBiomeKeys.MOUNT_TITLEIST_FOOT, createMountTitleistBiome(context, new BiomeColorsDTO(
                5460048, 4999240, 5860962, 731161, 6252369, 4735297)));
        context.register(EdumiaBiomeKeys.MOUNT_TITLEIST, createMountTitleistBiome(context, new BiomeColorsDTO(
                5460048, 4999240, 5860962, 731161, 6252369, 4735297)));
        context.register(EdumiaBiomeKeys.MOUNT_TITLEIST_PEAK, createMountTitleistBiome(context, new BiomeColorsDTO(
                5460048, 4999240, 5860962, 731161, 6252369, 4735297)));
        context.register(EdumiaBiomeKeys.MOUNT_TITLEIST_CRATER, createMountTitleistBiome(context, new BiomeColorsDTO(
                5460048, 4999240, 5860962, 731161, 6252369, 4735297)));



        context.register(EdumiaBiomeKeys.OASIS, createOasisBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 7253092, 6592350)));
        context.register(EdumiaBiomeKeys.OCEAN, createOceanBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, defaultOceanWater, defaultOceanWaterFog, 7576434, 6588506)));
        context.register(EdumiaBiomeKeys.OCEAN_COAST, createOceanCoastBiome(context, new BiomeColorsDTO(
                8104447, defaultFog, defaultCoastWater, defaultOceanWaterFog, 7971954, 6590810)));

        context.register(EdumiaBiomeKeys.POND, createPondBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290786, defaultWaterFog, 7583083, 6592339)));


        context.register(EdumiaBiomeKeys.RIVER, createRiverBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290790, defaultWaterFog, 7583083, 6592339)));

        context.register(EdumiaBiomeKeys.GENSAI_REEF, createGensaiReefBiome(context, new BiomeColorsDTO(
                waterSky, 12638463, 4159204, defaultWaterFog, 10995507, 7181907)));

        context.register(EdumiaBiomeKeys.TAIGA_FOREST, createTaigaBiome(context, new BiomeColorsDTO(
                7508201, 10863086, defaultWater, defaultWaterFog, 8302697, 7252827), true));

        context.register(EdumiaBiomeKeys.GENSAI_JUNGLE, createGensaiJungleBiome(context, new BiomeColorsDTO(
                6785744, 10004675, 4421513, 402733, 2311707, 2050588)));

        context.register(EdumiaBiomeKeys.WASTE_POND, createWastePondBiome(context, new BiomeColorsDTO(
                8163746, 10926783, 5860963, 863008, 4020033, 2695710)));


    }

    public static Biome createEdumiaValesBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addFarmAnimals(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addFlowerGreenJewel(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addVeryRareBirchTrees(vegetation);
        ModBiomeFeatures.addSparseLarchTrees(vegetation);
        ModBiomeFeatures.addMapleTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createGensaiBeachBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addHaradMobs(spawnSettings);
        //ModSpawnSettingsBuilder.addLlama(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(
                Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        ModBiomeFeatures.addCoastalFoliage(vegetation);
        vegetation.add(VegetationPlacements.PATCH_CACTUS_DESERT);
        ModBiomeFeatures.addGraniteBoulder(vegetation);
        ModBiomeFeatures.addSandStoneBoulder(vegetation);
        ModBiomeFeatures.addStoneBoulder(vegetation);
        ModBiomeFeatures.addSandOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);

        ModBiomeFeatures.addPalmTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createEdumiaFoothillsBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addMountainsMobs(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addDolomiteOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addPodzolOre(vegetation);
        ModBiomeFeatures.addStoneGrassOre(vegetation);
        ModBiomeFeatures.addTuffOre(vegetation);
        ModBiomeFeatures.addCommonLarchTrees(vegetation);
        ModBiomeFeatures.addAbundantPineTrees(vegetation);
        ModBiomeFeatures.addAbundantSpruceTrees(vegetation);
        ModBiomeFeatures.addCommonSpruceBushes(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createDarkElvenWoodBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        vegetation.add(VegetationPlacements.PATCH_TALL_GRASS_2);
        ModBiomeFeatures.addMossyBoulder(vegetation);
        ModBiomeFeatures.addForestMoss(vegetation);
        ModBiomeFeatures.addForestBlockMoss(vegetation);
        ModBiomeFeatures.addOldPodzolOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addRareMorsel(vegetation);
        ModBiomeFeatures.addRareWhiteMushroom(vegetation);

        ModBiomeFeatures.addDarkElvenOakTrees(vegetation);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createTundraBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addForochelMobs(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addTundraVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings, -0.8f,  true);
    }
    public static Biome createFrozenOceanBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addOceanAnimals(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createOceanBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addOceanAnimals(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createFrozenPond(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        ModBiomeFeatures.addDisks(undergroundOres);

        vegetation.add(AquaticPlacements.KELP_COLD);
        vegetation.add(AquaticPlacements.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);

        return createBiome(biomeColors, spawnSettings, generationSettings, -0.1f, true);
    }
    public static Biome createOrcDesertBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOrcDesertVegetation(generationSettings);
        vegetation.add(VegetationPlacements.PATCH_DEAD_BUSH_2);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.8f, false);
    }
    public static Biome createAvelionPlainsBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        ModBiomeFeatures.addCornflower(vegetation);
        ModBiomeFeatures.addRareForestMoss(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addLimestoneBoulder(vegetation);
        ModBiomeFeatures.addWhiteSand(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addRareBirchTrees(vegetation);
        ModBiomeFeatures.addMegaBirchTrees(vegetation);
        ModBiomeFeatures.addRareMegaOakTrees(vegetation);
        ModBiomeFeatures.addElvenCrystal(undergroundOres);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createGensaiSakuraGroveBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        vegetation.add(TemperateTreePlacedFeatures.GENSAI_SAKURA_GROVE_TREES);

        addSakuraGroveVegetation(generationSettings);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createDarkElvenSwampBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addDarkElvenVegetation(generationSettings);
        ModBiomeFeatures.addWaterDelta(vegetation);
        ModBiomeFeatures.addForestMoss(vegetation);
        ModBiomeFeatures.addReedsFoliage(vegetation);
        ModBiomeFeatures.addWheatGrass(vegetation);
        ModBiomeFeatures.addMudOre(vegetation);

        ModBiomeFeatures.addWillowTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createAvelionMountainBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors, boolean foothills) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        float temperature = -0.6f;
        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addDolomiteOre(vegetation);
        ModBiomeFeatures.addTuffOre(vegetation);
        if(foothills) {
            temperature = 0.2f;
            ModBiomeFeatures.addCoarseDirtOre(vegetation);
            ModBiomeFeatures.addGravelOre(vegetation);
            ModBiomeFeatures.addStoneGrassOre(vegetation);
            ModBiomeFeatures.addCommonLarchTrees(vegetation);
            ModBiomeFeatures.addAbundantPineTrees(vegetation);
            ModBiomeFeatures.addAbundantSpruceTrees(vegetation);
            ModBiomeFeatures.addCommonSpruceBushes(vegetation);
        } else {
            ModBiomeFeatures.addPowderSnowOre(vegetation);
        }
        return createBiome(biomeColors, spawnSettings, generationSettings,temperature, true);
    }
    public static Biome createEdumiaMountainBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors, boolean peaks) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        float temperature = 0.5f;

        if(peaks) {
            temperature = 0.3f;

        } else {
            addNordicVegetation(generationSettings);
            ModBiomeFeatures.addSparseLarchTrees(vegetation);
            ModBiomeFeatures.addSparsePineTrees(vegetation);
            ModBiomeFeatures.addScarceSpruceTrees(vegetation);
            ModBiomeFeatures.addSpruceBushes(vegetation);
        }
        return createBiome(biomeColors, spawnSettings, generationSettings,temperature, true);
    }
    public static Biome createGensaiVolcanoBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addVolcanoVegetation(generationSettings);
        ModBiomeFeatures.addAshenDirtStoneOre(vegetation);
        ModBiomeFeatures.addLavaMagmaLake(generationSettings);
        ModBiomeFeatures.addBasaltPile(vegetation);
        ModBiomeFeatures.addBlackStonePile(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.7f, false);
    }

    public static Biome createMountTitleistBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addVolcanoVegetation(generationSettings);
        ModBiomeFeatures.addLavaMagmaLake(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.7f, false);
    }
    public static Biome createOceanCoastBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);
        ModBiomeFeatures.addCoastalFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createOasisBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOasisVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createPondBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);
        ModBiomeFeatures.addRiverSand(undergroundOres);
        ModBiomeFeatures.addWillowTrees(vegetation);
        ModBiomeFeatures.addReeds(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createRiverBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        ModBiomeFeatures.addRiverDisks(undergroundOres);
        vegetation.add(AquaticPlacements.KELP_COLD);
        vegetation.add(AquaticPlacements.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_PUMPKIN);
        ModBiomeFeatures.addReedsFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createGensaiReefBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //addOceanVegetation(generationSettings);
        addReef(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createTaigaBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors, boolean trees) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addSpruceBushes(vegetation);

        if(trees) {
            ModBiomeFeatures.addForestMoss(vegetation);
            ModBiomeFeatures.addBirchTrees(vegetation);
            ModBiomeFeatures.addLarchTrees(vegetation);
            ModBiomeFeatures.addOakTrees(vegetation);
            ModBiomeFeatures.addCommonPineTrees(vegetation);
            ModBiomeFeatures.addSpruceTrees(vegetation);
        } else {
            ModBiomeFeatures.addLarchTrees(vegetation);
            ModBiomeFeatures.addSparsePineTrees(vegetation);
            ModBiomeFeatures.addRareSpruceTrees(vegetation);
        }
        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createGensaiJungleBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        vegetation.add(VegetationPlacements.PATCH_TALL_GRASS_2);
        vegetation.add(VegetationPlacements.PATCH_GRASS_PLAIN);
        vegetation.add(VegetationPlacements.BAMBOO_LIGHT);
        vegetation.add(TropicalTreePlacedFeatures.GENSAI_JUNGLE_TREES);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static Biome createWastePondBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(AquaticPlacements.KELP_WARM);
        vegetation.add(AquaticPlacements.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        ModBiomeFeatures.addReedsFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createOgreForestBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        vegetation.add(OgreBiomePlacedFeatures.OGRE_FOREST_TREES);

        return createBiome(biomeColors, spawnSettings, generationSettings,0.7f, 0.8f, true);
    }
    public static Biome createTestBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        //ModSpawnSettingsBuilder.addCamel(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //addOasisVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }
    public static void addDefaultVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_PUMPKIN);
        ModBiomeFeatures.addStoneBoulder(vegetation);
        ModBiomeFeatures.addWildBeetroot(vegetation);
        ModBiomeFeatures.addWildCucumber(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
    }
    public static void addNordicVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacements.PATCH_LARGE_FERN);
        vegetation.add(VegetationPlacements.PATCH_GRASS_TAIGA);
        vegetation.add(VegetationPlacements.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_BERRY_RARE);
        ModBiomeFeatures.addAndesiteBoulder(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addBrownBolete(vegetation);
        ModBiomeFeatures.addMorsel(vegetation);
        ModBiomeFeatures.addWhiteMushroom(vegetation);
        ModBiomeFeatures.addWildBeetroot(vegetation);
        ModBiomeFeatures.addWildPotato(vegetation);
    }
    public static void addTundraVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        ModBiomeFeatures.addToughBerriesRare(vegetation);
    }
    public static void addOceanVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(AquaticPlacements.KELP_COLD);
        vegetation.add(AquaticPlacements.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_PUMPKIN);
    }
    public static void addOrcDesertVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_GRASS_SAVANNA);
        ModBiomeFeatures.addDryGrass(vegetation);
        ModBiomeFeatures.addSandStoneBoulder(vegetation);
    }
    public static void addSakuraGroveVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.FLOWER_MEADOW);
        vegetation.add(VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_PUMPKIN);
        vegetation.add(VegetationPlacements.TREES_PLAINS);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addDryDirtOre(vegetation);
        ModBiomeFeatures.addLimestoneBoulder(vegetation);
        ModBiomeFeatures.addTuftGrass(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addWhiteAshBushes(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addMallos(vegetation);
        ModBiomeFeatures.addWildCarrot(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
    }
    public static void addDarkElvenVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacements.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacements.PATCH_TALL_GRASS_2);
        vegetation.add(VegetationPlacements.PATCH_LARGE_FERN);
        vegetation.add(VegetationPlacements.PATCH_GRASS_TAIGA);
        vegetation.add(VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacements.PATCH_BERRY_RARE);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addOldPodzolOre(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addMossyBoulder(vegetation);
    }
    public static void addVolcanoVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
    }
    public static void addOasisVegetation(BiomeGenerationSettings.Builder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(AquaticPlacements.KELP_WARM);
        vegetation.add(AquaticPlacements.SEAGRASS_WARM);
        vegetation.add(VegetationPlacements.PATCH_GRASS_SAVANNA);
        vegetation.add(VegetationPlacements.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacements.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacements.PATCH_PUMPKIN);

    }
    public static void addReef(BiomeGenerationSettings.Builder generationSettings) {
        vegetation.add(ReefPlacedFeatures.REEF_KEY);
    }


    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings, float downfall) {
        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, downfall, true);
    }


    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings, float temperature, boolean precipitation) {
        return createBiome(biomeColors, spawnSettings, generationSettings, temperature, 0.5f, precipitation);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings) {
        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, 0.5f, true);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings, float temperature, float downfall, boolean precipitation) {
        undergroundOres.add(OrePlacements.ORE_DIRT);
        undergroundOres.add(OrePlacements.ORE_GRAVEL);
        undergroundOres.add(OrePlacements.ORE_GRANITE_UPPER);
        undergroundOres.add(OrePlacements.ORE_GRANITE_LOWER);
        undergroundOres.add(OrePlacements.ORE_DIORITE_UPPER);
        undergroundOres.add(OrePlacements.ORE_DIORITE_LOWER);
        undergroundOres.add(OrePlacements.ORE_ANDESITE_UPPER);
        undergroundOres.add(OrePlacements.ORE_ANDESITE_LOWER);
        undergroundOres.add(OrePlacements.ORE_TUFF);
        undergroundOres.add(OrePlacements.ORE_COAL_UPPER);
        vegetation.add(CavePlacements.GLOW_LICHEN);

        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);

        vegetation = vegetation.stream().sorted(Comparator.comparing(a -> a.location().toString())).toList();
        for (ResourceKey<PlacedFeature> feature: vegetation) {
            generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
        }
        for (ResourceKey<PlacedFeature> feature: undergroundOres.stream().sorted(Comparator.comparing(a -> a.location().toString())).toList()) {
            generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
        }

        Biome biome = (new Biome.BiomeBuilder())
                .hasPrecipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .skyColor(biomeColors.skyColor)
                        .fogColor(biomeColors.fogColor)
                        .waterColor(biomeColors.waterColor)
                        .waterFogColor(biomeColors.waterFogColor)
                        .grassColorOverride(biomeColors.grassColor)
                        .foliageColorOverride(biomeColors.foliageColor)
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
        vegetation = new ArrayList<>();
        undergroundOres = new ArrayList<>();
        return biome;
    }
}
