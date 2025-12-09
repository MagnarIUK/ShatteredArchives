package tally.shattered_archive.world;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.world.features.ArcticiteDripstoneFeature;
import tally.shattered_archive.world.features.BloodFreezeFeature;
import tally.shattered_archive.world.features.PlanetoidFeature;

public class ShatteredFeatures {
    public static final Feature<PlanetoidFeature.GeyserFeatureConfig> PLANETOID_FEATURE = register("planetoid_feature", new PlanetoidFeature(PlanetoidFeature.GeyserFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> BLOOD_FREEZE = register("blood_freeze", new BloodFreezeFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<LargeDripstoneFeatureConfig> ARCTICITE_COLUMN = register("arcticite_column", new ArcticiteDripstoneFeature(LargeDripstoneFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(ShatteredArchive.MOD_ID, name), feature);
    }

    public static void initialize() {
    }
}
