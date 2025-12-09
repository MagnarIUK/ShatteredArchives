package tally.shattered_archive.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.*;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.world.decorators.TrunkDecorator;
import tally.shattered_archive.world.features.PlanetoidFeature;
import tally.shattered_archive.world.foliage.AuroraFoliagePlacer;
import tally.shattered_archive.world.foliage.DroopingFoliagePlacer;
import tally.shattered_archive.world.trunk.AuroraTrunkPlacer;

import java.util.Collections;
import java.util.List;

public class ShatteredConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SOL_AURORA_KEY = registerKey("sol_aurora");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENCHANTED_WILLOW_KEY = registerKey("enchanted_willow_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLANETOID_KEYS = registerKey("configured_planetoids");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_ICE_STACK = registerKey("small_ice_stack");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_ICE_STACK_FLIPPED = registerKey("small_ice_stack_flipped");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_CORAL_VEGETATION = registerKey("dead_coral_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MIST = registerKey("purple_mist");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HALLOW_FLOWERS = registerKey("hallow_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONDROP = registerKey("moondrop");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FROZEN_LAVA = registerKey("frozen_lava");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOWING_CRYSTALS = registerKey("glowing_crystals");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARCTICITE_CRYSTAL = registerKey("arcticite_crystal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOLLOW_TREE = registerKey("hollow_yellow_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOLLOW_TREE_NAT = registerKey("hollow_nat_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPIDER_LILLIES = registerKey("spider_lillies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOOD_FREEZE = registerKey("blood_freeze");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_ENCHANTED_BLUE_MUSHROOM = registerKey("huge_enchanted_blue_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_ENCHANTED_PINK_MUSHROOM = registerKey("huge_enchanted_pink_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSH_PATCH = registerKey("enchanted_mush_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_MUSH_PATCH = registerKey("enchanted_pink_mush_patch");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BLUE_MUSH_PATCH, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM))));

        register(context, PINK_MUSH_PATCH, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM))));

        register(context, HUGE_ENCHANTED_BLUE_MUSHROOM, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 2));

        register(context, HUGE_ENCHANTED_PINK_MUSHROOM, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 2));

        register(context, SPIDER_LILLIES, Feature.FLOWER, new RandomPatchFeatureConfig(16, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ShatteredBlocks.SPIDER_LILY)))));

        register(context, BLOOD_FREEZE, ShatteredFeatures.BLOOD_FREEZE, new DefaultFeatureConfig());

        register(context, ARCTICITE_CRYSTAL, ShatteredFeatures.ARCTICITE_COLUMN, new LargeDripstoneFeatureConfig(
                100,
                UniformIntProvider.create(3, 8),
                UniformFloatProvider.create(1.35f, 4f),
                1.0f,
                UniformFloatProvider.create(0.2f, 1.5f),
                UniformFloatProvider.create(0.2f, 1f),
                UniformFloatProvider.create(0f, 0.3f),
                0,
                0
        ));

        register(context, HOLLOW_TREE_NAT, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(
                        RegistryEntryList.of(
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.RED_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                                )
                                                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.ORANGE_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.YELLOW_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.LIME_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.CYAN_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.BLUE_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.PURPLE_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.MAGENTA_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.PINK_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.BLACK_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.GRAY_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.WHITE_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.TREE,
                                        new TreeFeatureConfig.Builder(
                                                BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                                new StraightTrunkPlacer(6, 0, 2),
                                                BlockStateProvider.of(ShatteredBlocks.BROWN_HALLOW_LEAVES),
                                                new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                                new TwoLayersFeatureSize(2, 0, 2)
                                        ).decorators(
                                                List.of(
                                                        new AttachedToLeavesTreeDecorator(
                                                                0.05f, 1, 1, BlockStateProvider.of(Blocks.SOUL_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)), 1, Collections.singletonList(Direction.DOWN)
                                                        )
                                                )
                                        ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                                )
                        )
                )
        );

        register(context, HOLLOW_TREE, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(
                RegistryEntryList.of(
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                    BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                    new StraightTrunkPlacer(6, 0, 2),
                                    BlockStateProvider.of(ShatteredBlocks.RED_HALLOW_LEAVES),
                                    new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                    new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.ORANGE_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.YELLOW_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.LIME_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.CYAN_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.BLUE_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.PURPLE_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.MAGENTA_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.PINK_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.BLACK_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.GRAY_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.WHITE_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.PEARLWOOD_LOG),
                                        new StraightTrunkPlacer(6, 0, 2),
                                        BlockStateProvider.of(ShatteredBlocks.BROWN_HALLOW_LEAVES),
                                        new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), UniformIntProvider.create(3,5)),
                                        new TwoLayersFeatureSize(2, 0, 2)
                                ).dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build()
                        )
                )
            )
        );

        register(context, SOL_AURORA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.AMETHYST_BLOCK),
                new AuroraTrunkPlacer(5, 6, 3),

                BlockStateProvider.of(ShatteredBlocks.SOL_AURORA_BLOCK),
                new AuroraFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1)),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ENCHANTED_WILLOW_KEY, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(
                RegistryEntryList.of(
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                    BlockStateProvider.of(ShatteredBlocks.ENCHANTED_WILLOW_LOG),
                                    new CherryTrunkPlacer(4, 2, 3, UniformIntProvider.create(1,3), UniformIntProvider.create(2,4), UniformIntProvider.create(-4,0), UniformIntProvider.create(0, 2)),

                                    BlockStateProvider.of(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES),
                                    new DroopingFoliagePlacer(UniformIntProvider.create(4,6), ConstantIntProvider.create(1)),

                                    new TwoLayersFeatureSize(1, 0, 2))
                                        .decorators(
                                                List.of(
                                                        new TrunkDecorator(
                                                                0.4F,
                                                                BlockStateProvider.of(ShatteredBlocks.COCKATRICE_OF_THE_WOODS)
                                                        )
                                                )
                                        ).build()
                        ),
                        PlacedFeatures.createEntry(
                                Feature.TREE,
                                new TreeFeatureConfig.Builder(
                                        BlockStateProvider.of(ShatteredBlocks.ENCHANTED_WILLOW_LOG),
                                        new CherryTrunkPlacer(4, 2, 3, UniformIntProvider.create(1,3), UniformIntProvider.create(2,4), UniformIntProvider.create(-4,0), UniformIntProvider.create(0, 2)),

                                        BlockStateProvider.of(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES),
                                        new DroopingFoliagePlacer(UniformIntProvider.create(4,6), ConstantIntProvider.create(1)),

                                        new TwoLayersFeatureSize(1, 0, 2)).decorators(
                                        List.of(
                                                new TrunkDecorator(
                                                        0.4F,
                                                        BlockStateProvider.of(ShatteredBlocks.COCKATRICE_OF_THE_WOODS)
                                                )
                                        )
                                ).build()
                        )
                )
        ));

        register(context, DEAD_CORAL_VEGETATION, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                12,
                7,
                3,
                PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(
                                        DataPool.<BlockState>builder()
                                                .add(Blocks.DEAD_BRAIN_CORAL.getDefaultState().with(CoralParentBlock.WATERLOGGED, false))
                                                .add(Blocks.DEAD_BUBBLE_CORAL.getDefaultState().with(CoralParentBlock.WATERLOGGED, false))
                                                .add(Blocks.DEAD_FIRE_CORAL.getDefaultState().with(CoralParentBlock.WATERLOGGED, false))
                                                .add(Blocks.DEAD_HORN_CORAL.getDefaultState().with(CoralParentBlock.WATERLOGGED, false))
                                                .add(Blocks.DEAD_TUBE_CORAL.getDefaultState().with(CoralParentBlock.WATERLOGGED, false))
                                                .build()
                                )
                        )
                )
        ));

        register(context, FROZEN_LAVA, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(
                Blocks.LAVA.getDefaultState(),
                Blocks.OBSIDIAN.getDefaultState(),
                UniformIntProvider.create(4, 7)
        ));

        register(context, GLOWING_CRYSTALS, Feature.BLOCK_COLUMN,
                new BlockColumnFeatureConfig(
                        List.of(
                                new BlockColumnFeatureConfig.Layer(
                                        UniformIntProvider.create(1,4),
                                        SimpleBlockStateProvider.of(Blocks.AMETHYST_BLOCK)
                                ),
                                new BlockColumnFeatureConfig.Layer(
                                        ConstantIntProvider.create(1),
                                        SimpleBlockStateProvider.of(Blocks.AMETHYST_CLUSTER.getDefaultState().with(AmethystClusterBlock.FACING, Direction.DOWN))
                                )
                        ),
                        Direction.DOWN,
                        BlockPredicate.matchingBlockTag(BlockTags.AIR),
                        false
                )
        );

        register(context, PURPLE_MIST, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                40,
                8,
                3,
                PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(
                                        DataPool.<BlockState>builder()
                                                .add(Blocks.PURPLE_STAINED_GLASS.getDefaultState(), 18)
                                                .add(Blocks.PURPLE_STAINED_GLASS_PANE.getDefaultState(), 4)
                                                .add(Blocks.PEARLESCENT_FROGLIGHT.getDefaultState(), 1)
                                                .build()
                                )
                        )
                )
        ));

        register(context, SMALL_ICE_STACK, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                10,
                1,
                1,
                        PlacedFeatures.createEntry(
                                Feature.BLOCK_COLUMN,
                                new BlockColumnFeatureConfig(
                                        List.of(
                                                BlockColumnFeatureConfig.createLayer(UniformIntProvider.create(1, 6), BlockStateProvider.of(Blocks.PACKED_ICE))
                                        ),
                                        Direction.UP,
                                        BlockPredicate.allOf(
                                                BlockPredicate.solid(new Vec3i(0, 0, 0)),
                                                BlockPredicate.unobstructed(new Vec3i(0, 1, 0))
                                        ),
                                        false
                                )
                        )
        ));

        register(context, SMALL_ICE_STACK_FLIPPED, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                10,
                1,
                1,
                PlacedFeatures.createEntry(
                        Feature.BLOCK_COLUMN,
                        new BlockColumnFeatureConfig(
                                List.of(
                                        BlockColumnFeatureConfig.createLayer(UniformIntProvider.create(1, 6), BlockStateProvider.of(Blocks.PACKED_ICE))
                                ),
                                Direction.DOWN,
                                BlockPredicate.allOf(
                                        BlockPredicate.solid(new Vec3i(0, 0, 0)),
                                        BlockPredicate.unobstructed(new Vec3i(0, -1, 0))
                                ),
                                false
                        )
                )
        ));

        register(context, MOONDROP, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        12,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new NoiseBlockStateProvider(
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0),
                                                0.005F,
                                                List.of(
                                                        ShatteredBlocks.MOONDROP_FLOWER.getDefaultState(),
                                                        ShatteredBlocks.MANABLOOM.getDefaultState(),
                                                        ShatteredBlocks.SUNDROP_FLOWER.getDefaultState()
                                                )
                                        )
                                )
                        )
                )
        );

        register(context, HALLOW_FLOWERS, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new NoiseBlockStateProvider(
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0),
                                                0.020833334F,
                                                List.of(
                                                        ShatteredBlocks.FIDDLE_FERN.getDefaultState(),
                                                        ShatteredBlocks.DWARF_LAVENDER.getDefaultState()
                                                )
                                        )
                                )
                        )
                )
        );

        register(context,PLANETOID_KEYS, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(
                RegistryEntryList.of(
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.SNOW_BLOCK.getDefaultState(),
                                                List.of(Blocks.CALCITE.getDefaultState()),
                                                List.of(Blocks.PACKED_ICE.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.SNOW_BLOCK.getDefaultState(),
                                                List.of(Blocks.CALCITE.getDefaultState()),
                                                List.of(Blocks.PACKED_ICE.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.SNOW_BLOCK
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(SMALL_ICE_STACK)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(SMALL_ICE_STACK_FLIPPED)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.SANDSTONE.getDefaultState(),
                                                List.of(Blocks.SANDSTONE.getDefaultState()),
                                                List.of(Blocks.BONE_BLOCK.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.SANDSTONE.getDefaultState(),
                                                List.of(Blocks.SMOOTH_SANDSTONE.getDefaultState()),
                                                List.of(Blocks.BONE_BLOCK.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.SAND
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_CACTUS)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_DEAD_BUSH)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.COBBLESTONE.getDefaultState(),
                                                List.of(Blocks.STONE.getDefaultState()),
                                                List.of(Blocks.ANDESITE.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.DIRT.getDefaultState(),
                                                List.of(Blocks.COARSE_DIRT.getDefaultState()),
                                                List.of(Blocks.ROOTED_DIRT.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.GRASS_BLOCK
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_GRASS_JUNGLE)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(TreeConfiguredFeatures.JUNGLE_TREE_NO_VINE)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.BAMBOO_NO_PODZOL)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.VINES)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.DIRT.getDefaultState(),
                                                List.of(Blocks.COARSE_DIRT.getDefaultState()),
                                                List.of(Blocks.ROOTED_DIRT.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.DIRT.getDefaultState(),
                                                List.of(Blocks.COARSE_DIRT.getDefaultState()),
                                                List.of(Blocks.ROOTED_DIRT.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.MYCELIUM
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.MUSHROOM_ISLAND_VEGETATION)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_RED_MUSHROOM)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.BLACKSTONE.getDefaultState(),
                                                List.of(Blocks.NETHERRACK.getDefaultState()),
                                                List.of(Blocks.SOUL_SOIL.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.BLACKSTONE.getDefaultState(),
                                                List.of(Blocks.NETHERRACK.getDefaultState()),
                                                List.of(Blocks.SOUL_SOIL.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.CRIMSON_NYLIUM
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(NetherConfiguredFeatures.CRIMSON_FOREST_VEGETATION)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(NetherConfiguredFeatures.WEEPING_VINES)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.END_STONE.getDefaultState(),
                                                List.of(Blocks.END_STONE.getDefaultState()),
                                                List.of(Blocks.END_STONE_BRICKS.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.END_STONE.getDefaultState(),
                                                List.of(Blocks.END_STONE.getDefaultState()),
                                                List.of(Blocks.END_STONE_BRICKS.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.END_STONE
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(EndConfiguredFeatures.CHORUS_PLANT)), 0.1F)
                                        )
                                )
                        ),
                        PlacedFeatures.createEntry(
                                ShatteredFeatures.PLANETOID_FEATURE,
                                new PlanetoidFeature.GeyserFeatureConfig(
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.7F,
                                                Blocks.DIRT.getDefaultState(),
                                                List.of(Blocks.COARSE_DIRT.getDefaultState()),
                                                List.of(Blocks.ROOTED_DIRT.getDefaultState())),
                                        new NoiseThresholdBlockStateProvider(2048304793, new DoublePerlinNoiseSampler.NoiseParameters(0, 1), 2F, 0.3F, 0.3F,
                                                Blocks.DIRT.getDefaultState(),
                                                List.of(Blocks.COARSE_DIRT.getDefaultState()),
                                                List.of(Blocks.ROOTED_DIRT.getDefaultState())),
                                        BlockStateProvider.of(
                                                Blocks.PODZOL
                                        ),
                                        List.of(
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.TREES_TAIGA)), 0.1F),
                                                new Pair<>(PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_TAIGA_GRASS)), 0.1F)
                                        )
                                )
                        )
                )
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ShatteredArchive.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
