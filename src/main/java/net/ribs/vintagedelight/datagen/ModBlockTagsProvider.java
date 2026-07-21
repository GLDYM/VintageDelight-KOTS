package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VintageDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(commonBlockTag("stripped_logs"))
                .add(ModBlocks.STRIPPED_MAGIC_VINE.get());

        tag(commonBlockTag("stripped_woods"))
                .add(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get());

        tag(BlockTags.CROPS)
                .add(ModBlocks.OAT_CROP.get())
                .add(ModBlocks.PEANUT_CROP.get())
                .add(ModBlocks.GHOST_PEPPER_CROP.get())
                .add(ModBlocks.CUCUMBER_CROP.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.OAT_BAG.get())
                .add(ModBlocks.GEARO_BERRY_BAG.get())
                .add(ModBlocks.PEANUT_CRATE.get())
                .add(ModBlocks.CUCUMBER_CRATE.get())
                .add(ModBlocks.GHOST_PEPPER_CRATE.get())
                .add(ModBlocks.OAT_BALE.get())
                .add(ModBlocks.MAGIC_VINE.get())
                .add(ModBlocks.STRIPPED_MAGIC_VINE.get())
                .add(ModBlocks.MAGIC_VINE_BLOCK.get())
                .add(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get())
                .add(ModBlocks.VINE_TILE.get())
                .add(ModBlocks.VINE_TILE_STAIRS.get())
                .add(ModBlocks.VINE_TILE_SLAB.get())
                .add(ModBlocks.VINE_NET.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHEESE_MOLD.get())
                .add(ModBlocks.FERMENTING_JAR.get())
                .add(ModBlocks.EMPTY_MASON_JAR.get())
                .add(ModBlocks.VINEGAR_JAR.get())
                .add(ModBlocks.PEPPER_JAM_JAR.get())
                .add(ModBlocks.GEARO_BERRY_JAM_JAR.get())
                .add(ModBlocks.SWEET_BERRY_JAM_JAR.get())
                .add(ModBlocks.GLOW_BERRY_JAM_JAR.get())
                .add(ModBlocks.APPLE_SAUCE_JAR.get())
                .add(ModBlocks.NUT_MASH_JAR.get())
                .add(ModBlocks.RELISH_JAR.get())
                .add(ModBlocks.HONEY_JAR.get())
                .add(ModBlocks.EVAPORATOR.get())
                .add(ModBlocks.SALT_BLOCK.get())
                .add(ModBlocks.SMOOTH_SALT_BLOCK.get())
                .add(ModBlocks.SALT_PILLAR.get())
                .add(ModBlocks.SALT_BRICKS.get())
                .add(ModBlocks.SALT_BRICK_STAIRS.get())
                .add(ModBlocks.SALT_BRICK_SLAB.get())
                .add(ModBlocks.SALT_BRICK_WALL.get())
                .add(ModBlocks.MIXED_SALT_BRICKS.get())
                .add(ModBlocks.MIXED_SALT_BRICK_STAIRS.get())
                .add(ModBlocks.MIXED_SALT_BRICK_SLAB.get())
                .add(ModBlocks.MIXED_SALT_BRICK_WALL.get());
    }

    private static TagKey<Block> commonBlockTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
