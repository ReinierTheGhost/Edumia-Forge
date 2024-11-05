package com.legends.edumia.world.congiguredfeatures.biomes;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.congiguredfeatures.trees.JungleTreeConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.trees.TropicalTreeConfiguredFeatures;
import com.legends.edumia.world.placedfeatures.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class FairyBiomesConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_FOREST_TREES_LAYER_1 = registerKey("trees/layer_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_FOREST_TREES_LAYER_2 = registerKey("trees/layer_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_FOREST_TREES_LAYER_3 = registerKey("trees/layer_3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_FOREST_TREES_LAYER_4 = registerKey("trees/layer_4");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_FOREST_TREES_LAYER_5 = registerKey("trees/layer_5");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        var holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        var registryEntryLookup = context.lookup(Registries.PLACED_FEATURE);

        Holder.Reference<PlacedFeature> noting = registryEntryLookup.getOrThrow(ModPlacedFeatures.NOTING);

        register(context, FAIRY_FOREST_TREES_LAYER_4, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(JungleTreeConfiguredFeatures.JUNGLE_TREE_4)), 0.15f),
                        new WeightedPlacedFeature(
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(TropicalTreeConfiguredFeatures.MAHOGANY_NBT)), 0.15f),
                        new WeightedPlacedFeature(
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(TropicalTreeConfiguredFeatures.KAPOK_1)), 0.15f)
                ), noting));

    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Edumia.MOD_ID, "biome/fairy/" +name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext< ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature,
                                                                                          FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
