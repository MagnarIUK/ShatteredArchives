package tally.shattered_archive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;

import java.util.concurrent.CompletableFuture;

public class ShatteredBlockTagGen extends FabricTagProvider<Block> {
    public ShatteredBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    public static final TagKey<Block> PEARLWOOD_LOGS  = of("pearlwood_logs");
    public static final TagKey<Block> ENCHANTED_WILLOW_LOGS  = of("enchanted_willow_logs");
    public static final TagKey<Block> DROOPING_WILLOW  = of("hanging_willow");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ShatteredArchive.MOD_ID, id));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ShatteredBlocks.RED_HALLOW_LEAVES)
                .add(ShatteredBlocks.ORANGE_HALLOW_LEAVES)
                .add(ShatteredBlocks.YELLOW_HALLOW_LEAVES)
                .add(ShatteredBlocks.LIME_HALLOW_LEAVES)
                .add(ShatteredBlocks.GREEN_HALLOW_LEAVES)
                .add(ShatteredBlocks.CYAN_HALLOW_LEAVES)
                .add(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES)
                .add(ShatteredBlocks.BLUE_HALLOW_LEAVES)
                .add(ShatteredBlocks.PURPLE_HALLOW_LEAVES)
                .add(ShatteredBlocks.MAGENTA_HALLOW_LEAVES)
                .add(ShatteredBlocks.PINK_HALLOW_LEAVES)
                .add(ShatteredBlocks.BROWN_HALLOW_LEAVES)
                .add(ShatteredBlocks.BLACK_HALLOW_LEAVES)
                .add(ShatteredBlocks.GRAY_HALLOW_LEAVES)
                .add(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES)
                .add(ShatteredBlocks.WHITE_HALLOW_LEAVES)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES)
                .add(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES)
                .add(ShatteredBlocks.GLOWING_ENCHANTED_WILLOW_LEAVES)
                .add(ShatteredBlocks.GLOWING_BLUE_ENCHANTED_WILLOW_LEAVES);

        getOrCreateTagBuilder(BlockTags.ICE)
                .add(ShatteredBlocks.BLOOD_ICE);

        getOrCreateTagBuilder(BlockTags.SAND)
                .add(ShatteredBlocks.INK_SAND);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ShatteredBlocks.INK_SANDSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ShatteredBlocks.INK_SANDSTONE_SLAB)
                .add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_SLAB)
                .add(ShatteredBlocks.CUT_INK_SANDSTONE_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ShatteredBlocks.INK_SANDSTONE_STAIRS)
                .add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ShatteredBlocks.INK_SANDSTONE)
                .add(ShatteredBlocks.INK_SANDSTONE_WALL)
                .add(ShatteredBlocks.INK_SANDSTONE_SLAB)
                .add(ShatteredBlocks.INK_SANDSTONE_STAIRS)
                .add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_STAIRS)
                .add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_SLAB)
                .add(ShatteredBlocks.SMOOTH_INK_SANDSTONE)
                .add(ShatteredBlocks.CUT_INK_SANDSTONE)
                .add(ShatteredBlocks.CUT_INK_SANDSTONE_SLAB)
                .add(ShatteredBlocks.CHISELED_INK_SANDSTONE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ShatteredBlocks.INK_SAND)
                .add(ShatteredBlocks.BLOOD_STAINED_SNOW_BLOCK)
                .add(ShatteredBlocks.BLOOD_STAINED_SNOW);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ShatteredBlocks.BLOOD_STAINED_SNOW);

        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)
                .add(ShatteredBlocks.BLOOD_ICE);

        getOrCreateTagBuilder(PEARLWOOD_LOGS)
                .add(ShatteredBlocks.PEARLWOOD_LOG)
                .add(ShatteredBlocks.PEARLWOOD_WOOD)
                .add(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG)
                .add(ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD);

        getOrCreateTagBuilder(ENCHANTED_WILLOW_LOGS)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_LOG)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_WOOD)
                .add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG)
                .add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM_BLOCK)
                .add(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .addTag(PEARLWOOD_LOGS)
                .addTag(ENCHANTED_WILLOW_LOGS);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ShatteredBlocks.PEARLWOOD_PLANKS)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ShatteredBlocks.INK_SANDSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ShatteredBlocks.PEARLWOOD_STAIRS)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ShatteredBlocks.PEARLWOOD_TRAPDOOR)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ShatteredBlocks.PEARLWOOD_DOOR)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ShatteredBlocks.PEARLWOOD_SLAB)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ShatteredBlocks.PEARLWOOD_BUTTON)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ShatteredBlocks.PEARLWOOD_FENCE)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ShatteredBlocks.PEARLWOOD_FENCE_GATE)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ShatteredBlocks.PEARLWOOD_PRESSURE_PLATE)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ShatteredBlocks.PEARLWOOD_SAPLING)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING);

        getOrCreateTagBuilder(BlockTags.BASE_STONE_NETHER)
                .add(ShatteredBlocks.SMOKE_STACK);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ShatteredBlocks.MANABLOOM)
                .add(ShatteredBlocks.SUNDROP_FLOWER)
                .add(ShatteredBlocks.FIDDLE_FERN)
                .add(ShatteredBlocks.MOONDROP_FLOWER)
                .add(ShatteredBlocks.SPIDER_LILY)
                .add(ShatteredBlocks.DWARF_LAVENDER);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ShatteredBlocks.POTTED_MANABLOOM)
                .add(ShatteredBlocks.POTTED_FIDDLE_FERN)
                .add(ShatteredBlocks.POTTED_PEARLWOOD_SAPLING)
                .add(ShatteredBlocks.POTTED_ENCHANTED_WILLOW_SAPLING)
                .add(ShatteredBlocks.POTTED_SUNDROP_FLOWER)
                .add(ShatteredBlocks.POTTED_MOONDROP_FLOWER)
                .add(ShatteredBlocks.POTTED_SPIDER_LILY)
                .add(ShatteredBlocks.POTTED_DWARF_LAVENDER)
                .add(ShatteredBlocks.POTTED_ENCHANTED_BLUE_MUSHROOM)
                .add(ShatteredBlocks.POTTED_ENCHANTED_PINK_MUSHROOM);

        getOrCreateTagBuilder(DROOPING_WILLOW)
                .add(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES);
    }
}