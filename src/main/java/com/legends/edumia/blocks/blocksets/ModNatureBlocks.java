package com.legends.edumia.blocks.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.AxialSlabBlock;
import com.legends.edumia.blocks.EdumiaLeavesBlock;
import com.legends.edumia.blocks.trees.BlackOakLeavesBlock;
import com.legends.edumia.core.ItemLoader;
import com.legends.edumia.world.treegrowers.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.legends.edumia.blocks.blocksets.WoodBlockSets.LEAVES_STRENGTH;

@SuppressWarnings("deprecation")
public class ModNatureBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MOD_ID);
    public static final RegistryObject<Block> GHOST_GUM_LEAVES = ModNatureBlocks.registerBlock("ghost_gum_leaves", () ->
            new EdumiaLeavesBlock());
    public static final RegistryObject<Block> HOLLY_LEAVES = ModNatureBlocks.registerBlock("holly_leaves", () ->
            new EdumiaLeavesBlock());
    public static final RegistryObject<Block> MAPLE_LEAVES = ModNatureBlocks.registerBlock("maple_leaves", () ->
            new EdumiaLeavesBlock());
    public static final RegistryObject<Block> BLACK_OAK_LEAVES = ModNatureBlocks.registerBlock("black_oak_leaves", () ->
            new BlackOakLeavesBlock());
    public static final RegistryObject<Block> APPLE_LEAVES_RED = ModNatureBlocks.registerBlock("apple_leaves_red", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> APPLE_LEAVES_GREEN = ModNatureBlocks.registerBlock("apple_leaves_green", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PEAR_LEAVES_FRUIT = ModNatureBlocks.registerBlock("pear_leaves_fruit", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CHERRY_LEAVES_FRUIT = ModNatureBlocks.registerBlock("cherry_leaves_fruit", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> TEST_SAPLING = registerBlock("test_sapling", () ->
            new SaplingBlock(new TestTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling", () ->
            new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_sapling", () ->
            new SaplingBlock(new BananaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ASPEN_SAPLING = registerBlock("aspen_sapling", () ->
            new SaplingBlock(new AspenTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GHOST_GUM_SAPLING = registerBlock("ghost_gum_sapling", () ->
            new SaplingBlock(new GhostGumTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BEECH_SAPLING = registerBlock("beech_sapling", () ->
            new SaplingBlock(new BeechTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BLACKTHORN_SAPLING = registerBlock("blackthorn_sapling", () ->
            new SaplingBlock(new BlackthornTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BLACK_OAK_SAPLING = registerBlock("black_oak_sapling", () ->
            new SaplingBlock(new BlackOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CEDAR_SAPLING = registerBlock("cedar_sapling", () ->
            new SaplingBlock(new CederTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling", () ->
            new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CYPRESS_SAPLING = registerBlock("cypress_sapling", () ->
            new SaplingBlock(new CypressTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DRAGON_BLOOD_SAPLING = registerBlock("dragon_blood_sapling", () ->
            new SaplingBlock(new DragonBloodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> FIR_SAPLING = registerBlock("fir_sapling", () ->
            new SaplingBlock(new FirTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GREEN_OAK_SAPLING = registerBlock("green_oak_sapling", () ->
            new SaplingBlock(new GreenOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> HOLLY_SAPLING = registerBlock("holly_sapling", () ->
            new SaplingBlock(new HollyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LARCH_SAPLING = registerBlock("larch_sapling", () ->
            new SaplingBlock(new LarchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling", () ->
            new SaplingBlock(new MahoganyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling", () ->
            new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling", () ->
            new SaplingBlock(new MangoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PEAR_SAPLING = registerBlock("pear_sapling", () ->
            new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PALM_SAPLING = registerBlock("palm_sapling", () ->
            new SaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling", () ->
            new SaplingBlock(new PineTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> RED_OAK_SAPLING = registerBlock("red_oak_sapling", () ->
            new SaplingBlock(new RedOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling", () ->
            new SaplingBlock(new RedwoodTreeGrowen(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SILVER_SPRUCE_SAPLING = registerBlock("silver_spruce_sapling", () ->
            new SaplingBlock(new SilverSpruceTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WHITE_ASH_SAPLING = registerBlock("white_ash_sapling", () ->
            new SaplingBlock(new WhiteAshTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WILLOW_SAPLING = registerBlock("willow_sapling", () ->
            new SaplingBlock(new WillowTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> JUNGLE_WOOD_SLAB = registerBlock("jungle_wood_slab", () ->
            new AxialSlabBlock(Blocks.JUNGLE_WOOD));
    public static final RegistryObject<Block> JUNGLE_WOOD_STAIRS = registerBlock("jungle_wood_stairs", () ->
            new StairBlock(Blocks.JUNGLE_WOOD.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));

    public static final RegistryObject<Block> JUNGLE_WOOD_FENCE = registerBlock("jungle_wood_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> JUNGLE_WOOD_WALL = registerBlock("jungle_wood_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block) {
        var item = ItemLoader.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));


        return item;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
