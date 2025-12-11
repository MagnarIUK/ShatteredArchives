package tally.shattered_archive;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.blocks.ShatteredBoat;
import tally.shattered_archive.commands.CommandHandler;
import tally.shattered_archive.items.ShatteredItems;
import tally.shattered_archive.particles.ShatteredParticles;
import tally.shattered_archive.sounds.ShatteredSounds;
import tally.shattered_archive.util.LootTableMods;
import tally.shattered_archive.world.ShatteredFeatures;
import tally.shattered_archive.world.biome.BiolithApi;
import tally.shattered_archive.world.decorators.ShatteredDecorators;
import tally.shattered_archive.world.foliage.ShatteredFoliagePlacers;
import tally.shattered_archive.world.trunk.ShatteredTrunkPlacers;

import java.util.ArrayList;

public class ShatteredArchive implements ModInitializer {
	public static final String MOD_ID = "shatteredarchive";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ShatteredSounds.registerSounds();
		ShatteredParticles.init();
		ShatteredBlocks.initialize();
		ShatteredItems.registerModItems();
		ShatteredBoat.load();

		ShatteredFeatures.initialize();

		ShatteredTrunkPlacers.register();
		ShatteredFoliagePlacers.register();
		ShatteredDecorators.register();
		CommandHandler.register();
		LootTableMods.modifyLootTables();
		SpawnRestriction.register(EntityType.BREEZE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

		FuelRegistry.INSTANCE.add(ShatteredItems.INKED_XANDRITE, 1000);


		StrippableBlockRegistry.register(ShatteredBlocks.PEARLWOOD_LOG, ShatteredBlocks.STRIPPED_PEARLWOOD_LOG);
		StrippableBlockRegistry.register(ShatteredBlocks.PEARLWOOD_WOOD, ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD);

		StrippableBlockRegistry.register(ShatteredBlocks.ENCHANTED_WILLOW_LOG, ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG);
		StrippableBlockRegistry.register(ShatteredBlocks.ENCHANTED_WILLOW_WOOD, ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD);

		new BiolithApi().run();
	}
}