package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.blocksets.ModNatureBlocks;
import com.legends.edumia.blocks.blocksets.WoodBlockSets;
import com.legends.edumia.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Edumia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.GROUND_MAHOGANY_SAPLING)
                .add(Blocks.DIRT);

        this.tag(ModTags.Blocks.TREE_BRANCH_REPLACEABLE)
                .add(Blocks.AIR)
                .add(Blocks.VINE)
                .add(Blocks.GLOW_LICHEN)
                .add(Blocks.OAK_LEAVES)
                .add(Blocks.SPRUCE_LEAVES)
                .add(Blocks.BIRCH_LEAVES)
                .add(Blocks.JUNGLE_LEAVES)
                .add(Blocks.ACACIA_LEAVES)
                .add(Blocks.DARK_OAK_LEAVES)
                .add(Blocks.AZALEA_LEAVES)
                .add(Blocks.FLOWERING_AZALEA_LEAVES)
                .add(Blocks.MANGROVE_LEAVES)
                .add(Blocks.CHERRY_LEAVES)
                .add(WoodBlockSets.APPLE.leaves().get())
                .add(ModNatureBlocks.APPLE_LEAVES_GREEN.get())
                .add(ModNatureBlocks.APPLE_LEAVES_RED.get())
                .add(WoodBlockSets.ASPEN.leaves().get())
                .add(WoodBlockSets.BANANA.leaves().get())
                .add(WoodBlockSets.BEECH.leaves().get())
                .add(WoodBlockSets.BLACKTHORN.leaves().get())
                .add(ModNatureBlocks.BLACK_OAK_LEAVES.get())
                .add(WoodBlockSets.CEDAR.leaves().get())
                .add(WoodBlockSets.CHERRY.leaves().get())
                .add(ModNatureBlocks.CHERRY_LEAVES_FRUIT.get())
                .add(WoodBlockSets.CYPRESS.leaves().get())
                .add(WoodBlockSets.FIR.leaves().get())
                .add(ModNatureBlocks.GHOST_GUM_LEAVES.get())
                .add(WoodBlockSets.GREEN_OAK.leaves().get())
                .add(ModNatureBlocks.HOLLY_LEAVES.get())
                .add(WoodBlockSets.LARCH.leaves().get())
                .add(WoodBlockSets.MAHOGANY.leaves().get())
                .add(WoodBlockSets.MANGO.leaves().get())
                .add(ModNatureBlocks.MAPLE_LEAVES.get())
                .add(WoodBlockSets.PALM.leaves().get())
                .add(WoodBlockSets.PEAR.leaves().get())
                .add(ModNatureBlocks.PEAR_LEAVES_FRUIT.get())
                .add(WoodBlockSets.PINE.leaves().get())
                .add(WoodBlockSets.RED_OAK.leaves().get())
                .add(WoodBlockSets.REDWOOD.leaves().get())
                .add(WoodBlockSets.SILVER_SPRUCE.leaves().get())
                .add(WoodBlockSets.WHITE_ASH.leaves().get())
                .add(WoodBlockSets.WILLOW.leaves().get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
