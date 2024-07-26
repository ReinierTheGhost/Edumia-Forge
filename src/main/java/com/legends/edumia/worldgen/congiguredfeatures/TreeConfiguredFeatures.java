package com.legends.edumia.worldgen.congiguredfeatures;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.blocksets.ModNatureBlocks;
import com.legends.edumia.blocks.blocksets.WoodBlockSets;
import com.legends.edumia.worldgen.trees.foliageplacer.*;
import com.legends.edumia.worldgen.trees.treedecorators.PineBranchDecorator;
import com.legends.edumia.worldgen.trees.trunkplacers.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeConfiguredFeatures {


    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("tree/apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_KEY = registerKey("tree/test/test_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TEST2_KEY = registerKey("tree/test/test2_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GHOST_GUM_KEY = registerKey("tree/ghost_gum_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GHOST_GUM_BEES_KEY = registerKey("tree/ghost_gum_bees_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_ASH_KEY = registerKey("tree/white_ash_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_KEY = registerKey("tree/fir_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("tree/pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_KEY = registerKey("tree/redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKTHORN_KEY = registerKey("tree/blackthorn_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGON_BLOOD_SMALL_KEY = registerKey("tree/dragon_blood_small");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        BeehiveDecorator beehiveTreeDecorator = new BeehiveDecorator(0.03f);
        BlockStateProvider pineBranchProvider = (new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(WoodBlockSets.PINE.log().get().defaultBlockState(), 2)
                .add(WoodBlockSets.PINE.strippedLog().get().defaultBlockState(), 1)));


        register(context, TEST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.MAPLE.log().get()),
                new YellowMerantiTrunkPlacer(12, 13, 14),
                BlockStateProvider.simple(ModNatureBlocks.MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(6), ConstantInt.of(4), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines().build ());

        register(context, DRAGON_BLOOD_SMALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.DRAGON_BLOOD.log().get()),
                new DragonBloodTrunkPlacer(3, 4, 0,
                        WoodBlockSets.DRAGON_BLOOD.wood().get().defaultBlockState(),
                        WoodBlockSets.DRAGON_BLOOD.woodWall().get().defaultBlockState()),
                BlockStateProvider.simple(WoodBlockSets.DRAGON_BLOOD.leaves().get()),
                new DragonBloodFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());


        register(context, TEST2_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.BEECH.log().get()),
                new ForkingTrunkPlacer(5, 4, 8),
                BlockStateProvider.simple(WoodBlockSets.BEECH.leaves().get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 2),
                new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(beehiveTreeDecorator)).ignoreVines().build());

        register(context, BLACKTHORN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.BLACKTHORN.log().get()),
                new ForkingTrunkPlacer(5, 4, 0),
                BlockStateProvider.simple(WoodBlockSets.BLACKTHORN.leaves().get()),
                new AspenFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(2)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, REDWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.REDWOOD.log().get()),
                new MediumRedwoodTrunkPlacer(WoodBlockSets.REDWOOD.wood().get().defaultBlockState()),
                BlockStateProvider.simple(WoodBlockSets.REDWOOD.leaves().get()),
                new EdumiaPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(20)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.PINE.log().get()),
                new StraightTrunkPlacer(12, 12, 0),
                BlockStateProvider.simple(WoodBlockSets.PINE.leaves().get()),
                new PinusFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), UniformInt.of(6, 12)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                .decorators(Collections.singletonList(new
                        PineBranchDecorator(WoodBlockSets.PINE.log().get().defaultBlockState(), 0.75f))).build());


        register(context, FIR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.FIR.log().get()),
                new StraightTrunkPlacer(6, 7, 0),
                BlockStateProvider.simple(WoodBlockSets.FIR.leaves().get()),
                new FirFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(2),
                        UniformInt.of(7, 11)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());






        register(context, WHITE_ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.WHITE_ASH.log().get()),
                new BoughsTrunkPlacer(10, 4, 0, WoodBlockSets.WHITE_ASH.wood().get().defaultBlockState(),
                        WoodBlockSets.WHITE_ASH.woodWall().get().defaultBlockState()),
                BlockStateProvider.simple(WoodBlockSets.WHITE_ASH.leaves().get()),
                new BoughsFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());


        register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(WoodBlockSets.APPLE.log().get()),
                new StraightTrunkPlacer(4, 3, 2),
                BlockStateProvider.simple(WoodBlockSets.APPLE.leaves().get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, GHOST_GUM_KEY, Feature.TREE, buildClassicTreeWithSpecifiedFoliage(
                WoodBlockSets.GHOST_GUM.log().get().defaultBlockState(),
                BlockStateProvider.simple(ModNatureBlocks.GHOST_GUM_LEAVES.get()), 5, 4,
                new GhostGumFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 4),
                false, false));

        register(context, GHOST_GUM_BEES_KEY, Feature.TREE, buildClassicTreeWithSpecifiedFoliage(
                WoodBlockSets.GHOST_GUM.log().get().defaultBlockState(),
                BlockStateProvider.simple(ModNatureBlocks.GHOST_GUM_LEAVES.get()), 5, 4,
                new GhostGumFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 4),
                true, false));

    }

    private static TreeConfiguration buildClassicTreeWithSpecifiedFoliage(BlockState log, BlockStateProvider leavesPool, int baseHeight,
                                                                          int heightRandA, FoliagePlacer foliage, boolean bees, boolean vines){
        List<TreeDecorator> decorators = new ArrayList<>();
        BeehiveDecorator beehiveTreeDecorator = new BeehiveDecorator(0.05f);

        if (bees){
            decorators.add(beehiveTreeDecorator);
        }

        if (vines){
            decorators.add(TrunkVineDecorator.INSTANCE);
            decorators.add(new LeaveVineDecorator(0.25f));
        }

        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),new StraightTrunkPlacer(baseHeight,
                heightRandA, 0), leavesPool,
                foliage, new TwoLayersFeatureSize(1, 0, 1))).ignoreVines()
                .decorators(ImmutableList.copyOf(decorators)).build();
    }

    private static TreeConfiguration buildEdumiaMegaTree(BlockState log, BlockState leaves, BlockState wood, BlockState strippedLog,
                                                         boolean vines){
        List<TreeDecorator> decorators = new ArrayList<>();

        if (vines){
            decorators.add(TrunkVineDecorator.INSTANCE);
            decorators.add(new LeaveVineDecorator(0.5f));
        }

        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new EdumiaGiantTrunkPlacer(20, 20, 0, wood, strippedLog),
                BlockStateProvider.simple(leaves.setValue(LeavesBlock.PERSISTENT, true)),
                new ClusterFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(ImmutableList.copyOf(decorators)).build());

    }
    public static TreeConfiguration buildClassicTree(BlockState log, BlockStateProvider leavesPool, int baseHeight, int heightRandA, boolean bees, boolean vines){
        return buildClassicTreeWithSpecifiedFoliage(log, leavesPool, baseHeight, heightRandA,
                new BlobFoliagePlacer(ConstantInt.of(2 ), ConstantInt.of(0), 3), bees, vines);
    }

    public static TreeConfiguration buildClassicTree(BlockState log, BlockState leaves, int baseHeight, int heightRandA){
        return buildClassicTree(log, BlockStateProvider.simple(leaves), baseHeight, heightRandA, false, false);
    }
    public static TreeConfiguration buildClassicTree(BlockState log, BlockStateProvider leavesPool, int baseHeight, int heightRandA){
        return buildClassicTree(log, leavesPool, baseHeight, heightRandA, false, false);
    }
    public static TreeConfiguration buildClassicTreeWithBees(BlockState log, BlockState leaves, int baseHeight, int heightRandA){
        return buildClassicTree(log, BlockStateProvider.simple(leaves), baseHeight, heightRandA, true, false);
    }
    public static TreeConfiguration buildClassicTreeWithBees(BlockState log, BlockStateProvider leavesPool, int baseHeight, int heightRandA){
        return buildClassicTree(log, leavesPool, baseHeight, heightRandA, true, false);
    }

    public static TreeConfiguration buildClassicTreeWithVines(BlockState log, BlockState leaves, int baseHeight, int heightRandA){
        return buildClassicTree(log, BlockStateProvider.simple(leaves), baseHeight, heightRandA, false, true);
    }
    public static TreeConfiguration buildClassicTreeWithVines(BlockState log, BlockStateProvider leavesPool, int baseHeight, int heightRandA){
        return buildClassicTree(log, leavesPool, baseHeight, heightRandA, false, true);
    }
    public static TreeConfiguration buildClassicTreeWithBeesAndVines(BlockState log, BlockState leaves, int baseHeight, int heightRandA){
        return buildClassicTree(log, BlockStateProvider.simple(leaves), baseHeight, heightRandA, true, true);
    }
    public static TreeConfiguration buildClassicTreeWithBeesAndVines(BlockState log, BlockStateProvider leavesPool, int baseHeight, int heightRandA){
        return buildClassicTree(log, leavesPool, baseHeight, heightRandA, true, true);
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