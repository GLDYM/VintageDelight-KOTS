package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.init.ModTags;
import net.ribs.vintagedelight.init.items.ModItems;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output,
                              CompletableFuture<HolderLookup.Provider> lookupProvider,
                              BlockTagsProvider blockTags,
                              ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), VintageDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        copy(commonBlockTag("stripped_logs"), commonItemTag("stripped_logs"));
        copy(commonBlockTag("stripped_woods"), commonItemTag("stripped_woods"));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "magic_vines")))
                .add(ModBlocks.MAGIC_VINE.asItem())
                .add(ModBlocks.STRIPPED_MAGIC_VINE.asItem())
                .add(ModBlocks.MAGIC_VINE_BLOCK.asItem())
                .add(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.asItem());

        tag(ModTags.CONTAINER_ITEMS)
                .add(Items.GLASS_BOTTLE)
                .add(Items.BOWL)
                .add(Items.BUCKET)
                .add(ModItems.MASON_JAR.get());

        tag(ModTags.RAW_FISH)
                .add(Items.COD, Items.SALMON, Items.TROPICAL_FISH);

        tag(ModTags.SALT_LAMP)
                .add(ModItems.DEFAULT_SALT_LAMP_ITEM.get())
                .add(ModItems.BLACK_SALT_LAMP_ITEM.get())
                .add(ModItems.BLUE_SALT_LAMP_ITEM.get())
                .add(ModItems.BROWN_SALT_LAMP_ITEM.get())
                .add(ModItems.CYAN_SALT_LAMP_ITEM.get())
                .add(ModItems.GRAY_SALT_LAMP_ITEM.get())
                .add(ModItems.GREEN_SALT_LAMP_ITEM.get())
                .add(ModItems.LIGHT_BLUE_SALT_LAMP_ITEM.get())
                .add(ModItems.LIGHT_GRAY_SALT_LAMP_ITEM.get())
                .add(ModItems.LIME_SALT_LAMP_ITEM.get())
                .add(ModItems.MAGENTA_SALT_LAMP_ITEM.get())
                .add(ModItems.ORANGE_SALT_LAMP_ITEM.get())
                .add(ModItems.PINK_SALT_LAMP_ITEM.get())
                .add(ModItems.PURPLE_SALT_LAMP_ITEM.get())
                .add(ModItems.RED_SALT_LAMP_ITEM.get())
                .add(ModItems.WHITE_SALT_LAMP_ITEM.get())
                .add(ModItems.YELLOW_SALT_LAMP_ITEM.get());

        tag(ModTags.SAVORY_JAM)
                .add(ModItems.PEPPER_JAM_JAR.get())
                .add(ModItems.RELISH.get());

        tag(ModTags.SAVORY_JAM_BOTTLES)
                .add(ModItems.PEPPER_JAM_BOTTLE.get())
                .add(ModItems.RELISH_BOTTLE.get())
                .add(Items.HONEY_BOTTLE);

        tag(ModTags.SLIME_BALL_FERMENTING)
                .add(Items.VINE)
                .add(Items.SHORT_GRASS)
                .add(Items.FERN)
                .add(Items.LARGE_FERN)
                .add(Items.TALL_GRASS)
                .add(Items.SEAGRASS)
                .add(Items.SEA_PICKLE)
                .add(Items.SUGAR_CANE)
                .addTag(ItemTags.SAPLINGS)
                .addTag(ItemTags.FLOWERS);

        tag(ModTags.SWEET_JAM)
                .add(ModItems.APPLE_SAUCE.get())
                .add(ModItems.SWEET_BERRY_JAM.get())
                .add(ModItems.GLOW_BERRY_JAM.get())
                .add(ModItems.GEARO_BERRY_JAM.get())
                .add(ModItems.HONEY_JAR.get());

        tag(ModTags.SWEET_JAM_BOTTLES)
                .add(ModItems.APPLE_SAUCE_BOTTLE.get())
                .add(ModItems.SWEET_BERRY_JAM_BOTTLE.get())
                .add(ModItems.GLOW_BERRY_JAM_BOTTLE.get())
                .add(ModItems.GEARO_BERRY_JAM_BOTTLE.get());

        tag(Tags.Items.EGGS).add(Items.EGG);
        tag(Tags.Items.MUSHROOMS).add(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);
        tag(Tags.Items.GLASS_BLOCKS_COLORLESS).add(Items.GLASS);
        tag(Tags.Items.INGOTS_IRON).add(Items.IRON_INGOT);
        tag(Tags.Items.FOODS_BREAD).add(Items.BREAD);
        tag(Tags.Items.FOODS_COOKED_MEAT)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_RABBIT);
        tag(Tags.Items.FOODS_COOKED_FISH).add(Items.COOKED_COD, Items.COOKED_SALMON);
        tag(Tags.Items.FOODS_RAW_FISH).addTag(ModTags.RAW_FISH);
        tag(Tags.Items.FOODS_BERRY)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(Tags.Items.FOODS_FRUIT).addTag(Tags.Items.FOODS_BERRY);
        tag(Tags.Items.FOODS_VEGETABLE)
                .add(ModItems.CUCUMBER.get())
                .add(ModItems.GHOST_PEPPER.get())
                .add(ModItems.PEANUT.get());
        tag(Tags.Items.FOODS_DOUGH).add(ModItems.OAT_DOUGH.get());

        tag(commonItemTag("seeds/oat"))
                .add(ModItems.OAT_SEEDS.get());
        tag(commonItemTag("seeds/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("seeds/pepper"))
                .add(ModItems.GHOST_PEPPER_SEEDS.get());
        tag(commonItemTag("seeds/cucumber"))
                .add(ModItems.CUCUMBER_SEEDS.get());
        tag(commonItemTag("seeds"))
                .add(ModItems.OAT_SEEDS.get())
                .add(ModItems.PEANUT.get())
                .add(ModItems.GHOST_PEPPER_SEEDS.get())
                .add(ModItems.CUCUMBER_SEEDS.get())
                .add(ModBlocks.MAGIC_PEANUT.asItem());

        tag(commonItemTag("cheese"))
                .add(ModItems.CHEESE_SLICE.get());
        tag(commonItemTag("salt"))
                .add(ModItems.SALT_DUST.get());
        tag(commonItemTag("jam_bottles"))
                .add(ModItems.PEPPER_JAM_BOTTLE.get())
                .add(ModItems.RELISH_BOTTLE.get())
                .add(ModItems.APPLE_SAUCE_BOTTLE.get())
                .add(ModItems.SWEET_BERRY_JAM_BOTTLE.get())
                .add(ModItems.GLOW_BERRY_JAM_BOTTLE.get())
                .add(ModItems.GEARO_BERRY_JAM_BOTTLE.get())
                .add(Items.HONEY_BOTTLE);
        tag(commonItemTag("jam_jars"))
                .add(ModItems.PEPPER_JAM_JAR.get())
                .add(ModItems.RELISH.get())
                .add(ModItems.APPLE_SAUCE.get())
                .add(ModItems.SWEET_BERRY_JAM.get())
                .add(ModItems.GLOW_BERRY_JAM.get())
                .add(ModItems.GEARO_BERRY_JAM.get())
                .add(ModItems.HONEY_JAR.get());
        tag(commonItemTag("foods/milk"))
                .add(ModItems.NUT_MILK.get());
        tag(commonItemTag("crops/oat"))
                .add(ModItems.OAT.get());
        tag(commonItemTag("crops/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("crops/cucumber"))
                .add(ModItems.CUCUMBER.get());
        tag(commonItemTag("crops/pepper"))
                .add(ModItems.GHOST_PEPPER.get());
        tag(commonItemTag("crops"))
                .add(ModItems.OAT.get())
                .add(ModItems.PEANUT.get())
                .add(ModItems.CUCUMBER.get())
                .add(ModItems.GHOST_PEPPER.get());
        tag(commonItemTag("grain/oat"))
                .add(ModItems.RAW_OAT.get());
        tag(commonItemTag("grain"))
                .add(ModItems.RAW_OAT.get());
        tag(commonItemTag("fruits/gearo_berry"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("fruits/berries"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("fruits"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("foods/fruits/berries"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("foods/fruits/gearo_berry"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("foods/pasta"))
                .add(ModItems.CUCUMBER_NOODLES.get());
        tag(commonItemTag("foods/protein"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("foods/protein/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("foods/vegetable/cucumber"))
                .add(ModItems.CUCUMBER.get());
        tag(commonItemTag("foods/vegetable/chili_pepper"))
                .add(ModItems.GHOST_PEPPER.get());
        tag(commonItemTag("foods/vegetable/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("foods/fruit/gearo_berry"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("foods/carbs"))
                .add(ModItems.RAW_OAT.get());
        tag(commonItemTag("foods/fruits"))
                .add(ModItems.GEARO_BERRY_ITEM.get());
        tag(commonItemTag("foods/proteins"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("vegetables/cucumber"))
                .add(ModItems.CUCUMBER.get());
        tag(commonItemTag("vegetables/chili_pepper"))
                .add(ModItems.GHOST_PEPPER.get());
        tag(commonItemTag("vegetables/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("vegetables"))
                .add(ModItems.CUCUMBER.get())
                .add(ModItems.GHOST_PEPPER.get())
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("foods/vegetables/cucumber"))
                .add(ModItems.CUCUMBER.get());
        tag(commonItemTag("foods/vegetables/chili_pepper"))
                .add(ModItems.GHOST_PEPPER.get());
        tag(commonItemTag("foods/vegetables/peanut"))
                .add(ModItems.PEANUT.get());
        tag(commonItemTag("foods/vegetables"))
                .add(ModItems.CUCUMBER.get())
                .add(ModItems.GHOST_PEPPER.get())
                .add(ModItems.PEANUT.get());
    }

    private static TagKey<net.minecraft.world.level.block.Block> commonBlockTag(String path) {
        return TagKey.create(net.minecraft.core.registries.Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<net.minecraft.world.item.Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
