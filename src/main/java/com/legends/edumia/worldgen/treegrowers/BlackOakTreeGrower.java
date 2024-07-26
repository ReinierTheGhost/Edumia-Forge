package com.legends.edumia.worldgen.treegrowers;

import com.legends.edumia.worldgen.congiguredfeatures.trees.OakTreeConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class BlackOakTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return OakTreeConfiguredFeatures.BLACK_OAK_KEY;
    }
}