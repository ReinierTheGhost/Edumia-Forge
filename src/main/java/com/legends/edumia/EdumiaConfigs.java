package com.legends.edumia;

import net.minecraftforge.common.ForgeConfigSpec;
public class EdumiaConfigs {
    public static final ForgeConfigSpec GENERAL_SPEC;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    public static ForgeConfigSpec.ConfigValue<Boolean> REPLACE_TREE_FEATURES_FIX;

    private static void setupConfig(ForgeConfigSpec.Builder builder) {

        builder.push("Dynamic Trees + Edumia Compat Mod Config");

        REPLACE_TREE_FEATURES_FIX = builder
                .comment("If \"true\", implements fixes for failed tree cancellation in edumia biomes. \n" +
                        "Replaces tree features in biomes that tree cancellation has failed. \n" +
                        "Defaults to \"true\".")
                .define("replace_tree_features_fix_entry", true);

        builder.pop();
    }
}
