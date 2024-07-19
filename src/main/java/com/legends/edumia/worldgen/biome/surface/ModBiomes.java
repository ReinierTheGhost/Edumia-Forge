package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.worldgen.biome.BiomeColorsDTO;
import com.legends.edumia.worldgen.biome.EdumiaBiomeKeys;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
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
    public static final int hillySky = 8233727;
    public static final int waterSky = 8103167;
    public static final int nearHaradSky = 7254527;
    public static final int nearHaradSkyFog = 12902399;

    private static List<ResourceKey<PlacedFeature>> vegetation = new ArrayList<>();;
    private static ArrayList<ResourceKey<PlacedFeature>> undergroundOres = new ArrayList<>();;

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(EdumiaBiomeKeys.EDUMIA_VALES, createTestBiome(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8703593, 8703593)));

        context.register(EdumiaBiomeKeys.GENSAI_BEACH, createTestBiome(context, new BiomeColorsDTO(
                nearHaradSky, defaultFog, 5212644, 333363, 12107900, 10860366)));

        context.register(EdumiaBiomeKeys.EDUMIA_FOOTHILLS, createTestBiome(context, new BiomeColorsDTO(
                7508201, 10863086, defaultWater, defaultWaterFog, 6722387, 6198343)));

        context.register(EdumiaBiomeKeys.DARK_ELF_FOREST, createTestBiome(context, new BiomeColorsDTO(
                7972607, defaultFog, 4293787, 338483, 3559947, 1789719)));

        context.register(EdumiaBiomeKeys.EDUMIA_TUNDRA, createTestBiome(context, new BiomeColorsDTO(
                8364543, 10335206, 3823818, 66852, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.FROZEN_OCEAN, createTestBiome(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.FROZEN_POND, createTestBiome(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.ORC_DESERT, createTestBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 13419633, 9615182)));

        context.register(EdumiaBiomeKeys.AVELION_PLAINS, createTestBiome(context, new BiomeColorsDTO(
                8827134, 12771327, defaultWater, defaultWaterFog, 6929025, 5157703)));

        context.register(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, createTestBiome(context, new BiomeColorsDTO(
                defaultSky, 13748853, defaultWater, defaultWaterFog, 12961832, 6989412)));

        context.register(EdumiaBiomeKeys.FAIRY_SWAMP, createTestBiome(context, new BiomeColorsDTO(
                6981536, 8821922, 5080729, 1458241, 4546876, 4284215)));

        context.register(EdumiaBiomeKeys.AVELION_MOUNTAINS, createTestBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862)));

        context.register(EdumiaBiomeKeys.EDUMIA_MOUNTAINS, createTestBiome(context, new BiomeColorsDTO(
                9745151, 13426943, defaultWater, defaultWaterFog, 7643011, 7709826)));

        context.register(EdumiaBiomeKeys.GENSAI_VOLCANO, createTestBiome(context, new BiomeColorsDTO(
                4142646, 3090215, 6450777, 1513734, 3550502, 2169880)));

        context.register(EdumiaBiomeKeys.OCEAN, createTestBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4157145, defaultWaterFog, 7576434, 6588506)));

        context.register(EdumiaBiomeKeys.OCEAN_COAST, createTestBiome(context, new BiomeColorsDTO(
                8104447, defaultFog, 5145060, 330291, 7971954, 6590810)));

        context.register(EdumiaBiomeKeys.OASIS, createTestBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 7253092, 6592350)));

        context.register(EdumiaBiomeKeys.POND, createTestBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290786, defaultWaterFog, 7583083, 6592339)));


        context.register(EdumiaBiomeKeys.EDUMIA_RIVER, createTestBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290790, defaultWaterFog, 7583083, 6592339)));
        context.register(EdumiaBiomeKeys.GENSAI_REEF, createTestBiome(context, new BiomeColorsDTO(
                waterSky, 12638463, 4159204, defaultWaterFog, 10995507, 7181907)));
        context.register(EdumiaBiomeKeys.TAIGA_FOREST, createTestBiome(context, new BiomeColorsDTO(
                7508201, 10863086, defaultWater, defaultWaterFog, 8302697, 7252827)));

        context.register(EdumiaBiomeKeys.GENSAI_JUNGLE, createTestBiome(context, new BiomeColorsDTO(
                6785744, 10004675, 4421513, 402733, 2311707, 2050588)));

        context.register(EdumiaBiomeKeys.WASTE_POND, createTestBiome(context, new BiomeColorsDTO(
                8163746, 10926783, 5860963, 863008, 4020033, 2371608)));

    }

    public static Biome createTestBiome(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        //ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        //ModSpawnSettingsBuilder.addCamel(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //addOasisVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings) {
        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }


    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings, float temperature, boolean precipitation) {
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
                .downfall(0.5F)
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
