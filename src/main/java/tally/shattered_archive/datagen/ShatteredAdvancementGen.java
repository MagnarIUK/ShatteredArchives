package tally.shattered_archive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tally.shattered_archive.ShatteredArchive;
import tally.shattered_archive.items.ShatteredItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ShatteredAdvancementGen extends FabricAdvancementProvider
{
    public ShatteredAdvancementGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }
    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getCuterExclamationMark = Advancement.Builder.create()
                .display(
                        ShatteredItems.GLASS_CUTER,
                        Text.literal("Get Cuter!"),
                        Text.literal("Cutting with Cuteness"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                ).criterion("get_cuter", InventoryChangedCriterion.Conditions.items(ShatteredItems.GLASS_CUTER))
                .build(consumer, ShatteredArchive.MOD_ID+ "/get_cuter");
    }

}
