package com.legends.edumia.worldgen.biome;

import com.legends.edumia.Edumia;
import com.legends.edumia.utils.LoggerUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class EdumiaBiomeKeys extends Biomes {
        // region SURFACE
        public static final ResourceKey<Biome> EDUMIA_VALES = EdumiaBiomeKeys.register("edumia_vales");
        public static final ResourceKey<Biome> GENSAI_BEACH = EdumiaBiomeKeys.register("gensai_beach");
        public static final ResourceKey<Biome> EDUMIA_FOOTHILLS = EdumiaBiomeKeys.register("edumia_foothills");
        public static final ResourceKey<Biome> DARK_ELF_FOREST = EdumiaBiomeKeys.register("dark_elf_forest");
        public static final ResourceKey<Biome> EDUMIA_TUNDRA = EdumiaBiomeKeys.register("edumia_tundra");
        public static final ResourceKey<Biome> FROZEN_OCEAN = EdumiaBiomeKeys.register("frozen_ocean");
        public static final ResourceKey<Biome> FROZEN_POND = EdumiaBiomeKeys.register("frozen_pond");
        public static final ResourceKey<Biome> ORC_DESERT = EdumiaBiomeKeys.register("orc_desert");


        public static final ResourceKey<Biome> OGRE_FOREST = EdumiaBiomeKeys.register("ogre_forest");
        public static final ResourceKey<Biome> AVELION_PLAINS = EdumiaBiomeKeys.register("avelion_plains");

        public static final ResourceKey<Biome> GENSAI_SAKURA_GROVE = EdumiaBiomeKeys.register("gensai_sakura_grove");

        public static final ResourceKey<Biome> FAIRY_SWAMP = EdumiaBiomeKeys.register("fairy_swamp");

        public static final ResourceKey<Biome> AVELION_MOUNTAINS = EdumiaBiomeKeys.register("avelion_mountains");
        public static final ResourceKey<Biome> EDUMIA_MOUNTAINS = EdumiaBiomeKeys.register("edumia_mountains");

        public static final ResourceKey<Biome> GENSAI_VOLCANO = EdumiaBiomeKeys.register("gensai_volcano");

        public static final ResourceKey<Biome> OCEAN = EdumiaBiomeKeys.register("edumia_ocean");
        public static final ResourceKey<Biome> OCEAN_COAST = EdumiaBiomeKeys.register("ocean_coast");

        public static final ResourceKey<Biome> OASIS = EdumiaBiomeKeys.register("oasis");
        public static final ResourceKey<Biome> POND = EdumiaBiomeKeys.register("pond");

        public static final ResourceKey<Biome> GENSAI_REEF = EdumiaBiomeKeys.register("gensai_reef");
        public static final ResourceKey<Biome> EDUMIA_RIVER = EdumiaBiomeKeys.register("edumia_river");


        public static final ResourceKey<Biome> TAIGA_FOREST = EdumiaBiomeKeys.register("taiga_forest");
        public static final ResourceKey<Biome> MARSHES = EdumiaBiomeKeys.register("marches");


        public static final ResourceKey<Biome> GENSAI_JUNGLE = EdumiaBiomeKeys.register("gensai_jungle");

        public static final ResourceKey<Biome> WASTE_POND = EdumiaBiomeKeys.register("waste_pond");

        // endregion

        // region CAVES
        public static final ResourceKey<Biome> BASIC_CAVE = EdumiaBiomeKeys.register("basic_cave");
        public static final ResourceKey<Biome> LUSH_CAVE = EdumiaBiomeKeys.register("lush_cave");
        public static final ResourceKey<Biome> DRIPSTONE_CAVE = EdumiaBiomeKeys.register("dripstone_cave");
        public static final ResourceKey<Biome> MUD_CAVE = EdumiaBiomeKeys.register("mud_cave");
        public static final ResourceKey<Biome> FUNGUS_CAVE = EdumiaBiomeKeys.register("fungus_cave");
        public static final ResourceKey<Biome> BASALT_CAVE = EdumiaBiomeKeys.register("basalt_cave");
        public static final ResourceKey<Biome> MAGMA_CAVE = EdumiaBiomeKeys.register("magma_cave");
        public static final ResourceKey<Biome> MITHRIL_CAVE = EdumiaBiomeKeys.register("mithril_cave");
        public static final ResourceKey<Biome> DRY_CAVE = EdumiaBiomeKeys.register("dry_cave");
        public static final ResourceKey<Biome> ICE_CAVE = EdumiaBiomeKeys.register("ice_cave");

        // endregion

        public static ResourceKey<Biome> register(String name) {
            return ResourceKey.create(Registries.BIOME, new ResourceLocation(Edumia.MOD_ID, name));
        }

        public static void registerModBiomes() {
            LoggerUtil.getInstance().logDebugMsg("Registering ModBiomes for " + Edumia.MOD_ID);
        }
}
