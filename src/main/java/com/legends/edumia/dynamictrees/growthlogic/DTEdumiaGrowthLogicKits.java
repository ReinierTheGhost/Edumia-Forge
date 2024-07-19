package com.legends.edumia.dynamictrees.growthlogic;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import com.legends.edumia.Edumia;

public class DTEdumiaGrowthLogicKits {

    public static final GrowthLogicKit POPLAR = new PoplarLogic(Edumia.location("poplar"));

    public static void register(final Registry<GrowthLogicKit> registry) {
        registry.registerAll(POPLAR);
    }
}
