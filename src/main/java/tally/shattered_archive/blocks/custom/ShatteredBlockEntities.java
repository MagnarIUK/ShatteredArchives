package tally.shattered_archive.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;

public class ShatteredBlockEntities {

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType.BlockEntityFactory<? extends T> entityFactory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, name, BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
    }

    public static void registerBEs() {
        ShatteredArchive.LOGGER.info("Registering Mod Block Entities for " + ShatteredArchive.MOD_ID);
    }
}
