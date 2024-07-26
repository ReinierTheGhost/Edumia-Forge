package com.legends.edumia.blocks.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.AxialSlabBlock;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class NotBrickBuildingSets {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MOD_ID);

    public static final float STONE_STRENGTH = 2.0f;

    public static BuildSet POLISHED_DRIPSTONE = registerBuildingSet("polished_dripstone", STONE_STRENGTH, false);

    public static BuildSet[] buildSets = new BuildSet[]{
            POLISHED_DRIPSTONE,
    };

    public record BuildSet(RegistryObject<Block> block, RegistryObject<Block> slab, RegistryObject<Block> stair, RegistryObject<Block> wall){
    }

    public static BuildSet registerBuildingSet(String name, float strength, boolean hasWall){

        RegistryObject<Block> stone = registerBlock(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));


        RegistryObject<Block> slab = registerBlock(name + "_slab", () -> new AxialSlabBlock(stone));

        RegistryObject<Block> stairs = registerBlock(name + "_stairs", () -> new StairBlock(stone.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(stone.get()).strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> wall = null;
        if (hasWall){
            wall = registerBlock(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(stone.get())
                    .strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        }




        return new BuildSet(stone, slab, stairs, wall);
    }

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
