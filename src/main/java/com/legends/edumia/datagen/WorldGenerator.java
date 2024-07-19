package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.biome.caves.ModCaveBiomes;
import com.legends.edumia.worldgen.biome.surface.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenerator  extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.BIOME, ModCaveBiomes::bootstrap);
    public WorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Edumia.MOD_ID));
    }
}
