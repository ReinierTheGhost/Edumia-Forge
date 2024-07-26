package com.legends.edumia.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class MediumRedwoodTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<MediumRedwoodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, MediumRedwoodTrunkPlacer::new));

    protected MediumRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider,
                                       Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public MediumRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood){
        this(baseHeight, heightRandA, heightRandB, Optional.empty(), Optional.empty(),
                Optional.of(BlockStateProvider.simple(wood)));
    }
    public MediumRedwoodTrunkPlacer(BlockState wood){
        this(32, 24, 0, Optional.empty(), Optional.empty(),
                Optional.of(BlockStateProvider.simple(wood)));
    }
    @Override
    protected TrunkPlacerType<?> type() {
        return EdumiaTrunkPlacerTypes.MEDIUM_REDWOOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> trunk,
                                                            RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        BlockPos blockPos = startPos.below();
        setDirtAt(world, trunk, random, blockPos, config);

        setDirtAt(world, trunk, random, blockPos.north(), config);
        setDirtAt(world, trunk, random, blockPos.west(), config);
        setDirtAt(world, trunk, random, blockPos.east(), config);
        setDirtAt(world, trunk, random, blockPos.south(), config);
        setDirtAt(world, trunk, random, blockPos.north().east(), config);
        setDirtAt(world, trunk, random, blockPos.north().west(), config);
        setDirtAt(world, trunk, random, blockPos.south().east(), config);
        setDirtAt(world, trunk, random, blockPos.south().west(), config);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int i = 0; i < height + 30; ++i) {
            this.setLog(world, trunk, random, mutable, config, startPos, 0, i, 0);
            if (i >= height - 1) continue; // makes the log on the position of the sapling 1 higher than the rest
            this.setLog(world, trunk, random, mutable, config, startPos, 1, i, 0);
            this.setLog(world, trunk, random, mutable, config, startPos, 1, i, 1);
            this.setLog(world, trunk, random, mutable, config, startPos, 0, i, 1);

            this.setLog(world, trunk, random, mutable, config, startPos, -1, i, 1);
            this.setLog(world, trunk, random, mutable, config, startPos, -1, i, 0);
            this.setLog(world, trunk, random, mutable, config, startPos, -1, i, -1);
            this.setLog(world, trunk, random, mutable, config, startPos, 1, i, -1);
            this.setLog(world, trunk, random, mutable, config, startPos, 0, i, -1);
        }

        BlockPos.MutableBlockPos rootPos1 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, -1,
                random.nextIntBetweenInclusive(1, 3), -2);
        BlockPos.MutableBlockPos rootPos2 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 0,
                random.nextIntBetweenInclusive(1, 3), -2);
        BlockPos.MutableBlockPos rootPos3 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 1,
                random.nextIntBetweenInclusive(1, 3), -2);

        BlockPos.MutableBlockPos rootPos4 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, -1,
                random.nextIntBetweenInclusive(1, 3), 2);
        BlockPos.MutableBlockPos rootPos5 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 0,
                random.nextIntBetweenInclusive(1, 3), 2);
        BlockPos.MutableBlockPos rootPos6 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 1,
                random.nextIntBetweenInclusive(1, 3), 2);

        BlockPos.MutableBlockPos rootPos7 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 2,
                random.nextIntBetweenInclusive(1, 3), -1);
        BlockPos.MutableBlockPos rootPos8 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 2,
                random.nextIntBetweenInclusive(1, 3), 0);
        BlockPos.MutableBlockPos rootPos9 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, 2,
                random.nextIntBetweenInclusive(1, 3), 1);

        BlockPos.MutableBlockPos rootPos10 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, -2,
                random.nextIntBetweenInclusive(1, 3), -1);
        BlockPos.MutableBlockPos rootPos11 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, -2,
                random.nextIntBetweenInclusive(1, 3), 0);
        BlockPos.MutableBlockPos rootPos12 = (new BlockPos.MutableBlockPos()).setWithOffset(startPos, -2,
                random.nextIntBetweenInclusive(1, 3), 1);

        int rootLength = 4 + random.nextInt(3);
        this.growRootsDown(world, random, rootPos1, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos2, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos3, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos4, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos5, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos6, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos7, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos8, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos9, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos10, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos11, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos12, rootLength, trunk, config);

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(startPos.above(height), 0, true));
    }

    private void setLog(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> trunk, RandomSource random,
                        BlockPos.MutableBlockPos tmpPos, TreeConfiguration config, BlockPos startPos, int dx, int dy, int dz) {
        tmpPos.setWithOffset(startPos, dx, dy, dz);
        this.placeLogIfFree(world, trunk, random, tmpPos, config);
    }
}
