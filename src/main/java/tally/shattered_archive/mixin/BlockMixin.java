package tally.shattered_archive.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tally.shattered_archive.datagen.ShatteredBlockTagGen;
import tally.shattered_archive.items.ShatteredItems;

import java.util.List;

@Mixin(AbstractBlock.class)
public abstract class BlockMixin {

    @Inject(
            method = "getDroppedStacks",
            at = @At("HEAD"),
            cancellable = true
    )
    private void shattered$glassCutterDrops(
            BlockState state,
            LootContextParameterSet.Builder builder,
            CallbackInfoReturnable<List<ItemStack>> cir
    ) {
        ItemStack tool = builder.get(LootContextParameters.TOOL);

        if (tool == null || !tool.isOf(ShatteredItems.GLASS_CUTTER)) return;
        if (!state.isIn(ShatteredBlockTagGen.GLASS)) return;

        Block block = (Block)(Object)this;
        cir.setReturnValue(List.of(new ItemStack(block)));
    }
}

