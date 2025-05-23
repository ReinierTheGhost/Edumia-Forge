package com.legends.edumia.world.trees.foliageplacer;

import com.legends.edumia.world.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import javax.swing.tree.TreeNode;

public class ParasolPalmFoliagePlacer extends FoliagePlacer {

    public static final Codec<ParasolPalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            foliagePlacerParts(instance).apply(instance, ParasolPalmFoliagePlacer::new));
    protected ParasolPalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public ParasolPalmFoliagePlacer() {
        this(ConstantInt.of(0), ConstantInt.of(0));
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EdumiaFoliagePlacerTypes.PARASOL_PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter leaves, RandomSource random, TreeConfiguration config, int trunkHeight,
                                 FoliagePlacer.FoliageAttachment foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.pos();
        
        generateLeaf(world, leaves, pos.offset(0, 0, 0), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1,  1), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1,  2), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1,  3), random, config);
        generateLeaf(world, leaves, pos.offset(0, -2,  4), random, config);
        generateLeaf(world, leaves, pos.offset(1, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset(2, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset(3, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset( 4, -2, 0), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1, -1), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1, -2), random, config);
        generateLeaf(world, leaves, pos.offset(0, -1, -3), random, config);
        generateLeaf(world, leaves, pos.offset(0, -2, -4), random, config);
        generateLeaf(world, leaves, pos.offset(-1, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset(-1, -1, -1), random, config);
        generateLeaf(world, leaves, pos.offset(-1, -1,  1), random, config);
        generateLeaf(world, leaves, pos.offset(1, -1, -1), random, config);
        generateLeaf(world, leaves, pos.offset(1, -1,  1), random, config);
        generateLeaf(world, leaves, pos.offset(-2, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset(-3, -1, 0), random, config);
        generateLeaf(world, leaves, pos.offset(-4, -2, 0), random, config);
        generateLeaf(world, leaves, pos.offset(2, -1,  2), random, config);
        generateLeaf(world, leaves, pos.offset(2, -1, -2), random, config);
        generateLeaf(world, leaves, pos.offset(-2, -1,  2), random, config);
        generateLeaf(world, leaves, pos.offset(-2, -1, -2), random, config);
        generateLeaf(world, leaves, pos.offset(3, -2,  3), random, config);
        generateLeaf(world, leaves, pos.offset(3, -2, -3), random, config);
        generateLeaf(world, leaves, pos.offset(-3, -2,  3), random, config);
        generateLeaf(world, leaves, pos.offset(-3, -2, -3), random, config);
        
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private void generateLeaf(LevelSimulatedReader seedReader, FoliageSetter leaves, BlockPos pos, RandomSource random,
                              TreeConfiguration config) {
        if (TreeFeature.isAirOrLeaves(seedReader, pos)) {
            leaves.set(pos, config.foliageProvider.getState(random, pos).setValue(LeavesBlock.PERSISTENT, true));
        }
    }
}
