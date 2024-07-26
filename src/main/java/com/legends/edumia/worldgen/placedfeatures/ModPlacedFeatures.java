package com.legends.edumia.worldgen.placedfeatures;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.congiguredfeatures.ModConfiguredFeatures;
import com.legends.edumia.worldgen.placedfeatures.biomes.BiomePlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.boulders.BoulderPlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.crystrals.CrystalPlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.ocean.ReefPlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.plants.ReedsPlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.trees.BorealTreePlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.trees.OakTreePlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.worldgen.placedfeatures.trees.TropicalTreePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NOTING = registerKey("noting");

    public static void boostrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NOTING, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOTING),
                List.of());

        TreePlacedFeatures.boostrap(context);
        BeachPlacedFeatures.boostrap(context);
        ReefPlacedFeatures.boostrap(context);
        FlowerPlacedFeatures.boostrap(context);
        TropicalTreePlacedFeatures.boostrap(context);
        TemperateTreePlacedFeatures.boostrap(context);
        BorealTreePlacedFeatures.boostrap(context);
        BoulderPlacedFeatures.bootstrap(context);
        CrystalPlacedFeatures.bootstrap(context);
        ReedsPlacedFeatures.boostrap(context);
        OakTreePlacedFeatures.boostrap(context);
        BiomePlacedFeatures.boostrap(context);
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Edumia.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
