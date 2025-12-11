package tally.shattered_archive.blocks;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.custom.*;
import tally.shattered_archive.blocks.helpers.ModBlockProperties;
import tally.shattered_archive.world.ShatteredConfiguredFeatures;
import tally.shattered_archive.world.ShatteredSaplingGenerators;

import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;

public class ShatteredBlocks {

    public static boolean fullBlock(BlockState state, BlockView world, BlockPos pos) {
        return state.get(ModBlockProperties.OPAQUE) == 15;
    }

    public static final Block COCKATRICE_OF_THE_WOODS = registerNo(
            "cockatrice_of_the_woods",
            new WallDependentBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.CYAN).strength(2.0F, 3.0F).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY).luminance(lightLevel(11))
            )
    );

    public static final Block DWARF_LAVENDER = register(
            "dwarf_lavender",
            (Block)new FlowerBlock(StatusEffects.REGENERATION, 0.9f, AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block SPIDER_LILY = register(
            "spider_lily",
            (Block)new FlowerBlock(StatusEffects.INSTANT_DAMAGE, 0.1f, AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block MANABLOOM = register(
            "manabloom",
            (Block)new FlowerBlock(StatusEffects.INVISIBILITY, 3.0f, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).luminance(lightLevel(9)))
    );

    public static final Block FIDDLE_FERN = register(
            "fiddle_fern",
            (Block)new ShortPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block ENCHANTED_BLUE_MUSHROOM_BLOCK = register("enchanted_blue_mushroom_block", new MushroomBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(0.2f).sounds(BlockSoundGroup.WOOD).luminance(state -> 6).burnable()));

    public static final Block ENCHANTED_BLUE_MUSHROOM = register(
            "enchanted_blue_mushroom",
            (Block)new MushroomPlantBlock(ShatteredConfiguredFeatures.HUGE_ENCHANTED_BLUE_MUSHROOM, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(state -> 4).postProcess(Blocks::always).pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block ENCHANTED_PINK_MUSHROOM_BLOCK = register("enchanted_pink_mushroom_block", new MushroomBlock(AbstractBlock.Settings.create().mapColor(MapColor.PINK).instrument(NoteBlockInstrument.BASS).strength(0.2f).sounds(BlockSoundGroup.WOOD).luminance(state -> 6).burnable()));

    public static final Block ENCHANTED_PINK_MUSHROOM = register(
            "enchanted_pink_mushroom",
            (Block)new MushroomPlantBlock(ShatteredConfiguredFeatures.HUGE_ENCHANTED_PINK_MUSHROOM, AbstractBlock.Settings.create().mapColor(MapColor.PINK).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(state -> 4).postProcess(Blocks::always).pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block POTTED_ENCHANTED_BLUE_MUSHROOM = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_enchanted_blue_mushroom"), createFlowerPotBlock(ENCHANTED_BLUE_MUSHROOM));

    public static final Block POTTED_ENCHANTED_PINK_MUSHROOM = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_enchanted_pink_mushroom"), createFlowerPotBlock(ENCHANTED_PINK_MUSHROOM));

    public static final Block POTTED_MANABLOOM = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_manabloom"), createFlowerPotBlock(MANABLOOM));

    public static final Block POTTED_FIDDLE_FERN = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_fiddle_fern"), createFlowerPotBlock(FIDDLE_FERN));

    public static final Block POTTED_DWARF_LAVENDER = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_dwarf_lavender"), createFlowerPotBlock(DWARF_LAVENDER));

    public static final Block POTTED_SPIDER_LILY = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_spider_lily"), createFlowerPotBlock(SPIDER_LILY));

    public static final Block ENCHANTED_WILLOW_DROOPING_LEAVES = register(
            "hanging_willow",
            new DroopingLeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.HANGING_ROOTS).offset(AbstractBlock.OffsetType.XZ).burnable().replaceable().pistonBehavior(PistonBehavior.DESTROY).offset(AbstractBlock.OffsetType.NONE).nonOpaque().luminance(lightLevel(12))));

    public static final Block BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES = register(
            "blue_hanging_willow",
            new DroopingLeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.HANGING_ROOTS).offset(AbstractBlock.OffsetType.XZ).burnable().replaceable().pistonBehavior(PistonBehavior.DESTROY).offset(AbstractBlock.OffsetType.NONE).nonOpaque().luminance(lightLevel(12))));

    //public static final Block AURORA_LOG = register("aurora_log", new GlassPillar((AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((p_50886_) -> {
        //return 2;
    //}).nonOpaque().postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always))));

    public static final Block ARCTICITE_GLASS = register("arcticite_glass", new VariableGlass(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.HAT).strength(0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(ShatteredBlocks::fullBlock)));
    public static final Block RED_STAINED_ARCTICITE_GLASS = register("red_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.RED));
    public static final Block ORANGE_STAINED_ARCTICITE_GLASS = register("orange_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.ORANGE));
    public static final Block YELLOW_STAINED_ARCTICITE_GLASS = register("yellow_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.YELLOW));
    public static final Block LIME_STAINED_ARCTICITE_GLASS = register("lime_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.LIME));
    public static final Block GREEN_STAINED_ARCTICITE_GLASS = register("green_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.GREEN));
    public static final Block CYAN_STAINED_ARCTICITE_GLASS = register("cyan_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.CYAN));
    public static final Block LIGHT_BLUE_STAINED_ARCTICITE_GLASS = register("light_blue_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.LIGHT_BLUE));
    public static final Block BLUE_STAINED_ARCTICITE_GLASS = register("blue_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.BLUE));
    public static final Block PURPLE_STAINED_ARCTICITE_GLASS = register("purple_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.PURPLE));
    public static final Block MAGENTA_STAINED_ARCTICITE_GLASS = register("magenta_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.MAGENTA));
    public static final Block PINK_STAINED_ARCTICITE_GLASS = register("pink_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.PINK));
    public static final Block WHITE_STAINED_ARCTICITE_GLASS = register("white_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.WHITE));
    public static final Block LIGHT_GRAY_STAINED_ARCTICITE_GLASS = register("light_gray_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.LIGHT_GRAY));
    public static final Block GRAY_STAINED_ARCTICITE_GLASS = register("gray_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.GRAY));
    public static final Block BLACK_STAINED_ARCTICITE_GLASS = register("black_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.BLACK));
    public static final Block BROWN_STAINED_ARCTICITE_GLASS = register("brown_stained_arcticite_glass", createStainedArcticiteBlock(DyeColor.BROWN));

    private static Block createStainedArcticiteBlock(DyeColor color) {
        return new VariableStainedGlass(color, AbstractBlock.Settings.create().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(ShatteredBlocks::fullBlock));
    }

    public static final BlockSetType PEARLWOOD = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Identifier.of(ShatteredArchive.MOD_ID, "pearlwood"));
    public static final WoodType PEARLWOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).build(Identifier.of(ShatteredArchive.MOD_ID, "pearlwood_type"), PEARLWOOD);

    public static final Block PEARLWOOD_SAPLING = register("pearlwood_sapling", new SaplingBlock(
            new SaplingGenerator("pearlwood_sapling_gen",
                0.0F,
                    Optional.empty(),
                    Optional.empty(),
                Optional.of(ShatteredConfiguredFeatures.HOLLOW_TREE),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
            ),
            AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING)
    ));

    public static final Block PEARLWOOD_LOG = register("pearlwood_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block PEARLWOOD_WOOD = register(
            "pearlwood_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block STRIPPED_PEARLWOOD_LOG = register("stripped_pearlwood_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block STRIPPED_PEARLWOOD_WOOD = register(
            "stripped_pearlwood_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block PEARLWOOD_PLANKS = register(
            "pearlwood_planks",
            new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );


    private static final Identifier PEARLWOOD_SIGN_TEXTURE = ShatteredArchive.id("entity/signs/pearlwood");
    private static final Identifier PEARLWOOD_HANGING_SIGN_TEXTURE = ShatteredArchive.id("entity/signs/hanging/pearlwood");
    private static final Identifier PEARLWOOD_HANGING_SIGN_GUI_TEXTURE = ShatteredArchive.id("textures/gui/hanging_signs/pearlwood");

    public static final TerraformSignBlock PEARLWOOD_SIGN = registerNo("pearlwood_sign",
            new TerraformSignBlock(PEARLWOOD_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformWallSignBlock PEARLWOOD_WALL_SIGN = registerNo("pearlwood_wall_sign",
            new TerraformWallSignBlock(PEARLWOOD_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformHangingSignBlock PEARLWOOD_HANGING_SIGN = registerNo("pearlwood_hanging_sign",
            new TerraformHangingSignBlock(PEARLWOOD_HANGING_SIGN_TEXTURE, PEARLWOOD_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformWallHangingSignBlock PEARLWOOD_WALL_HANGING_SIGN = registerNo("pearlwood_wall_hanging_sign",
            new TerraformWallHangingSignBlock(PEARLWOOD_HANGING_SIGN_TEXTURE, PEARLWOOD_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final Block PEARLWOOD_SLAB = register(
            "pearlwood_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block PEARLWOOD_FENCE = register(
            "pearlwood_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block PEARLWOOD_FENCE_GATE = register(
            "pearlwood_fence_gate",
            new FenceGateBlock(
                    PEARLWOOD_TYPE,
                    AbstractBlock.Settings.create().mapColor(PEARLWOOD_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F)
            )
    );
    public static final Block PEARLWOOD_STAIRS = register("pearlwood_stairs", createOldStairsBlock(PEARLWOOD_PLANKS));
    public static final Block PEARLWOOD_BUTTON = register("pearlwood_button", new ButtonBlock(PEARLWOOD, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PEARLWOOD_PRESSURE_PLATE = register(
            "pearlwood_pressure_plate",
            new PressurePlateBlock(
                    PEARLWOOD,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(0.5F)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final Block PEARLWOOD_TRAPDOOR = register(
            "pearlwood_trapdoor",
            new TrapdoorBlock(
                    PEARLWOOD,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.OAK_TAN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never)
            )
    );
    public static final Block PEARLWOOD_DOOR = register(
            "pearlwood_door",
            new DoorBlock(
                    PEARLWOOD,
                    AbstractBlock.Settings.create()
                            .mapColor(PEARLWOOD_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block POTTED_PEARLWOOD_SAPLING = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_pearlwood_sapling"), createFlowerPotBlock(PEARLWOOD_SAPLING));

    public static final BlockSetType ENCHANTED_WILLOW = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Identifier.of(ShatteredArchive.MOD_ID, "enchanted_willow"));
    public static final WoodType ENCHANTED_WILLOW_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).build(Identifier.of(ShatteredArchive.MOD_ID, "enchanted_willow_type"), ENCHANTED_WILLOW);

    public static final Block ENCHANTED_WILLOW_SAPLING = register("enchanted_willow_sapling", new SaplingBlock(
            new SaplingGenerator("enchanted_willow_sapling_gen",
                    0.0F,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ShatteredConfiguredFeatures.ENCHANTED_WILLOW_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            ),
            AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING)
    ));


    public static final Block ENCHANTED_WILLOW_LOG = register("enchanted_willow_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block ENCHANTED_WILLOW_WOOD = register(
            "enchanted_willow_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block STRIPPED_ENCHANTED_WILLOW_LOG = register("stripped_enchanted_willow_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block STRIPPED_ENCHANTED_WILLOW_WOOD = register(
            "stripped_enchanted_willow_wood",
            new PillarBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block ENCHANTED_WILLOW_PLANKS = register(
            "enchanted_willow_planks",
            new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );

    private static final Identifier ENCHANTED_WILLOW_SIGN_TEXTURE = ShatteredArchive.id("entity/signs/enchanted_willow");
    private static final Identifier ENCHANTED_WILLOW_HANGING_SIGN_TEXTURE = ShatteredArchive.id("entity/signs/hanging/enchanted_willow");
    private static final Identifier ENCHANTED_WILLOW_HANGING_SIGN_GUI_TEXTURE = ShatteredArchive.id("textures/gui/hanging_signs/enchanted_willow");

    public static final TerraformSignBlock ENCHANTED_WILLOW_SIGN = registerNo("enchanted_willow_sign",
            new TerraformSignBlock(ENCHANTED_WILLOW_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformWallSignBlock ENCHANTED_WILLOW_WALL_SIGN = registerNo("enchanted_willow_wall_sign",
            new TerraformWallSignBlock(ENCHANTED_WILLOW_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformHangingSignBlock ENCHANTED_WILLOW_HANGING_SIGN = registerNo("enchanted_willow_hanging_sign",
            new TerraformHangingSignBlock(ENCHANTED_WILLOW_HANGING_SIGN_TEXTURE, ENCHANTED_WILLOW_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final TerraformWallHangingSignBlock ENCHANTED_WILLOW_WALL_HANGING_SIGN = registerNo("enchanted_willow_wall_hanging_sign",
            new TerraformWallHangingSignBlock(ENCHANTED_WILLOW_HANGING_SIGN_TEXTURE, ENCHANTED_WILLOW_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(1.0F)));

    public static final Block ENCHANTED_WILLOW_SLAB = register(
            "enchanted_willow_slab",
            new SlabBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block ENCHANTED_WILLOW_FENCE = register(
            "enchanted_willow_fence",
            new FenceBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block ENCHANTED_WILLOW_FENCE_GATE = register(
            "enchanted_willow_fence_gate",
            new FenceGateBlock(
                    ENCHANTED_WILLOW_TYPE,
                    AbstractBlock.Settings.create().mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F)
            )
    );
    public static final Block ENCHANTED_WILLOW_STAIRS = register("enchanted_willow_stairs", createOldStairsBlock(ENCHANTED_WILLOW_PLANKS));
    public static final Block ENCHANTED_WILLOW_BUTTON = register("enchanted_willow_button", new ButtonBlock(ENCHANTED_WILLOW, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ENCHANTED_WILLOW_PRESSURE_PLATE = register(
            "enchanted_willow_pressure_plate",
            new PressurePlateBlock(
                    ENCHANTED_WILLOW,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(0.5F)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final Block ENCHANTED_WILLOW_TRAPDOOR = register(
            "enchanted_willow_trapdoor",
            new TrapdoorBlock(
                    ENCHANTED_WILLOW,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.OAK_TAN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never)
            )
    );
    public static final Block ENCHANTED_WILLOW_DOOR = register(
            "enchanted_willow_door",
            new DoorBlock(
                    ENCHANTED_WILLOW,
                    AbstractBlock.Settings.create()
                            .mapColor(ENCHANTED_WILLOW_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block POTTED_ENCHANTED_WILLOW_SAPLING = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_enchanted_willow_sapling"), createFlowerPotBlock(ENCHANTED_WILLOW_SAPLING));

    public static final Block ENCHANTED_WILLOW_LEAVES = register("enchanted_willow_leaves", new WillowLeavesBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PURPLE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    ));

    public static final Block BLUE_ENCHANTED_WILLOW_LEAVES = register("blue_enchanted_willow_leaves", new WillowLeavesBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    ));

    public static final Block GLOWING_ENCHANTED_WILLOW_LEAVES = register("glowing_enchanted_willow_leaves", new WillowLeavesBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PURPLE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
                    .luminance(lightLevel(11))
    ));

    public static final Block GLOWING_BLUE_ENCHANTED_WILLOW_LEAVES = register("glowing_blue_enchanted_willow_leaves", new WillowLeavesBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
                    .luminance(lightLevel(11))
    ));

    public static final Block SUNDROP_FLOWER = register("sundrop_flower", new SunMoonFlower(
            new SuspiciousStewEffectsComponent(
                    List.of(
                            new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.LUCK, 10)
                    )
            ),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .ticksRandomly()
                    .luminance(createLightLevelFromLitBlockState(12))
    ));

    public static final Block BLOOD_STAINED_SNOW = register(
            "blood_stained_snow",
            new SnowBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.TERRACOTTA_PINK)
                            .replaceable()
                            .notSolid()
                            .ticksRandomly()
                            .strength(0.1F)
                            .requiresTool()
                            .sounds(BlockSoundGroup.SNOW)
                            .blockVision((state, world, pos) -> (Integer)state.get(SnowBlock.LAYERS) >= 8)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block BLOOD_STAINED_SNOW_BLOCK = register(
            "blood_stained_snow_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PINK).requiresTool().strength(0.2F).sounds(BlockSoundGroup.SNOW))
    );

    public static final Block BLOOD_ICE = register(
            "blood_ice",
            new IceBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DULL_RED)
                            .slipperiness(0.98F)
                            .ticksRandomly()
                            .strength(0.5F)
                            .sounds(BlockSoundGroup.GLASS)
                            .nonOpaque()
                            .allowsSpawning((state, world, pos, entityType) -> entityType == EntityType.POLAR_BEAR)
                            .solidBlock(Blocks::never)
            )
    );

    public static final Block SMOKE_STACK = register("smoke_stack", new SmokeVentBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.BLACK)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(1.25F, 4.2F)
            .sounds(BlockSoundGroup.BASALT)));

    public static final Block RED_HALLOW_LEAVES = register("red_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block ORANGE_HALLOW_LEAVES = register("orange_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block YELLOW_HALLOW_LEAVES = register("yellow_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block LIME_HALLOW_LEAVES = register("lime_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block GREEN_HALLOW_LEAVES = register("green_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block CYAN_HALLOW_LEAVES = register("cyan_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block LIGHT_BLUE_HALLOW_LEAVES = register("light_blue_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block BLUE_HALLOW_LEAVES = register("blue_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block PURPLE_HALLOW_LEAVES = register("purple_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block MAGENTA_HALLOW_LEAVES = register("magenta_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block PINK_HALLOW_LEAVES = register("pink_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block BLACK_HALLOW_LEAVES = register("black_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block GRAY_HALLOW_LEAVES = register("gray_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block LIGHT_GRAY_HALLOW_LEAVES = register("light_gray_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block WHITE_HALLOW_LEAVES = register("white_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));
    public static final Block BROWN_HALLOW_LEAVES = register("brown_hallow_leaves", createLeavesHallowBlock(BlockSoundGroup.GRASS));

    public static final Block MOONDROP_FLOWER = register("moondrop_flower", new SunMoonFlower(
            new SuspiciousStewEffectsComponent(
                    List.of(
                            new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.UNLUCK, 10)
                    )
            ),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .ticksRandomly()
                    .luminance(createLightLevelFromLitBlockState(12))
    ));
    
    public static final Block POTTED_SUNDROP_FLOWER = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_sundrop"), createFlowerPotBlock(SUNDROP_FLOWER));
    public static final Block POTTED_MOONDROP_FLOWER = Registry.register(Registries.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, "potted_moondrop"), createFlowerPotBlock(MOONDROP_FLOWER));

    public static final Block INK_SAND = register("ink_sand", new ColoredFallingBlock(
            new ColorCode(0),
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)
    ));

    public static final Block INK_SANDSTONE = register("ink_sandstone", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F)));

    public static final Block INK_SANDSTONE_SLAB = register(
            "ink_sandstone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F))
    );

    public static final Block CHISELED_INK_SANDSTONE = register(
            "chiseled_ink_sandstone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F))
    );
    public static final Block CUT_INK_SANDSTONE = register(
            "cut_ink_sandstone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F))
    );

    public static final Block INK_SANDSTONE_STAIRS = register("ink_sandstone_stairs", createOldStairsBlock(INK_SANDSTONE));

    public static final Block CUT_INK_SANDSTONE_SLAB = register(
            "cut_ink_sandstone_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F))
    );

    public static final Block INK_SANDSTONE_WALL = register("ink_sandstone_wall", new WallBlock(AbstractBlock.Settings.copyShallow(INK_SANDSTONE).solid()));

    public static final Block SMOOTH_INK_SANDSTONE = register(
            "smooth_ink_sandstone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F))
    );

    public static final Block SMOOTH_INK_SANDSTONE_SLAB = register("smooth_ink_sandstone_slab", new SlabBlock(AbstractBlock.Settings.copyShallow(SMOOTH_INK_SANDSTONE)));

    public static final Block SMOOTH_INK_SANDSTONE_STAIRS = register("smooth_ink_sandstone_stairs", createOldStairsBlock(SMOOTH_INK_SANDSTONE));

    public static final Block SOARE_AURORA_BLOCK = register("soare_aurora_block", new AuroraBlock((AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((p_50886_) -> {
        return 2;
    }).nonOpaque().postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always).ticksRandomly()),3));

    public static final Block LUNA_AURORA_BLOCK = register("luna_aurora_block", new AuroraBlock((AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((p_50886_) -> {
        return 2;
    }).nonOpaque().postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always).ticksRandomly()),2));

    public static final Block SOL_AURORA_BLOCK = register("sol_aurora_block", new AuroraBlock((AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((p_50886_) -> {
        return 2;
    }).nonOpaque().postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always).ticksRandomly()),1));

    public static final Block SOL_AURORA_CLUSTER = register(
            "sol_aurora_cluster",
            new AuroraClusterBlock(
                    ShatteredSaplingGenerators.SOL_AURORA,
                    7.0F,
                    3.0F,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PURPLE)
                            .solid()
                            .nonOpaque()
                            .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                            .strength(1.5F)
                            .luminance(state -> 5)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always).ticksRandomly(),
                    true
            )
    );
    public static final Block LARGE_SOL_AURORA_BUD = register(
            "large_sol_aurora_bud",
            new AuroraClusterBlock(ShatteredSaplingGenerators.SOL_AURORA,5.0F, 3.0F, AbstractBlock.Settings.copyShallow(SOL_AURORA_BLOCK).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 4))
    );
    public static final Block MEDIUM_SOL_AURORA_BUD = register(
            "medium_sol_aurora_bud",
            new AuroraClusterBlock(ShatteredSaplingGenerators.SOL_AURORA,4.0F, 3.0F, AbstractBlock.Settings.copyShallow(SOL_AURORA_BLOCK).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 3))
    );
    public static final Block SMALL_SOL_AURORA_BUD = register(
            "small_sol_aurora_bud",
            new AuroraClusterBlock(ShatteredSaplingGenerators.SOL_AURORA,3.0F, 4.0F, AbstractBlock.Settings.copyShallow(SOL_AURORA_BLOCK).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 2))
    );

    public static final Block ECLIPSA_AURORA_BLOCK = register("eclipsa_aurora_block", new AuroraBlock((AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((p_50886_) -> {
        return 2;
    }).nonOpaque().postProcess(ShatteredBlocks::always).emissiveLighting(ShatteredBlocks::always).ticksRandomly()), 4));

    public static final Block INKED_XANDRITE_BLOCK = register("inked_xandrite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block FROSTED_CALCITE = register("frosted_calcite",
            new Block(AbstractBlock.Settings.copy(Blocks.CALCITE).instrument(NoteBlockInstrument.BASEDRUM).
                    sounds(BlockSoundGroup.CALCITE).requiresTool().strength(0.75f)));

    public static final Block ARCTICITE_ORE = register("arcticite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0f, 3.0f)));

    private static boolean always(BlockState blockState, net.minecraft.world.BlockView blockView, BlockPos blockPos) {
        return true;
    }

    private static Block createOldStairsBlock(Block block) {
        return new StairsBlock(block.getDefaultState(), AbstractBlock.Settings.copyShallow(block));
    }

    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK, Identifier.of("shatteredarchive", path), block);
        Registry.register(Registries.ITEM, Identifier.of("shatteredarchive", path), new BlockItem(block, new Item.Settings()));
        return block;
    }

    private static <T extends Block> T registerNo(String path, T block) {
        Registry.register(Registries.BLOCK, Identifier.of("shatteredarchive", path), block);
        return block;
    }


    public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sounds(BlockSoundGroup.WOOD)
        );
    }

    public static Block createFlowerPotBlock(Block flower) {
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
    }

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    public static ToIntFunction<BlockState> lightLevel(int litLevel) {
        return state -> litLevel;
    }

    public static void initialize() {
    }

    public static Block createLeavesHallowBlock(BlockSoundGroup soundGroup) {
        return new HallowLeavesBlocks(
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.DARK_GREEN)
                        .strength(0.2F)
                        .ticksRandomly()
                        .sounds(soundGroup)
                        .nonOpaque()
                        .allowsSpawning(Blocks::canSpawnOnLeaves)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .solidBlock(Blocks::never)
        );
    }

    public static final BlockFamily PEARLWOOD_FAMILY = new BlockFamily.Builder(
            PEARLWOOD_PLANKS)
            .slab(PEARLWOOD_SLAB)
            .stairs(PEARLWOOD_STAIRS)
            .trapdoor(PEARLWOOD_TRAPDOOR)
            .door(PEARLWOOD_DOOR)
            .fence(PEARLWOOD_FENCE)
            .fenceGate(PEARLWOOD_FENCE_GATE)
            .pressurePlate(PEARLWOOD_PRESSURE_PLATE)
            .button(PEARLWOOD_BUTTON)
            .sign(PEARLWOOD_SIGN, PEARLWOOD_WALL_SIGN)
            .build();

    public static final BlockFamily ENCHANTED_WILLOW_FAMILY = new BlockFamily.Builder(
            ENCHANTED_WILLOW_PLANKS)
            .slab(ENCHANTED_WILLOW_SLAB)
            .stairs(ENCHANTED_WILLOW_STAIRS)
            .trapdoor(ENCHANTED_WILLOW_TRAPDOOR)
            .door(ENCHANTED_WILLOW_DOOR)
            .fence(ENCHANTED_WILLOW_FENCE)
            .fenceGate(ENCHANTED_WILLOW_FENCE_GATE)
            .pressurePlate(ENCHANTED_WILLOW_PRESSURE_PLATE)
            .button(ENCHANTED_WILLOW_BUTTON)
            .sign(ENCHANTED_WILLOW_SIGN, ENCHANTED_WILLOW_WALL_SIGN)
            .build();
}
