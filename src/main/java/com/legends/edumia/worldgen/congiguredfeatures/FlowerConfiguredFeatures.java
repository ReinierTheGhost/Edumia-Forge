package com.legends.edumia.worldgen.congiguredfeatures;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class FlowerConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AVELION_FLOWER_KEY = registerKey("avelion/flower");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, AVELION_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 2,
                PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder().add(BlockLoader.ASPHODEL.get().defaultBlockState(), 1))))));

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
