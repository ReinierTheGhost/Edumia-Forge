package com.legends.edumia.worldgen.placedfeatures;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.congiguredfeatures.FlowerConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class FlowerPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AVELION_FLOWER_KEY = registerKey("avelion/flower");

    public static void boostrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, AVELION_FLOWER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(FlowerConfiguredFeatures.AVELION_FLOWER_KEY),
                List.of(CountPlacement.of(3),
                        InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                        BiomeFilter.biome()));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Edumia.MOD_ID, "flowers/" + name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
