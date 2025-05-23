package com.legends.edumia.blocks.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.*;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class BuildingSets {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MOD_ID);
    public static final float STONE_STRENGTH = 2.0f;
    public static BuildSet REDISH_GENSAI_BRICKS = registerBuildingSet("redish_gensai", STONE_STRENGTH, false);
    public static BuildSet CRACKED_REDISH_GENSAI_BRICKS = registerBuildingSet("cracked_redish_gensai", STONE_STRENGTH, false);
    public static BuildSet MOSSY_REDISH_GENSAI_BRICKS = registerBuildingSet("mossy_redish_gensai", STONE_STRENGTH, false);
    public static BuildSet MOSSY_LIGHT_HIGH_ELVEN = registerBuildingSet("mossy_light_high_elven", STONE_STRENGTH, false);
    public static BuildSet MOSSY_DARK_HIGH_ELVEN = registerBuildingSet("mossy_dark_high_elven", STONE_STRENGTH, false);
    public static BuildSet MOSSY_HIGH_ELVEN = registerBuildingSet("mossy_high_elven", STONE_STRENGTH, false);
    public static BuildSet CRACKED_LIGHT_HIGH_ELVEN = registerBuildingSet("cracked_light_high_elven", STONE_STRENGTH, false);
    public static BuildSet CRACKED_DARK_HIGH_ELVEN = registerBuildingSet("cracked_dark_high_elven", STONE_STRENGTH, false);
    public static BuildSet CRACKED_HIGH_ELVEN = registerBuildingSet("cracked_high_elven", STONE_STRENGTH, false);
    public static BuildSet SMALL_LIGHT_HIGH_ELVEN = registerBuildingSet("small_light_high_elven", STONE_STRENGTH, false);
    public static BuildSet SMALL_DARK_HIGH_ELVEN = registerBuildingSet("small_dark_high_elven", STONE_STRENGTH, false);
    public static BuildSet SMALL_HIGH_ELVEN = registerBuildingSet("small_high_elven", STONE_STRENGTH, false);
    public static BuildSet LIGHT_HIGH_ELVEN = registerBuildingSet("light_high_elven", STONE_STRENGTH, true);
    public static BuildSet DARK_HIGH_ELVEN = registerBuildingSet("dark_high_elven", STONE_STRENGTH, true);
    public static BuildSet HIGH_ELVEN = registerBuildingSet("high_elven", STONE_STRENGTH, true);
    public static BuildSet CHALK = registerBuildingSet("chalk", STONE_STRENGTH, true);
    public static BuildSet MOSSY_BASALT_BRICKS = registerBuildingSet("mossy_basalt", STONE_STRENGTH, false);
    public static BuildSet GREEN_BASALT_BRICKS = registerBuildingSet("green_basalt", STONE_STRENGTH, false);
    public static BuildSet BASALT_BRICKS = registerBuildingSet("basalt", STONE_STRENGTH, false);
    public static BuildSet YELLOW_STONE_SMALL_BRICKS = registerBuildingSet("yellow_stone_small", STONE_STRENGTH, false);
    public static BuildSet YELLOW_STONE_BRICKS = registerBuildingSet("yellow_stone", STONE_STRENGTH, false);
    public static BuildSet RED_GENSAI_BRICK = registerBuildingSet("red_gensai", STONE_STRENGTH, true);
    public static BuildSet MOSSY_RED_GENSAI_BRICK = registerBuildingSet("mossy_red_gensai", STONE_STRENGTH, false);
    public static BuildSet CRACKED_RED_GENSAI_BRICK = registerBuildingSet("cracked_red_gensai", STONE_STRENGTH, false);
    public static BuildSet LIGHT_GRAY_STONE = registerBuildingSet("light_gray_stone", STONE_STRENGTH, false);
    public static BuildSet MOSSY_GENSAI_BRICK = registerBuildingSet("mossy_gensai", STONE_STRENGTH, false);
    public static BuildSet TRIMMED_GENSAI_BRICK = registerBuildingSet("trimmed_gensai", STONE_STRENGTH, false);
    public static BuildSet GENSAI_BRICK = registerBuildingSet("gensai", STONE_STRENGTH, true);
    public static BuildSet BROWN_SANDSTONE_BRICKS = registerBuildingSet("brown_sandstone", STONE_STRENGTH, true);
    public static BuildSet BROWN_SANDSTONE_GOLD_BRICKS = registerBuildingSet("brown_sandstone_gold", STONE_STRENGTH, true);
    public static BuildSet CRACKED_BROWN_SANDSTONE_BRICKS = registerBuildingSet("cracked_brown_sandstone", STONE_STRENGTH, false);
    public static BuildSet MOSSY_BROWN_SANDSTONE_BRICKS = registerBuildingSet("mossy_brown_sandstone", STONE_STRENGTH, false);
    public static BuildSet CACHOLONG_BRICKS = registerBuildingSet("cacholong", STONE_STRENGTH, true);
    public static BuildSet CRACKED_CACHOLONG_BRICKS = registerBuildingSet("cracked_cacholong", STONE_STRENGTH, false);
    public static BuildSet MOSSY_CACHOLONG_BRICKS = registerBuildingSet("mossy_cacholong", STONE_STRENGTH, false);
    public static BuildSet BLACK_DEMON_BRICKS = registerBuildingSet("black_demon", STONE_STRENGTH, true);
    public static BuildSet CRACKED_BLACK_DEMON_BRICKS = registerBuildingSet("cracked_black_demon", STONE_STRENGTH, false);
    public static BuildSet MOSSY_BLACK_DEMON_BRICKS = registerBuildingSet("mossy_black_demon", STONE_STRENGTH, false);
    public static BuildSet BLUE_BRICKS = registerBuildingSet("blue", STONE_STRENGTH, false);
    public static BuildSet CRACKED_BLUE_BRICKS = registerBuildingSet("cracked_blue", STONE_STRENGTH, false);
    public static BuildSet MOSSY_BLUE_BRICKS = registerBuildingSet("mossy_blue", STONE_STRENGTH, false);
    public static BuildSet DEMON_BASALT_BRICKS = registerBuildingSet("demon_basalt", STONE_STRENGTH, false);
    public static BuildSet VOLCANIC_DEMON_BRICKS = registerBuildingSet("volcanic_demon", STONE_STRENGTH, true);
    public static BuildSet CRACKED_VOLCANIC_DEMON_BRICKS = registerBuildingSet("cracked_volcanic_demon", STONE_STRENGTH, false);
    public static BuildSet MOSSY_VOLCANIC_DEMON_BRICKS = registerBuildingSet("mossy_volcanic_demon", STONE_STRENGTH, false);
    public static BuildSet DESERT_MUD_BRICKS = registerBuildingSet("desert_mud", STONE_STRENGTH, true);
    public static BuildSet CRACKED_DESERT_MUD_BRICKS = registerBuildingSet("cracked_desert_mud", STONE_STRENGTH, false);
    public static BuildSet MOSSY_DESERT_MUD_BRICKS = registerBuildingSet("mossy_desert_mud", STONE_STRENGTH, false);
    public static BuildSet GRAYSTONE_BRICKS = registerBuildingSet("graystone", STONE_STRENGTH, true);
    public static BuildSet CRACKED_GRAYSTONE_BRICKS = registerBuildingSet("cracked_graystone", STONE_STRENGTH, false);
    public static BuildSet MOSSY_GRAYSTONE_BRICKS = registerBuildingSet("mossy_graystone", STONE_STRENGTH, false);
    public static BuildSet LIMESTONE_BRICKS = registerBuildingSet("limestone", STONE_STRENGTH, true);

    public static BuildSet OBSIDIAN = registerBuildingSet("obsidian", STONE_STRENGTH, true);
    public static BuildSet ANDESITE_BRICKS = registerBuildingSet("andesite", STONE_STRENGTH, false);
    public static BuildSet GRANITE_BRICKS = registerBuildingSet("granite", STONE_STRENGTH, false);
    public static BuildSet DIORITE_BRICKS = registerBuildingSet("diorite", STONE_STRENGTH, false);
    public static BuildSet DRIPSTONE_BRICKS = registerBuildingSet("dripstone", STONE_STRENGTH, false);

    public static BuildSet[] buildSets = new BuildSet[]{
            REDISH_GENSAI_BRICKS,
            CRACKED_REDISH_GENSAI_BRICKS,
            MOSSY_REDISH_GENSAI_BRICKS,
            DRIPSTONE_BRICKS,
            DIORITE_BRICKS,
            GRANITE_BRICKS,
            ANDESITE_BRICKS,
            MOSSY_GENSAI_BRICK,
            TRIMMED_GENSAI_BRICK,
            GENSAI_BRICK,
            LIGHT_GRAY_STONE,
            RED_GENSAI_BRICK,
            CRACKED_RED_GENSAI_BRICK,
            MOSSY_RED_GENSAI_BRICK,
            YELLOW_STONE_BRICKS,
            YELLOW_STONE_SMALL_BRICKS,
            BASALT_BRICKS,
            MOSSY_BASALT_BRICKS,
            GREEN_BASALT_BRICKS,
            CHALK,
            HIGH_ELVEN,
            LIGHT_HIGH_ELVEN,
            DARK_HIGH_ELVEN,
            CRACKED_HIGH_ELVEN,
            CRACKED_DARK_HIGH_ELVEN,
            CRACKED_LIGHT_HIGH_ELVEN,
            SMALL_HIGH_ELVEN,
            SMALL_DARK_HIGH_ELVEN,
            SMALL_LIGHT_HIGH_ELVEN,
            MOSSY_HIGH_ELVEN,
            MOSSY_DARK_HIGH_ELVEN,
            MOSSY_LIGHT_HIGH_ELVEN,
            BROWN_SANDSTONE_BRICKS,
            CRACKED_BROWN_SANDSTONE_BRICKS,
            MOSSY_BROWN_SANDSTONE_BRICKS,
            BROWN_SANDSTONE_GOLD_BRICKS,
            CACHOLONG_BRICKS,
            CRACKED_CACHOLONG_BRICKS,
            MOSSY_CACHOLONG_BRICKS,
            BLACK_DEMON_BRICKS,
            CRACKED_BLACK_DEMON_BRICKS,
            MOSSY_BLACK_DEMON_BRICKS,
            BLUE_BRICKS,
            CRACKED_BLUE_BRICKS,
            MOSSY_BLUE_BRICKS,
            DEMON_BASALT_BRICKS,
            VOLCANIC_DEMON_BRICKS,
            CRACKED_VOLCANIC_DEMON_BRICKS,
            MOSSY_VOLCANIC_DEMON_BRICKS,
            DESERT_MUD_BRICKS,
            CRACKED_DESERT_MUD_BRICKS,
            MOSSY_DESERT_MUD_BRICKS,
            GRAYSTONE_BRICKS,
            CRACKED_GRAYSTONE_BRICKS,
            MOSSY_GRAYSTONE_BRICKS,
            OBSIDIAN,
            LIMESTONE_BRICKS
    };

    public record BuildSet(RegistryObject<Block> block, RegistryObject<Block> slab, RegistryObject<Block> stair, RegistryObject<Block> wall,
                           RegistryObject<Block> pillar, RegistryObject<Block> pillarSlab, RegistryObject<Block> smallArch,
                           RegistryObject<Block> twoMeterArch, RegistryObject<Block> roundArch, RegistryObject<Block> segmentalArch,
                           RegistryObject<Block> gothicArch, RegistryObject<Block> balustrade, RegistryObject<Block> arrowSlit){
    }

    public static BuildSet registerBuildingSet(String name, float strength, boolean hasPillar){

        RegistryObject<Block> stone = registerbuildingBlock(name + "_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));


        RegistryObject<Block> slab = registerbuildingBlock(name + "_bricks_slab", () -> new AxialSlabBlock(stone));

        RegistryObject<Block> stairs = registerbuildingBlock(name + "_bricks_stairs", () -> new StairBlock(stone.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(Blocks.STONE).strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> wall = registerbuildingBlock(name + "_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> pillar;
        RegistryObject<Block> pillarSlab = null;
        if (hasPillar){
            pillar = registerbuildingBlock(name + "_pillar", () -> new EdumiaPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(strength).sound(SoundType.STONE).requiresCorrectToolForDrops()));

            pillarSlab = registerbuildingBlock(name + "_pillar_slab", () -> new AxialSlabBlock(pillar));
        } else {
            pillar = null;
        }

        RegistryObject<Block> smallArch = registerbuildingBlock(name + "_bricks_small_arch", () -> new ArchSmall(BlockBehaviour.Properties.of()
                    .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> twoMeterArch = registerbuildingBlock(name + "_bricks_two_meter_arch",
                () -> new ArchTwoMeter(BlockBehaviour.Properties.of()
                    .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> roundArch = registerbuildingBlock(name + "_bricks_round_arch", () -> new Arch(BlockBehaviour.Properties.of()
                    .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> segmentalArch = registerbuildingBlock(name + "_bricks_segmental_arch",
                () -> new Arch(BlockBehaviour.Properties.of()
                    .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> gothicArch = registerbuildingBlock(name + "_bricks_gothic_arch", () -> new Arch(BlockBehaviour.Properties.of()
                    .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> balustrade = registerbuildingBlock(name + "_bricks_balustrade",
                () -> new Balustrade(BlockBehaviour.Properties.of()
                .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        RegistryObject<Block> arrowslit = registerbuildingBlock(name + "_bricks_arrowslit", () -> new ArrowSlit(BlockBehaviour.Properties.of()
                .strength(STONE_STRENGTH).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        return new BuildSet(stone, slab, stairs, wall, pillar, pillarSlab, smallArch, twoMeterArch, roundArch,
                segmentalArch, gothicArch, balustrade, arrowslit);
    }
    private static <T extends Block> RegistryObject<T> registerbuildingBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBuildingBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBuildingBlockItem(String name, RegistryObject<T> block) {
        var item = ItemLoader.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

//        Item.BY_BLOCK.put(block.get(), item.get());
//        CreativeTabLoader.BUILDING_CONTENTS.add(item.get().getDefaultInstance());

        return item;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
