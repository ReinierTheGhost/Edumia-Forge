package com.legends.edumia;

import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import com.legends.edumia.blocks.blocksets.*;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.core.ItemLoader;
import com.legends.edumia.worldgen.biome.EdumiaBiomeKeys;
import com.legends.edumia.worldgen.biome.surface.EdumiaBiomesData;
import com.legends.edumia.worldgen.chunkgen.ModChunkGenerators;
import com.legends.edumia.worldgen.dimension.ModDimensions;
import com.legends.edumia.worldgen.features.EdumiaFeatures;
import com.legends.edumia.worldgen.gen.ModWorldGeneration;
import com.legends.edumia.worldgen.map.EdumiaMapGeneration;
import com.legends.edumia.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.legends.edumia.worldgen.trees.EdumiaTreeDecoratorTypes;
import com.legends.edumia.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;

import java.io.IOException;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Edumia.MOD_ID)
public class Edumia
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "edumia";
    // Directly reference a slf4j logger

    public static final String MOD_VERSION = "1.4.0-1.20.1";
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "edumia" namespace

    public static final boolean IS_DEBUG = true;

    public Edumia()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        BuildingSets.register(modEventBus);
        ClayTilingSets.register(modEventBus);
        GlassSets.register(modEventBus);
        NotBrickBuildingSets.register(modEventBus);
        PaperwallSets.register(modEventBus);
        StoneSets.register(modEventBus);
        WoodBlockSets.register(modEventBus);
        ModNatureBlocks.register(modEventBus);
        BlockLoader.register(modEventBus);
        ItemLoader.register(modEventBus);
        CreativeTabLoader.register(modEventBus);

        EdumiaTrunkPlacerTypes.register(modEventBus);
        EdumiaFoliagePlacerTypes.register(modEventBus);
        EdumiaTreeDecoratorTypes.register(modEventBus);
        EdumiaFeatures.register(modEventBus);

        modEventBus.addListener(EdumiaClient::onClientSetup);
        ModChunkGenerators.register(modEventBus);

        ModDimensions.register();
        EdumiaBiomeKeys.registerModBiomes();
//        EdumiaBiomesData edumiaBiomesData = new EdumiaBiomesData();
//        edumiaBiomesData.loadBiomes();
        ModWorldGeneration.generateModWorldGen();

        try {
            new EdumiaMapGeneration();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        EdumiaBiomesData edumiaBiomesData = new EdumiaBiomesData();
        edumiaBiomesData.loadBiomes();

    }


    public static ResourceLocation location(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
