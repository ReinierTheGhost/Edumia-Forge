package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.AxialSlabBlock;
import com.legends.edumia.blocks.CrystalBlock;
import com.legends.edumia.blocks.EdumiaPillarBlock;
import com.legends.edumia.blocks.Layer;
import com.legends.edumia.blocks.plants.DriedReedsBlock;
import com.legends.edumia.blocks.plants.ReedsBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockLoader {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MOD_ID);

    public static final RegistryObject<Block> SAND_LAYER = registerBlock("sand_layer", () ->
            new Layer(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));
    public static final RegistryObject<Block> RED_SAND_LAYER = registerBlock("red_sand_layer", () ->
            new Layer(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));

    public static final RegistryObject<Block> WHITE_SAND = registerBlock("white_sand", () ->
            new FallingBlock(BlockBehaviour.Properties.of().sound(SoundType.SAND)));
    public static final RegistryObject<Block> WHITE_SAND_LAYER = registerBlock("white_sand_layer", () ->
            new Layer(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));

//    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () ->
//            new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE)
//                    .strength(3.0f, 3.0f).requiresCorrectToolForDrops().dropsLike(Blocks.IRON_ORE)), false);


    public static final RegistryObject<Block> HIGH_ELVEN_CRYSTAL = registerBlock("high_elven_crystal", () ->
            new CrystalBlock(12, 2, DyeColor.LIGHT_BLUE));

    public static final RegistryObject<Block> VOLCANIC_DIRT = registerBlock("volcanic_dirt", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> VOLCANIC_DIRT_PATH = registerBlock("volcanic_dirt_path", () ->
            new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));
    public static final RegistryObject<Block> VOLCANIC_GRAVEL = registerBlock("volcanic_gravel", () ->
            new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> BRICK_PILLAR = registerBlock("brick_pillar", () ->
            new EdumiaPillarBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> STONE_PILLAR = registerBlock("stone_pillar", () ->
            new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SANDSTONE_PILLAR = registerBlock("sandstone_pillar", () ->
            new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLUE_BRICK = registerBlock("blue_brick", () ->
            new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUE_BRICK_STAIRS = registerBlock("blue_brick_stairs", () ->
            new StairBlock(BlockLoader.BLUE_BRICK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_BRICK_SLAB = registerBlock("blue_brick_slab", () ->
            new AxialSlabBlock(BLUE_BRICK));
    public static final RegistryObject<Block> BLUE_BRICK_WALL = registerBlock("blue_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_BASALT = registerBlock("chiseled_basalt", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT = registerBlock("cracked_green_basalt", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_STAIRS = registerBlock("cracked_green_basalt_stairs", () ->
            new StairBlock(BlockLoader.CRACKED_GREEN_BASALT.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_SLAB = registerBlock("cracked_green_basalt_slab", () ->
            new AxialSlabBlock(CRACKED_GREEN_BASALT));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_WALL = registerBlock("cracked_green_basalt_wall", () ->
            new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_HIGH_ELVEN_BRICKS = registerBlock("chiseled_high_elven_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("chiseled_light_high_elven_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_DARK_HIGH_ELVEN_BRICKS = registerBlock("chiseled_dark_high_elven_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_BROWN_SANDSTONE_BRICKS = registerBlock("carved_brown_sandstone_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_CACHOLONG_BRICKS = registerBlock("carved_cacholong_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_BLACK_DEMON_BRICKS = registerBlock("carved_black_demon_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_BLUE_BRICKS = registerBlock("carved_blue_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_DEMON_BASALT_BRICKS = registerBlock("carved_demon_basalt_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_VOLCANIC_DEMON_BRICKS = registerBlock("carved_volcanic_demon_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_RED_GENSAI_BRICKS = registerBlock("carved_red_gensai_bricks", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING = registerBlock("high_elven_brick_tiling", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("high_elven_brick_tiling_stairs", () ->
            new StairBlock(BlockLoader.HIGH_ELVEN_BRICK_TILING.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("high_elven_brick_tiling_slab", () ->
            new AxialSlabBlock(HIGH_ELVEN_BRICK_TILING));

    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING = registerBlock("dark_high_elven_brick_tiling", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("dark_high_elven_brick_tiling_stairs", () ->
            new StairBlock(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("dark_high_elven_brick_tiling_slab", () ->
            new AxialSlabBlock(DARK_HIGH_ELVEN_BRICK_TILING));

    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING = registerBlock("light_high_elven_brick_tiling", () ->
            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("light_high_elven_brick_tiling_stairs", () ->
            new StairBlock(BlockLoader.HIGH_ELVEN_BRICK_TILING.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("light_high_elven_brick_tiling_slab", () ->
            new AxialSlabBlock(LIGHT_HIGH_ELVEN_BRICK_TILING));



    public static final RegistryObject<Block> BROWN_SANDSTONE_SLATES = registerBlock("brown_sandstone_slates", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_ANDESITE = registerBlock("chiseled_andesite", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(2f, 6f)));

    public static final RegistryObject<Block> CHISELED_DIORITE = registerBlock("chiseled_diorite", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(2f, 6f)));

    public static final RegistryObject<Block> CHISELED_GRANITE = registerBlock("chiseled_granite", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(2f, 6f)));

    public static final RegistryObject<Block> CHISELED_DRIPSTONE = registerBlock("chiseled_dripstone", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(2f, 6f)));
    public static final RegistryObject<Block> DIRTY_CHALK = registerBlock("dirty_chalk", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(2f, 6f)));
//
//
//
//    public static final RegistryObject<Block> MARBLE_PINK = registerBlock("marble_pink",
//            new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
//                    .strength(1.5f, 6f)));
//    //ores
//    public static final RegistryObject<Block> ORE_VEIL = registerBlock("ore_veil",
//            new Block(BlockBehaviour.Properties.of()
//                    .strength(3f).requiresCorrectToolForDrops()));
//    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
//            new Block(BlockBehaviour.Properties.of()
//                    .strength(3f).requiresCorrectToolForDrops()));
//    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
//            new Block(BlockBehaviour.Properties.of()
//                    .strength(3f).requiresCorrectToolForDrops()));
//    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
//            new Block(BlockBehaviour.Properties.of()
//                    .strength(3f).requiresCorrectToolForDrops()));
//
//
    //wood



    //Plants

    public static final RegistryObject<Block> REEDS = registerBlock("reeds", () -> new ReedsBlock());

    public static final RegistryObject<Block> PAPYRUS = registerBlock("papyrus", () -> new ReedsBlock());

    public static final RegistryObject<Block> DRIED_REEDS = registerBlock("dried_reeds", () -> new DriedReedsBlock());


    //grass

    public static final RegistryObject<Block> DRY_BUSH = registerBlock("dry_bush", () ->
            new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_DRY_BUSH = registerBlock("tall_dry_bush", () ->
            new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_DEAD_BUSH = registerBlock("tall_dead_bush", () ->
            new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> ARID_GRASS = registerBlock("arid_grass", () ->
            new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BLACK_GRASS = registerBlock("black_grass", () ->
            new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FLAX_GRASS = registerBlock("flax_grass", () ->
            new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BEACH_GRASS = registerBlock("beach_grass", () ->
            new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_BEACH_GRASS = registerBlock("tall_beach_grass", () ->
            new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FROSTED_GRASS = registerBlock("frosted_grass", () ->
            new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_FROSTED_GRASS = registerBlock("tall_frosted_grass", () ->
            new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    //Mushrooms
    public static final RegistryObject<Block> PARASOL_MUSHROOM_1 = registerBlock("parasol_mushroom_01", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> PARASOL_MUSHROOM_2 = registerBlock("parasol_mushroom_02", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> PARASOL_MUSHROOM_TALL = registerBlock("parasol_mushroom_tall", () -> new TallFlowerBlock(BlockBehaviour.Properties
            .of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));


    //flowers
    public static final RegistryObject<Block> ASPHODEL = registerBlock("asphodel", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> BLUE_DELPHINIUM = registerBlock("blue_delphinium", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> BLUEBELL = registerBlock("bluebell", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CALLA_LILY = registerBlock("calla_lily", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CELSEMIUM = registerBlock("celsemium", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHRYS_BLUE = registerBlock("chrys_blue", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHRYS_ORANGE = registerBlock("chrys_orange", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHRYS_PINK = registerBlock("chrys_pink", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHRYS_WHITE = registerBlock("chrys_white", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHRYS_YELLOW = registerBlock("chrys_yellow", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> CROCUS = registerBlock("crocus", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> DAISY = registerBlock("daisy", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> DELPHINIUM = registerBlock("delphinium", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> FLAX_FLOWERS = registerBlock("flax_flowers", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> FOXGLOVE_ORANGE = registerBlock("foxglove_orange", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> FOXGLOVE_PINK = registerBlock("foxglove_pink", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> FOXGLOVE_RED = registerBlock("foxglove_red", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> FOXGLOVE_WHITE = registerBlock("foxglove_white", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> GERBERA_RED = registerBlock("gerbera_red", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> GENSAI_ORCHID = registerBlock("gensai_orchid", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> GERBERA_YELLOW = registerBlock("gerbera_yellow", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> HEATHER_BUSH = registerBlock("heather_bush", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> LAVENDER = registerBlock("lavender", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> MARIGOLD = registerBlock("marigold", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> PINK_ANEMONE = registerBlock("pink_anemone", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> SIMBLELMYNE = registerBlock("simbelmyne", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));
    public static final RegistryObject<Block> TUBEROSE = registerBlock("tuberose", () ->
            new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> YELLOW_IRIS = registerBlock("yellow_iris", () -> new TallFlowerBlock(BlockBehaviour.Properties
            .of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FLAME_OF_THE_SOUTH = registerBlock("flame_of_the_south", () -> new TallFlowerBlock(BlockBehaviour.Properties
            .of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HIBISCUS = registerBlock("hibiscus", () -> new TallFlowerBlock(BlockBehaviour.Properties
            .of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> POTTED_ASPHODEL = BLOCKS.register("potted_asphodel", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), ASPHODEL, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_BLUE_DELPHINIUM = BLOCKS.register("potted_blue_delphinium", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), BLUE_DELPHINIUM, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_BLUEBELL = BLOCKS.register("potted_bluebell", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), BLUEBELL, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CALLA_LILY = BLOCKS.register("potted_calla_lily", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CALLA_LILY, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CELSEMIUM = BLOCKS.register("potted_celsemium", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CELSEMIUM, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CHRYS_BLUE = BLOCKS.register("potted_chrys_blue", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CHRYS_BLUE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CHRYS_ORANGE = BLOCKS.register("potted_chrys_orange", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CHRYS_ORANGE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CHRYS_PINK = BLOCKS.register("potted_chrys_pink", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CHRYS_PINK, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CHRYS_WHITE = BLOCKS.register("potted_chrys_white", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CHRYS_WHITE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CHRYS_YELLOW = BLOCKS.register( "potted_chrys_yellow", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CHRYS_YELLOW, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_CROCUS = BLOCKS.register("potted_crocus", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CROCUS, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_DAISY = BLOCKS.register("potted_daisy", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), DAISY, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_DELPHINIUM = BLOCKS.register("potted_delphinium", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), DELPHINIUM, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_FLAX_FLOWERS = BLOCKS.register("potted_flax_flowers", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), FLAX_FLOWERS, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_FOXGLOVE_ORANGE = BLOCKS.register("potted_foxglove_orange", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), FOXGLOVE_ORANGE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_FOXGLOVE_PINK = BLOCKS.register("potted_foxglove_pink", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), FOXGLOVE_PINK, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_FOXGLOVE_RED = BLOCKS.register("potted_foxglove_red", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), FOXGLOVE_RED, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_FOXGLOVE_WHITE = BLOCKS.register("potted_foxglove_white", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), FOXGLOVE_WHITE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_GERBERA_RED = BLOCKS.register("potted_gerbera_red", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), GERBERA_RED, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_GENSAI_ORCHID = BLOCKS.register("potted_gensai_orchid", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), GENSAI_ORCHID, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_GERBERA_YELLOW = BLOCKS.register("potted_gerbera_yellow", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), GERBERA_YELLOW, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_HEATHER_BUSH = BLOCKS.register("potted_heather_bush", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), HEATHER_BUSH, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), LAVENDER, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_MARIGOLD = BLOCKS.register("potted_marigold", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), MARIGOLD, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_PINK_ANEMONE = BLOCKS.register("potted_pink_anemone", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), PINK_ANEMONE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_SIMBLELMYNE = BLOCKS.register("potted_simbelmyne", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), SIMBLELMYNE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));
    public static final RegistryObject<Block> POTTED_TUBEROSE = BLOCKS.register("potted_tuberose", () ->
            new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), TUBEROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)
                    .noOcclusion()));


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
