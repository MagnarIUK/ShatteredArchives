package tally.shattered_archive.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ShatteredOverworldRegion extends Region {
    public ShatteredOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
                    RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, ShatteredBiomes.GRAVITY_SPRINGS);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.JUNGLE, ShatteredBiomes.THE_ZONE);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DEEP_COLD_OCEAN, ShatteredBiomes.ABYSSAL_OCEAN);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DESERT, ShatteredBiomes.INK_DESERT);
            //modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.OLD_GROWTH_PINE_TAIGA, ShatteredBiomes.GIANTS_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.SNOWY_PLAINS, ShatteredBiomes.BLOOD_STAINED_TUNDRA);
        });
    }
}
