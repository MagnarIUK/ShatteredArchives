package tally.shattered_archive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.blocks.helpers.ModBlockProperties;
import tally.shattered_archive.items.ShatteredItems;

import java.util.Optional;

public class ShatteredModels extends FabricModelProvider {
    public ShatteredModels(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ShatteredBlocks.COCKATRICE_OF_THE_WOODS);

        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.MANABLOOM, ShatteredBlocks.POTTED_MANABLOOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM, ShatteredBlocks.POTTED_ENCHANTED_PINK_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM, ShatteredBlocks.POTTED_ENCHANTED_BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.FIDDLE_FERN, ShatteredBlocks.POTTED_FIDDLE_FERN, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.SPIDER_LILY, ShatteredBlocks.POTTED_SPIDER_LILY, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.DWARF_LAVENDER, ShatteredBlocks.POTTED_DWARF_LAVENDER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerMushroomBlock(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM_BLOCK);
        blockStateModelGenerator.registerMushroomBlock(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM_BLOCK);

        registerAuroraCluster(blockStateModelGenerator, ShatteredBlocks.SOL_AURORA_CLUSTER, "aurora_cluster");
        registerAuroraCluster(blockStateModelGenerator, ShatteredBlocks.LARGE_SOL_AURORA_BUD, "large_aurora_bud");
        registerAuroraCluster(blockStateModelGenerator, ShatteredBlocks.MEDIUM_SOL_AURORA_BUD, "medium_aurora_bud");
        registerAuroraCluster(blockStateModelGenerator, ShatteredBlocks.SMALL_SOL_AURORA_BUD, "small_aurora_bud");
        blockStateModelGenerator.registerRandomHorizontalRotations(TexturedModel.CUBE_ALL, ShatteredBlocks.INK_SAND);
        blockStateModelGenerator.registerLog(ShatteredBlocks.PEARLWOOD_LOG).log(ShatteredBlocks.PEARLWOOD_LOG).wood(ShatteredBlocks.PEARLWOOD_WOOD);
        blockStateModelGenerator.registerLog(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG).log(ShatteredBlocks.STRIPPED_PEARLWOOD_LOG).wood(ShatteredBlocks.STRIPPED_PEARLWOOD_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ShatteredBlocks.PEARLWOOD_PLANKS).family(new BlockFamily.Builder(ShatteredBlocks.PEARLWOOD_PLANKS).build()).fence(ShatteredBlocks.PEARLWOOD_FENCE).fenceGate(ShatteredBlocks.PEARLWOOD_FENCE_GATE).slab(ShatteredBlocks.PEARLWOOD_SLAB).stairs(ShatteredBlocks.PEARLWOOD_STAIRS).pressurePlate(ShatteredBlocks.PEARLWOOD_PRESSURE_PLATE).button(ShatteredBlocks.PEARLWOOD_BUTTON);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.PEARLWOOD_SAPLING, ShatteredBlocks.POTTED_PEARLWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoor(ShatteredBlocks.PEARLWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ShatteredBlocks.PEARLWOOD_TRAPDOOR);

        blockStateModelGenerator.registerLog(ShatteredBlocks.ENCHANTED_WILLOW_LOG).log(ShatteredBlocks.ENCHANTED_WILLOW_LOG).wood(ShatteredBlocks.ENCHANTED_WILLOW_WOOD);
        blockStateModelGenerator.registerLog(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG).log(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_LOG).wood(ShatteredBlocks.STRIPPED_ENCHANTED_WILLOW_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS).family(new BlockFamily.Builder(ShatteredBlocks.ENCHANTED_WILLOW_PLANKS).build()).fence(ShatteredBlocks.ENCHANTED_WILLOW_FENCE).fenceGate(ShatteredBlocks.ENCHANTED_WILLOW_FENCE_GATE).slab(ShatteredBlocks.ENCHANTED_WILLOW_SLAB).stairs(ShatteredBlocks.ENCHANTED_WILLOW_STAIRS).pressurePlate(ShatteredBlocks.ENCHANTED_WILLOW_PRESSURE_PLATE).button(ShatteredBlocks.ENCHANTED_WILLOW_BUTTON);
        blockStateModelGenerator.registerFlowerPotPlant(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, ShatteredBlocks.POTTED_ENCHANTED_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoor(ShatteredBlocks.ENCHANTED_WILLOW_DOOR);
        blockStateModelGenerator.registerTrapdoor(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.ENCHANTED_WILLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_LEAVES);

        blockStateModelGenerator.registerSimpleState(ShatteredBlocks.GLOWING_ENCHANTED_WILLOW_LEAVES);
        blockStateModelGenerator.registerSimpleState(ShatteredBlocks.GLOWING_BLUE_ENCHANTED_WILLOW_LEAVES);

        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.ARCTICITE_GLASS, "base");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.RED_STAINED_ARCTICITE_GLASS, "red");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.ORANGE_STAINED_ARCTICITE_GLASS, "orange");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.YELLOW_STAINED_ARCTICITE_GLASS, "yellow");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.LIME_STAINED_ARCTICITE_GLASS, "lime");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.GREEN_STAINED_ARCTICITE_GLASS, "green");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.CYAN_STAINED_ARCTICITE_GLASS, "cyan");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.LIGHT_BLUE_STAINED_ARCTICITE_GLASS, "light_blue");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.BLUE_STAINED_ARCTICITE_GLASS, "blue");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.PURPLE_STAINED_ARCTICITE_GLASS, "purple");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.MAGENTA_STAINED_ARCTICITE_GLASS, "magenta");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.PINK_STAINED_ARCTICITE_GLASS, "pink");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.WHITE_STAINED_ARCTICITE_GLASS, "white");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.LIGHT_GRAY_STAINED_ARCTICITE_GLASS, "light_gray");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.GRAY_STAINED_ARCTICITE_GLASS, "gray");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.BLACK_STAINED_ARCTICITE_GLASS, "black");
        registerArcticGlass(blockStateModelGenerator, ShatteredBlocks.BROWN_STAINED_ARCTICITE_GLASS, "brown");

        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.INKED_XANDRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.FROSTED_CALCITE);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.ARCTICITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.RED_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.ORANGE_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.YELLOW_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.LIME_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.GREEN_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.CYAN_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.LIGHT_BLUE_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.BLUE_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.PURPLE_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.MAGENTA_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.PINK_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.BLACK_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.GRAY_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.LIGHT_GRAY_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.WHITE_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.BROWN_HALLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ShatteredBlocks.BLOOD_ICE);
        registerDroopingLeaves(blockStateModelGenerator, ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES);
        registerDroopingLeaves(blockStateModelGenerator, ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES);
        registerSnows(blockStateModelGenerator);
    }

    public static void registerArcticGlass(BlockStateModelGenerator blockStateModelGenerator, Block block, String base) {
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(ModBlockProperties.OPAQUE).register(opaque -> {
            String string = "shatteredarchive:block/arctic/" + base + "_" + opaque;
            String stringb = "_" + opaque;
            Identifier identifier = Identifier.of(string);
            return BlockStateVariant.create().put(VariantSettings.MODEL, Models.CUBE_ALL.upload(block, stringb, new TextureMap().put(TextureKey.ALL, identifier), blockStateModelGenerator.modelCollector));
        })));
        blockStateModelGenerator.registerParentedItemModel(block, TextureMap.getSubId(block, "_0"));
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(ShatteredArchive.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static final Model HANGING_CROSS = block("hanging_cross", TextureKey.TEXTURE);
    public static final TexturedModel.Factory DROOPING_LEAVES = TexturedModel.makeFactory(TextureMap::texture, HANGING_CROSS);

    public void registerDroopingLeaves(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        blockStateModelGenerator.registerSingleton(block, DROOPING_LEAVES);
    }

    public final void registerAuroraCluster(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(block);
        Identifier identifier = BlockStateModelGenerator.TintType.TINTED.getCrossModel().upload(block, TextureMap.of(TextureKey.CROSS, Identifier.of("shatteredarchive:block/" + texture)), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(
                                        block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)
                                )
                                .coordinate(blockStateModelGenerator.createUpDefaultFacingVariantMap())
                );
    }

    private void registerSnows(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = TextureMap.all(ShatteredBlocks.BLOOD_STAINED_SNOW);
        Identifier identifier = Models.CUBE_ALL.upload(ShatteredBlocks.BLOOD_STAINED_SNOW_BLOCK, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(ShatteredBlocks.BLOOD_STAINED_SNOW)
                                .coordinate(
                                        BlockStateVariantMap.create(Properties.LAYERS)
                                                .register(
                                                        height -> BlockStateVariant.create()
                                                                .put(VariantSettings.MODEL, height < 8 ? ModelIds.getBlockSubModelId(ShatteredBlocks.BLOOD_STAINED_SNOW, "_height" + height * 2) : identifier)
                                                )
                                )
                );
        blockStateModelGenerator.registerParentedItemModel(ShatteredBlocks.BLOOD_STAINED_SNOW, ModelIds.getBlockSubModelId(ShatteredBlocks.BLOOD_STAINED_SNOW, "_height2"));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(ShatteredBlocks.BLOOD_STAINED_SNOW_BLOCK, identifier));
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.SOL_AURORA_CLUSTER.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/aurora_cluster")), itemModelGenerator.writer);
        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.LARGE_SOL_AURORA_BUD.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/large_aurora_bud")), itemModelGenerator.writer);
        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.MEDIUM_SOL_AURORA_BUD.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/medium_aurora_bud")), itemModelGenerator.writer);
        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.SMALL_SOL_AURORA_BUD.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/small_aurora_bud")), itemModelGenerator.writer);

        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/hanging_willow")), itemModelGenerator.writer);
        Models.GENERATED.upload(ModelIds.getItemModelId(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES.asItem()), TextureMap.layer0(Identifier.of("shatteredarchive:block/blue_hanging_willow")), itemModelGenerator.writer);

        itemModelGenerator.register(ShatteredItems.LEMONADE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.PEARLWOOD_BOAT, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.PEARLWOOD_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.PEARLWOOD_SIGN, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.PEARLWOOD_HANGING_SIGN, Models.GENERATED);

        itemModelGenerator.register(ShatteredItems.INKED_XANDRITE, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ARCTICITE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.GLASS_CUTTER, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ENCHANTED_WILLOW_BOAT, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ENCHANTED_WILLOW_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ENCHANTED_WILLOW_SIGN, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ENCHANTED_WILLOW_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.INSOMNIA_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.AMBER_LEAF_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.MYTHICAL_WORLDS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.THE_CORE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.THE_WARRIOR_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.EMBERS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.ANOMALOUS_CHILD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.BUBBLES_AND_PEARLS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.IN_THE_INBETWEEN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.NIGHT_TERRORS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.RESIN_REQUIEM_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.SECTOR_0_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.STARDUST_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.AURORA_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.CROW_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.DECAY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.FLOW_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.GLIMMERING_HOPE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.GROVE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.MYCELIUM_DREAMS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.OMEN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.RIFT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.SILLINESS_OVERLOAD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.SILLY_NOTE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.SOUR_TASTE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.TIDEBORN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShatteredItems.INFESTATION_MUSIC_DISC, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "FabricDocsReference Model Provider";
    }
}

