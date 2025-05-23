package com.legends.edumia.world.treegrowers;

import com.legends.edumia.world.congiguredfeatures.FlowerConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.TreeConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.trees.JungleTreeConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.trees.KapokTreeConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.trees.PalmConfiguredFeatures;
import com.legends.edumia.world.congiguredfeatures.trees.TropicalTreeConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class TestTreeGrower  extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return FlowerConfiguredFeatures.FOXGLOVE_ORANGE_FLOWER_KEY;
    }
}
