package com.legends.edumia.datagen.custom.models;

import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleWallModel {
    public record Wall(Block block, Block wall) {}
    public static List<Wall> blocks = new ArrayList<>() {
        {

        }
    };
}
