package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.biome.caves.ModCaveBiomes;
import com.legends.edumia.worldgen.biome.surface.ModBiomes;
import com.legends.edumia.worldgen.congiguredfeatures.ModConfiguredFeatures;
import com.legends.edumia.worldgen.placedfeatures.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenerator  extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::boostrap)
            .add(Registries.BIOME, ModBiomes::bootstrap);
    public WorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Edumia.MOD_ID));
    }
}
