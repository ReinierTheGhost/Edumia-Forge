package com.legends.edumia.item;


import com.legends.edumia.client.gui.map.EdumiaMapScreen;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EdumiaMapItem extends Item {
    public EdumiaMapItem(Item.Properties settings) {
        super(settings);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        Minecraft mc = Minecraft.getInstance();
        if(world.isClientSide) {
            if (mc.screen == null) {
                mc.setScreen(new EdumiaMapScreen());
            }
        }
        return super.use(world, user, hand);
    }
}
