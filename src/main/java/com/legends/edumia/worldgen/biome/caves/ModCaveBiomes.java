package com.legends.edumia.worldgen.biome.caves;

import com.legends.edumia.worldgen.biome.BiomeColorsDTO;
import com.legends.edumia.worldgen.biome.EdumiaBiomeKeys;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiome;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.phys.Vec2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModCaveBiomes {
    public static final int defaultSky = 7907327;
    public static final int defaultFog = 12638463;
    public static final int defaultWater = 4159204;
    public static final int defaultWaterFog = 329011;

    private static List<ResourceKey<PlacedFeature>> undergroundOres = new ArrayList<>();
    ;

    public static CaveBiomesMap defaultCaves = new CaveBiomesMap();
    public static CaveBiomesMap ashCaves = new CaveBiomesMap();
    public static CaveBiomesMap forodCaves = new CaveBiomesMap();
    public static CaveBiomesMap desertCaves = new CaveBiomesMap();

    public static void init() {
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.LUSH_CAVE, new Vec2(-1.0f,0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2(1.0f,0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.MUD_CAVE, new Vec2(1.0f,1.0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.FUNGUS_CAVE, new Vec2(0f,-1.0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASIC_CAVE, new Vec2(0.0f,0.8f)));

        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2(1.0f,0.5f)));
        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASALT_CAVE, new Vec2(-1.0f,0.5f)));
        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.MAGMA_CAVE, new Vec2(0.0f,-1.0f)));

        desertCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2(1.0f,0f)));
        desertCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRY_CAVE, new Vec2(0.0f,0f)));
        desertCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASIC_CAVE, new Vec2(-1.0f,0f)));

        forodCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.ICE_CAVE, new Vec2(-0.5f,0f)));
        forodCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2(1.0f,0f)));
    }

    public static ResourceKey<Biome> getBiome(Vec2 coordinates, EdumiaBiome surfaceBiome) {
        return switch (surfaceBiome.caveType) {
            case ASHEN -> ashCaves.getClosestBiome(coordinates);
            case DESERT -> desertCaves.getClosestBiome(coordinates);
            case FROZEN -> forodCaves.getClosestBiome(coordinates);
            default -> defaultCaves.getClosestBiome(coordinates);
        };
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(EdumiaBiomeKeys.BASIC_CAVE, createBasicCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));
        context.register(EdumiaBiomeKeys.LUSH_CAVE, createLushCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8703593, 8703593)));
        context.register(EdumiaBiomeKeys.DRIPSTONE_CAVE, createDripstoneCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));
        context.register(EdumiaBiomeKeys.MUD_CAVE, createMudCaves(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 7435337, 7905386)));
        context.register(EdumiaBiomeKeys.FUNGUS_CAVE, createFungusCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 5869935, 6263141)));

        context.register(EdumiaBiomeKeys.MITHRIL_CAVE, createMithrilCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));

        context.register(EdumiaBiomeKeys.BASALT_CAVE, createBasaltCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 9534809, 8878692)));
        context.register(EdumiaBiomeKeys.MAGMA_CAVE, createMagmaCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 9527897, 8876132)));

        context.register(EdumiaBiomeKeys.DRY_CAVE, createDryCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10928742, 11259497)));
        context.register(EdumiaBiomeKeys.ICE_CAVE, createIceCaves(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 11121530, 10990723)));

    }

    public static Biome createBasicCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createLushCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        ModCaveBiomeFeatures.addAxolotls(spawnSettings);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        BiomeDefaultFeatures.addPlainGrass(generationSettings);

        undergroundOres.add(OrePlacements.ORE_CLAY);
        undergroundOres.add(CavePlacements.UNDERWATER_MAGMA);
        undergroundOres.add(MiscOverworldPlacements.DISK_SAND);
        undergroundOres.add(MiscOverworldPlacements.DISK_CLAY);
        undergroundOres.add(MiscOverworldPlacements.DISK_GRAVEL);
        //undergroundOres.add(CrystalPlacedFeatures.ELVEN_CRYSTAL);


        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createDripstoneCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        undergroundOres.add(CavePlacements.LARGE_DRIPSTONE);
        undergroundOres.add(CavePlacements.DRIPSTONE_CLUSTER);
        undergroundOres.add(CavePlacements.POINTED_DRIPSTONE);
        undergroundOres.add(MiscOverworldPlacements.DISK_GRAVEL);
        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMudCaves(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        ModCaveBiomeFeatures.addSnails(spawnSettings);
        ModCaveBiomeFeatures.addFrogs(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        undergroundOres.add(MiscOverworldPlacements.DISK_GRAVEL);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createFungusCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        ModCaveBiomeFeatures.addSnails(spawnSettings);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        undergroundOres.add(MiscOverworldPlacements.DISK_GRAVEL);


        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMithrilCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createBasaltCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, false);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, NetherPlacements.SMALL_BASALT_COLUMNS);

        undergroundOres.add(MiscOverworldPlacements.DISK_GRAVEL);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMagmaCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, false);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, NetherPlacements.DELTA);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createDryCave(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));


        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, false);
    }

    public static Biome createIceCaves(BootstapContext<Biome> context, BiomeColorsDTO biomeColors) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, false);
    }

    private static void addBasicFeatures(BiomeGenerationSettings.Builder generationSettings, boolean vanillaRocks) {
        ModCaveBiomeFeatures.addAmethystGeode(generationSettings);
        ModCaveBiomeFeatures.addCitrineGeode(generationSettings);
        ModCaveBiomeFeatures.addGlowstoneGeode(generationSettings);
        ModCaveBiomeFeatures.addRedAgateGeode(generationSettings);
        ModCaveBiomeFeatures.addQuartzGeode(generationSettings);

        undergroundOres.add(MiscOverworldPlacements.SPRING_WATER);


        undergroundOres.add(OrePlacements.ORE_GRAVEL);

        if (vanillaRocks) {
            undergroundOres.add(OrePlacements.ORE_DIRT);
            undergroundOres.add(OrePlacements.ORE_GRANITE_UPPER);
            undergroundOres.add(OrePlacements.ORE_GRANITE_LOWER);
            undergroundOres.add(OrePlacements.ORE_DIORITE_UPPER);
            undergroundOres.add(OrePlacements.ORE_DIORITE_LOWER);
            undergroundOres.add(OrePlacements.ORE_ANDESITE_UPPER);
            undergroundOres.add(OrePlacements.ORE_ANDESITE_LOWER);
        }
        undergroundOres.add(OrePlacements.ORE_TUFF);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, MobSpawnSettings.Builder spawnSettings, BiomeGenerationSettings.Builder generationSettings, float temperature, boolean precipitation) {
        ModCaveBiomeFeatures.addBats(spawnSettings);
        ModCaveBiomeFeatures.addCaveTrolls(spawnSettings);

        undergroundOres = undergroundOres.stream().sorted(Comparator.comparing(a -> a.location().toString())).toList();
        for (ResourceKey<PlacedFeature> feature : undergroundOres) {
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
        undergroundOres = new ArrayList<>();
        return biome;

    }
}
