package com.legends.edumia.client;

import com.legends.edumia.Edumia;
//import com.legends.edumia.client.gui.map.EdumiaDimMasterMenuScreen;
import com.legends.edumia.client.gui.EdumiaMasterMenuScreen;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.lwjgl.glfw.GLFW;

public class EdumiaKeyHandler {
    public static final String KEY_CATEGORY_EDUMIA ="key.categories." + Edumia.MOD_ID;

    public static final String KEY_MAP = "key.edumia.key_map";
    public static final String KEY_BIND_MENU = "key.edumia.menu";

    public static final KeyMapping MENU_KEY = new KeyMapping(KEY_BIND_MENU, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, KEY_CATEGORY_EDUMIA);
    public static final KeyMapping MAP_KEY = new KeyMapping(KEY_MAP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_L, KEY_CATEGORY_EDUMIA);

    public EdumiaKeyHandler(){
    }
}
