package com.legends.edumia.worldgen.congiguredfeatures;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.congiguredfeatures.beach.BeachConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.biomes.BiomeConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.biomes.OgreBiomeConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.boulders.BoulderConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.crystals.CrystalConfiguresFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.ocean.ReefConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.plants.ReedsConfiguredFeatures;
import com.legends.edumia.worldgen.congiguredfeatures.trees.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> NOTING = registerKey("noting");

    public static void boostrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, NOTING, Feature.NO_OP, new NoneFeatureConfiguration());

        BeechTreeConfiguredFeatures.bootstrap(context);
        TreeConfiguredFeatures.bootstrap(context);
        SaplingConfiguredFeatures.bootstrap(context);
        BushesConfiguredFeatures.bootstrap(context);
        BeachConfiguredFeatures.bootstrap(context);
        ReefConfiguredFeatures.bootstrap(context);
        OakTreeConfiguredFeatures.bootstrap(context);
        FlowerConfiguredFeatures.bootstrap(context);
        TropicalTreeConfiguredFeatures.bootstrap(context);
        TemperateTreeConfiguredFeatures.bootstrap(context);
        BorealTreeConfiguredFeatures.bootstrap(context);
        BoulderConfiguredFeatures.bootstrap(context);
        CrystalConfiguresFeatures.bootstrap(context);
        ReedsConfiguredFeatures.bootstrap(context);
        BiomeConfiguredFeatures.bootstrap(context);
        FruitTreeConfiguredFeatures.bootstrap(context);
        OgreBiomeConfiguredFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext< ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature,
                                                                                          FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
