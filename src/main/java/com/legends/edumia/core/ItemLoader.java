package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.item.EdumiaFoodComponent;
import com.legends.edumia.item.EdumiaMapItem;
import com.legends.edumia.item.WorldTeleporterItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemLoader {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Edumia.MOD_ID);

    public static final RegistryObject<Item> ABOMINABLE_BLADE = ITEMS.register("abominable_blade",
            () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> GENSAI_AXE = ITEMS.register("gensai_axe",
            () -> new AxeItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> GENSAI_HOE = ITEMS.register("gensai_hoe",
            () -> new HoeItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> GENSAI_PICKAXE = ITEMS.register("gensai_pickaxe",
            () -> new PickaxeItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> GENSAI_SHOVEL = ITEMS.register("gensai_shovel",
            () -> new ShovelItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> GENSAI_STEEL = ITEMS.register("gensai_steel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEGENDS_COIN = ITEMS.register("legends_coin",
            () -> new WorldTeleporterItem(new Item.Properties().stacksTo(1)));

//    public static final RegistryObject<Item> ATLAS = ITEMS.register("atlas",
//            () -> new EdumiaMapItem(new Item.Properties().stacksTo(1)));
    //gems
    public static final RegistryObject<Item> GEM_FINE_AMBER = ITEMS.register("gem_fine_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_AMBER = ITEMS.register("gem_flawed_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_AMBER = ITEMS.register("gem_flawless_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_AMBER = ITEMS.register("gem_perfect_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_AMBER = ITEMS.register("gem_rough_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_AMETHYST = ITEMS.register("gem_fine_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_AMETHYST = ITEMS.register("gem_flawed_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_AMETHYST = ITEMS.register("gem_flawless_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_AMETHYST = ITEMS.register("gem_perfect_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_AMETHYST = ITEMS.register("gem_rough_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_JADE = ITEMS.register("gem_fine_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_JADE = ITEMS.register("gem_flawed_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_JADE = ITEMS.register("gem_flawless_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_JADE = ITEMS.register("gem_perfect_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_JADE = ITEMS.register("gem_rough_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_JASPER = ITEMS.register("gem_fine_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_JASPER = ITEMS.register("gem_flawed_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_JASPER = ITEMS.register("gem_flawless_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_JASPER = ITEMS.register("gem_perfect_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_JASPER = ITEMS.register("gem_rough_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_RUBY = ITEMS.register("gem_fine_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_RUBY = ITEMS.register("gem_flawed_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_RUBY = ITEMS.register("gem_flawless_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_RUBY = ITEMS.register("gem_perfect_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_RUBY = ITEMS.register("gem_rough_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_SAPPHIRE = ITEMS.register("gem_fine_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_SAPPHIRE = ITEMS.register("gem_flawed_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_SAPPHIRE = ITEMS.register("gem_flawless_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_SAPPHIRE = ITEMS.register("gem_perfect_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_SAPPHIRE = ITEMS.register("gem_rough_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_TOPAZ = ITEMS.register("gem_fine_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_TOPAZ = ITEMS.register("gem_flawed_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_TOPAZ = ITEMS.register("gem_flawless_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_TOPAZ = ITEMS.register("gem_perfect_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_TOPAZ = ITEMS.register("gem_rough_topaz",
            () -> new Item(new Item.Properties()));


    /**
     * food Items
     */

    public static final RegistryObject<Item> TEA_SAKURA_PETALS = ITEMS.register("tea_sakura_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_MINT_LEAVES = ITEMS.register("tea_mint_leaves",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_LEAF = ITEMS.register("tea_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_LILY_PETALS = ITEMS.register("tea_lily_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_WHITE_JADE_PETALS = ITEMS.register("tea_white_jade_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_HIBISCUS_PETALS = ITEMS.register("tea_hibiscus_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_JASMINE_PETALS = ITEMS.register("tea_jasmine_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_CINNAMON_STICK = ITEMS.register("tea_cinnamon_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_WHITE_DRAGON_PETALS = ITEMS.register("tea_white_dragon_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.BROCCOLI)));
    public static final RegistryObject<Item> PAPRIKA_GREEN = ITEMS.register("paprika_green",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.PAPRIKA)));
    public static final RegistryObject<Item> RAMEN = ITEMS.register("ramen",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RAMEN)));
    public static final RegistryObject<Item> RAMEN_BEEF = ITEMS.register("ramen_beef",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RAMEN_BEEF)));
    public static final RegistryObject<Item> RAMEN_PORK = ITEMS.register("ramen_pork",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RAMEN_PORK)));
    public static final RegistryObject<Item> RAMEN_SHRIMPS = ITEMS.register("ramen_shrimps",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RAMEN_SHRIMPS)));
    public static final RegistryObject<Item> RAMEN_VEGI = ITEMS.register("ramen_vegi",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RAMEN_VEGI)));
    public static final RegistryObject<Item> RED_GRAPES = ITEMS.register("red_grapes",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RED_GRAPES)));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RICE_BALL = ITEMS.register("rice_ball",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.RICE_BALL)));
    public static final RegistryObject<Item> SPINACH = ITEMS.register("spinach",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.TOMATO)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.CHEESE)));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.LETTUCE)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.BANANA)));
    public static final RegistryObject<Item> BANANA_BREAD = ITEMS.register("banana_bread",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.BANANA_BREAD)));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.MANGO)));
    public static final RegistryObject<Item> DATE = ITEMS.register("date",
            () -> new Item(new Item.Properties().food(EdumiaFoodComponent.DATE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
