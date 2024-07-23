package com.legends.edumia.datagen.custom.models;

import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleStairModel {
    public record Stair(Block block, Block stairs) {}
    public static List<Stair> blocks = new ArrayList<>() {
        {

        }
    };
}
