package tally.shattered_archive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.items.ShatteredItems;

import java.util.concurrent.CompletableFuture;

public class ShatteredItemTagGen extends FabricTagProvider<Item> {
    public ShatteredItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> INK_SAND = of("ink_sand");
    public static final TagKey<Item> WITCH_DISCS = of("witch_discs");
    public static final TagKey<Item> WITHER_DISCS = of("wither_discs");
    public static final TagKey<Item> GUARDIAN_DISCS = of("guardian_discs");
    public static final TagKey<Item> PEARLWOOD_LOGS  = of("pearlwood_logs");
    public static final TagKey<Item> ENCHANTED_WILLOW_LOGS  = of("enchanted_willow_logs");
    public static final TagKey<Item> ARCTICITE_GLASS  = of("arcticite_glass");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(ShatteredArchive.MOD_ID, id));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ShatteredBlocks.MANABLOOM.asItem())
                .add(ShatteredBlocks.SUNDROP_FLOWER.asItem())
                .add(ShatteredBlocks.FIDDLE_FERN.asItem())
                .add(ShatteredBlocks.MOONDROP_FLOWER.asItem())
                .add(ShatteredBlocks.SPIDER_LILY.asItem())
                .add(ShatteredBlocks.DWARF_LAVENDER.asItem());
        getOrCreateTagBuilder(ARCTICITE_GLASS)
                .add(ShatteredBlocks.ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.RED_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.ORANGE_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.YELLOW_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.LIME_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.GREEN_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.CYAN_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.LIGHT_BLUE_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.BLUE_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.PURPLE_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.MAGENTA_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.PINK_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.BLACK_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.GRAY_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.LIGHT_GRAY_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.WHITE_STAINED_ARCTICITE_GLASS.asItem())
                .add(ShatteredBlocks.BROWN_STAINED_ARCTICITE_GLASS.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ShatteredBlocks.RED_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.ORANGE_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.YELLOW_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.LIME_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.GREEN_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.CYAN_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.BLUE_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.PURPLE_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.MAGENTA_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.PINK_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.BROWN_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.BLACK_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.GRAY_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.WHITE_HALLOW_LEAVES.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES.asItem())
                .add(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES.asItem());
        getOrCreateTagBuilder(PEARLWOOD_LOGS)
                .add(ShatteredBlocks.PEARLWOOD_LOG.asItem())
                .add(ShatteredBlocks.PEARLWOOD_WOOD.asItem())
                .add(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG.asItem())
                .add(ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD.asItem());
        getOrCreateTagBuilder(ENCHANTED_WILLOW_LOGS)
                .add(ShatteredBlocks.ENCHANTED_WILLOW_LOG.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_WOOD.asItem())
                .add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG.asItem())
                .add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS)
                .addTag(PEARLWOOD_LOGS)
                .addTag(ENCHANTED_WILLOW_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ShatteredBlocks.PEARLWOOD_PLANKS.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ShatteredBlocks.PEARLWOOD_STAIRS.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ShatteredBlocks.PEARLWOOD_TRAPDOOR.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ShatteredBlocks.PEARLWOOD_DOOR.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ShatteredBlocks.PEARLWOOD_SLAB.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ShatteredBlocks.PEARLWOOD_BUTTON.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ShatteredBlocks.PEARLWOOD_FENCE.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ShatteredBlocks.PEARLWOOD_FENCE_GATE.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ShatteredBlocks.PEARLWOOD_PRESSURE_PLATE.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ShatteredBlocks.PEARLWOOD_SAPLING.asItem())
                .add(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING.asItem());
        getOrCreateTagBuilder(WITHER_DISCS)
                .add(ShatteredItems.DECAY_MUSIC_DISC)
                .add(ShatteredItems.EMBERS_MUSIC_DISC)
                .add(ShatteredItems.SOUR_TASTE_MUSIC_DISC)
                .add(ShatteredItems.OMEN_MUSIC_DISC)
                .add(ShatteredItems.THE_WARRIOR_MUSIC_DISC)
                .add(ShatteredItems.SILLINESS_OVERLOAD_MUSIC_DISC)
                .add(ShatteredItems.RESIN_REQUIEM_MUSIC_DISC)
                .add(ShatteredItems.INFESTATION_MUSIC_DISC);
        getOrCreateTagBuilder(WITCH_DISCS)
                .add(ShatteredItems.RIFT_MUSIC_DISC)
                .add(ShatteredItems.MYCELIUM_DREAMS_MUSIC_DISC)
                .add(ShatteredItems.ANOMALOUS_CHILD_MUSIC_DISC)
                .add(ShatteredItems.IN_THE_INBETWEEN_MUSIC_DISC)
                .add(ShatteredItems.GLIMMERING_HOPE_MUSIC_DISC)
                .add(ShatteredItems.INSOMNIA_MUSIC_DISC)
                .add(ShatteredItems.GROVE_MUSIC_DISC)
                .add(ShatteredItems.LEMONADE_MUSIC_DISC)
                .add(ShatteredItems.AMBER_LEAF_MUSIC_DISC)
                .add(ShatteredItems.MYTHICAL_WORLDS_MUSIC_DISC)
                .add(ShatteredItems.CROW_MUSIC_DISC)
                .add(ShatteredItems.STARDUST_MUSIC_DISC);
        getOrCreateTagBuilder(GUARDIAN_DISCS)
                .add(ShatteredItems.AURORA_MUSIC_DISC)
                .add(ShatteredItems.NIGHT_TERRORS_MUSIC_DISC)
                .add(ShatteredItems.FLOW_MUSIC_DISC)
                .add(ShatteredItems.TIDEBORN_MUSIC_DISC)
                .add(ShatteredItems.BUBBLES_AND_PEARLS_MUSIC_DISC)
                .add(ShatteredItems.THE_CORE_MUSIC_DISC)
                .add(ShatteredItems.SILLY_NOTE_MUSIC_DISC)
                .add(ShatteredItems.SECTOR_0_DISC);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ShatteredBlocks.PEARLWOOD_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ShatteredBlocks.PEARLWOOD_LOG.asItem());
        getOrCreateTagBuilder(INK_SAND)
                .add(ShatteredBlocks.INK_SAND.asItem())
                .add(ShatteredBlocks.INK_SANDSTONE.asItem());
    }
}