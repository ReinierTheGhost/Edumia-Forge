package com.legends.edumia.worldgen.placedfeatures;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.worldgen.congiguredfeatures.beach.BeachConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class BeachPlacedFeatures {

    public static final ResourceKey<PlacedFeature> WHITE_SAND_LAYER_FIRST = registerKey("beach/layers/white/first");
    public static final ResourceKey<PlacedFeature> WHITE_SAND_LAYER_SECOND = registerKey("beach/layers/white/second");
    public static final ResourceKey<PlacedFeature> WHITE_SAND_LAYER_THIRD = registerKey("beach/layers/white/third");

    public static void boostrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WHITE_SAND_LAYER_FIRST, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_FIRST),
                List.of(CountPlacement.of(80), CountPlacement.of(10), BiomeFilter.biome(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                        BlockLoader.WHITE_SAND.get()), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER.get()))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND.get()))),
                        BiomeFilter.biome()));

        register(context, WHITE_SAND_LAYER_SECOND, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_SECOND),
                List.of(CountPlacement.of(80), CountPlacement.of(10), BiomeFilter.biome(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                         BlockLoader.WHITE_SAND.get()), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER.get()))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND.get()))),
                        BiomeFilter.biome()));

        register(context, WHITE_SAND_LAYER_THIRD, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_THIRD),
                List.of(CountPlacement.of(80), CountPlacement.of(10), BiomeFilter.biome(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                         BlockLoader.WHITE_SAND.get()), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER.get()))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND.get()),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND.get()))),
                        BiomeFilter.biome()));

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Edumia.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
