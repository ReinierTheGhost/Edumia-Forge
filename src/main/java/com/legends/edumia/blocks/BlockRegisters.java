package com.legends.edumia.blocks;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.CreativeTabLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class BlockRegisters {

    public static Block registerbuildingBlock(String name, Block block) {
        registerBuildingBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Edumia.MOD_ID, name), block);
    }

    static Item registerBuildingBlockItem(String name, Block block) {
        var item =  Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Edumia.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));

        Item.BY_BLOCK.put(block, item);
        CreativeTabLoader.BUILDING_CONTENTS.add(item.getDefaultInstance());
        return item;
    }

    public static Block registerGlassBlock(String name, Block block) {
        registerGlassBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Edumia.MOD_ID, name), block);
    }

    static Item registerGlassBlockItem(String name, Block block) {
        var item =  Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Edumia.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));

        Item.BY_BLOCK.put(block, item);
        CreativeTabLoader.GLASS_CONTENTS.add(item.getDefaultInstance());
        return item;
    }

    public static Block registerStoneBlock(String name, Block block) {
        registerStoneBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Edumia.MOD_ID, name), block);
    }

    static Item registerStoneBlockItem(String name, Block block) {
        var item =  Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Edumia.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));

        Item.BY_BLOCK.put(block, item);
        CreativeTabLoader.NATURAL_STONE_BLOCKS_CONTENTS.add(item.getDefaultInstance());
        return item;
    }

    public static Block registerDoorBlock(String name, Block block) {
        registerDoorBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Edumia.MOD_ID, name), block);
    }

    static Item registerDoorBlockItem(String name, Block block) {
        var item =  Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Edumia.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));

        Item.BY_BLOCK.put(block, item);
        CreativeTabLoader.UTILITY_CONTENTS.add(item.getDefaultInstance());
        return item;
    }
}
