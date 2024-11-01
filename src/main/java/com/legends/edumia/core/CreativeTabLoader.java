package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.EdumiaLeavesBlock;
import com.legends.edumia.blocks.blocksets.*;
import com.legends.edumia.blocks.trees.BlackOakLeavesBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.legends.edumia.blocks.blocksets.WoodBlockSets.LEAVES_STRENGTH;

public class CreativeTabLoader {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Edumia.MOD_ID);

    public static final RegistryObject<CreativeModeTab>  LEGENDS_GROUP =
            CREATIVE_MODE_TABS.register("edumia_rewards",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.LEGENDS_COIN.get()))
                    .title(Component.translatable("creativetab.edumia_rewards"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.LEGENDS_COIN.get());
                        //entries.accept(ItemLoader.ATLAS.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  UTILITY_GROUP =
            CREATIVE_MODE_TABS.register("edumia_utilities",() ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(WoodBlockSets.DRAGON_BLOOD.door().get()))
                            .title(Component.translatable("creativetab.edumia_utilities"))
                            .displayItems((displayParameters, entries) -> {
                                for (WoodBlockSets.SimpleBlockSet wood: WoodBlockSets.sets){
                                    entries.accept(wood.door().get());
                                    entries.accept(wood.trapdoor().get());
                                }
                            }).build());

    public static final RegistryObject<CreativeModeTab>  WEAPON_GROUP = CREATIVE_MODE_TABS.register("edumia_weapons",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.ABOMINABLE_BLADE.get()))
                    .title(Component.translatable("creativetab.edumia_weapons"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.ABOMINABLE_BLADE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  MATERIAL_GROUP = CREATIVE_MODE_TABS.register("edumia_materials",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.GENSAI_STEEL.get()))
                    .title(Component.translatable("creativetab.edumia_materials"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.GENSAI_STEEL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  TOOL_GROUP = CREATIVE_MODE_TABS.register("edumia_tools",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.GENSAI_AXE.get()))
                    .title(Component.translatable("creativetab.edumia_tools"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.GENSAI_AXE.get());
                        entries.accept(ItemLoader.GENSAI_HOE.get());
                        entries.accept(ItemLoader.GENSAI_PICKAXE.get());
                        entries.accept(ItemLoader.GENSAI_SHOVEL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  EDUMIA_PLANTS =
            CREATIVE_MODE_TABS.register("edumia_plants",() ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.PAPYRUS.get()))
                            .title(Component.translatable("creativetab.edumia_plants"))
                            .displayItems((displayParameters, entries) -> {
                                for (WoodBlockSets.SimpleBlockSet set : WoodBlockSets.sets){
                                    if (set.leaves() != null){
                                        entries.accept(set.leaves().get());
                                    }
                                }
                                entries.accept(ModNatureBlocks.GHOST_GUM_LEAVES.get());
                                entries.accept(ModNatureBlocks.HOLLY_LEAVES.get());
                                entries.accept(ModNatureBlocks.MAPLE_LEAVES.get());
                                entries.accept(ModNatureBlocks.BLACK_OAK_LEAVES.get());

                                entries.accept(ModNatureBlocks.APPLE_LEAVES_RED.get());
                                entries.accept(ModNatureBlocks.APPLE_LEAVES_GREEN.get());
                                entries.accept(ModNatureBlocks.PEAR_LEAVES_FRUIT.get());
                                entries.accept(ModNatureBlocks.CHERRY_LEAVES_FRUIT.get());
                                entries.accept(ModNatureBlocks.TEST_SAPLING.get());
                                entries.accept(ModNatureBlocks.APPLE_SAPLING.get());
                                entries.accept(ModNatureBlocks.BANANA_SAPLING.get());
                                entries.accept(ModNatureBlocks.ASPEN_SAPLING.get());
                                entries.accept(ModNatureBlocks.GHOST_GUM_SAPLING.get());

                                entries.accept(ModNatureBlocks.BEECH_SAPLING.get());
                                entries.accept(ModNatureBlocks.BLACKTHORN_SAPLING.get());
                                entries.accept(ModNatureBlocks.BLACK_OAK_SAPLING.get());
                                entries.accept(ModNatureBlocks.CEDAR_SAPLING.get());
                                entries.accept(ModNatureBlocks.CHERRY_SAPLING.get());
                                entries.accept(ModNatureBlocks.CYPRESS_SAPLING.get());
                                entries.accept(ModNatureBlocks.DRAGON_BLOOD_SAPLING.get());
                                entries.accept(ModNatureBlocks.FIR_SAPLING.get());
                                entries.accept(ModNatureBlocks.GREEN_OAK_SAPLING.get());
                                entries.accept(ModNatureBlocks.HOLLY_SAPLING.get());
                                entries.accept(ModNatureBlocks.LARCH_SAPLING.get());
                                entries.accept(ModNatureBlocks.MAHOGANY_SAPLING.get());
                                entries.accept(ModNatureBlocks.MAPLE_SAPLING.get());
                                entries.accept(ModNatureBlocks.MANGO_SAPLING.get());


                                entries.accept(ModNatureBlocks.PEAR_SAPLING.get());

                                entries.accept(ModNatureBlocks.PALM_SAPLING.get());
                                entries.accept(ModNatureBlocks.PINE_SAPLING.get());
                                entries.accept(ModNatureBlocks.RED_OAK_SAPLING.get());
                                entries.accept(ModNatureBlocks.REDWOOD_SAPLING.get());
                                entries.accept(ModNatureBlocks.SILVER_SPRUCE_SAPLING.get());
                                entries.accept(ModNatureBlocks.WHITE_ASH_SAPLING.get());
                                entries.accept(ModNatureBlocks.WILLOW_SAPLING.get());
                                entries.accept(BlockLoader.PAPYRUS.get());
                                entries.accept(BlockLoader.REEDS.get());
                                entries.accept(BlockLoader.DRIED_REEDS.get());

                                entries.accept(BlockLoader.DRY_BUSH.get());
                                entries.accept(BlockLoader.TALL_DRY_BUSH.get());
                                entries.accept(BlockLoader.TALL_DEAD_BUSH.get());

                                entries.accept(BlockLoader.ARID_GRASS.get());
                                entries.accept(BlockLoader.BLACK_GRASS.get());
                                entries.accept(BlockLoader.FLAX_GRASS.get());
                                entries.accept(BlockLoader.BEACH_GRASS.get());
                                entries.accept(BlockLoader.TALL_BEACH_GRASS.get());
                                entries.accept(BlockLoader.FROSTED_GRASS.get());
                                entries.accept(BlockLoader.TALL_FROSTED_GRASS.get());

                                entries.accept(BlockLoader.PARASOL_MUSHROOM_1.get());
                                entries.accept(BlockLoader.PARASOL_MUSHROOM_2.get());
                                entries.accept(BlockLoader.PARASOL_MUSHROOM_TALL.get());

//                             flowers
                                entries.accept(BlockLoader.ASPHODEL.get());
                                entries.accept(BlockLoader.BLUE_DELPHINIUM.get());
                                entries.accept(BlockLoader.BLUEBELL.get());
                                entries.accept(BlockLoader.CALLA_LILY.get());
                                entries.accept(BlockLoader.CELSEMIUM.get());
                                entries.accept(BlockLoader.CHRYS_BLUE.get());
                                entries.accept(BlockLoader.CHRYS_ORANGE.get());
                                entries.accept(BlockLoader.CHRYS_PINK.get());
                                entries.accept(BlockLoader.CHRYS_WHITE.get());
                                entries.accept(BlockLoader.CHRYS_YELLOW.get());
                                entries.accept(BlockLoader.CROCUS.get());
                                entries.accept(BlockLoader.DAISY.get());
                                entries.accept(BlockLoader.DELPHINIUM.get());
                                entries.accept(BlockLoader.FLAX_FLOWERS.get());
                                entries.accept(BlockLoader.FOXGLOVE_ORANGE.get());
                               entries.accept(BlockLoader.FOXGLOVE_PINK.get());
                               entries.accept(BlockLoader.FOXGLOVE_RED.get());
                               entries.accept(BlockLoader.FOXGLOVE_WHITE.get());
                               entries.accept(BlockLoader.GERBERA_RED.get());
                               entries.accept(BlockLoader.GENSAI_ORCHID.get());
                               entries.accept(BlockLoader.GERBERA_YELLOW.get());
                               entries.accept(BlockLoader.HEATHER_BUSH.get());
                               entries.accept(BlockLoader.LAVENDER.get());
                               entries.accept(BlockLoader.MARIGOLD.get());
                               entries.accept(BlockLoader.PINK_ANEMONE.get());
                               entries.accept(BlockLoader.SIMBLELMYNE.get());
                               entries.accept(BlockLoader.TUBEROSE.get());
                               entries.accept(BlockLoader.YELLOW_IRIS.get());
                               entries.accept(BlockLoader.FLAME_OF_THE_SOUTH.get());
                               entries.accept(BlockLoader.HIBISCUS.get());
                            }).build());


    public static final RegistryObject<CreativeModeTab>  EDUMIA_GEMS = CREATIVE_MODE_TABS.register("edumia_gems",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.GEM_PERFECT_AMBER.get()))
                    .title(Component.translatable("creativetab.edumia_gems"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.GEM_FINE_AMBER.get());
                        entries.accept(ItemLoader.GEM_FLAWED_AMBER.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_AMBER.get());
                        entries.accept(ItemLoader.GEM_PERFECT_AMBER.get());
                        entries.accept(ItemLoader.GEM_ROUGH_AMBER.get());
                        entries.accept(ItemLoader.GEM_FINE_AMETHYST.get());
                        entries.accept(ItemLoader.GEM_FLAWED_AMETHYST.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_AMETHYST.get());
                        entries.accept(ItemLoader.GEM_PERFECT_AMETHYST.get());
                        entries.accept(ItemLoader.GEM_ROUGH_AMETHYST.get());
                        entries.accept(ItemLoader.GEM_FINE_JADE.get());
                        entries.accept(ItemLoader.GEM_FLAWED_JADE.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_JADE.get());
                        entries.accept(ItemLoader.GEM_PERFECT_JADE.get());
                        entries.accept(ItemLoader.GEM_ROUGH_JADE.get());
                        entries.accept(ItemLoader.GEM_FINE_JASPER.get());
                        entries.accept(ItemLoader.GEM_FLAWED_JASPER.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_JASPER.get());
                        entries.accept(ItemLoader.GEM_PERFECT_JASPER.get());
                        entries.accept(ItemLoader.GEM_ROUGH_JASPER.get());
                        entries.accept(ItemLoader.GEM_FINE_RUBY.get());
                        entries.accept(ItemLoader.GEM_FLAWED_RUBY.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_RUBY.get());
                        entries.accept(ItemLoader.GEM_PERFECT_RUBY.get());
                        entries.accept(ItemLoader.GEM_ROUGH_RUBY.get());
                        entries.accept(ItemLoader.GEM_FINE_SAPPHIRE.get());
                        entries.accept(ItemLoader.GEM_FLAWED_SAPPHIRE.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_SAPPHIRE.get());
                        entries.accept(ItemLoader.GEM_PERFECT_SAPPHIRE.get());
                        entries.accept(ItemLoader.GEM_ROUGH_SAPPHIRE.get());
                        entries.accept(ItemLoader.GEM_FINE_TOPAZ.get());
                        entries.accept(ItemLoader.GEM_FLAWED_TOPAZ.get());
                        entries.accept(ItemLoader.GEM_FLAWLESS_TOPAZ.get());
                        entries.accept(ItemLoader.GEM_PERFECT_TOPAZ.get());
                        entries.accept(ItemLoader.GEM_ROUGH_TOPAZ.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  FOOD_GROUP = CREATIVE_MODE_TABS.register("edumia_food",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.TEA_HIBISCUS_PETALS.get()))
                    .title(Component.translatable("creativetab.edumia_food"))
                    .displayItems((displayParameters, entries) -> {
                        entries.accept(ItemLoader.TEA_SAKURA_PETALS.get());
                entries.accept(ItemLoader.TEA_MINT_LEAVES.get());
                entries.accept(ItemLoader.TEA_LEAF.get());
                entries.accept(ItemLoader.TEA_LILY_PETALS.get());
                entries.accept(ItemLoader.TEA_WHITE_JADE_PETALS.get());
                entries.accept(ItemLoader.TEA_HIBISCUS_PETALS.get());
                entries.accept(ItemLoader.TEA_JASMINE_PETALS.get());
                entries.accept(ItemLoader.TEA_CINNAMON_STICK.get());
                entries.accept(ItemLoader.TEA_WHITE_DRAGON_PETALS.get());

                entries.accept(ItemLoader.BROCCOLI.get());
                entries.accept(ItemLoader.PAPRIKA_GREEN.get());
                entries.accept(ItemLoader.RAMEN.get());
                entries.accept(ItemLoader.RAMEN_BEEF.get());
                entries.accept(ItemLoader.RAMEN_PORK.get());
                entries.accept(ItemLoader.RAMEN_SHRIMPS.get());
                entries.accept(ItemLoader.RAMEN_VEGI.get());
                entries.accept(ItemLoader.RED_GRAPES.get());
                entries.accept(ItemLoader.RICE.get());
                entries.accept(ItemLoader.RICE_BALL.get());
                entries.accept(ItemLoader.SPINACH.get());
                entries.accept(ItemLoader.TOMATO.get());
                entries.accept(ItemLoader.CHEESE.get());

                entries.accept(ItemLoader.LETTUCE.get());
                entries.accept(ItemLoader.BANANA.get());
                entries.accept(ItemLoader.BANANA_BREAD.get());
                entries.accept(ItemLoader.MANGO.get());
                entries.accept(ItemLoader.DATE.get());
                    }).build());

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
//    public static List<ItemStack> BUILDING_CONTENTS = new ArrayList<>() {
//        {
//            for (BuildingSets.BuildSet set : BuildingSets.buildSets){
//                add(set.block().get().asItem().getDefaultInstance());
//            }
//        }
//    };


    public static final RegistryObject<CreativeModeTab> EDUMIA_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("edumia_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BuildingSets.GREEN_BASALT_BRICKS.block().get()))
                    .title(Component.translatable("creativetab.edumia_building_blocks"))
                    .displayItems((displayParameters, entries) -> {
                        for (BuildingSets.BuildSet set : BuildingSets.buildSets) {
                            entries.accept(set.block().get());
                            entries.accept(set.slab().get());
                            entries.accept(set.stair().get());
                            entries.accept(set.wall().get());
                            if (set.pillar() != null){
                                entries.accept(set.pillar().get());
                                entries.accept(set.pillarSlab().get());
                            }
                            entries.accept(set.smallArch().get());
                            entries.accept(set.twoMeterArch().get());
                            entries.accept(set.roundArch().get());
                            entries.accept(set.segmentalArch().get());
                            entries.accept(set.gothicArch().get());
                            entries.accept(set.balustrade().get());
                        }

                        for (ClayTilingSets.ClayTilingSet set : ClayTilingSets.sets) {
                            entries.accept(set.block().get());
                            entries.accept(set.slab().get());
                            entries.accept(set.stairs().get());
                            entries.accept(set.corner().get());
                        }

                        for (NotBrickBuildingSets.BuildSet set : NotBrickBuildingSets.buildSets) {
                            entries.accept(set.block().get());
                            entries.accept(set.slab().get());
                            entries.accept(set.stair().get());
                            if (set.wall() != null){
                                entries.accept(set.wall().get());
                            }
                        }
                       entries.accept(BlockLoader.BRICK_PILLAR.get());
                       entries.accept(BlockLoader.STONE_PILLAR.get());
                       entries.accept(BlockLoader.SANDSTONE_PILLAR.get());

                       entries.accept(BlockLoader.BLUE_BRICK.get());
                       entries.accept(BlockLoader.BLUE_BRICK_SLAB.get());
                       entries.accept(BlockLoader.BLUE_BRICK_STAIRS.get());
                       entries.accept(BlockLoader.BLUE_BRICK_WALL.get());

                       entries.accept(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS.get());

                       entries.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING.get());
                       entries.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS.get());
                       entries.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB.get());

                       entries.accept(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS.get());

                       entries.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING.get());
                       entries.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB.get());
                       entries.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS.get());

                       entries.accept(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS.get());

                       entries.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get());
                       entries.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS.get());
                       entries.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB.get());

                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT.get());
                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get());
                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get());
                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT_WALL.get());

                       entries.accept(BlockLoader.CHISELED_BASALT.get());

                       entries.accept(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_CACHOLONG_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_BLACK_DEMON_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_BLUE_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_DEMON_BASALT_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_VOLCANIC_DEMON_BRICKS.get());

                       entries.accept(BlockLoader.CARVED_RED_GENSAI_BRICKS.get());

                       entries.accept(BlockLoader.CHISELED_ANDESITE.get());
                       entries.accept(BlockLoader.CHISELED_DRIPSTONE.get());
                       entries.accept(BlockLoader.CHISELED_DIORITE.get());
                       entries.accept(BlockLoader.CHISELED_GRANITE.get());
                       entries.accept(BlockLoader.DIRTY_CHALK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab>  EDUMIA_WOOD_BLOCKS =
            CREATIVE_MODE_TABS.register("edumia_wood_blocks",() ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(WoodBlockSets.APPLE.planks().get()))
                            .title(Component.translatable("creativetab.edumia_wood_blocks"))
                            .displayItems((displayParameters, entries) -> {
                                for (WoodBlockSets.SimpleBlockSet wood: WoodBlockSets.sets){
                                    entries.accept(wood.log().get());
                                    entries.accept(wood.wood().get());
                                    entries.accept(wood.woodStairs().get());
                                    entries.accept(wood.woodSlab().get());
                                    entries.accept(wood.woodWall().get());
                                    entries.accept(wood.woodFence().get());
                                    entries.accept(wood.strippedLog().get());
                                    entries.accept(wood.strippedWood().get());
                                    entries.accept(wood.strippedWoodStairs().get());
                                    entries.accept(wood.strippedWoodSlab().get());
                                    entries.accept(wood.strippedWoodWall().get());
                                    entries.accept(wood.strippedWoodFence().get());
                                    entries.accept(wood.planks().get());
                                    entries.accept(wood.planksSlab().get());
                                    entries.accept(wood.planksStairs().get());
                                    entries.accept(wood.planksSlab().get());
                                    entries.accept(wood.planksFence().get());
                                    entries.accept(wood.planksGate().get());
                                    entries.accept(wood.pressurePlate().get());
                                    entries.accept(wood.button().get());
                                    entries.accept(wood.beam().get());
                                }

                                for (WoodBlockSets.SimpleVanillaBlocks wood: WoodBlockSets.beams){
                                    entries.accept(wood.beam().get());
                                }
                            }).build());


    public static final RegistryObject<CreativeModeTab>  EDUMIA_NATURAL_STONE_BLOCKS =
            CREATIVE_MODE_TABS.register("edumia_natural_stone_blocks",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.WHITE_SAND.get()))
                    .title(Component.translatable("creativetab.edumia_natural_stone_blocks"))
                    .displayItems((displayParameters, entries) -> {
                        for (StoneSets.StoneSet item: StoneSets.naturalSets){
                            entries.accept(item.block().get());
                            entries.accept(item.slab().get());
                            entries.accept(item.stair().get());
                            entries.accept(item.wall().get());
                        }

                        entries.accept(BlockLoader.CRACKED_GREEN_BASALT.get());
                        entries.accept(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get());
                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get());
                       entries.accept(BlockLoader.CRACKED_GREEN_BASALT_WALL.get());

                       entries.accept(BlockLoader.CHISELED_BASALT.get());

                       entries.accept(BlockLoader.BROWN_SANDSTONE_SLATES.get());

                       entries.accept(BlockLoader.DIRTY_CHALK.get());
//
                       entries.accept(BlockLoader.SAND_LAYER.get());
                       entries.accept(BlockLoader.RED_SAND_LAYER.get());
                       entries.accept(BlockLoader.WHITE_SAND.get());
                       entries.accept(BlockLoader.WHITE_SAND_LAYER.get());

                       entries.accept(BlockLoader.VOLCANIC_DIRT.get());
                       entries.accept(BlockLoader.VOLCANIC_DIRT_PATH.get());
                       entries.accept(BlockLoader.VOLCANIC_GRAVEL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab>  EDUMIA_GLASS_BLOCKS = CREATIVE_MODE_TABS.register("edumia_glass_blocks",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GlassSets.FINE_GLASS.block().get()))
                    .title(Component.translatable("creativetab.edumia_glass_blocks"))
                    .displayItems((displayParameters, entries) -> {
                for (GlassSets.GlassSet item: GlassSets.glassSets){
                    entries.accept(item.pane().get());
                    entries.accept(item.block().get());
                }

                for (PaperwallSets.PaperwallSet set : PaperwallSets.paperwallSets){
                    entries.accept(set.pane().get());
                }
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
