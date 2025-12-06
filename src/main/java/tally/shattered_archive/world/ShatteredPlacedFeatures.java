package tally.shattered_archive.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;

import java.util.List;

public class ShatteredPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SOL_AURORA_PLACED_KEY = registerKey("sol_aurora_placed");
    public static final RegistryKey<PlacedFeature> DEAD_CORAL_PATCH = registerKey("dead_coral_patch_placed");
    public static final RegistryKey<PlacedFeature> PLANETOIDS_PLACED_KEY = registerKey("planetoids_placed");
    public static final RegistryKey<PlacedFeature> PURPLE_MIST = registerKey("purple_mist");
    public static final RegistryKey<PlacedFeature> ZONE_FLOWERS = registerKey("zone_flowers");
    public static final RegistryKey<PlacedFeature> WILLOW_TREE = registerKey("willow_tree");
    public static final RegistryKey<PlacedFeature> FROZEN_LAVA = registerKey("frozen_lava");
    public static final RegistryKey<PlacedFeature> ICE_SPIKE_EVERYWHERE = registerKey("ice_spike_everywhere");
    public static final RegistryKey<PlacedFeature> GLOW_CRYSTAL = registerKey("glow_crystal_placed");
    public static final RegistryKey<PlacedFeature> HOLLOW_TREE = registerKey("hollow_tree_placed");
    public static final RegistryKey<PlacedFeature> BLOOD_FREEZE = registerKey("blood_freeze");
    public static final RegistryKey<PlacedFeature> GRASS_HALLOW = registerKey("grass_hallow");
    public static final RegistryKey<PlacedFeature> FLOWERS_HALLOW = registerKey("flowers_hallow");
    public static final RegistryKey<PlacedFeature> SPIDER_LILLIES = registerKey("spider_lillies_placed");
    public static final RegistryKey<PlacedFeature> RED_MUSH = registerKey("red_mush");
    public static final RegistryKey<PlacedFeature> BROWN_MUSH = registerKey("brown_mush");
    public static final RegistryKey<PlacedFeature> BLUE_MUSH = registerKey("blue_mush");
    public static final RegistryKey<PlacedFeature> HUGE_BLUE_MUSH = registerKey("huge_blue_mush");
    public static final RegistryKey<PlacedFeature> PINK_MUSH = registerKey("pink_mush");
    public static final RegistryKey<PlacedFeature> HUGE_PINK_MUSH = registerKey("huge_pink_mush");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SPIDER_LILLIES, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.SPIDER_LILLIES), RarityFilterPlacementModifier.of(6), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLOOD_FREEZE, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.BLOOD_FREEZE),
                BiomePlacementModifier.of());

        register(context, HOLLOW_TREE, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.HOLLOW_TREE_NAT),
                CountMultilayerPlacementModifier.of(8),
                BiomePlacementModifier.of());

        register(context, GRASS_HALLOW, configuredFeatures.getOrThrow(VegetationConfiguredFeatures.PATCH_GRASS),
                CountMultilayerPlacementModifier.of(4),
                BiomePlacementModifier.of());

        register(context, FLOWERS_HALLOW, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.HALLOW_FLOWERS),
                CountMultilayerPlacementModifier.of(1),
                BiomePlacementModifier.of());

        register(context, FROZEN_LAVA, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.FROZEN_LAVA),
                CountPlacementModifier.of(40),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(32)),
                BiomePlacementModifier.of());

        register(context, SOL_AURORA_PLACED_KEY, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.SOL_AURORA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ShatteredBlocks.SOL_AURORA_CLUSTER));

        register(context, DEAD_CORAL_PATCH, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.DEAD_CORAL_VEGETATION),
                SquarePlacementModifier.of(),
                HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG),
                BiomePlacementModifier.of());

        register(context, GLOW_CRYSTAL, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.GLOWING_CRYSTALS),
                CountPlacementModifier.of(20),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(
                        YOffset.aboveBottom(0),
                        YOffset.belowTop(0)
                ),
                EnvironmentScanPlacementModifier.of(
                        Direction.UP,
                        BlockPredicate.solid(),
                        BlockPredicate.unobstructed(),
                        12
                ),
                BiomePlacementModifier.of());

        register(context, ICE_SPIKE_EVERYWHERE, configuredFeatures.getOrThrow(MiscConfiguredFeatures.ICE_SPIKE),
                CountMultilayerPlacementModifier.of(10),
                BiomePlacementModifier.of());

        register(context, PLANETOIDS_PLACED_KEY, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.PLANETOID_KEYS),
                RarityFilterPlacementModifier.of(4),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(150), YOffset.belowTop(100)),
                BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR),
                BiomePlacementModifier.of());

        register(
                context,
                WILLOW_TREE,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.ENCHANTED_WILLOW_KEY),
                CountPlacementModifier.of(11),
                SquarePlacementModifier.of(),
                SurfaceWaterDepthFilterPlacementModifier.of(2),
                PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
                BiomePlacementModifier.of(),
                BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING.getDefaultState(), BlockPos.ORIGIN))
        );

        register(context, PURPLE_MIST, configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.PURPLE_MIST),
                RarityFilterPlacementModifier.of(3),
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(120), YOffset.belowTop(100)),
                BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR),
                BiomePlacementModifier.of());

        register(
                context,
                ZONE_FLOWERS,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.MOONDROP),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                CountPlacementModifier.of(UniformIntProvider.create(0, 3)),
                BiomePlacementModifier.of()
        );

        register(
                context,
                RED_MUSH,
                configuredFeatures.getOrThrow(VegetationConfiguredFeatures.PATCH_RED_MUSHROOM),
                mushroomModifiers(0, CountPlacementModifier.of(4))
        );
        register(
                context,
                BROWN_MUSH,
                configuredFeatures.getOrThrow(VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM),
                mushroomModifiers(0, CountPlacementModifier.of(4))
        );
        register(
                context,
                BLUE_MUSH,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.BLUE_MUSH_PATCH),
                mushroomModifiers(0, CountPlacementModifier.of(4))
        );
        register(
                context,
                HUGE_BLUE_MUSH,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.HUGE_ENCHANTED_BLUE_MUSHROOM),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()
        );
        register(
                context,
                PINK_MUSH,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.PINK_MUSH_PATCH),
                mushroomModifiers(0, CountPlacementModifier.of(4))
        );
        register(
                context,
                HUGE_PINK_MUSH,
                configuredFeatures.getOrThrow(ShatteredConfiguredFeatures.HUGE_ENCHANTED_PINK_MUSHROOM),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()
        );
    }

    private static List<PlacementModifier> mushroomModifiers(int chance, @Nullable PlacementModifier modifier) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (modifier != null) {
            builder.add(modifier);
        }
        if (chance != 0) {
            builder.add(RarityFilterPlacementModifier.of(chance));
        }
        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ShatteredArchive.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
