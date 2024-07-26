package com.legends.edumia.blocks.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.blocks.AxialSlabBlock;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class WoodBlockSets {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MOD_ID);
    public static final float WOOD_STRENGTH = 2f;
    public static final float PLATE_BUTTON_STRENGTH = 0.5f;
    public static final float LEAVES_STRENGTH = 0.1f;

    public static SimpleBlockSet APPLE = registerWoodSet("apple", WOOD_STRENGTH, true);
    public static SimpleBlockSet BANANA = registerWoodSet("banana", WOOD_STRENGTH, true);
    public static SimpleBlockSet ASPEN = registerWoodSet("aspen", WOOD_STRENGTH, true);
    public static SimpleBlockSet BEECH = registerWoodSet("beech", WOOD_STRENGTH, true);
    public static SimpleBlockSet BLACKTHORN = registerWoodSet("blackthorn", WOOD_STRENGTH, true);
    public static SimpleBlockSet CEDAR = registerWoodSet("cedar", WOOD_STRENGTH, true);
    public static SimpleBlockSet CHERRY = registerWoodSet("cherry", WOOD_STRENGTH, true);
    public static SimpleBlockSet CYPRESS = registerWoodSet("cypress", WOOD_STRENGTH, true);
    public static SimpleBlockSet FIR = registerWoodSet("fir", WOOD_STRENGTH, true);
    public static SimpleBlockSet GHOST_GUM = registerWoodSet("ghost_gum", WOOD_STRENGTH, false);
    public static SimpleBlockSet GREEN_OAK = registerWoodSet("green_oak", WOOD_STRENGTH, true);
    public static SimpleBlockSet HOLLY = registerWoodSet("holly", WOOD_STRENGTH, false);
    public static SimpleBlockSet LARCH = registerWoodSet("larch", WOOD_STRENGTH, true);
    public static SimpleBlockSet MANGO = registerWoodSet("mango", WOOD_STRENGTH, true);
    public static SimpleBlockSet MAPLE = registerWoodSet("maple", WOOD_STRENGTH, false);
    public static SimpleBlockSet PEAR = registerWoodSet("pear", WOOD_STRENGTH, true);
    public static SimpleBlockSet PINE = registerWoodSet("pine", WOOD_STRENGTH, true);
    public static SimpleBlockSet RED_OAK = registerWoodSet("red_oak", WOOD_STRENGTH, true);
    public static SimpleBlockSet REDWOOD = registerWoodSet("redwood", WOOD_STRENGTH, true);
    public static SimpleBlockSet SILVER_SPRUCE = registerWoodSet("silver_spruce", WOOD_STRENGTH, true);
    public static SimpleBlockSet WHITE_ASH = registerWoodSet("white_ash", WOOD_STRENGTH, true);
    public static SimpleBlockSet DRAGON_BLOOD = registerWoodSet("dragon_blood", WOOD_STRENGTH, true);
    public static SimpleBlockSet PALM = registerWoodSet("palm", WOOD_STRENGTH, true);
    public static SimpleBlockSet MAHOGANY = registerWoodSet("mahogany", WOOD_STRENGTH, true);
    public static SimpleBlockSet CHARRED = registerWoodSet("charred", WOOD_STRENGTH, false);
    public static SimpleBlockSet BLACK_OAK = registerWoodSet("black_oak", WOOD_STRENGTH, false);
    public static SimpleBlockSet WILLOW = registerWoodSet("willow", WOOD_STRENGTH, true);


    public static SimpleVanillaBlocks OAK = registerBeams("oak", WOOD_STRENGTH);
    public static SimpleVanillaBlocks ACACIA = registerBeams("acacia", WOOD_STRENGTH);
    public static SimpleVanillaBlocks BIRCH = registerBeams("birch", WOOD_STRENGTH);
    public static SimpleVanillaBlocks SPRUCE = registerBeams("spruce", WOOD_STRENGTH);
    public static SimpleVanillaBlocks DARK_OAK = registerBeams("dark_oak", WOOD_STRENGTH);
    public static SimpleVanillaBlocks JUNGLE = registerBeams("jungle", WOOD_STRENGTH);



    public static SimpleBlockSet[] sets = new SimpleBlockSet[] {
            APPLE,
            ASPEN,
            BANANA,
            BEECH,
            BLACK_OAK,
            BLACKTHORN,
            CEDAR,
            CHERRY,
            CYPRESS,
            CHARRED,
            DRAGON_BLOOD,
            FIR,
            GHOST_GUM,
            GREEN_OAK,
            HOLLY,
            LARCH,
            MAHOGANY,
            MANGO,
            MAPLE,
            PALM,
            PEAR,
            PINE,
            RED_OAK,
            REDWOOD,
            SILVER_SPRUCE,
            WHITE_ASH,
            WILLOW

    };

    public static SimpleVanillaBlocks[] beams = new SimpleVanillaBlocks[]{
            OAK,
            ACACIA,
            SPRUCE,
            BIRCH,
            JUNGLE,
            DARK_OAK,
    };

    public record SimpleBlockSet(RegistryObject<Block> leaves, RegistryObject<Block> log, RegistryObject<Block> wood,
                                 RegistryObject<Block> woodStairs, RegistryObject<Block> woodSlab, RegistryObject<Block> woodWall,
                                 RegistryObject<Block> woodFence, RegistryObject<Block> strippedLog, RegistryObject<Block> strippedWood,
                                 RegistryObject<Block> strippedWoodStairs, RegistryObject<Block> strippedWoodSlab,
                                 RegistryObject<Block> strippedWoodWall, RegistryObject<Block> strippedWoodFence,
                                 RegistryObject<Block> planks, RegistryObject<Block> planksSlab, RegistryObject<Block> planksStairs,
                                 RegistryObject<Block> planksFence, RegistryObject<Block> planksGate,
                                 RegistryObject<Block> pressurePlate, RegistryObject<Block> button, RegistryObject<Block> beam,
                                 RegistryObject<Block> door, RegistryObject<Block> trapdoor) {
    }

    public record SimpleVanillaBlocks(RegistryObject<Block> beam){}

    private static SimpleVanillaBlocks registerBeams(String name, float strength){
        RegistryObject<Block> beam = registerBlock(name + "_beam", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(strength)
                .sound(SoundType.WOOD)));

         return new SimpleVanillaBlocks(beam);
    }


    private static SimpleBlockSet registerWoodSet(String name, float strength, boolean hasLeaves) {
        RegistryObject<Block> leaves = null;
        if(hasLeaves) {
            leaves = registerBlock(name + "_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sound(SoundType.GRASS)));
        }
        RegistryObject<Block> log = registerBlock(name + "_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(
                Blocks.OAK_LOG).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> wood = registerBlock(name + "_wood", () -> new RotatedPillarBlock(
                BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> woodStairs = registerBlock(name + "_wood_stairs", () -> new StairBlock(wood.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(wood.get()).strength(strength).sound(SoundType.WOOD)));
        RegistryObject<Block> woodSlab = registerBlock(name + "_wood_slab", () -> new AxialSlabBlock(wood));
        RegistryObject<Block> woodWall = registerBlock(name + "_wood_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(wood.get())
                .strength(strength).sound(SoundType.WOOD)));
        RegistryObject<Block> woodFence = registerBlock(name + "_wood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(wood.get())
                .strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> strippedLog = registerBlock("stripped_" + name + "_log", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> strippedWood = registerBlock("stripped_" + name + "_wood", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> strippedWoodStairs = registerBlock("stripped_" + name + "_wood_stairs", () ->
                new StairBlock(wood.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(wood.get()).strength(strength).sound(SoundType.WOOD)));
        RegistryObject<Block> strippedWoodSlab = registerBlock("stripped_" + name + "_wood_slab", () ->
                new AxialSlabBlock(strippedWood));
        RegistryObject<Block> strippedWoodWall = registerBlock("stripped_" + name + "_wood_wall", () ->
                new WallBlock(BlockBehaviour.Properties.copy(wood.get()).strength(strength).sound(SoundType.WOOD)));
        RegistryObject<Block> strippedWoodFence = registerBlock("stripped_" + name + "_wood_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.copy(wood.get()).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> planks = registerBlock(name + "_planks", () ->
                new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> slab = registerBlock(name + "_slab", () -> new AxialSlabBlock(planks));

        RegistryObject<Block> stairs = registerBlock(name + "_stairs", () -> new StairBlock(planks.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(planks.get()).strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> fence = registerBlock(name + "_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.copy(planks.get())
                .strength(strength).sound(SoundType.WOOD)));

        RegistryObject<Block> gate = registerBlock(name + "_fence_gate", () ->
                new FenceGateBlock(BlockBehaviour.Properties.copy(planks.get())
                .strength(strength).sound(SoundType.WOOD), WoodType.OAK));

        RegistryObject<Block> button = registerBlock(name + "_button", () ->
                new ButtonBlock(BlockBehaviour.Properties.copy(planks.get()).strength(PLATE_BUTTON_STRENGTH)
                .sound(SoundType.WOOD), BlockSetType.OAK, 5, true));

        RegistryObject<Block> pressurePlate = registerBlock(name + "_pressure_plate", () ->
                new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                BlockBehaviour.Properties.copy(planks.get()).strength(PLATE_BUTTON_STRENGTH).sound(SoundType.WOOD), BlockSetType.OAK));

        RegistryObject<Block> beam = registerBlock(name + "_beam", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(strength)
                .sound(SoundType.WOOD)));

        RegistryObject<Block> door = registerBlock(name + "_door", () ->
                new DoorBlock(BlockBehaviour.Properties.copy(planks.get())
                .noOcclusion(), BlockSetType.OAK));

        RegistryObject<Block> trapdoor = registerBlock(name + "_trapdoor", () ->
                new TrapDoorBlock(BlockBehaviour.Properties.copy(planks.get()).noOcclusion(), BlockSetType.OAK));

        return new SimpleBlockSet(leaves, log, wood, woodStairs, woodSlab, woodWall,woodFence,
                strippedLog, strippedWood, strippedWoodStairs, strippedWoodSlab, strippedWoodWall, strippedWoodFence, planks,
                slab, stairs, fence, gate, pressurePlate, button, beam, door, trapdoor);
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
