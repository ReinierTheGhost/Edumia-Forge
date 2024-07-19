package com.legends.edumia.dynamictrees.registry;

import com.ferreusveritas.dynamictrees.api.cell.CellKit;
import com.ferreusveritas.dynamictrees.api.registry.RegistryEvent;
import com.ferreusveritas.dynamictrees.api.registry.TypeRegistryEvent;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import com.legends.edumia.Edumia;
import com.legends.edumia.dynamictrees.cellkits.DTEdumiaCellKits;
import com.legends.edumia.dynamictrees.genfeatures.DTEdumiaGenFeatures;
import com.legends.edumia.dynamictrees.growthlogic.DTEdumiaGrowthLogicKits;
import com.legends.edumia.dynamictrees.tree.PoplarSpecies;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DTEdumiaRegistries {

    public static void setup() {

    }

    @SubscribeEvent
    public static void registerSpeciesTypes (final TypeRegistryEvent<Species> event) {
        event.registerType(Edumia.location("poplar"), PoplarSpecies.TYPE);
    }

    @SubscribeEvent
    public static void onCellKitRegistry(final RegistryEvent<CellKit> event) {
        DTEdumiaCellKits.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onGrowthLogicKitRegistry(final RegistryEvent<GrowthLogicKit> event) {
        DTEdumiaGrowthLogicKits.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onGenFeatureRegistry(final RegistryEvent<GenFeature> event) {
        DTEdumiaGenFeatures.register(event.getRegistry());
    }

}
