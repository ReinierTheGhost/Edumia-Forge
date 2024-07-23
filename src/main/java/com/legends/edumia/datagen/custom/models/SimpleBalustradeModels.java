package com.legends.edumia.datagen.custom.models;

import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleBalustradeModels {
    public record Balustrade(Block texture, Block balustrade) {}

    public static List<Balustrade> blocks = new ArrayList<>() {
        {
        }
    };
}
