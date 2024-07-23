package com.legends.edumia.datagen.custom.models;



import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrowSlitModel {
    public record ArrowSlit(Block texture, Block arrowSlit) {}

    public static List<ArrowSlit> blocks = new ArrayList<>() {
        {
        }
    };
}
