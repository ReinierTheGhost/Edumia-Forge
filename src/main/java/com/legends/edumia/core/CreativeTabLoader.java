package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.blocksets.BuildingSets;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import java.util.LinkedList;
import java.util.List;

public class CreativeTabLoader {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Edumia.MOD_ID);

//    public static final ItemGroup LEGENDS_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Rewards"))
//                    .icon(() -> new ItemStack(ItemLoader.LEGENDS_COIN)).entries((displayContext, entries) -> {
//                        entries.add(ItemLoader.LEGENDS_COIN);
//                        entries.add(ItemLoader.ATLAS);
//                        entries.add(BlockLoader.HIGH_ELVEN_CRYSTAL);
////                        entries.add(BlockLoader.BIRCH_LOG_SMALL_BRANCH);
////                        entries.add(BlockLoader.BIRCH_LOG_BRANCH);
////                        entries.add(BlockLoader.BIRCH_LOG_LARGE_BRANCH);
//                    }).build();

    public static final List<ItemStack> UTILITY_CONTENTS = new LinkedList<>();
//    public static final ItemGroup UTILITY_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Utilities"))
//            .icon(() -> new ItemStack(WoodBlockSets.DRAGON_BLOOD.door())).entries((displayContext, entries) -> {
//                for (ItemStack item : UTILITY_CONTENTS) {
//                    entries.add(item);
//                }
//            }).build();
//    public static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Weapons"))
//            .icon(() -> new ItemStack(ItemLoader.ABOMINABLE_BLADE)).entries((displayContext, entries) -> {
//                entries.add(ItemLoader.ABOMINABLE_BLADE);
//            }).build();

//    public static final ItemGroup MATERIAL_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Materials"))
//            .icon(() -> new ItemStack(ItemLoader.GENSAI_STEEL)).entries((displayContext, entries) -> {
//                entries.add(ItemLoader.GENSAI_STEEL);
//            }).build();

//    public static final ItemGroup TOOL_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Tools"))
//            .icon(() -> new ItemStack(ItemLoader.GENSAI_AXE)).entries((displayContext, entries) -> {
//                entries.add(ItemLoader.GENSAI_AXE);
//                entries.add(ItemLoader.GENSAI_HOE);
//                entries.add(ItemLoader.GENSAI_PICKAXE);
//                entries.add(ItemLoader.GENSAI_SHOVEL);
//            }).build();


    public static final List<ItemStack> PLANT_CONTENTS = new LinkedList<>();
//
//    public static final ItemGroup EDUMIA_PLANTS = FabricItemGroup.builder()
//            .displayName(Text.literal("Edumia Plants"))
//            .icon(() -> new ItemStack(BlockLoader.PAPYRUS)).entries((displayContext, entries) -> {
//                for (ItemStack item : PLANT_CONTENTS) {
//                    entries.add(item);
//                }
//                entries.add(BlockLoader.PAPYRUS);
//                entries.add(BlockLoader.REEDS);
//                entries.add(BlockLoader.DRIED_REEDS);
//
//                entries.add(BlockLoader.DRY_BUSH);
//                entries.add(BlockLoader.TALL_DRY_BUSH);
//                entries.add(BlockLoader.TALL_DEAD_BUSH);
//
//                entries.add(BlockLoader.ARID_GRASS);
//                entries.add(BlockLoader.BLACK_GRASS);
//                entries.add(BlockLoader.FLAX_GRASS);
//                entries.add(BlockLoader.BEACH_GRASS);
//                entries.add(BlockLoader.TALL_BEACH_GRASS);
//                entries.add(BlockLoader.FROSTED_GRASS);
//                entries.add(BlockLoader.TALL_FROSTED_GRASS);
//
//                entries.add(BlockLoader.PARASOL_MUSHROOM_1);
//                entries.add(BlockLoader.PARASOL_MUSHROOM_2);
//                entries.add(BlockLoader.PARASOL_MUSHROOM_TALL);
//
////                        flowers
//                entries.add(BlockLoader.ASPHODEL);
//                entries.add(BlockLoader.BLUE_DELPHINIUM);
//                entries.add(BlockLoader.BLUEBELL);
//                entries.add(BlockLoader.CALLA_LILY);
//                entries.add(BlockLoader.CELSEMIUM);
//                entries.add(BlockLoader.CHRYS_BLUE);
//                entries.add(BlockLoader.CHRYS_ORANGE);
//                entries.add(BlockLoader.CHRYS_PINK);
//                entries.add(BlockLoader.CHRYS_WHITE);
//                entries.add(BlockLoader.CHRYS_YELLOW);
//                entries.add(BlockLoader.CROCUS);
//                entries.add(BlockLoader.DAISY);
//                entries.add(BlockLoader.DELPHINIUM);
//                entries.add(BlockLoader.FLAX_FLOWERS);
//                entries.add(BlockLoader.FOXGLOVE_ORANGE);
//                entries.add(BlockLoader.FOXGLOVE_PINK);
//                entries.add(BlockLoader.FOXGLOVE_RED);
//                entries.add(BlockLoader.FOXGLOVE_WHITE);
//                entries.add(BlockLoader.GERBERA_RED);
//                entries.add(BlockLoader.GENSAI_ORCHID);
//                entries.add(BlockLoader.GERBERA_YELLOW);
//                entries.add(BlockLoader.HEATHER_BUSH);
//                entries.add(BlockLoader.LAVENDER);
//                entries.add(BlockLoader.MARIGOLD);
//                entries.add(BlockLoader.PINK_ANEMONE);
//                entries.add(BlockLoader.SIMBLELMYNE);
//                entries.add(BlockLoader.TUBEROSE);
//                entries.add(BlockLoader.YELLOW_IRIS);
//                entries.add(BlockLoader.FLAME_OF_THE_SOUTH);
//                entries.add(BlockLoader.HIBISCUS);
//            })
//            .build();

//    public static final ItemGroup EDUMIA_GEMS = FabricItemGroup.builder()
//            .displayName(Text.literal("Edumia Gems"))
//                    .icon(() -> new ItemStack(ItemLoader.GEM_PERFECT_AMBER)).entries((displayContext, entries) -> {
//                        entries.add(ItemLoader.GEM_FINE_AMBER);
//                        entries.add(ItemLoader.GEM_FLAWED_AMBER);
//                        entries.add(ItemLoader.GEM_FLAWLESS_AMBER);
//                        entries.add(ItemLoader.GEM_PERFECT_AMBER);
//                        entries.add(ItemLoader.GEM_ROUGH_AMBER);
//                        entries.add(ItemLoader.GEM_FINE_AMETHYST);
//                        entries.add(ItemLoader.GEM_FLAWED_AMETHYST);
//                        entries.add(ItemLoader.GEM_FLAWLESS_AMETHYST);
//                        entries.add(ItemLoader.GEM_PERFECT_AMETHYST);
//                        entries.add(ItemLoader.GEM_ROUGH_AMETHYST);
//                        entries.add(ItemLoader.GEM_FINE_JADE);
//                        entries.add(ItemLoader.GEM_FLAWED_JADE);
//                        entries.add(ItemLoader.GEM_FLAWLESS_JADE);
//                        entries.add(ItemLoader.GEM_PERFECT_JADE);
//                        entries.add(ItemLoader.GEM_ROUGH_JADE);
//                        entries.add(ItemLoader.GEM_FINE_JASPER);
//                        entries.add(ItemLoader.GEM_FLAWED_JASPER);
//                        entries.add(ItemLoader.GEM_FLAWLESS_JASPER);
//                        entries.add(ItemLoader.GEM_PERFECT_JASPER);
//                        entries.add(ItemLoader.GEM_ROUGH_JASPER);
//                        entries.add(ItemLoader.GEM_FINE_RUBY);
//                        entries.add(ItemLoader.GEM_FLAWED_RUBY);
//                        entries.add(ItemLoader.GEM_FLAWLESS_RUBY);
//                        entries.add(ItemLoader.GEM_PERFECT_RUBY);
//                        entries.add(ItemLoader.GEM_ROUGH_RUBY);
//                        entries.add(ItemLoader.GEM_FINE_SAPPHIRE);
//                        entries.add(ItemLoader.GEM_FLAWED_SAPPHIRE);
//                        entries.add(ItemLoader.GEM_FLAWLESS_SAPPHIRE);
//                        entries.add(ItemLoader.GEM_PERFECT_SAPPHIRE);
//                        entries.add(ItemLoader.GEM_ROUGH_SAPPHIRE);
//                        entries.add(ItemLoader.GEM_FINE_TOPAZ);
//                        entries.add(ItemLoader.GEM_FLAWED_TOPAZ);
//                        entries.add(ItemLoader.GEM_FLAWLESS_TOPAZ);
//                        entries.add(ItemLoader.GEM_PERFECT_TOPAZ);
//                        entries.add(ItemLoader.GEM_ROUGH_TOPAZ);
//                    })
//                    .build();
//
//    public static final ItemGroup FOOD_GROUP = FabricItemGroup.builder()
//            .displayName(Text.literal("Food"))
//            .icon(() -> new ItemStack(ItemLoader.TEA_HIBISCUS_PETALS)).entries((displayContext, entries) -> {
//                entries.add(ItemLoader.TEA_SAKURA_PETALS);
//                entries.add(ItemLoader.TEA_MINT_LEAVES);
//                entries.add(ItemLoader.TEA_LEAF);
//                entries.add(ItemLoader.TEA_LILY_PETALS);
//                entries.add(ItemLoader.TEA_WHITE_JADE_PETALS);
//                entries.add(ItemLoader.TEA_HIBISCUS_PETALS);
//                entries.add(ItemLoader.TEA_JASMINE_PETALS);
//                entries.add(ItemLoader.TEA_CINNAMON_STICK);
//                entries.add(ItemLoader.TEA_WHITE_DRAGON_PETALS);
//
//                entries.add(ItemLoader.BROCCOLI);
//                entries.add(ItemLoader.PAPRIKA_GREEN);
//                entries.add(ItemLoader.RAMEN);
//                entries.add(ItemLoader.RAMEN_BEEF);
//                entries.add(ItemLoader.RAMEN_PORK);
//                entries.add(ItemLoader.RAMEN_SHRIMPS);
//                entries.add(ItemLoader.RAMEN_VEGI);
//                entries.add(ItemLoader.RED_GRAPES);
//                entries.add(ItemLoader.RICE);
//                entries.add(ItemLoader.RICE_BALL);
//                entries.add(ItemLoader.SPINACH);
//                entries.add(ItemLoader.TOMATO);
//                entries.add(ItemLoader.CHEESE);
//
//                entries.add(ItemLoader.LETTUCE);
//                entries.add(ItemLoader.BANANA);
//                entries.add(ItemLoader.BANANA_BREAD);
//                entries.add(ItemLoader.MANGO);
//                entries.add(ItemLoader.DATE);
//
//
//            }).build();

//
//    public static final ItemGroup EDUMIA_ITEMS = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Edumia.MOD_ID,"edumia_items"),
//            FabricItemGroup.builder().displayName(Text.translatable("creativetab.edumia_items"))
//                    .icon(() -> new ItemStack(ItemLoader.TEA_SAKURA_PETALS)).entries((displayContext, entries) -> {
//
//
//
//
//                        entries.add(ItemLoader.POLISHED_JADE);
//                        entries.add(ItemLoader.TOPAZ_SHARD);
//
//                        entries.add(ItemLoader.INGOT_OCkER);
//                        entries.add(ItemLoader.INGOT_BLACK);
//                        entries.add(ItemLoader.INGOT_ICE);
//                        entries.add(ItemLoader.INGOT_PINK);
//                        entries.add(ItemLoader.INGOT_VEIL);
//                        entries.add(ItemLoader.INGOT_AQUATIA);
//                        entries.add(ItemLoader.INGOT_CRIMSUN);
//                        entries.add(ItemLoader.INGOT_DEMONIUM);
//                        entries.add(ItemLoader.INGOT_DRACONIAN);
//                        entries.add(ItemLoader.INGOT_HELLIAN);
//                        entries.add(ItemLoader.INGOT_GLIMMERING);
//                        entries.add(ItemLoader.INGOT_NEPTUNIUM);
//                        entries.add(ItemLoader.INGOT_SOLARITE);
//
//                        entries.add(ItemLoader.BAMBOO_STAFF);
//                        entries.add(ItemLoader.WAND_AIRSCEPTRE);
//                        entries.add(ItemLoader.GENSAI_NECKLESS);
//
//                        entries.add(ItemLoader.MAN_HOE);
//                        entries.add(ItemLoader.MAN_AXE);
//                        entries.add(ItemLoader.MAN_SHOVEL);
//                        entries.add(ItemLoader.MAN_PICKAXE);
//                        entries.add(ItemLoader.MAN_SWORD);
//
//                        entries.add(ItemLoader.ORC_HOE);
//                        entries.add(ItemLoader.ORC_AXE);
//                        entries.add(ItemLoader.ORC_SHOVEL);
//                        entries.add(ItemLoader.ORC_PICKAXE);
//                        entries.add(ItemLoader.ORC_SWORD);
//
//                        entries.add(ItemLoader.BATTLE_AXE);
//
//                        entries.add(ItemLoader.ATLAS);
//                        entries.add(ItemLoader.BIGBOOK);
//                        entries.add(ItemLoader.CHASE);
//                        entries.add(ItemLoader.CLIPBOARDSIMPLE);
//                        entries.add(ItemLoader.FRAMINGBOARD);
//                        entries.add(ItemLoader.FRAMINGAHEET);
//                        entries.add(ItemLoader.HANDDRILL);
//                        entries.add(ItemLoader.LOCK);
//                        entries.add(ItemLoader.MAPTOOL);
//                        entries.add(ItemLoader.MONOCLE);
//                        entries.add(ItemLoader.PLATE);
//                        entries.add(ItemLoader.PLUMBLINE);
//                        entries.add(ItemLoader.RECIPEBOOK);
//                        entries.add(ItemLoader.SAW);
//                        entries.add(ItemLoader.STOCKCATALOG);
//                        entries.add(ItemLoader.TAPE);
//
//                        entries.add(ItemLoader.ALEXANDRITE);
//                        entries.add(ItemLoader.RAW_ALEXANDRITE);
//                    })
//                    .build());
//
//    public static final ItemGroup EDUMIA_SPAWNS = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Edumia.MOD_ID,"edumia_spawns"),
//            FabricItemGroup.builder().displayName(Text.translatable("creativetab.edumia_spawns"))
//                    .icon(() -> new ItemStack(ItemLoader.RHINO_SPAWN_EGG)).entries((displayContext, entries) -> {
//                        entries.add(ItemLoader.RHINO_SPAWN_EGG);
//                        entries.add((ItemLoader.BOAR_SPAWN_EGG));
//                        entries.add(ItemLoader.ALLIGATOR_SPAWN_EGG);
//                        entries.add(ItemLoader.BADGER_SPAWN_EGG);
//                    })
//                    .build());
    public static final List<ItemStack> BUILDING_CONTENTS = new LinkedList<>();


    public static final RegistryObject<CreativeModeTab> EDUMIA_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BuildingSets.GREEN_BASALT_BRICKS.block().get()))
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, entries) -> {
                        for (ItemStack item : BUILDING_CONTENTS) {
                            entries.accept(item);
                        }
//                        entries.add(BlockLoader.BRICK_PILLAR);
//                        entries.add(BlockLoader.STONE_PILLAR);
//                        entries.add(BlockLoader.SANDSTONE_PILLAR);
//
//                        entries.add(BlockLoader.BLUE_BRICK);
//                        entries.add(BlockLoader.BLUE_BRICK_SLAB);
//                        entries.add(BlockLoader.BLUE_BRICK_STAIRS);
//                        entries.add(BlockLoader.BLUE_BRICK_WALL);
//
//                        entries.add(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);
//
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB);
//
//                        entries.add(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);
//
//                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
//                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB);
//                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);
//
//                        entries.add(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);
//
//                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
//                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
//                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB);
//
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_WALL);
//
//                        entries.add(BlockLoader.CHISELED_BASALT);
//
//                        entries.add(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_CACHOLONG_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_BLACK_DEMON_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_BLUE_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_DEMON_BASALT_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_VOLCANIC_DEMON_BRICKS);
//
//                        entries.add(BlockLoader.CARVED_RED_GENSAI_BRICKS);
//
//                        entries.add(BlockLoader.CHISELED_ANDESITE);
//                        entries.add(BlockLoader.CHISELED_DRIPSTONE);
//                        entries.add(BlockLoader.CHISELED_DIORITE);
//                        entries.add(BlockLoader.CHISELED_GRANITE);
//                        entries.add(BlockLoader.DIRTY_CHALK);

                    }).build());

    public static final List<ItemStack> WOOD_BLOCKS_CONTENTS = new LinkedList<>();
//    public static final ItemGroup EDUMIA_WOOD_BLOCKS = FabricItemGroup.builder()
//            .displayName(Text.literal("Edumia Wood Blocks"))
//                    .icon(() -> new ItemStack(WoodBlockSets.APPLE.planks().asItem()))
//                    .entries((displayContext, entries) ->  {
//                        for (ItemStack item: WOOD_BLOCKS_CONTENTS){
//                            entries.add(item);
//                        }
//                    }).build();

    public static final List<ItemStack> NATURAL_STONE_BLOCKS_CONTENTS = new LinkedList<>();
//    public static final ItemGroup EDUMIA_NATURAL_STONE_BLOCKS = FabricItemGroup.builder()
//            .displayName(Text.literal("Edumia Natural stone blocks"))
//                    .icon(() -> new ItemStack(BlockLoader.WHITE_SAND)).entries((displayContext, entries) -> {
//                        for (ItemStack item : NATURAL_STONE_BLOCKS_CONTENTS){
//                            entries.add(item);
//                        }
//
//
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
//                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_WALL);
//
//                        entries.add(BlockLoader.CHISELED_BASALT);
//
//                        entries.add(BlockLoader.BROWN_SANDSTONE_SLATES);
//
//                        entries.add(BlockLoader.DIRTY_CHALK);
////
//                        entries.add(BlockLoader.SAND_LAYER);
//                        entries.add(BlockLoader.RED_SAND_LAYER);
//                        entries.add(BlockLoader.WHITE_SAND);
//                        entries.add(BlockLoader.WHITE_SAND_LAYER);
//
//                        entries.add(BlockLoader.VOLCANIC_DIRT);
//                        entries.add(BlockLoader.VOLCANIC_DIRT_PATH);
//                        entries.add(BlockLoader.VOLCANIC_GRAVEL);
//                    })
//                    .build();

    public static final List<ItemStack> GLASS_CONTENTS = new LinkedList<>();
//    public static final ItemGroup EDUMIA_GLASS_BLOCKS = FabricItemGroup.builder()
//            .displayName(Text.literal("Edumia Glass Blocks"))
//            .icon(() -> new ItemStack(GlassSets.FINE_GLASS.block().asItem()))
//            .entries((displayContext, entries) ->  {
//                for (ItemStack item: GLASS_CONTENTS){
//                    entries.add(item);
//                }
//            }).build();

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
