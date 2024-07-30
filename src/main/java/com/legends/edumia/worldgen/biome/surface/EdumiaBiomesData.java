package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.blocks.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.worldgen.biome.EdumiaBiomeKeys;
import com.legends.edumia.worldgen.biome.EdumiaBiomesDataConfigs;
import com.legends.edumia.worldgen.biome.caves.CaveType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {


    private static List<EdumiaBiome> biomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> coastalBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> riverBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> frozenBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> swampBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> oasisBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> pondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> marchesBiomes = new ArrayList<>();

    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome oceanCoast;
    public static EdumiaBiome frozenPond;
    public static EdumiaBiome oasis;
    public static EdumiaBiome pond;
    public static EdumiaBiome greatRiver;
    public static EdumiaBiome wastePond;
    public static EdumiaBiome swamp;
    public static EdumiaBiome marches;
    public static EdumiaBiome marchesWater;


    public static void addBiome(Color color, EdumiaBiome biome) {
        biome.color = color;
        biomes.add(biome);
    }

    public static EdumiaBiome getBiomeByColor(Integer rgb) throws Exception{
        try{
            return biomes.stream().filter(x -> x.color.getRGB() == rgb).findFirst().get();
        } catch (Exception e){
            Color color = new Color(rgb);
            LoggerUtil.getInstance().logError("EdumiaBiomes::No registered biome has %s for color".formatted(color.toString()));
            throw new Exception();
        }
    }

    public static EdumiaBiome getBiomeById(Short id){
        try{
            return biomes.get(id);
        } catch (Exception e){
            LoggerUtil.getInstance().logError("EdumiaBiomes::No registered biome has %s for id".formatted(id));
            return null;
        }
    }

    public static Integer getColorByBiomeId(Short id){
        try{
            return biomes.get(id).color.getRGB();
        } catch (Exception e){
            LoggerUtil.getInstance().logError("EdumiaBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public void loadBiomes() {
        defaultBiome = new EdumiaBiome(-17, EdumiaBiomeKeys.OCEAN, EdumiaBiomesDataConfigs.oceanModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers);
        oceanCoast = new EdumiaBiome(-11, EdumiaBiomeKeys.OCEAN_COAST, EdumiaBiomesDataConfigs.oceanModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers);
        /** Ponds*/
        frozenPond = new EdumiaBiome(-10, EdumiaBiomeKeys.FROZEN_POND,  EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers, CaveType.FROZEN);
        oasis = new EdumiaBiome(-10, EdumiaBiomeKeys.OASIS,  EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.beach, EdumiaBiomesDataConfigs.sandstoneLayers, CaveType.DESERT);
        pond = new EdumiaBiome(-10, EdumiaBiomeKeys.POND,  EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers);
        swamp = new EdumiaBiome(-10, EdumiaBiomeKeys.FAIRY_SWAMP, EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers);
        greatRiver = new EdumiaBiome(-10, EdumiaBiomeKeys.EDUMIA_RIVER, EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.river, EdumiaBiomesDataConfigs.stoneLayers);
        wastePond = new EdumiaBiome(-10, EdumiaBiomeKeys.WASTE_POND, EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.river, EdumiaBiomesDataConfigs.stoneLayers);
        marches = new EdumiaBiome(0, EdumiaBiomeKeys.MARSHES, EdumiaBiomesDataConfigs.plainsModifier.noiseModifier(0f), EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers);
        marchesWater = new EdumiaBiome(-10, EdumiaBiomeKeys.MARSHES_WATER, EdumiaBiomesDataConfigs.riverModifier, EdumiaBiomesDataConfigs.river, EdumiaBiomesDataConfigs.stoneLayers);
        // Water Biomes :
        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(75, 106, 199), oceanCoast);
        addBiome(new Color(104, 168, 222), oasis);
        addBiome(new Color(104, 168, 222), frozenPond);
        addBiome(new Color(110, 154, 218), pond);
        addBiome(new Color(89, 136, 129), swamp);
        addBiome(new Color(75, 108, 143), wastePond);
        addBiome(new Color(90, 124, 161), marchesWater);
        addBiome(new Color(83, 129, 186), greatRiver);

        addBiome(new Color(101, 123, 243), new EdumiaBiome(-12, EdumiaBiomeKeys.FROZEN_OCEAN, EdumiaBiomesDataConfigs.oceanModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers, CaveType.FROZEN));
        addBiome(new Color(255, 0, 110), new EdumiaBiome(-1, EdumiaBiomeKeys.GENSAI_REEF, EdumiaBiomesDataConfigs.oceanModifier, EdumiaBiomesDataConfigs.beach, EdumiaBiomesDataConfigs.sandstoneLayers));



        addBiome(new Color(156, 207, 113), new EdumiaBiome(4, EdumiaBiomeKeys.EDUMIA_VALES, EdumiaBiomesDataConfigs.oceanModifier, EdumiaBiomesDataConfigs.ocean, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(234, 222, 117), new EdumiaBiome(1, EdumiaBiomeKeys.GENSAI_BEACH, EdumiaBiomesDataConfigs.landModifier, EdumiaBiomesDataConfigs.beach, EdumiaBiomesDataConfigs.sandstoneLayers, CaveType.DESERT));
        addBiome(new Color(132, 137, 124), new EdumiaBiome(35, EdumiaBiomeKeys.EDUMIA_FOOTHILLS, EdumiaBiomesDataConfigs.foothillModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_ELF_FOREST, EdumiaBiomesDataConfigs.darkWoodsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(14, EdumiaBiomeKeys.EDUMIA_TUNDRA, EdumiaBiomesDataConfigs.fieldsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers, CaveType.FROZEN));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(4, EdumiaBiomeKeys.ORC_DESERT, EdumiaBiomesDataConfigs.plainsModifier, EdumiaBiomesDataConfigs.beach, EdumiaBiomesDataConfigs.sandstoneLayers, CaveType.DESERT));
        addBiome(new Color(92, 42, 109), new EdumiaBiome(5, EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, EdumiaBiomesDataConfigs.darkWoodsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(178, 0, 255), new EdumiaBiome(35, EdumiaBiomeKeys.AVELION_MOUNTAINS, EdumiaBiomesDataConfigs.mountainModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers, CaveType.MISTIES));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(5, EdumiaBiomeKeys.AVELION_PLAINS, EdumiaBiomesDataConfigs.plainsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(53, EdumiaBiomeKeys.EDUMIA_MOUNTAINS, EdumiaBiomesDataConfigs.mountainModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers, CaveType.MISTIES));
        addBiome(new Color(36, 31, 31), new EdumiaBiome(15, EdumiaBiomeKeys.GENSAI_VOLCANO, EdumiaBiomesDataConfigs.volcanicMountainModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers, CaveType.ASHEN));
        addBiome(new Color(92, 42, 235), new EdumiaBiome(5, EdumiaBiomeKeys.OGRE_FOREST, EdumiaBiomesDataConfigs.darkWoodsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));
        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.TAIGA_FOREST, EdumiaBiomesDataConfigs.darkWoodsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));

        addBiome(new Color(48, 109, 42), new EdumiaBiome(7, EdumiaBiomeKeys.GENSAI_JUNGLE, EdumiaBiomesDataConfigs.darkWoodsModifier, EdumiaBiomesDataConfigs.grassPlains, EdumiaBiomesDataConfigs.stoneLayers));

        coastalBiomes.add(EdumiaBiomeKeys.GENSAI_BEACH);


        waterBiomes.add(EdumiaBiomeKeys.FROZEN_POND);
        waterBiomes.add(EdumiaBiomeKeys.FROZEN_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN_COAST);
        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_RIVER);
        waterBiomes.add(EdumiaBiomeKeys.GENSAI_REEF);

        frozenBiomes.add(EdumiaBiomeKeys.EDUMIA_TUNDRA);

        swampBiomes.add(EdumiaBiomeKeys.DARK_ELF_FOREST);

//        oasisBiomes.add(EdumiaBiomeKeys.ORC_DESERT);

        wastePondBiomes.add(EdumiaBiomeKeys.GENSAI_VOLCANO);
    }

    public static EdumiaBiome getBiomeByKey(Holder<Biome> biome) {
        return biomes.stream().filter(
                        b -> b.biome.location().toString().equalsIgnoreCase(biome.unwrapKey().get().location().toString()))
                .findFirst().get();
    }
}
