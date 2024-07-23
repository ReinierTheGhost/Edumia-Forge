package com.legends.edumia.worldgen.dimension;

import com.legends.edumia.Edumia;
import com.legends.edumia.EdumiaLog;
import com.legends.edumia.utils.EdumiaUtil;
import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.worldgen.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.worldgen.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.worldgen.map.EdumiaMapUtils;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldOptions;
import org.joml.Vector2i;
import org.joml.Vector3i;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class ModDimensions {

    public static final Vector3i ME_SPAWN_LOCATION = new Vector3i(1555, 90, 1348);
    public static final String PATH = "edumia";

    public static final ResourceKey<LevelStem> DIMENSION_KEY =
            ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Edumia.MOD_ID, PATH));

    public static ResourceKey<Level> WORLD_KEY =
            ResourceKey.create(Registries.DIMENSION, DIMENSION_KEY.location());

    public static void register() {
        //replaceDimensionCodecToForceStability();
        //Registry.register(BuiltInRegistries.CHUNK_GENERATOR, new ResourceLocation(Edumia.MOD_ID, PATH), EdumiaChunkGenerator.CODEC);
        WORLD_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Edumia.MOD_ID, PATH));

        LoggerUtil.getInstance().logDebugMsg("Registering ModDimensions for " + Edumia.MOD_ID);
    }

    public static void replaceDimensionCodecToForceStability(){
        try{
            final Codec<WorldOptions> codec = WorldOptions.CODEC.codec();
            Codec<WorldOptions> stableCodec = new Codec<WorldOptions>() {
                @Override
                public <T> DataResult<T> encode(WorldOptions input, DynamicOps<T> ops, T prefix) {
                    return codec.encode(input, ops, prefix);
                }
                @Override
                public <T> DataResult<Pair<WorldOptions, T>> decode(DynamicOps<T> ops, T input) {
                    DataResult<Pair<WorldOptions, T>> result = codec.decode(ops, input);
                    return DataResult.success(result.result().orElseThrow(() -> {
                        return new IllegalArgumentException("Failed to change lifecycle to stable");
                    }), Lifecycle.stable());
                }
            };

            Field f_codec = (Field) Stream.of(WorldOptions.class.getDeclaredFields()).filter((field) -> {
                return (field.getModifiers() & 8) != 0;
            }).filter((field) -> {
                return field.getType() == Codec.class;
            }).findFirst().orElseThrow(() -> {
                return new IllegalStateException("Failed to find codec in WorldOption");
            });
            EdumiaUtil.unlockFinalField(f_codec);
            f_codec.set((Object) null, stableCodec);
        }catch (Exception var3){
            var3.printStackTrace();
            EdumiaLog.error("Failed to set dimension generator settings codec to stable");
        }
    }
    public static void teleportPlayerToME(Player player) {
        Vector2i coordinates = EdumiaMapUtils.getInstance().getWorldCoordinateFromInitialMap(ME_SPAWN_LOCATION.x, ME_SPAWN_LOCATION.z);
        int height = (int) (1 + EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(coordinates.x, coordinates.y));
        Vector3i targetCoords = new Vector3i(coordinates.x, height, coordinates.y);
        teleportPlayerToMe(player, targetCoords);
    }

    public static void teleportPlayerToMe(Player player, Vector3i coordinates){
        if(!player.level().isClientSide()) {
            ResourceKey<Level> registryKey = WORLD_KEY;
            ServerLevel serverWorld = (ServerLevel) player.level();
            if (serverWorld != null) {
                serverWorld = serverWorld.getServer().getLevel(registryKey);

                player.stopSleeping();

                ((ServerPlayer) player).teleportTo(serverWorld, coordinates.x , coordinates.y, coordinates.z, 0, 0);
                player.moveTo(coordinates.x, coordinates.y, coordinates.z);
            }
        }
    }

    public static boolean isInEdumia(Level world){
        return world.dimension().location().equals(WORLD_KEY.location());
    }
}
