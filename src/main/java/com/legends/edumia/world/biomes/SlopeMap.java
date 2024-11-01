package com.legends.edumia.world.biomes;

import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SlopeMap {
    public ArrayList<SlopeData> slopeDatas;

    public SlopeMap(SlopeMap slopeMap) {
        this.slopeDatas = new ArrayList<>(slopeMap.slopeDatas);
    }

    public SlopeMap() {
        this.slopeDatas = new ArrayList<>();
    }

    public SlopeMap addSlopeData(float angle, Supplier<Block> block) {
        return addSlopeData(angle, block.get());
    }
    public SlopeMap addSlopeData(float angle, Block block) {
        if(!slopeDatas.isEmpty()) {
            int last = slopeDatas.size() - 1;
            float newAngle = slopeDatas.get(last).angle;
            if (newAngle >= angle) {
                throw new ArithmeticException("Cannot add slope angle smaller than previous slope data");
            } else if(newAngle < 0 || newAngle > 90) {
                throw new ArithmeticException("The new slope cannot exceed slope angle boundaries (0 to 90 degrees)");
            }
        }
        slopeDatas.add(new SlopeData(angle, block));
        return this;
    }

    public SlopeMap addLayeredSlopeData(float angle, ArrayList<Layer> layers) {
        if(!slopeDatas.isEmpty()) {
            int last = slopeDatas.size() - 1;
            float newAngle = slopeDatas.get(last).angle;
            if (newAngle >= angle) {
                throw new ArithmeticException("Cannot add slope angle smaller than previous slope data");
            }
        }
        slopeDatas.add(new LayeredSlopeData(angle, layers));
        return this;
    }

    public Block getBlockAtAngle(float angle) {
        for(SlopeData slopeData : slopeDatas) {
            if(angle <= slopeData.angle) {
                return slopeData.block;
            }
        }
        int last = slopeDatas.size() - 1;
        throw new RuntimeException("The angle exceeds the maximal allowed slope of: " + slopeDatas.get(last).angle + " degrees");
    }

    public class SlopeData {
        public float angle; // Maximal angle to apply the block
        public Block block;

        public SlopeData(float angle, Block block) {
            this.angle = angle;
            this.block = block;
        }
    }

    public class LayeredSlopeData extends SlopeData {
        private final ArrayList<Layer> layers;

        public LayeredSlopeData(float angle, ArrayList<Layer> layers) {
            super(angle, null);  // No single block, layers will be used instead
            this.layers = layers;
        }

        public Block getBlockForHeight(int height) {
            for (Layer layer : layers) {
                if (height >= layer.minHeight && height <= layer.maxHeight) {
                    return layer.block;
                }
            }
            return null;  // No block found in the layers for the given height
        }
    }

    public class Layer {
        public final int minHeight;
        public final int maxHeight;
        public final Block block;

        public Layer(int minHeight, int maxHeight, Block block) {
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.block = block;
        }
    }
}
