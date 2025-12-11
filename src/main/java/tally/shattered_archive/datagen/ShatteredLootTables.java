package tally.shattered_archive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.items.ShatteredItems;

import java.util.concurrent.CompletableFuture;

public class ShatteredLootTables extends FabricBlockLootTableProvider {
    public ShatteredLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ShatteredBlocks.SOARE_AURORA_BLOCK);
        addDrop(ShatteredBlocks.LUNA_AURORA_BLOCK);

        addDropWithSilkTouch(ShatteredBlocks.ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.RED_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.ORANGE_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.YELLOW_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.LIME_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.GREEN_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.CYAN_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.BLUE_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.LIGHT_BLUE_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.PURPLE_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.MAGENTA_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.PINK_HALLOW_LEAVES);
        addDropWithSilkTouch(ShatteredBlocks.BLACK_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.GRAY_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.LIGHT_GRAY_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.WHITE_STAINED_ARCTICITE_GLASS);
        addDropWithSilkTouch(ShatteredBlocks.BROWN_STAINED_ARCTICITE_GLASS);

        addDrop(ShatteredBlocks.SOL_AURORA_BLOCK);
        addDrop(ShatteredBlocks.SOL_AURORA_CLUSTER);
        addDrop(ShatteredBlocks.LARGE_SOL_AURORA_BUD);
        addDrop(ShatteredBlocks.MEDIUM_SOL_AURORA_BUD);
        addDrop(ShatteredBlocks.SMALL_SOL_AURORA_BUD);

        addDrop(ShatteredBlocks.ECLIPSA_AURORA_BLOCK);
        
        addDrop(ShatteredBlocks.COCKATRICE_OF_THE_WOODS, ShatteredItems.COCKATRICE_OF_THE_WOODS_ITEM);

        addDrop(ShatteredBlocks.INK_SANDSTONE);
        addDrop(ShatteredBlocks.INK_SANDSTONE_SLAB);
        addDrop(ShatteredBlocks.CUT_INK_SANDSTONE_SLAB);
        addDrop(ShatteredBlocks.INK_SAND);
        addDrop(ShatteredBlocks.SMOOTH_INK_SANDSTONE_SLAB);
        addDrop(ShatteredBlocks.SMOOTH_INK_SANDSTONE);
        addDrop(ShatteredBlocks.SMOOTH_INK_SANDSTONE_STAIRS);
        addDrop(ShatteredBlocks.INK_SANDSTONE_STAIRS);
        addDrop(ShatteredBlocks.CHISELED_INK_SANDSTONE);

        addDrop(ShatteredBlocks.MOONDROP_FLOWER);
        addDrop(ShatteredBlocks.SUNDROP_FLOWER);

        addDrop(ShatteredBlocks.ARCTICITE_ORE, drops(ShatteredBlocks.ARCTICITE_ORE, ShatteredItems.ARCTICITE_SHARD));

        addDrop(ShatteredBlocks.INKED_XANDRITE_BLOCK, drops(ShatteredBlocks.INKED_XANDRITE_BLOCK, ShatteredItems.INKED_XANDRITE));
        addDrop(ShatteredBlocks.FROSTED_CALCITE);

        addDrop(ShatteredBlocks.PEARLWOOD_SAPLING);
        addDrop(ShatteredBlocks.PEARLWOOD_PLANKS);
        addDrop(ShatteredBlocks.PEARLWOOD_LOG);
        addDrop(ShatteredBlocks.PEARLWOOD_WOOD);
        addDrop(ShatteredBlocks.PEARLWOOD_BUTTON);
        addDrop(ShatteredBlocks.PEARLWOOD_DOOR, doorDrops(ShatteredBlocks.PEARLWOOD_DOOR));
        addDrop(ShatteredBlocks.PEARLWOOD_FENCE);
        addDrop(ShatteredBlocks.PEARLWOOD_FENCE_GATE);
        addDrop(ShatteredBlocks.PEARLWOOD_PRESSURE_PLATE);
        addDrop(ShatteredBlocks.PEARLWOOD_TRAPDOOR);
        addDrop(ShatteredBlocks.PEARLWOOD_STAIRS);
        addDrop(ShatteredBlocks.PEARLWOOD_SIGN);
        addDrop(ShatteredBlocks.PEARLWOOD_WALL_SIGN, ShatteredItems.PEARLWOOD_SIGN);
        addDrop(ShatteredBlocks.PEARLWOOD_HANGING_SIGN);
        addDrop(ShatteredBlocks.PEARLWOOD_WALL_HANGING_SIGN, ShatteredItems.PEARLWOOD_HANGING_SIGN);
        addDrop(ShatteredBlocks.PEARLWOOD_SLAB);
        addDrop(ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD);
        addDrop(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG);

        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_LOG);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_WOOD);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_BUTTON);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_DOOR, doorDrops(ShatteredBlocks.ENCHANTED_WILLOW_DOOR));
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_FENCE);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_FENCE_GATE);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_PRESSURE_PLATE);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_STAIRS);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_SIGN);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_WALL_SIGN, ShatteredItems.ENCHANTED_WILLOW_SIGN);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_HANGING_SIGN);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_WALL_HANGING_SIGN, ShatteredItems.ENCHANTED_WILLOW_HANGING_SIGN);
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_SLAB);
        addDrop(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD);
        addDrop(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG);
        addDrop(ShatteredBlocks.FIDDLE_FERN);
        addDrop(ShatteredBlocks.MANABLOOM);
        addDrop(ShatteredBlocks.SPIDER_LILY);
        addDrop(ShatteredBlocks.DWARF_LAVENDER);
        addDrop(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM);
        addDrop(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM_BLOCK, mushroomBlockDrops(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM_BLOCK, ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM));

        addDrop(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM);
        addDrop(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM_BLOCK, mushroomBlockDrops(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM_BLOCK, ShatteredBlocks.ENCHANTED_PINK_MUSHROOM));

        addDrop(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES, dropsWithShears(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES));
        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES, dropsWithShears(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES));
        
        addDropWithSilkTouch(ShatteredBlocks.BLOOD_ICE);

        this.addDrop(ShatteredBlocks.BLOOD_STAINED_SNOW_BLOCK, block -> this.drops(block, Items.SNOWBALL, ConstantLootNumberProvider.create(4.0F)));

        addDrop(
                ShatteredBlocks.BLOOD_STAINED_SNOW,
                block -> LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
                                        .with(
                                                AlternativeEntry.builder(
                                                        AlternativeEntry.builder(
                                                                SnowBlock.LAYERS.getValues(),
                                                                integer -> integer == 8
                                                                        ? ItemEntry.builder(ShatteredBlocks.BLOOD_STAINED_SNOW_BLOCK)
                                                                        : ItemEntry.builder(ShatteredBlocks.BLOOD_STAINED_SNOW)
                                                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(integer.intValue())))
                                                                        .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, integer)))
                                                        ).conditionally(createSilkTouchCondition())
                                                )
                                        )
                        )
        );

        addPottedPlantDrops(ShatteredBlocks.POTTED_SUNDROP_FLOWER);
        addPottedPlantDrops(ShatteredBlocks.POTTED_MOONDROP_FLOWER);
        addPottedPlantDrops(ShatteredBlocks.POTTED_PEARLWOOD_SAPLING);
        addPottedPlantDrops(ShatteredBlocks.POTTED_ENCHANTED_WILLOW_SAPLING);
        addPottedPlantDrops(ShatteredBlocks.POTTED_MANABLOOM);
        addPottedPlantDrops(ShatteredBlocks.POTTED_ENCHANTED_BLUE_MUSHROOM);
        addPottedPlantDrops(ShatteredBlocks.POTTED_FIDDLE_FERN);
        addPottedPlantDrops(ShatteredBlocks.POTTED_SPIDER_LILY);
        addPottedPlantDrops(ShatteredBlocks.POTTED_DWARF_LAVENDER);

        addDrop(ShatteredBlocks.RED_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.RED_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.ORANGE_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.ORANGE_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.YELLOW_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.YELLOW_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.LIME_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.LIME_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.GREEN_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.GREEN_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.CYAN_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.CYAN_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.BLUE_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.BLUE_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.PURPLE_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.PURPLE_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.MAGENTA_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.MAGENTA_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.PINK_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.PINK_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.BLACK_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.BLACK_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.GRAY_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.GRAY_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.WHITE_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.WHITE_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.BROWN_HALLOW_LEAVES, leavesDrops(ShatteredBlocks.BROWN_HALLOW_LEAVES, ShatteredBlocks.PEARLWOOD_SAPLING, 0.07f));

        addDrop(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES, leavesDrops(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES, ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES, leavesDrops(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES, ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, 0.07f));

        addDrop(ShatteredBlocks.GLOWING_ENCHANTED_WILLOW_LEAVES, leavesDrops(ShatteredBlocks.GLOWING_ENCHANTED_WILLOW_LEAVES, ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, 0.07f));
        addDrop(ShatteredBlocks.GLOWING_BLUE_ENCHANTED_WILLOW_LEAVES, leavesDrops(ShatteredBlocks.GLOWING_BLUE_ENCHANTED_WILLOW_LEAVES, ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, 0.07f));
    }
}
