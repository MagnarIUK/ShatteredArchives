package tally.shattered_archive;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import tally.shattered_archive.datagen.*;
import tally.shattered_archive.world.ShatteredConfiguredFeatures;
import tally.shattered_archive.world.ShatteredPlacedFeatures;
import tally.shattered_archive.world.biome.BiomeInit;
import tally.shattered_archive.world.biome.ShatteredBiomes;
import tally.shattered_archive.world.biome.ShatteredNetherRegion;

public class ShatteredArchiveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ShatteredModels::new);
		pack.addProvider(ShatteredLootTables::new);
		pack.addProvider(ModRegistryDatagen::new);
		pack.addProvider(ShatteredWorldGen::new);
		pack.addProvider(ShatteredLootTableProvider::new);
		pack.addProvider(ShatteredItemTagGen::new);
		pack.addProvider(ShatteredBlockTagGen::new);
		pack.addProvider(ShatteredRecipeGen::new);
		pack.addProvider(ShatteredAdvancementGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ShatteredConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ShatteredPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ShatteredBiomes::boostrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, BiomeInit::bootstrap);
	}
}