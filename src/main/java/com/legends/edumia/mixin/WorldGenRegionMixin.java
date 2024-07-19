package com.legends.edumia.mixin;

import net.minecraft.server.level.WorldGenRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldGenRegion.class)
public class WorldGenRegionMixin {

    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0)
    private static int ChunkRegion(int placementRadius) {
        if(placementRadius > 0) placementRadius++;
        else if (placementRadius < 0) placementRadius--;
        return placementRadius;
    }
}
