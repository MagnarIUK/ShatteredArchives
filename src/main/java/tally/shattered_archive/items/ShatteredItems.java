package tally.shattered_archive.items;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.blocks.ShatteredBoat;
import tally.shattered_archive.sounds.ShatteredSounds;

public class ShatteredItems {
    public static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ShatteredArchive.MOD_ID, "item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ShatteredItems.MYTHICAL_WORLDS_MUSIC_DISC))
            .displayName(Text.translatable("itemGroup.shatteredarchives"))
            .build();

    public static final Item LEMONADE_MUSIC_DISC = registerItem("lemonade_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.LEMONADE_KEY).maxCount(1)));
    public static final Item THE_CORE_MUSIC_DISC = registerItem("the_core_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.THE_CORE_KEY).maxCount(1)));
    public static final Item THE_WARRIOR_MUSIC_DISC = registerItem("the_warrior_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.THE_WARRIOR_KEY).maxCount(1)));
    public static final Item AMBER_LEAF_MUSIC_DISC = registerItem("amber_leaf_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.AMBER_LEAF_KEY).maxCount(1)));
    public static final Item INSOMNIA_MUSIC_DISC = registerItem("insomnia_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.INSOMNIA_KEY).maxCount(1)));
    public static final Item MYTHICAL_WORLDS_MUSIC_DISC = registerItem("mythical_worlds_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.MYTHICAL_WORLDS_KEY).maxCount(1)));
    public static final Item EMBERS_MUSIC_DISC = registerItem("embers_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.EMBERS_KEY).maxCount(1)));
    public static final Item ANOMALOUS_CHILD_MUSIC_DISC = registerItem("anomalous_child_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.ANOMALOUS_CHILD_KEY).maxCount(1)));
    public static final Item BUBBLES_AND_PEARLS_MUSIC_DISC = registerItem("bubbles_and_pearls_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.BUBBLES_AND_PEARLS_KEY).maxCount(1)));
    public static final Item IN_THE_INBETWEEN_MUSIC_DISC = registerItem("in_the_inbetween_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.IN_THE_INBETWEEN_KEY).maxCount(1)));
    public static final Item NIGHT_TERRORS_MUSIC_DISC = registerItem("night_terrors_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.NIGHT_TERRORS_KEY).maxCount(1)));
    public static final Item RESIN_REQUIEM_MUSIC_DISC = registerItem("resin_requiem_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.RESIN_REQUIEM_KEY).maxCount(1)));
    public static final Item SECTOR_0_DISC = registerItem("sector_0_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.SECTOR_0_KEY).maxCount(1)));
    public static final Item STARDUST_MUSIC_DISC = registerItem("stardust_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.STARDUST_KEY).maxCount(1)));
    public static final Item AURORA_MUSIC_DISC = registerItem("aurora_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.AURORA_KEY).maxCount(1)));
    public static final Item CROW_MUSIC_DISC = registerItem("crow_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.CROW_KEY).maxCount(1)));
    public static final Item DECAY_MUSIC_DISC = registerItem("decay_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.DECAY_KEY).maxCount(1)));
    public static final Item FLOW_MUSIC_DISC = registerItem("flow_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.FLOW_KEY).maxCount(1)));
    public static final Item GLIMMERING_HOPE_MUSIC_DISC = registerItem("glimmering_hope_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.GLIMMERING_HOPE_KEY).maxCount(1)));
    public static final Item GROVE_MUSIC_DISC = registerItem("grove_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.GROVE_KEY).maxCount(1)));
    public static final Item MYCELIUM_DREAMS_MUSIC_DISC = registerItem("mycelium_dreams_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.MYCELIUM_DREAMS_KEY).maxCount(1)));
    public static final Item OMEN_MUSIC_DISC = registerItem("omen_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.OMEN_KEY).maxCount(1)));
    public static final Item RIFT_MUSIC_DISC = registerItem("rift_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.RIFT_KEY).maxCount(1)));
    public static final Item SILLINESS_OVERLOAD_MUSIC_DISC = registerItem("silliness_overload_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.SILLINESS_OVERLOAD_KEY).maxCount(1)));
    public static final Item SILLY_NOTE_MUSIC_DISC = registerItem("silly_note_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.SILLY_NOTE_KEY).maxCount(1)));
    public static final Item SOUR_TASTE_MUSIC_DISC = registerItem("sour_taste_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.SOUR_TASTE_KEY).maxCount(1)));
    public static final Item TIDEBORN_MUSIC_DISC = registerItem("tideborn_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.TIDEBORN_KEY).maxCount(1)));
    public static final Item INFESTATION_MUSIC_DISC = registerItem("infestation_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ShatteredSounds.INFESTATION_KEY).maxCount(1)));

    public static final FoodComponent COCKATRICE_COMPONENT = new FoodComponent.Builder()
            .snack()
            .nutrition(3)
            .saturationModifier(2f)
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 6 * 20, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6 * 20, 1), 0.5f)
            .build();

    public static final Item COCKATRICE_OF_THE_WOODS_ITEM = registerItem("cockatrice_of_the_woods", (Item)new AliasedBlockItem(ShatteredBlocks.COCKATRICE_OF_THE_WOODS, new Item.Settings().food(COCKATRICE_COMPONENT)));

    public static final Item PEARLWOOD_SIGN = registerItem("pearlwood_sign",
            new SignItem(new Item.Settings().maxCount(16), ShatteredBlocks.PEARLWOOD_SIGN, ShatteredBlocks.PEARLWOOD_WALL_SIGN));

    public static final Item PEARLWOOD_HANGING_SIGN = registerItem("pearlwood_hanging_sign",
            new HangingSignItem(ShatteredBlocks.PEARLWOOD_HANGING_SIGN, ShatteredBlocks.PEARLWOOD_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item PEARLWOOD_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ShatteredBoat.PEARLWOOD_BOAT_ID, ShatteredBoat.PEARLWOOD_BOAT_KEY, false);

    public static final Item PEARLWOOD_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ShatteredBoat.PEARLWOOD_CHEST_BOAT_ID, ShatteredBoat.PEARLWOOD_BOAT_KEY, true);

    public static final Item ENCHANTED_WILLOW_SIGN = registerItem("enchanted_willow_sign",
            new SignItem(new Item.Settings().maxCount(16), ShatteredBlocks.ENCHANTED_WILLOW_SIGN, ShatteredBlocks.ENCHANTED_WILLOW_WALL_SIGN));

    public static final Item ENCHANTED_WILLOW_HANGING_SIGN = registerItem("enchanted_willow_hanging_sign",
            new HangingSignItem(ShatteredBlocks.ENCHANTED_WILLOW_HANGING_SIGN, ShatteredBlocks.ENCHANTED_WILLOW_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item ENCHANTED_WILLOW_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ShatteredBoat.ENCHANTED_WILLOW_BOAT_ID, ShatteredBoat.ENCHANTED_WILLOW_BOAT_KEY, false);

    public static final Item ENCHANTED_WILLOW_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ShatteredBoat.ENCHANTED_WILLOW_CHEST_BOAT_ID, ShatteredBoat.ENCHANTED_WILLOW_BOAT_KEY, true);

    public static final Item INKED_XANDRITE = registerItem("inked_xandrite", new Item(new Item.Settings()));
    public static final Item ARCTICITE_SHARD = registerItem("arcticite_shard", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ShatteredArchive.MOD_ID, name), item);
    }

    public static final ItemGroup MAIN_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);

    public static void registerModItems() {
        ShatteredArchive.LOGGER.info("Registering Mod Items for " + ShatteredArchive.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(INKED_XANDRITE);
            itemGroup.add(ARCTICITE_SHARD);
            itemGroup.add(ShatteredBlocks.INKED_XANDRITE_BLOCK);
            itemGroup.add(ShatteredBlocks.FROSTED_CALCITE);
            itemGroup.add(ShatteredBlocks.ARCTICITE_ORE);

            itemGroup.add(ShatteredItems.MYTHICAL_WORLDS_MUSIC_DISC);
            itemGroup.add(ShatteredItems.AMBER_LEAF_MUSIC_DISC);
            itemGroup.add(ShatteredItems.EMBERS_MUSIC_DISC);
            itemGroup.add(ShatteredItems.INSOMNIA_MUSIC_DISC);
            itemGroup.add(ShatteredItems.THE_CORE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.THE_WARRIOR_MUSIC_DISC);
            itemGroup.add(ShatteredItems.LEMONADE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.RESIN_REQUIEM_MUSIC_DISC);
            itemGroup.add(ShatteredItems.SECTOR_0_DISC);
            itemGroup.add(ShatteredItems.ANOMALOUS_CHILD_MUSIC_DISC);
            itemGroup.add(ShatteredItems.BUBBLES_AND_PEARLS_MUSIC_DISC);
            itemGroup.add(ShatteredItems.IN_THE_INBETWEEN_MUSIC_DISC);
            itemGroup.add(ShatteredItems.STARDUST_MUSIC_DISC);
            itemGroup.add(ShatteredItems.NIGHT_TERRORS_MUSIC_DISC);
            itemGroup.add(ShatteredItems.AURORA_MUSIC_DISC);
            itemGroup.add(ShatteredItems.CROW_MUSIC_DISC);
            itemGroup.add(ShatteredItems.DECAY_MUSIC_DISC);
            itemGroup.add(ShatteredItems.FLOW_MUSIC_DISC);
            itemGroup.add(ShatteredItems.GLIMMERING_HOPE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.GROVE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.MYCELIUM_DREAMS_MUSIC_DISC);
            itemGroup.add(ShatteredItems.OMEN_MUSIC_DISC);
            itemGroup.add(ShatteredItems.RIFT_MUSIC_DISC);
            itemGroup.add(ShatteredItems.SILLINESS_OVERLOAD_MUSIC_DISC);
            itemGroup.add(ShatteredItems.SILLY_NOTE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.SOUR_TASTE_MUSIC_DISC);
            itemGroup.add(ShatteredItems.TIDEBORN_MUSIC_DISC);
            itemGroup.add(ShatteredItems.INFESTATION_MUSIC_DISC);
            itemGroup.add(ShatteredBlocks.SUNDROP_FLOWER);
            itemGroup.add(ShatteredBlocks.MOONDROP_FLOWER);
            itemGroup.add(ShatteredBlocks.MANABLOOM);
            itemGroup.add(ShatteredBlocks.FIDDLE_FERN);
            itemGroup.add(ShatteredBlocks.SPIDER_LILY);
            itemGroup.add(ShatteredBlocks.DWARF_LAVENDER);
            itemGroup.add(ShatteredBlocks.SMOKE_STACK);
            itemGroup.add(ShatteredBlocks.INK_SAND);
            itemGroup.add(ShatteredBlocks.INK_SANDSTONE);
            itemGroup.add(ShatteredBlocks.CHISELED_INK_SANDSTONE);
            itemGroup.add(ShatteredBlocks.CUT_INK_SANDSTONE);
            itemGroup.add(ShatteredBlocks.CUT_INK_SANDSTONE_SLAB);
            itemGroup.add(ShatteredBlocks.INK_SANDSTONE_STAIRS);
            itemGroup.add(ShatteredBlocks.INK_SANDSTONE_SLAB);
            itemGroup.add(ShatteredBlocks.INK_SANDSTONE_WALL);
            itemGroup.add(ShatteredBlocks.SMOOTH_INK_SANDSTONE);
            itemGroup.add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_STAIRS);
            itemGroup.add(ShatteredBlocks.SMOOTH_INK_SANDSTONE_SLAB);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_LOG);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_WOOD);
            itemGroup.add(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG);
            itemGroup.add(ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_WOOD);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_PLANKS);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_STAIRS);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_SLAB);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_FENCE);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_FENCE_GATE);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_DOOR);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_TRAPDOOR);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_PRESSURE_PLATE);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_BUTTON);
            itemGroup.add(ShatteredItems.PEARLWOOD_SIGN);
            itemGroup.add(ShatteredItems.PEARLWOOD_HANGING_SIGN);
            itemGroup.add(ShatteredItems.PEARLWOOD_BOAT);
            itemGroup.add(ShatteredItems.PEARLWOOD_CHEST_BOAT);
            itemGroup.add(ShatteredBlocks.WHITE_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.GRAY_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.BLACK_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.BROWN_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.RED_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.ORANGE_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.YELLOW_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.LIME_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.GREEN_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.CYAN_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.BLUE_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.PURPLE_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.MAGENTA_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.PINK_HALLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.PEARLWOOD_SAPLING);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_LOG);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_WOOD);
            itemGroup.add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG);
            itemGroup.add(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_WOOD);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_STAIRS);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_SLAB);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_FENCE_GATE);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_DOOR);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_PRESSURE_PLATE);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_BUTTON);
            itemGroup.add(ShatteredItems.ENCHANTED_WILLOW_SIGN);
            itemGroup.add(ShatteredItems.ENCHANTED_WILLOW_HANGING_SIGN);
            itemGroup.add(ShatteredItems.ENCHANTED_WILLOW_BOAT);
            itemGroup.add(ShatteredItems.ENCHANTED_WILLOW_CHEST_BOAT);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES);
            itemGroup.add(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES);
            itemGroup.add(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES);
            itemGroup.add(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING);
            itemGroup.add(ShatteredBlocks.ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.RED_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.ORANGE_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.YELLOW_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.LIME_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.GREEN_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.CYAN_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.LIGHT_BLUE_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.BLUE_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.PURPLE_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.MAGENTA_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.PINK_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.WHITE_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.LIGHT_GRAY_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.GRAY_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.BLACK_STAINED_ARCTICITE_GLASS);
            itemGroup.add(ShatteredBlocks.BROWN_STAINED_ARCTICITE_GLASS);
        });
    }
}
