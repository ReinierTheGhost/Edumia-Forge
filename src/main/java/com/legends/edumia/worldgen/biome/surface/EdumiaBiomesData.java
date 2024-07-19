package com.legends.edumia.worldgen.biome.surface;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {


    private static List<EdumiaBiome> biomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> frozenBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> oasisBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> pondBiomes = new ArrayList<>();

    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome frozenPond;
    public static EdumiaBiome oasis;
    public static EdumiaBiome pond;
    public static EdumiaBiome wastePond;
    public static EdumiaBiome mirkwoodSwamp;


    public static void addBiome(Color color, EdumiaBiome biome) {
        biome.color = color;
        biomes.add(biome);
    }

    public static EdumiaBiome getBiomeByColor(Integer rgb){
        try{
            return biomes.stream().filter(x -> x.color.getRGB() == rgb).findFirst().get();
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for color".formatted(rgb));
        }
        return null;
    }

    public static EdumiaBiome getBiomeById(Short id){
        try{
            return biomes.get(id);
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public static Integer getColorByBiomeId(Short id){
        try{
            return biomes.get(id).color.getRGB();
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public void loadBiomes() {

    }

    public static EdumiaBiome getBiomeByKey(Holder<Biome> biome) {
        return biomes.stream().filter(
                        b -> b.biome.location().toString().equalsIgnoreCase(biome.unwrapKey().get().location().toString()))
                .findFirst().get();
    }
}
