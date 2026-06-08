package net.ribs.vintagedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.init.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VintageDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("fermenting_jar", modLoc("block/fermenting_jar"));

        generated(
                "apple_sauce_bottle", "apple_sauce_jar", "century_egg", "cheese_burger", "cheese_curds",
                "cheese_pasta", "cheese_pizza", "cheese_pizza_slice", "cheese_slice", "cheese_wheel",
                "chocolate_nut_granola_bar", "cucumber", "cucumber_noodles", "cucumber_salad", "cucumber_seeds",
                "deluxe_burger", "deluxe_granola_bar", "fruity_granola_bar", "gearo_berry",
                "gearo_berry_jam_bottle", "gearo_berry_jam_jar", "ghostly_chili", "ghost_charcoal",
                "ghost_pepper", "ghost_pepper_seeds", "glow_berry_jam_bottle", "glow_berry_jam_jar", "honey_jar",
                "honey_roasted_peanut", "kimchi", "mason_jar", "meat_pizza", "meat_pizza_slice",
                "nut_mash_bottle", "nut_mash_jar", "nut_milk_bottle", "oat", "oatmeal", "oatmeal_cookie",
                "oat_dough", "oat_seeds", "organic_mash", "overnight_oats", "pad_thai", "pb_j", "peanut",
                "pepper_jam_bottle", "pepper_jam_jar", "pickle", "pickled_beetroot", "pickled_egg",
                "pickled_onion", "pickled_pepper", "pickled_pitcher_pod", "pickle_soup", "raw_oats",
                "relish_bottle", "relish_jar", "roasted_peanut", "salted_cod", "salted_salmon", "salt_bucket",
                "salt_dust", "stuffed_burrito", "surstromming", "sweet_berry_jam_bottle", "sweet_berry_jam_jar",
                "vinegar_bottle", "magic_peanut"
        );
        singleTexture("salt", mcLoc("item/generated"), "layer0", modLoc("item/salt_dust"));
        generated("mason_jar");
        aliasedGenerated("vinegar_mason_jar", "vinegar_jar");
        aliasedGenerated("pepper_jam_mason_jar", "pepper_jam_jar");
        aliasedGenerated("gearo_berry_mason_jar", "gearo_berry_jam_jar");
        aliasedGenerated("sweet_berry_mason_jar", "sweet_berry_jam_jar");
        aliasedGenerated("glow_berry_mason_jar", "glow_berry_jam_jar");
        aliasedGenerated("apple_sauce_mason_jar", "apple_sauce_jar");
        aliasedGenerated("relish_mason_jar", "relish_jar");
        aliasedGenerated("honey_mason_jar", "honey_jar");
        aliasedGenerated("nut_mash_mason_jar", "nut_mash_jar");
        lampItem("salt_lamp_default");
        lampItem("salt_lamp_black");
        lampItem("salt_lamp_blue");
        lampItem("salt_lamp_brown");
        lampItem("salt_lamp_cyan");
        lampItem("salt_lamp_gray");
        lampItem("salt_lamp_green");
        lampItem("salt_lamp_light_blue");
        lampItem("salt_lamp_light_gray");
        lampItem("salt_lamp_lime");
        lampItem("salt_lamp_magenta");
        lampItem("salt_lamp_orange");
        lampItem("salt_lamp_pink");
        lampItem("salt_lamp_purple");
        lampItem("salt_lamp_red");
        lampItem("salt_lamp_white");
        lampItem("salt_lamp_yellow");

        simpleBlockItem(ModBlocks.CHEESE_MOLD.get());
        simpleBlockItem(ModBlocks.CUCUMBER_CRATE.get());
        simpleBlockItem(ModBlocks.EVAPORATOR.get());
        aliasedBlockItem(ModBlocks.EMPTY_MASON_JAR.get(), "mason_jar_one_jar");
        simpleBlockItem(ModBlocks.GEARO_BERRY_BAG.get());
        aliasedBlockItem(ModBlocks.GEARO_BERRY_JAM_JAR.get(), "gearo_berry_jam_jar_one_jar");
        simpleBlockItem(ModBlocks.GOLDEN_EGG.get());
        simpleBlockItem(ModBlocks.GHOST_PEPPER_CRATE.get());
        aliasedBlockItem(ModBlocks.GLOW_BERRY_JAM_JAR.get(), "glow_berry_jam_jar_one_jar");
        aliasedBlockItem(ModBlocks.HONEY_JAR.get(), "honey_jar_one_jar");
        simpleBlockItem(ModBlocks.LUSH_GRASS_BLOCK.get());
        simpleBlockItem(ModBlocks.MAGIC_VINE.get());
        simpleBlockItem(ModBlocks.MAGIC_VINE_BLOCK.get());
        simpleBlockItem(ModBlocks.MIXED_SALT_BRICKS.get());
        simpleBlockItem(ModBlocks.MIXED_SALT_BRICK_SLAB.get());
        simpleBlockItem(ModBlocks.MIXED_SALT_BRICK_STAIRS.get());
        wallItem(ModBlocks.MIXED_SALT_BRICK_WALL.get());
        simpleGeneratedItem(ModBlocks.MAGIC_PEANUT.get());
        aliasedBlockItem(ModBlocks.NUT_MASH_JAR.get(), "nut_mash_jar_one_jar");
        simpleBlockItem(ModBlocks.OAT_BAG.get());
        aliasedBlockItem(ModBlocks.OAT_BALE.get(), "oat_bale");
        simpleBlockItem(ModBlocks.PEANUT_CRATE.get());
        aliasedBlockItem(ModBlocks.PEPPER_JAM_JAR.get(), "pepper_jam_jar_one_jar");
        aliasedBlockItem(ModBlocks.RELISH_JAR.get(), "relish_jar_one_jar");
        simpleBlockItem(ModBlocks.SALT_BLOCK.get());
        simpleBlockItem(ModBlocks.SALT_BRICKS.get());
        simpleBlockItem(ModBlocks.SALT_BRICK_SLAB.get());
        simpleBlockItem(ModBlocks.SALT_BRICK_STAIRS.get());
        wallItem(ModBlocks.SALT_BRICK_WALL.get());
        simpleBlockItem(ModBlocks.SALT_PILLAR.get());
        simpleBlockItem(ModBlocks.SMOOTH_SALT_BLOCK.get());
        simpleBlockItem(ModBlocks.STRIPPED_MAGIC_VINE.get());
        simpleBlockItem(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get());
        aliasedBlockItem(ModBlocks.SWEET_BERRY_JAM_JAR.get(), "sweet_berry_jam_jar_one_jar");
        aliasedBlockItem(ModBlocks.VINEGAR_JAR.get(), "vinegar_jar_one_jar");
        blockTextureItem("vine_net", "vine_net");
        simpleBlockItem(ModBlocks.VINE_TILE.get());
        simpleBlockItem(ModBlocks.VINE_TILE_SLAB.get());
        simpleBlockItem(ModBlocks.VINE_TILE_STAIRS.get());
        simpleGeneratedBlockItem(ModBlocks.WILD_CUCUMBERS.get());
        simpleGeneratedBlockItem(ModBlocks.WILD_GHOST_PEPPERS.get());
        simpleGeneratedBlockItem(ModBlocks.WILD_OATS.get());
        simpleGeneratedBlockItem(ModBlocks.WILD_PEANUTS.get());
        aliasedBlockItem(ModBlocks.APPLE_SAUCE_JAR.get(), "apple_sauce_jar_one_jar");
    }

    private void generated(String... names) {
        for (String name : names) {
            singleTexture(name, mcLoc("item/generated"), "layer0", modLoc("item/" + name));
        }
    }

    private void simpleGeneratedBlockItem(Block block) {
        withExistingParent(name(block), modLoc("block/" + name(block)));
    }

    private void simpleGeneratedItem(Block block) {
        generated(name(block));
    }

    private void aliasedGenerated(String modelName, String textureName) {
        singleTexture(modelName, mcLoc("item/generated"), "layer0", modLoc("item/" + textureName));
    }

    private void blockTextureItem(String modelName, String textureName) {
        singleTexture(modelName, mcLoc("item/generated"), "layer0", modLoc("block/" + textureName));
    }

    private void wallItem(Block block) {
        withExistingParent(name(block), modLoc("block/" + name(block) + "_inventory"));
    }

    private void lampItem(String name) {
        singleTexture(name, mcLoc("item/generated"), "layer0", modLoc("item/" + name + "_icon"));
    }

    private void aliasedBlockItem(Block block, String modelName) {
        withExistingParent(name(block), modLoc("block/" + modelName));
    }

    private String name(Block block) {
        return ModBlocks.BLOCKS.getEntries().stream()
                .filter(holder -> holder.get() == block)
                .findFirst()
                .map(holder -> holder.getId().getPath())
                .orElseThrow();
    }
}
