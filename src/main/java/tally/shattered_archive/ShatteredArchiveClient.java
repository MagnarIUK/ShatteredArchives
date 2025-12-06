package tally.shattered_archive;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.biome.GrassColors;
import org.jetbrains.annotations.Nullable;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.blocks.ShatteredBoat;
import tally.shattered_archive.blocks.custom.ShatteredBlockEntities;
import tally.shattered_archive.particles.ShatteredParticles;
import tally.shattered_archive.particles.custom.SmokeParticle;
import tally.shattered_archive.particles.custom.SmokeParticleType;
import tally.shattered_archive.particles.custom.WillowParticle;

public class ShatteredArchiveClient implements ClientModInitializer {

    public static final Vec3i[] SOARE_COLORS;
    public static final Vec3i[] SOL_COLORS;
    public static final Vec3i[] LUNA_COLORS;
    public static final Vec3i[] ECLIPSA_COLORS;

    static {
        SOARE_COLORS = new Vec3i[]{
                new Vec3i(220,20,60),
                new Vec3i(255,127,80),
                new Vec3i(255,250,205),
                new Vec3i(255,250,250)
        };
        SOL_COLORS = new Vec3i[]{
                new Vec3i(247, 77, 161),
                new Vec3i(120, 184, 255),
                new Vec3i(120, 255, 168),
                new Vec3i(243, 58, 255)
        };
        LUNA_COLORS = new Vec3i[]{
                new Vec3i(153,50,204),
                new Vec3i(0,0,128),
                new Vec3i(32,178,170),
                new Vec3i(169,169,169)
        };
        ECLIPSA_COLORS = new Vec3i[]{
                new Vec3i(255,0,0),
                new Vec3i(255,0,255),
                new Vec3i(30,30,30),
                new Vec3i(255,165,0)
        };
    }

    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ShatteredParticles.SMOKE_PARTICLE, Factory::new);
        ParticleFactoryRegistry.getInstance().register(ShatteredParticles.WILLOW_LEAVES, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new WillowParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(ShatteredParticles.BLUE_WILLOW_LEAVES, (FabricSpriteProvider spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new WillowParticle(world, x, y, z, spriteProvider));
        ParticleFactoryRegistry.getInstance().register(ShatteredParticles.SMOKE_PARTICLE_SIMPLE, SmokeParticle.SmokeParticleFactory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.COCKATRICE_OF_THE_WOODS, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.BLUE_ENCHANTED_WILLOW_DROOPING_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_WILLOW_DROOPING_LEAVES, RenderLayer.getCutoutMipped());

        TerraformBoatClientHelper.registerModelLayers(ShatteredBoat.PEARLWOOD_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ShatteredBoat.ENCHANTED_WILLOW_BOAT_ID, false);

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SOARE_AURORA_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.LUNA_AURORA_BLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ARCTICITE_GLASS, RenderLayer.getTranslucent());
        
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.RED_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.WHITE_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.GRAY_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.LIGHT_GRAY_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.BLACK_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.BROWN_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ORANGE_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.YELLOW_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.LIME_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.GREEN_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.CYAN_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.BLUE_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.LIGHT_BLUE_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.PURPLE_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.MAGENTA_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.PINK_STAINED_ARCTICITE_GLASS, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.BLOOD_ICE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SOL_AURORA_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SOL_AURORA_CLUSTER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.LARGE_SOL_AURORA_BUD, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.MEDIUM_SOL_AURORA_BUD, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SMALL_SOL_AURORA_BUD, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SUNDROP_FLOWER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.MOONDROP_FLOWER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.FIDDLE_FERN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.MANABLOOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.SPIDER_LILY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.DWARF_LAVENDER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_BLUE_MUSHROOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_PINK_MUSHROOM, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_MOONDROP_FLOWER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_PEARLWOOD_SAPLING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_ENCHANTED_WILLOW_SAPLING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_SUNDROP_FLOWER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_FIDDLE_FERN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_MANABLOOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_DWARF_LAVENDER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_SPIDER_LILY, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_ENCHANTED_BLUE_MUSHROOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.POTTED_ENCHANTED_PINK_MUSHROOM, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_WILLOW_SAPLING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_WILLOW_DOOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ENCHANTED_WILLOW_TRAPDOOR, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.PEARLWOOD_SAPLING, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.PEARLWOOD_DOOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.PEARLWOOD_TRAPDOOR, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ShatteredBlocks.ECLIPSA_AURORA_BLOCK, RenderLayer.getTranslucent());

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor()), ShatteredBlocks.FIDDLE_FERN, ShatteredBlocks.POTTED_FIDDLE_FERN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getDefaultColor(), ShatteredBlocks.FIDDLE_FERN.asItem());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (pos == null) {
                pos = (BlockPos) BlockPos.ZERO;
            }

            long i = (long) pos.getX() + (long) pos.getY() + (long) pos.getZ();
            double delta = i * 0.1;
            int index = MathHelper.floor(delta);
            int index2 = (index + 1) & 3;
            delta -= index;
            index &= 3;

            Vec3i color1 = SOARE_COLORS[index];
            Vec3i color2 = SOARE_COLORS[index2];

            int r = MathHelper.floor(MathHelper.lerp(delta, color1.getX(), color2.getX()));
            int g = MathHelper.floor(MathHelper.lerp(delta, color1.getY(), color2.getY()));
            int b = MathHelper.floor(MathHelper.lerp(delta, color1.getZ(), color2.getZ()));

            return Integer.decode(String.format("#%02X%02X%02X", r, g, b));
        }, ShatteredBlocks.SOARE_AURORA_BLOCK);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> Integer.decode(String.format("#%02X%02X%02X", 255,127,80)), ShatteredBlocks.SOARE_AURORA_BLOCK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (pos == null) {
                pos = (BlockPos) BlockPos.ZERO;
            }

            long i = (long) pos.getX() + (long) pos.getY() + (long) pos.getZ();
            double delta = i * 0.1;
            int index = MathHelper.floor(delta);
            int index2 = (index + 1) & 3;
            delta -= index;
            index &= 3;

            Vec3i color1 = LUNA_COLORS[index];
            Vec3i color2 = LUNA_COLORS[index2];

            int r = MathHelper.floor(MathHelper.lerp(delta, color1.getX(), color2.getX()));
            int g = MathHelper.floor(MathHelper.lerp(delta, color1.getY(), color2.getY()));
            int b = MathHelper.floor(MathHelper.lerp(delta, color1.getZ(), color2.getZ()));

            return Integer.decode(String.format("#%02X%02X%02X", r, g, b));
        }, ShatteredBlocks.LUNA_AURORA_BLOCK);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> Integer.decode(String.format("#%02X%02X%02X", 0,0,128)), ShatteredBlocks.LUNA_AURORA_BLOCK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (pos == null) {
                pos = (BlockPos) BlockPos.ZERO;
            }

            long i = (long) pos.getX() + (long) pos.getY() + (long) pos.getZ();
            double delta = i * 0.1;
            int index = MathHelper.floor(delta);
            int index2 = (index + 1) & 3;
            delta -= index;
            index &= 3;

            Vec3i color1 = SOL_COLORS[index];
            Vec3i color2 = SOL_COLORS[index2];

            int r = MathHelper.floor(MathHelper.lerp(delta, color1.getX(), color2.getX()));
            int g = MathHelper.floor(MathHelper.lerp(delta, color1.getY(), color2.getY()));
            int b = MathHelper.floor(MathHelper.lerp(delta, color1.getZ(), color2.getZ()));

            return Integer.decode(String.format("#%02X%02X%02X", r, g, b));
        }, ShatteredBlocks.SOL_AURORA_BLOCK, ShatteredBlocks.SOL_AURORA_CLUSTER, ShatteredBlocks.LARGE_SOL_AURORA_BUD, ShatteredBlocks.MEDIUM_SOL_AURORA_BUD, ShatteredBlocks.SMALL_SOL_AURORA_BUD);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> Integer.decode(String.format("#%02X%02X%02X", 120, 184, 255)),
                ShatteredBlocks.SOL_AURORA_BLOCK, ShatteredBlocks.SOL_AURORA_CLUSTER, ShatteredBlocks.LARGE_SOL_AURORA_BUD, ShatteredBlocks.MEDIUM_SOL_AURORA_BUD, ShatteredBlocks.SMALL_SOL_AURORA_BUD);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (pos == null) {
                pos = (BlockPos) BlockPos.ZERO;
            }

            long i = (long) pos.getX() + (long) pos.getY() + (long) pos.getZ();
            double delta = i * 0.1;
            int index = MathHelper.floor(delta);
            int index2 = (index + 1) & 3;
            delta -= index;
            index &= 3;

            Vec3i color1 = ECLIPSA_COLORS[index];
            Vec3i color2 = ECLIPSA_COLORS[index2];

            int r = MathHelper.floor(MathHelper.lerp(delta, color1.getX(), color2.getX()));
            int g = MathHelper.floor(MathHelper.lerp(delta, color1.getY(), color2.getY()));
            int b = MathHelper.floor(MathHelper.lerp(delta, color1.getZ(), color2.getZ()));

            return Integer.decode(String.format("#%02X%02X%02X", r, g, b));
        }, ShatteredBlocks.ECLIPSA_AURORA_BLOCK);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> Integer.decode(String.format("#%02X%02X%02X", 30, 30, 30)), ShatteredBlocks.ECLIPSA_AURORA_BLOCK);
    }

    public static class Factory implements ParticleFactory<SmokeParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }


        @Nullable
        @Override
        public Particle createParticle(SmokeParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            SmokeParticle particle = new SmokeParticle(world, x, y, z, velocityX, velocityY, velocityZ, true);
            particle.setMaxAge(world.getRandom().nextInt(50) + parameters.maxAge());
            particle.setColor(parameters.color().x, parameters.color().y, parameters.color().z);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}
