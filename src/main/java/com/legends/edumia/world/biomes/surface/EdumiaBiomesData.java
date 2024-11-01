package com.legends.edumia.world.biomes.surface;


import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.world.biomes.EdumiaBiomeDataConfigs;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.caves.CaveType;
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
    public static List<ResourceKey<Biome>> coastalBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> riverbiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> frozenBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> oasisBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> anduinWaterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> deadMarshesBiomes = new ArrayList<>();

    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome oceanCoast;
    public static EdumiaBiome frozenPond;
    public static EdumiaBiome oasis;
    public static EdumiaBiome pond;
    public static EdumiaBiome greatRiver;
    public static EdumiaBiome wastePond;
    public static EdumiaBiome mirkwoodSwamp;
    public static EdumiaBiome deadMarshes;
    public static EdumiaBiome deadMarshesWater;

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
            LoggerUtil.getInstance().logError("MeBiomes::No registered biome has %s for id".formatted(id));
            return null;
        }
    }

    public static Integer getColorByBiomeId(Short id){
        try{
            return biomes.get(id).color.getRGB();
        } catch (Exception e){
            LoggerUtil.getInstance().logError("MeBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public static void loadBiomes() {
        defaultBiome = new EdumiaBiome(-17, EdumiaBiomeKeys.OCEAN, EdumiaBiomeDataConfigs.oceanModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers);
        oceanCoast = new EdumiaBiome(-9, EdumiaBiomeKeys.OCEAN_COAST, EdumiaBiomeDataConfigs.oceanModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers);
        // Ponds
        frozenPond = new EdumiaBiome(-10, EdumiaBiomeKeys.FROZEN_POND, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers, CaveType.FOROD);
        oasis = new EdumiaBiome(-10, EdumiaBiomeKeys.OASIS, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.beach, EdumiaBiomeDataConfigs.sandstoneLayers, CaveType.HARAD);
        pond = new EdumiaBiome(-10, EdumiaBiomeKeys.POND, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.pond, EdumiaBiomeDataConfigs.stoneLayers);
        mirkwoodSwamp = new EdumiaBiome(-10, EdumiaBiomeKeys.FAIRY_SWAMP, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers);
        greatRiver = new EdumiaBiome(-10, EdumiaBiomeKeys.GREAT_RIVER, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.river, EdumiaBiomeDataConfigs.stoneLayers);
        wastePond = new EdumiaBiome(-10, EdumiaBiomeKeys.WASTE_POND, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.ashenDirt, EdumiaBiomeDataConfigs.volcanicRockLayers);
        deadMarshes = new EdumiaBiome(0, EdumiaBiomeKeys.DEAD_MARSHES, EdumiaBiomeDataConfigs.plainsModifier.noiseModifier(0f), EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers);
        deadMarshesWater = new EdumiaBiome(-10, EdumiaBiomeKeys.DEAD_MARSHES_WATER, EdumiaBiomeDataConfigs.riverModifier, EdumiaBiomeDataConfigs.ashenDirt, EdumiaBiomeDataConfigs.volcanicRockLayers);

        // Water Biomes :
        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(75, 106, 199), oceanCoast);
        addBiome(new Color(104, 168, 222), oasis);
        addBiome(new Color(104, 168, 222), frozenPond);
        addBiome(new Color(110, 154, 218), pond);
        addBiome(new Color(75, 108, 143), wastePond);
        addBiome(new Color(90, 124, 161), deadMarshesWater);

        addBiome(new Color(101, 123, 243), new EdumiaBiome(-12, EdumiaBiomeKeys.FROZEN_OCEAN, EdumiaBiomeDataConfigs.oceanModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers, CaveType.FOROD));
        addBiome(new Color(75, 106, 199), new EdumiaBiome(-11, EdumiaBiomeKeys.OCEAN_COAST, EdumiaBiomeDataConfigs.oceanModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(83, 129, 186), new EdumiaBiome(-6, EdumiaBiomeKeys.RIVER, EdumiaBiomeDataConfigs.smallRiverModifier, EdumiaBiomeDataConfigs.river, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(99, 138, 186), greatRiver);
        addBiome(new Color(255, 0, 110), new EdumiaBiome(-8, EdumiaBiomeKeys.GENSAI_REEF, EdumiaBiomeDataConfigs.oceanModifier, EdumiaBiomeDataConfigs.ocean, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(28, 107, 86), mirkwoodSwamp);

        // Land Biomes :
        addBiome(new Color(156, 207, 113), new EdumiaBiome(4, EdumiaBiomeKeys.EDUMIA_VALES, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(234, 222, 117), new EdumiaBiome(0, EdumiaBiomeKeys.GENSAI_BEACH,
                EdumiaBiomeDataConfigs.landModifier.heightModifier(0.97f).heightModifier(0.1f).noiseModifier(0.05f),
                EdumiaBiomeDataConfigs.gensaiShores, EdumiaBiomeDataConfigs.limestoneLayers, CaveType.HARAD));
        addBiome(new Color(48, 94, 66), deadMarshes);
        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_ELF_FOREST, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(14, EdumiaBiomeKeys.EDUMIA_TUNDRA, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.forodwaith, EdumiaBiomeDataConfigs.frozenLayers, CaveType.FOROD));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(9, EdumiaBiomeKeys.ORC_DESERT, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.harad, EdumiaBiomeDataConfigs.sandstoneLayers, CaveType.HARAD));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(4, EdumiaBiomeKeys.AVELION_PLAINS, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.limeStoneLayers));
        addBiome(new Color(92, 42, 235), new EdumiaBiome(4, EdumiaBiomeKeys.OGRE_FOREST, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.gondorLayers));
        addBiome(new Color(92, 42, 109), new EdumiaBiome(6, EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.limeStoneLayers));
        addBiome(new Color(132, 137, 124), new EdumiaBiome(37, EdumiaBiomeKeys.EDUMIA_FOOTHILLS, EdumiaBiomeDataConfigs.emModifier.heightModifier(0.23f), EdumiaBiomeDataConfigs.edumiaMountainsBase, EdumiaBiomeDataConfigs.mistyMountainsLayers, CaveType.MISTIES));
        addBiome(new Color(143, 142, 142), new EdumiaBiome(53, EdumiaBiomeKeys.EDUMIA_MOUNTAINS_BASE, EdumiaBiomeDataConfigs.emModifier, EdumiaBiomeDataConfigs.edumiaMountainsBase, EdumiaBiomeDataConfigs.mistyMountainsLayers, CaveType.MISTIES));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(82, EdumiaBiomeKeys.EDUMIA_MOUNTAINS, EdumiaBiomeDataConfigs.emModifier, EdumiaBiomeDataConfigs.edumiaMountains, EdumiaBiomeDataConfigs.mistyMountainsLayers, CaveType.MISTIES));
        addBiome(new Color(185, 183, 183), new EdumiaBiome(100, EdumiaBiomeKeys.EDUMIA_MOUNTAINS_PEAKS, EdumiaBiomeDataConfigs.emPeaksModifier, EdumiaBiomeDataConfigs.edumiaMountainsPeaks, EdumiaBiomeDataConfigs.mistyMountainsLayers, CaveType.MISTIES));
        addBiome(new Color(54, 114, 12), new EdumiaBiome(7, EdumiaBiomeKeys.FAIRY_FOREST, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers));


        addBiome(new Color(56, 36, 36), new EdumiaBiome(6, EdumiaBiomeKeys.GENSAI_VOLCANO_PLAINS, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.gensaiVolcano, EdumiaBiomeDataConfigs.volcanicRockLayers, CaveType.ASHEN));
        addBiome(new Color(45, 42, 42), new EdumiaBiome(36, EdumiaBiomeKeys.MOUNT_TITLEIST_FOOT, EdumiaBiomeDataConfigs.mountTitleistModifier, EdumiaBiomeDataConfigs.gensaiVolcano, EdumiaBiomeDataConfigs.volcanicRockLayers, CaveType.ASHEN));
        addBiome(new Color(36, 31, 31), new EdumiaBiome(73, EdumiaBiomeKeys.MOUNT_TITLEIST, EdumiaBiomeDataConfigs.mountTitleistModifier, EdumiaBiomeDataConfigs.gensaiVolcano, EdumiaBiomeDataConfigs.volcanicRockLayers, CaveType.ASHEN));
        addBiome(new Color(26, 23, 23), new EdumiaBiome(96, EdumiaBiomeKeys.MOUNT_TITLEIST_PEAK, EdumiaBiomeDataConfigs.mountTitleistModifier, EdumiaBiomeDataConfigs.gensaiVolcano, EdumiaBiomeDataConfigs.volcanicRockLayers, CaveType.ASHEN));
        addBiome(new Color(96, 39, 13), new EdumiaBiome(90, EdumiaBiomeKeys.MOUNT_TITLEIST_CRATER, EdumiaBiomeDataConfigs.mountTitleistModifier.heightModifier(0.36f).noiseModifier(1.0f).expansionWeight(new byte[]{2, 3}), EdumiaBiomeDataConfigs.gensaiVolcano, EdumiaBiomeDataConfigs.volcanicRockLayers, CaveType.ASHEN));



        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.TAIGA_FOREST, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(48, 109, 42), new EdumiaBiome(7, EdumiaBiomeKeys.GENSAI_JUNGLE, EdumiaBiomeDataConfigs.landModifier, EdumiaBiomeDataConfigs.grassPlains, EdumiaBiomeDataConfigs.stoneLayers));
        addBiome(new Color(222, 227, 191), new EdumiaBiome(0, EdumiaBiomeKeys.AVELION_SANDY_SHORES,
                EdumiaBiomeDataConfigs.landModifier.heightModifier(0.97f).heightModifier(0.1f).noiseModifier(0.05),
                EdumiaBiomeDataConfigs.whiteShores, EdumiaBiomeDataConfigs.sandstoneLayers));
        addBiome(new Color(74, 213, 138), new EdumiaBiome(30, EdumiaBiomeKeys.AVELION_ROCKY_SHORES,
                EdumiaBiomeDataConfigs.landModifier.heightModifier(0.76f),
                EdumiaBiomeDataConfigs.avelionRockShore, EdumiaBiomeDataConfigs.avelionLayers));


        riverbiomes.add(EdumiaBiomeKeys.RIVER);
        riverbiomes.add(EdumiaBiomeKeys.FROZEN_RIVER);

        waterBiomes.add(EdumiaBiomeKeys.DEAD_MARSHES_WATER);
        waterBiomes.add(EdumiaBiomeKeys.FROZEN_POND);
        waterBiomes.add(EdumiaBiomeKeys.FROZEN_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN_COAST);
        waterBiomes.add(EdumiaBiomeKeys.RIVER);
        waterBiomes.add(EdumiaBiomeKeys.GENSAI_REEF);
        waterBiomes.add(EdumiaBiomeKeys.AVELION_ROCKY_SHORES);
        waterBiomes.add(EdumiaBiomeKeys.AVELION_SANDY_SHORES);

        anduinWaterBiomes.add(EdumiaBiomeKeys.GREAT_RIVER);


        frozenBiomes.add(EdumiaBiomeKeys.EDUMIA_TUNDRA);



        oasisBiomes.add(EdumiaBiomeKeys.ORC_DESERT);


        wastePondBiomes.add(EdumiaBiomeKeys.GENSAI_VOLCANO_PLAINS);

        deadMarshesBiomes.add(EdumiaBiomeKeys.DEAD_MARSHES);
    }

    public static EdumiaBiome getBiomeByKey(Holder<Biome> biome) {
        return biomes.stream().filter(
                b -> b.biome.location().toString().equalsIgnoreCase(biome.unwrapKey().get().location().toString()))
                .findFirst().orElse(defaultBiome);
    }
}
