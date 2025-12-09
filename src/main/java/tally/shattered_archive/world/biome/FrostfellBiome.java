package tally.shattered_archive.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import tally.shattered_archive.world.ShatteredFeatures;
import tally.shattered_archive.world.ShatteredPlacedFeatures;

public class FrostfellBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(-0.45F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F);

    public static Biome create(Registerable<Biome> registerable) {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings(registerable))
                .spawnSettings(createSpawnSettings())
                .precipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .skyColor(0xc6d0ff)
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(0xa6b5ff)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.SNOWFLAKE, 0.01F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }

    private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);

        builder.feature(GenerationStep.Feature.LAKES, ShatteredPlacedFeatures.FROZEN_LAVA);

        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.ARCTICITE_COLUMNS);

        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.BLUE_ICE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.ICE_PATCH);

        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.ICEBERG_BLUE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.ICEBERG_PACKED);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.ICE_SPIKE_EVERYWHERE);

        return builder.build();
    }

    private static SpawnSettings createSpawnSettings() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 5, 2, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.POLAR_BEAR, 1, 1, 2));

        return builder.build();
    }
}
