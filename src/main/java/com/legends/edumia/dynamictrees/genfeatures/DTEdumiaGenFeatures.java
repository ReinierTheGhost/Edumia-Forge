package com.legends.edumia.dynamictrees.genfeatures;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import com.legends.edumia.Edumia;

public class DTEdumiaGenFeatures {
    public static final GenFeature RANDOM_STRIPPED_BRANCHES = new RandomStrippedBranches(Edumia.location("random_stripped_branches"));

    public static void register(final Registry<GenFeature> registry) {
        registry.registerAll(RANDOM_STRIPPED_BRANCHES);
    }
}
