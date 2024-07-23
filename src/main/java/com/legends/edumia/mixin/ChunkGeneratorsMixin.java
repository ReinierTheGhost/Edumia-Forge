package com.legends.edumia.mixin;

import com.legends.edumia.worldgen.chunkgen.EdumiaChunkGenerator;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGenerators;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkGenerators.class)
public class ChunkGeneratorsMixin {

//    @Inject(method = "bootstrap", at = @At("HEAD"), cancellable = true)
//    private static void onBootstrap(Registry<Codec<? extends ChunkGenerator>> registry, CallbackInfoReturnable<Codec<? extends ChunkGenerator>> cir) {
//        // Register custom chunk generator
//        Registry.register(registry, "edumia", EdumiaChunkGenerator.CODEC);
//        System.out.println("Edumia chunk gen registered!");
//    }
}
