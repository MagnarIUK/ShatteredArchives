package tally.shattered_archive.items;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tally.shattered_archive.datagen.ShatteredBlockTagGen;

import java.util.List;

public class GlassCutterItem extends Item {
    public GlassCutterItem(Settings settings) {
        super(settings);
    }

    public static ToolComponent createToolComponent(){
        return new ToolComponent(List.of(ToolComponent.Rule.of(ShatteredBlockTagGen.GLASS, 15.0F)), 1.0F, 1);
    }


    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isIn(ShatteredBlockTagGen.GLASS)){
            stack.damage(1, miner, LivingEntity.getSlotForHand(miner.getActiveHand()));
            return true;
        }

        return super.postMine(stack, world, state, pos, miner);
    }
}
