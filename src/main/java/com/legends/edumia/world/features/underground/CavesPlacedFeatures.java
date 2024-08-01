package com.legends.edumia.world.features.underground;


import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CavesPlacedFeatures {
    public static final int MAX_MITHRIL_HEIGHT = -55;

    public static void bootstrap(BootstapContext<PlacedFeature> featureRegisterable) {

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Edumia.MOD_ID, name));
    }


}
