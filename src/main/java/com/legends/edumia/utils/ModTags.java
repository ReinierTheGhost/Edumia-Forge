package com.legends.edumia.utils;

import com.legends.edumia.Edumia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {

    public static class Blocks{
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Edumia.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

        public static final TagKey<Block> AIRS = tag("airs");
        public static final TagKey<Block> ALT_STONES = tag("alt_stones");
        public static final TagKey<Block> SOIL_AND_GRAVEL = tag("soil_and_gravel");

        public static final TagKey<Block> STONE_DIORITE = tag("stone_diorite");
        public static final TagKey<Block> STONE_ONLY = tag("stone_only");
        public static final TagKey<Block> CALCITE = tag("calcite");
        public static final TagKey<Block> SOIL_STONE = tag("soil_stone");
        public static final TagKey<Block> BANISTERS = tag("banisters");
        public static final TagKey<Block> PILLARS = tag("pillars");
        public static final TagKey<Block> GRAVEL = tag("gravel");
        public static final TagKey<Block> DIRT = tag("dirt");

        public static final TagKey<Block> TREE_BRANCH_REPLACEABLE = tag("tree_branch_replaceable");
        public static final TagKey<Block> VOLCANIC_PLANT_SURFACE = tag("volcanic_plant_surface");
        public static final TagKey<Block> GROUND_MAHOGANY_SAPLING = tag("mahogany_sapling");

        public static final TagKey<Block> REEDS_PLACEABLE_ON = tag("reeds_placeable_on");

    }

    public static class Items{
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Edumia.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }
}
