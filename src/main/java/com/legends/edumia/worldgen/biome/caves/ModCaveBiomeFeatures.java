package com.legends.edumia.worldgen.biome.caves;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ModCaveBiomeFeatures {
    public static void addAmethystGeode(BiomeGenerationSettings.Builder builder) {
    }
    public static void addCitrineGeode(BiomeGenerationSettings.Builder builder) {
    }
    public static void addGlowstoneGeode(BiomeGenerationSettings.Builder builder) {
    }
    public static void addRedAgateGeode(BiomeGenerationSettings.Builder builder) {
    }
    public static void addQuartzGeode(BiomeGenerationSettings.Builder builder) {
    }

    public static void addAxolotls(MobSpawnSettings.Builder spawnSettings) {
    }
    public static void addBats(MobSpawnSettings.Builder spawnSettings) {
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 3, 1, 2));
    }
    public static void addFrogs(MobSpawnSettings.Builder spawnSettings) {
    }
    public static void addSnails(MobSpawnSettings.Builder spawnSettings) {
    }

    public static void addCaveTrolls(MobSpawnSettings.Builder spawnSettings) {
    }
}
