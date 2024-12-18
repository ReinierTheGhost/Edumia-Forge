package com.legends.edumia.mixin;


import com.legends.edumia.world.RandomTickScheduler;
import com.legends.edumia.world.dimension.ModDimensions;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin extends Level {
    protected ServerLevelMixin(WritableLevelData $$0, ResourceKey<Level> $$1, RegistryAccess $$2, Holder<DimensionType> $$3, Supplier<ProfilerFiller> $$4, boolean $$5, boolean $$6, long $$7, int $$8) {
        super($$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7, $$8);
    }

    @Inject(method = "tickChunk", at = @At("HEAD"))
    private void tickScheduledRandomTicks(LevelChunk chunk, int randomTickSpeed, CallbackInfo ci) {
        ((RandomTickScheduler) chunk).getScheduledRandomTicks().removeIf(scheduledPos -> {
            chunk.getBlockState(scheduledPos).randomTick((ServerLevel) (Object) this, scheduledPos, this.random);
            return true;
        });
    }
    @Inject(method = "tickChunk", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"), cancellable = true)
    private void tickChunk(LevelChunk chunk, int randomTickSpeed, CallbackInfo ci) {
        if(ModDimensions.isInEdumia(chunk.getLevel())) {
            ci.cancel();
        }
    }


}
