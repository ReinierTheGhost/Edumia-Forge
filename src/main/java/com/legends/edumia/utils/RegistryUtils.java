package com.legends.edumia.utils;


import com.legends.edumia.Edumia;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class RegistryUtils {
    public static <V, T extends V> T register(Registry<V> registry, String name, T entry) {
        return Registry.register(registry, new ResourceLocation(Edumia.MOD_ID, name), entry);
    }
}
