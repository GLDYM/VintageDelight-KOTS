package net.ribs.vintagedelight.datagen;

import net.minecraft.core.registries.Registries;



import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.ModBlocks;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VintageDelight.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        Block fermentingJar = ModBlocks.FERMENTING_JAR.get();
        ModelFile fermentingJarModel = new ModelFile.UncheckedModelFile(modLoc("block/fermenting_jar"));
        getVariantBuilder(fermentingJar).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(fermentingJarModel)
                .build());
        simpleBlockItem(fermentingJar, fermentingJarModel);
    }
}

