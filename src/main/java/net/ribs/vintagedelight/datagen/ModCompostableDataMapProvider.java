package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.init.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModCompostableDataMapProvider extends DataMapProvider {
    public ModCompostableDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(packOutput, provider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        Builder<Compostable, Item> builder = builder(NeoForgeDataMaps.COMPOSTABLES);

        add(builder, ModItems.PEANUT.get(), 0.4F);
        add(builder, ModItems.GEARO_BERRY_ITEM.get(), 0.4F);
        add(builder, ModItems.GHOST_PEPPER.get(), 0.4F);
        add(builder, ModItems.GHOST_PEPPER_SEEDS.get(), 0.3F);
        add(builder, ModItems.CUCUMBER.get(), 0.3F);
        add(builder, ModItems.CUCUMBER_SEEDS.get(), 0.3F);
        add(builder, ModItems.OAT_SEEDS.get(), 0.3F);
        add(builder, ModItems.PICKLE.get(), 0.4F);
        add(builder, ModItems.PICKLED_PEPPER.get(), 0.4F);
        add(builder, ModItems.PICKLED_BEETROOT.get(), 0.6F);
        add(builder, ModItems.PICKLED_EGG.get(), 0.6F);
        add(builder, ModItems.PICKLED_ONION.get(), 0.6F);
        add(builder, ModItems.PICKLED_PITCHER_POD.get(), 0.6F);
        add(builder, ModItems.CENTURY_EGG.get(), 0.9F);
        add(builder, ModBlocks.MAGIC_PEANUT.get().asItem(), 0.85F);
        add(builder, ModItems.OAT.get(), 0.3F);
    }

    private static void add(Builder<Compostable, Item> builder, Item item, float chance) {
        builder.add(BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow(), new Compostable(chance), false);
    }
}
