package com.legends.edumia.dynamictrees.genfeatures;

import com.ferreusveritas.dynamictrees.api.TreeHelper;
import com.ferreusveritas.dynamictrees.api.network.MapSignal;
import com.ferreusveritas.dynamictrees.block.branch.BranchBlock;
import com.ferreusveritas.dynamictrees.block.rooty.RootyBlock;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeatureConfiguration;
import com.ferreusveritas.dynamictrees.systems.genfeature.context.PostGenerationContext;
import com.ferreusveritas.dynamictrees.systems.nodemapper.DenuderNode;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RandomStrippedBranches extends GenFeature {
    public RandomStrippedBranches(ResourceLocation registryName) {
        super(registryName);
    }
    @Override
    protected void registerProperties() {
        register(PLACE_CHANCE);
    }
    @Override @NotNull
    public GenFeatureConfiguration createDefaultConfiguration() {
        return super.createDefaultConfiguration()
                .with(PLACE_CHANCE, 0.2f);
    }

    @Override
    protected boolean postGenerate(GenFeatureConfiguration configuration, PostGenerationContext context) {
        // If the family doesn't have a stripped branch the feature can't be applied.
        if (!context.species().getFamily().hasStrippedBranch()) {
            return false;
        }
        LevelAccessor level = context.level();
        BlockPos rootPos = context.pos();
        final RootyBlock dirt = TreeHelper.getRooty(level.getBlockState(rootPos));
        if (dirt == null) return false;

        Family family = context.species().getFamily();
        float chance = configuration.get(PLACE_CHANCE);
        if (!level.isClientSide()) {
            dirt.startAnalysis(level, rootPos, new MapSignal(new DenuderNode(context.species(), context.species().getFamily()){
                @Override
                public boolean run(BlockState state, LevelAccessor level, BlockPos pos, Direction fromDir) {
                    if (level.getRandom().nextFloat() >= chance) return false;

                    final BranchBlock branch = TreeHelper.getBranch(state);
                    if (branch == null || family.getBranch().map(other -> branch != other).orElse(false)) {
                        return false;
                    }
                    branch.stripBranch(state, level, pos, branch.getRadius(state));
                    return true;
                }
            }));

        }
        return true;
    }
}
