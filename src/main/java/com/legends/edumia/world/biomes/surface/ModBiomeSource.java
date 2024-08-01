package com.legends.edumia.world.biomes.surface;


import com.legends.edumia.utils.noises.SimplexNoise;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.caves.CaveType;
import com.legends.edumia.world.biomes.caves.ModCaveBiomes;
import com.legends.edumia.world.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.world.features.underground.CavesPlacedFeatures;
import com.legends.edumia.world.map.EdumiaMapRuntime;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.phys.Vec2;

import java.util.List;
import java.util.stream.Stream;

public class ModBiomeSource extends BiomeSource {

    public static final Codec<ModBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.list(Biome.CODEC).fieldOf("biomes").forGetter((biomeSource) -> biomeSource.biomes)).apply(instance, ModBiomeSource::new));

    private final List<Holder<Biome>> biomes;
    private final int CAVE_NOISE = 96;
    private final int CAVE_OFFSET = 7220;
    private EdumiaMapRuntime edumiaMapRuntime;
    public ModBiomeSource(List<Holder<Biome>> biomes) {
        this.biomes = biomes;
        edumiaMapRuntime = EdumiaMapRuntime.getInstance();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return biomes.stream();
    }

    private ResourceKey<Biome> getCaveBiome(int x, int z, EdumiaBiome surfaceBiome) {
        float temperature = (float) SimplexNoise.noise((double) x / CAVE_NOISE,  (double) z / CAVE_NOISE);
        float humidity = (float) SimplexNoise.noise((double) (x + CAVE_OFFSET) / CAVE_NOISE, (double)(z + CAVE_OFFSET) / CAVE_NOISE);
        return ModCaveBiomes.getBiome(new Vec2(temperature, humidity), surfaceBiome);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler noise) {
        int i = QuartPos.toBlock(x);
        int j = QuartPos.toBlock(y);
        int k = QuartPos.toBlock(z);

        EdumiaBiome edumiaBiome = edumiaMapRuntime.getBiome(i, k);
        
        if (edumiaBiome == null) {
            return biomes.get(0);
        }

        ResourceKey<Biome> biome = edumiaBiome.biome;
        ResourceKey<Biome> processedBiome;

        if(!EdumiaBiomesData.waterBiomes.contains(biome)) {
            float height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(i, k);
            if(j <= CavesPlacedFeatures.MAX_MITHRIL_HEIGHT && edumiaBiome.caveType == CaveType.MISTIES) {
                processedBiome = EdumiaBiomeKeys.MITHRIL_CAVE;
            } else if(biome == EdumiaBiomesData.deadMarshes.biome || biome == EdumiaBiomesData.deadMarshesWater.biome) {
                height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaChunkGenerator.getMarshesHeight(i, k, height);
                if(j < (height - 16)) processedBiome = getCaveBiome(i, k, edumiaBiome);
                else if(height < EdumiaChunkGenerator.WATER_HEIGHT) processedBiome = EdumiaBiomesData.deadMarshesWater.biome;
                else processedBiome = EdumiaBiomesData.deadMarshes.biome;
            } else if(j < (height - 16)) {
                processedBiome = getCaveBiome(i, k, edumiaBiome);
            } else if(height <= edumiaBiome.waterHeight + 1.25f) {
                if(EdumiaBiomesData.coastalBiomes.contains(biome)){
                    processedBiome = EdumiaBiomesData.oceanCoast.biome;
                } else if(EdumiaBiomesData.wastePondBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.wastePond.biome;
                } else if(EdumiaBiomesData.mirkwoodSwampBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.mirkwoodSwamp.biome;
                } else if(EdumiaBiomesData.oasisBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.oasis.biome;
                } else if(EdumiaBiomesData.frozenBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.frozenPond.biome;
                } else if(EdumiaBiomesData.anduinWaterBiomes.contains(biome)){
                    processedBiome = EdumiaBiomesData.greatRiver.biome;
                }
                else {
                    processedBiome = EdumiaBiomesData.pond.biome;
                }
            } else processedBiome = biome;
        } else processedBiome = biome;

        return biomes.stream().filter(
                        b -> b.unwrapKey().get().toString().equalsIgnoreCase(processedBiome.toString()))
                .findFirst().get();
    }
}
