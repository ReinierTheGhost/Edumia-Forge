package com.legends.edumia.world.chunkgen;

import com.legends.edumia.Edumia;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModChunkGenerators {
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> GENERATORS =
            DeferredRegister.create(Registries.CHUNK_GENERATOR, Edumia.MOD_ID);

    public static void register(IEventBus modEventBus) {
        GENERATORS.register("edumia", () -> EdumiaChunkGenerator.CODEC);

        GENERATORS.register(modEventBus);
    }
}
