package com.legends.edumia.worldgen.biome.surface;

import com.legends.edumia.utils.noises.SimplexNoise;
import com.legends.edumia.worldgen.biome.caves.ModCaveBiomes;
import com.legends.edumia.worldgen.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.worldgen.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.worldgen.map.EdumiaMapRuntime;
import com.mojang.serialization.Codec;
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
            Codec.list(Biome.CODEC).fieldOf("biomes").forGetter((biomeSource) ->
                    biomeSource.biomes)).apply(instance, ModBiomeSource::new));
    private final List<Holder<Biome>> biomes;
    private final int CAVE_NOISE = 96;
    private final int CAVE_OFFSET = 7220;
    private EdumiaMapRuntime middleEarthMapRuntime;
    public ModBiomeSource(List<Holder<Biome>> biomes) {
        this.biomes = biomes;
        middleEarthMapRuntime = EdumiaMapRuntime.getInstance();
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

        EdumiaBiome meBiome = middleEarthMapRuntime.getBiome(i, k);

        if (meBiome == null) {
            return biomes.get(0);
        }

        ResourceKey<Biome> biome = meBiome.biome;
        ResourceKey<Biome> processedBiome;

        if(!EdumiaBiomesData.waterBiomes.contains(biome)) {
            float height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(i, k);
            if(j < (height - 16)) {
                processedBiome = getCaveBiome(i, k, meBiome);
            }
            else if(height <= meBiome.waterHeight + 1.25f) {
                if(EdumiaBiomesData.coastalBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.oceanCoast.biome;
                } else if(EdumiaBiomesData.wastePondBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.wastePond.biome;
                } else if(EdumiaBiomesData.swampBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.swamp.biome;
                } else if(EdumiaBiomesData.oasisBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.oasis.biome;
                } else if(EdumiaBiomesData.frozenBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.frozenPond.biome;
                } else if(EdumiaBiomesData.riverBiomes.contains(biome)){
                    processedBiome = EdumiaBiomesData.greatRiver.biome;
                }else {
                    processedBiome = EdumiaBiomesData.pond.biome;
                }
            } else processedBiome = biome;
        } else processedBiome = biome;

        return biomes.stream().filter(
                        b -> b.unwrapKey().get().toString().equalsIgnoreCase(processedBiome.toString()))
                .findFirst().get();
    }
}
