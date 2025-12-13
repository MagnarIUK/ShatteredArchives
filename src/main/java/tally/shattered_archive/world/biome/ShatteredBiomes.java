package tally.shattered_archive.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.world.ShatteredPlacedFeatures;

public class ShatteredBiomes {
    public static final RegistryKey<Biome> GRAVITY_SPRINGS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "gravity_springs"));
    public static final RegistryKey<Biome> BLOOD_STAINED_TUNDRA = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "blood_stained_tundra"));
    public static final RegistryKey<Biome> ENCHANTED_WILLOW_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "enchanted_willow_forest"));
    public static final RegistryKey<Biome> ABYSSAL_OCEAN = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "abyssal_ocean"));
    public static final RegistryKey<Biome> INK_DESERT = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "ink_desert"));
    public static final RegistryKey<Biome> GIANTS_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ShatteredArchive.MOD_ID, "giants_forest"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(GRAVITY_SPRINGS, gravitySprings(context));
        context.register(BLOOD_STAINED_TUNDRA, bloodStainedTundra(context));
        context.register(ENCHANTED_WILLOW_FOREST, theZone(context));
        context.register(ABYSSAL_OCEAN, abyssalOcean(context));
        context.register(INK_DESERT, inkDesert(context));
        //context.register(GIANTS_FOREST, giantsForest(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome gravitySprings(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BREEZE, 1, 1, 1));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.DEAD_CORAL_PATCH);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.PLANETOIDS_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x1fcc98)
                        .waterFogColor(0x3f76e4)
                        .skyColor(0x000000)
                        .grassColor(0x59c93c)
                        .foliageColor(0x30bb0b)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
    public static Biome bloodStainedTundra(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
        DefaultBiomeFeatures.addAmethystGeodes(biomeBuilder);
        DefaultBiomeFeatures.addDungeons(biomeBuilder);
        DefaultBiomeFeatures.addMineables(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ShatteredPlacedFeatures.BLOOD_FREEZE);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.WEEPING_VINES);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_TAIGA_2);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.SPIDER_LILLIES);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.1f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xbd3030)
                        .waterFogColor(0x972828)
                        .skyColor(0xcecece)
                        .grassColor(0x7e1b1b)
                        .foliageColor(0x7e1b1b)
                        .fogColor(0xcecece)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
    public static Biome theZone(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 3, 1, 3));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 1, 1));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 2, 1, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MOOSHROOM, 1, 2, 3));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.FOREST_ROCK);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.ZONE_FLOWERS);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.WILLOW_TREE);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_FLOWER_FOREST);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_LARGE_FERN);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_TAIGA);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.HUGE_PINK_MUSH);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.HUGE_BLUE_MUSH);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.BROWN_MUSH);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.PINK_MUSH);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.BLUE_MUSH);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShatteredPlacedFeatures.PURPLE_MIST);


        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x039aff)
                        .waterFogColor(0x65e9c0)
                        .skyColor(0x7bedff)
                        .grassColor(0x4af29e)
                        .foliageColor(0xb064d4)
                        .fogColor(0xa523bd)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
    public static Biome abyssalOcean(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.GLOW_SQUID, 1, 2, 5));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x34438f)
                        .waterFogColor(0x34438f)
                        .skyColor(0xc0d8ff)
                        .grassColor(0x8eb971)
                        .foliageColor(0x71a74d)
                        .fogColor(0x7ba4ff)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
    public static Biome inkDesert(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 3, 1, 3));
        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 3, 1, 3));
        spawnBuilder.spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.GLOW_SQUID, 3, 1, 3));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.1f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x000000)
                        .waterFogColor(0x000000)
                        .skyColor(0x24454e)
                        .grassColor(0x000000)
                        .foliageColor(0x000000)
                        .fogColor(0x000000)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
    public static Biome giantsForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x2d6d77)
                        .skyColor(0x7da3ff)
                        .grassColor(0x86b783)
                        .foliageColor(0x68a464)
                        .fogColor(0xc0d8ff)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME)).build())
                .build();
    }
}
