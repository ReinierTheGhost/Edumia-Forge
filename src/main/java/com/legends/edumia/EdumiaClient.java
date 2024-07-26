package com.legends.edumia;

import com.legends.edumia.blocks.blocksets.GlassSets;
import com.legends.edumia.blocks.blocksets.ModNatureBlocks;
import com.legends.edumia.blocks.blocksets.PaperwallSets;
import com.legends.edumia.blocks.blocksets.WoodBlockSets;
import com.legends.edumia.client.EdumiaKeyHandler;
import com.legends.edumia.client.gui.EdumiaMasterMenuScreen;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Edumia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EdumiaClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.REEDS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.PAPYRUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.DRIED_REEDS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FLAX_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.BLACK_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.ARID_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.DRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.TALL_DRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.TALL_DEAD_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.BEACH_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.TALL_BEACH_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FROSTED_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.TALL_FROSTED_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.PARASOL_MUSHROOM_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.PARASOL_MUSHROOM_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.PARASOL_MUSHROOM_TALL.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.ASPHODEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.BLUE_DELPHINIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.BLUEBELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CALLA_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CELSEMIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CHRYS_BLUE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CHRYS_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CHRYS_PINK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CHRYS_WHITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CHRYS_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.CROCUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.DELPHINIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FLAX_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FOXGLOVE_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FOXGLOVE_PINK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FOXGLOVE_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FOXGLOVE_WHITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.GERBERA_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.GENSAI_ORCHID.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.GERBERA_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.HEATHER_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.LAVENDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.PINK_ANEMONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.SIMBLELMYNE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.TUBEROSE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.FLAME_OF_THE_SOUTH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.YELLOW_IRIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.HIBISCUS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.APPLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.BANANA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.TEST_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.ASPEN_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.BEECH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.BLACKTHORN_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.BLACK_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.CEDAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.CYPRESS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.DRAGON_BLOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.FIR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.GHOST_GUM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.GREEN_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.HOLLY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.LARCH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.PINE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.RED_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.REDWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.SILVER_SPRUCE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.WHITE_ASH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.WILLOW_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.PALM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.MAHOGANY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.MAPLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.MANGO_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.CHERRY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModNatureBlocks.PEAR_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_ASPHODEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_BLUE_DELPHINIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_BLUEBELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CALLA_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CELSEMIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CHRYS_BLUE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CHRYS_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CHRYS_PINK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CHRYS_WHITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CHRYS_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_CROCUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_DELPHINIUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_FLAX_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_FOXGLOVE_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_FOXGLOVE_PINK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_FOXGLOVE_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_FOXGLOVE_WHITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_GERBERA_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_GERBERA_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_HEATHER_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_LAVENDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_PINK_ANEMONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_SIMBLELMYNE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockLoader.POTTED_TUBEROSE.get(), RenderType.cutout());

        for (GlassSets.GlassSet set : GlassSets.glassSets) {
            ItemBlockRenderTypes.setRenderLayer(set.block().get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(set.pane().get(), RenderType.translucent());
        }
        for (PaperwallSets.PaperwallSet set : PaperwallSets.paperwallSets){
            ItemBlockRenderTypes.setRenderLayer(set.pane().get(), RenderType.translucent());
        }
        for (WoodBlockSets.SimpleBlockSet set : WoodBlockSets.sets){
            ItemBlockRenderTypes.setRenderLayer(set.door().get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(set.trapdoor().get(), RenderType.cutout());
        }
        event.enqueueWork(() -> {

        });

    }

    @Mod.EventBusSubscriber(modid = Edumia.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            int key = event.getKey();
            int scancode = event.getScanCode();
            int action = event.getAction();
            Minecraft mc = Minecraft.getInstance();
            if(EdumiaKeyHandler.MAP_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Open Map!!"));
            }
            if (EdumiaKeyHandler.MENU_KEY.matches(key, scancode) && mc.screen == null && mc.player != null){
                Screen menuScreen = EdumiaMasterMenuScreen.openMenu(mc.player);
                if (menuScreen != null){
                    mc.setScreen(menuScreen);
                }
            }
        }
    }
    @Mod.EventBusSubscriber(modid = Edumia.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(EdumiaKeyHandler.MAP_KEY);
            event.register(EdumiaKeyHandler.MENU_KEY);
        }
    }


}
