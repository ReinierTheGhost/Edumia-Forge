package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.utils.ModTags;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiome;
import com.legends.edumia.worldgen.features.bouders.BoulderFeature;
import com.legends.edumia.worldgen.features.bouders.BouldersFeatureConfig;
import com.legends.edumia.worldgen.features.crystal.CrystalFeature;
import com.legends.edumia.worldgen.features.crystal.CrystalFeatureConfig;
import com.legends.edumia.worldgen.features.reeds.ReedsFeature;
import com.legends.edumia.worldgen.features.reeds.ReedsFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EdumiaFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Edumia.MOD_ID);
    public static final RegistryObject<BoulderFeature> BOULDER = register("boulder", () -> new BoulderFeature(BouldersFeatureConfig.CODEC));
    public static final RegistryObject<CrystalFeature> CRYSTAL = register("crystal", () -> new CrystalFeature(CrystalFeatureConfig.CODEC));
    public static final RegistryObject<ReedsFeature> REEDS = register("reeds", () -> new ReedsFeature(ReedsFeatureConfig.CODEC));



    public static BlockState getBlockStateInContext(BlockState state, LevelAccessor worldAccess, BlockPos pos){
        return Block.updateFromNeighbourShapes(state, worldAccess, pos);
    }

    // Returns the axis that a rotatable block should face based on a start and end position
    public static Direction.Axis getAxisBetween(BlockPos start, BlockPos end) {
        Direction.Axis axis = Direction.Axis.Y;
        int xOffset = Math.abs(end.getX() - start.getX());
        int zOffset = Math.abs(end.getZ() - start.getZ());
        int maxOffset = Math.max(xOffset, zOffset);

        if (maxOffset > 0) {
            if (xOffset == maxOffset) {
                axis = Direction.Axis.X;
            } else {
                axis = Direction.Axis.Z;
            }
        }

        return axis;
    }

    public static boolean isSurfaceBlock(LevelAccessor world, BlockPos pos){
        return isSurfaceBlock(world, pos, 0);
    }

    private static boolean isSurfaceBlock(LevelAccessor world, BlockPos pos, int recursion) {
        if (world.getBlockState(pos.above()).liquid()){
            return false;
        } else {
            BlockState state = world.getBlockState(pos);
            EdumiaBiome edumiaBiome = new EdumiaBiome();
            Block block = state.getBlock();

            Block topMaterial = edumiaBiome.surfaceBlock;
            Block underMaterial = edumiaBiome.underSurfaceBlock;

            if (!block.defaultBlockState().is(BlockTags.SAND) && !block.defaultBlockState().is(BlockTags.VALID_SPAWN)
                    && !block.defaultBlockState().is(ModTags.Blocks.GRAVEL) && !block.defaultBlockState().is(ModTags.Blocks.DIRT)){
                if (block.defaultBlockState().is(ModTags.Blocks.VOLCANIC_PLANT_SURFACE)) {
                    return true;
                } else {
                    return block == Blocks.STONE && recursion <= 1 && isSurfaceBlock(world, pos.below(), recursion + 1);
                }
            } else {
                return true;
            }
        }
    }
    public static void setGrassToDirt(LevelSimulatedReader world, BlockPos groundPos) {
        if (world.isStateAtPosition(groundPos, (state) -> {
            return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MYCELIUM);
        })){
            TreeFeature.setBlockKnownShape((LevelWriter) world, groundPos, Blocks.DIRT.defaultBlockState());
        }
    }

    public static void setGrassToDirtBelow(LevelAccessor world, BlockPos pos){
        BlockPos belowPos = pos.below();
        BlockState belowState = world.getBlockState(belowPos);

        if (world.getBlockState(pos).is(Blocks.GRASS_BLOCK)){
            if (belowState.is(Blocks.DIRT) || belowState.is(Blocks.GRASS_BLOCK)){
                world.setBlock(belowPos, Blocks.DIRT.defaultBlockState(), 3);
            }
        }
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }

    private static <T extends Feature<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return FEATURES.register(name, sup);
    }
}
