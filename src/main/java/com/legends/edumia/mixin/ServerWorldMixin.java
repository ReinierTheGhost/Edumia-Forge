package com.legends.edumia.mixin;


import com.legends.edumia.world.dimension.ModDimensions;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ServerWorldMixin {
    @Inject(method = "tickChunk", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"), cancellable = true)
    private void tickChunk(LevelChunk chunk, int randomTickSpeed, CallbackInfo ci) {
        if(ModDimensions.isInEdumia(chunk.getLevel())) {
            ci.cancel();
        }
    }
}
