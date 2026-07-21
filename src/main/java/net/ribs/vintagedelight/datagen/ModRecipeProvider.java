package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.datagen.builder.FermentingRecipeBuilder;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.init.ModTags;
import net.ribs.vintagedelight.init.items.ModItems;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

import static vectorwing.farmersdelight.common.registry.ModItems.BEEF_PATTY;
import static vectorwing.farmersdelight.common.registry.ModItems.CABBAGE_LEAF;
import static vectorwing.farmersdelight.common.registry.ModItems.COOKED_BACON;
import static vectorwing.farmersdelight.common.registry.ModItems.FRIED_EGG;
import static vectorwing.farmersdelight.common.registry.ModItems.MILK_BOTTLE;
import static vectorwing.farmersdelight.common.registry.ModItems.MINCED_BEEF;
import static vectorwing.farmersdelight.common.registry.ModItems.ORGANIC_COMPOST;
import static vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE;
import static vectorwing.farmersdelight.common.registry.ModItems.ROTTEN_TOMATO;
import static vectorwing.farmersdelight.common.registry.ModItems.STRAW;
import static vectorwing.farmersdelight.common.registry.ModItems.TOMATO;
import static vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE;
import static vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SEEDS;
import static vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK;

public class ModRecipeProvider extends AbstractModRecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, VintageDelight.MODID, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output, HolderLookup.Provider registries) {
        registerBasicCrafting(output);
        registerSaltLampRecipes(output);
        registerCookingPotRecipes(output);
        registerCuttingRecipes(output);
        registerFermentingRecipes(output, registries);
    }

    private void registerBasicCrafting(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MASON_JAR.get(), 3)
                .pattern(" X ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.GLASS)
                .define('X', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .save(output, id("mason_jar"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FERMENTING_JAR.get())
                .pattern("iSi")
                .pattern("iWi")
                .pattern("iii")
                .define('i', Tags.Items.GLASS_BLOCKS_COLORLESS)
                .define('S', ItemTags.WOODEN_SLABS)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(output, id("fermenting_jar"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EVAPORATOR.get())
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .define('#', ItemTags.LOGS)
                .define('X', ModBlocks.SALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SALT_BLOCK.get()), has(ModBlocks.SALT_BLOCK.get()))
                .save(output, id("evaporator"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAT_BAG.get(), ModItems.RAW_OAT.get(), 1)
                .save(output, id("oat_bag"));
        unpack(RecipeCategory.MISC, ModItems.RAW_OAT.get(), 9, ModBlocks.OAT_BAG.get())
                .save(output, id("oat_bag_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GEARO_BERRY_BAG.get(), ModItems.GEARO_BERRY_ITEM.get(), 1)
                .save(output, id("gearo_berry_bag"));
        unpack(RecipeCategory.MISC, ModItems.GEARO_BERRY_ITEM.get(), 9, ModBlocks.GEARO_BERRY_BAG.get())
                .save(output, id("gearo_bag_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PEANUT_CRATE.get(), ModItems.PEANUT.get(), 1)
                .save(output, id("peanut_crate"));
        unpack(RecipeCategory.MISC, ModItems.PEANUT.get(), 9, ModBlocks.PEANUT_CRATE.get())
                .save(output, id("peanut_crate_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUCUMBER_CRATE.get(), ModItems.CUCUMBER.get(), 1)
                .save(output, id("cucumber_crate"));
        unpack(RecipeCategory.MISC, ModItems.CUCUMBER.get(), 9, ModBlocks.CUCUMBER_CRATE.get())
                .save(output, id("cucumber_crate_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GHOST_PEPPER_CRATE.get(), ModItems.GHOST_PEPPER.get(), 1)
                .save(output, id("ghost_pepper_crate"));
        unpack(RecipeCategory.MISC, ModItems.GHOST_PEPPER.get(), 9, ModBlocks.GHOST_PEPPER_CRATE.get())
                .save(output, id("ghost_pepper_crate_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAT_BALE.get(), ModItems.OAT.get(), 1)
                .save(output, id("oat_bale"));
        unpack(RecipeCategory.MISC, ModItems.OAT.get(), 9, ModBlocks.OAT_BALE.get())
                .save(output, id("oat_bale_deconstruct"));

        threeByThree(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BLOCK.get(), ModItems.SALT_DUST.get(), 1)
                .save(output, id("salt_block"));
        unpack(RecipeCategory.MISC, ModItems.SALT_DUST.get(), 9, ModBlocks.SALT_BLOCK.get())
                .save(output, id("salt_block_deconstruct"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SALT_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.SALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SALT_BLOCK.get()), has(ModBlocks.SALT_BLOCK.get()))
                .save(output, id("smooth_salt_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_PILLAR.get())
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.SALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SALT_BLOCK.get()), has(ModBlocks.SALT_BLOCK.get()))
                .save(output, id("salt_pillar"));
        stoneCutting("salt_pillar_from_stonecutting", ModBlocks.SALT_BLOCK.get(), ModBlocks.SALT_PILLAR.get(), 1, output);

        twoByTwo(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BRICKS.get(), 1, ModBlocks.SMOOTH_SALT_BLOCK.get())
                .save(output, id("salt_bricks"));
        stoneCutting("salt_bricks_from_stonecutting", ModBlocks.SMOOTH_SALT_BLOCK.get(), ModBlocks.SALT_BRICKS.get(), 1, output);
        stairs(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BRICK_STAIRS.get(), ModBlocks.SALT_BRICKS.get())
                .save(output, id("salt_brick_stairs"));
        stoneCutting("salt_brick_stairs_from_bricks_stonecutting", ModBlocks.SALT_BRICKS.get(), ModBlocks.SALT_BRICK_STAIRS.get(), 1, output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BRICK_SLAB.get(), ModBlocks.SALT_BRICKS.get())
                .save(output, id("salt_brick_slab"));
        stoneCutting("salt_brick_slab_from_bricks_stonecutting", ModBlocks.SALT_BRICKS.get(), ModBlocks.SALT_BRICK_SLAB.get(), 1, output);
        wall(RecipeCategory.DECORATIONS, ModBlocks.SALT_BRICK_WALL.get(), ModBlocks.SALT_BRICKS.get())
                .save(output, id("salt_brick_wall"));
        stoneCutting("salt_brick_wall_from_bricks_stonecutting", ModBlocks.SALT_BRICKS.get(), ModBlocks.SALT_BRICK_WALL.get(), 1, output);

        twoByTwo(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_SALT_BRICKS.get(), 1, ModBlocks.SALT_BRICKS.get())
                .save(output, id("mixed_salt_bricks"));
        stairs(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_SALT_BRICK_STAIRS.get(), ModBlocks.MIXED_SALT_BRICKS.get())
                .save(output, id("mixed_salt_brick_stairs"));
        stoneCutting("mixed_salt_brick_stairs_from_bricks_stonecutting", ModBlocks.MIXED_SALT_BRICKS.get(), ModBlocks.MIXED_SALT_BRICK_STAIRS.get(), 1, output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_SALT_BRICK_SLAB.get(), ModBlocks.MIXED_SALT_BRICKS.get())
                .save(output, id("mixed_salt_brick_slab"));
        stoneCutting("mixed_salt_brick_slab_from_bricks_stonecutting", ModBlocks.MIXED_SALT_BRICKS.get(), ModBlocks.MIXED_SALT_BRICK_SLAB.get(), 1, output);
        wall(RecipeCategory.DECORATIONS, ModBlocks.MIXED_SALT_BRICK_WALL.get(), ModBlocks.MIXED_SALT_BRICKS.get())
                .save(output, id("mixed_salt_brick_wall"));
        stoneCutting("mixed_salt_brick_wall_from_bricks_stonecutting", ModBlocks.MIXED_SALT_BRICKS.get(), ModBlocks.MIXED_SALT_BRICK_WALL.get(), 1, output);

        stairs(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VINE_TILE_STAIRS.get(), ModBlocks.VINE_TILE.get())
                .save(output, id("vine_tile_stairs"));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VINE_TILE_SLAB.get(), ModBlocks.VINE_TILE.get())
                .save(output, id("vine_tile_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.VINE_NET.get(), 8)
                .pattern("# #")
                .pattern(" # ")
                .pattern("# #")
                .define('#', ModBlocks.MAGIC_VINE.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_VINE.get()), has(ModBlocks.MAGIC_VINE.get()))
                .save(output, id("vine_net"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_VINE_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.MAGIC_VINE.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_VINE.get()), has(ModBlocks.MAGIC_VINE.get()))
                .save(output, id("magic_vine_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.STRIPPED_MAGIC_VINE.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAGIC_VINE.get()), has(ModBlocks.STRIPPED_MAGIC_VINE.get()))
                .save(output, id("stripped_magic_vine_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OAT_DOUGH.get(), 3)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("oat_dough_from_water"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OAT_DOUGH.get(), 3)
                .requires(Tags.Items.EGGS)
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("oat_dough_from_eggs"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHEESE_BURGER.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/bread")))
                .requires(BEEF_PATTY.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/tomato")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:cheese")))
                .unlockedBy(getHasName(BEEF_PATTY.get()), has(BEEF_PATTY.get()))
                .save(output, id("cheese_burger"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHEESE_MOLD.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("#X#")
                .define('#', ItemTags.create(ResourceLocation.parse("c:ingots/iron")))
                .define('X', Items.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .unlockedBy(getHasName(Items.HEAVY_WEIGHTED_PRESSURE_PLATE), has(Items.HEAVY_WEIGHTED_PRESSURE_PLATE))
                .save(output, id("cheese_mold"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHEESE_PIZZA.get())
                .pattern("   ")
                .pattern("AAA")
                .pattern("CEC")
                .define('A', ItemTags.create(ResourceLocation.parse("c:cheese")))
                .define('C', ItemTags.create(ResourceLocation.parse("c:foods/dough")))
                .define('E', TOMATO_SAUCE.get())
                .unlockedBy(getHasName(TOMATO_SAUCE.get()), has(TOMATO_SAUCE.get()))
                .save(output, id("cheese_pizza"));

        twoByTwo(RecipeCategory.MISC, ModBlocks.CHEESE_PIZZA.get(), 1, ModItems.CHEESE_PIZZA_SLICE.get())
                .save(output, id("cheese_pizza_from_slices"));

        twoByTwo(RecipeCategory.MISC, ModItems.CHEESE_WHEEL.get(), 1, ModItems.CHEESE_SLICE.get())
                .save(output, id("cheese_wheel_from_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_NUT_GRANOLA_BAR.get(), 3)
                .requires(ModItems.RAW_OAT.get())
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.COCOA_BEANS)
                .requires(ModItems.ROASTED_PEANUT.get())
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("chocolate_granola_bar"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUCUMBER_SALAD.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable")))
                .requires(ModItems.PICKLED_BEETROOT.get())
                .requires(ModItems.PICKLED_ONION.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModItems.CUCUMBER.get()), has(ModItems.CUCUMBER.get()))
                .save(output, id("cucumber_salad"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUCUMBER_SEEDS.get(), 3)
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .unlockedBy(getHasName(ModItems.CUCUMBER.get()), has(ModItems.CUCUMBER.get()))
                .save(output, id("cucumber_to_seeds"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DELUXE_BURGER.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/bread")))
                .requires(BEEF_PATTY.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/tomato")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:cheese")))
                .requires(FRIED_EGG.get())
                .requires(COOKED_BACON.get())
                .unlockedBy(getHasName(BEEF_PATTY.get()), has(BEEF_PATTY.get()))
                .save(output, id("deluxe_burger"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DELUXE_GRANOLA_BAR.get(), 4)
                .requires(ModItems.RAW_OAT.get())
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.COCOA_BEANS)
                .requires(ModItems.ROASTED_PEANUT.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("deluxe_granola_bar"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FRUITY_GRANOLA_BAR.get(), 3)
                .requires(ModItems.RAW_OAT.get())
                .requires(Items.HONEY_BOTTLE)
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("fruity_granola_bar"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GHOST_PEPPER_SEEDS.get(), 2)
                .requires(ModItems.GHOST_PEPPER.get())
                .unlockedBy(getHasName(ModItems.GHOST_PEPPER.get()), has(ModItems.GHOST_PEPPER.get()))
                .save(output, id("ghost_pepper_to_seeds"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HONEY_ROASTED_PEANUT.get(), 2)
                .requires(ModItems.ROASTED_PEANUT.get())
                .requires(ModItems.ROASTED_PEANUT.get())
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(ModItems.ROASTED_PEANUT.get()), has(ModItems.ROASTED_PEANUT.get()))
                .save(output, id("honey_roasted_peanut"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MEAT_PIZZA.get())
                .pattern(" Q ")
                .pattern("AAA")
                .pattern("CEC")
                .define('A', ItemTags.create(ResourceLocation.parse("c:cheese")))
                .define('C', ItemTags.create(ResourceLocation.parse("c:foods/dough")))
                .define('E', TOMATO_SAUCE.get())
                .define('Q', ItemTags.create(ResourceLocation.parse("c:foods/cooked_meat")))
                .unlockedBy(getHasName(TOMATO_SAUCE.get()), has(TOMATO_SAUCE.get()))
                .save(output, id("meat_pizza"));

        twoByTwo(RecipeCategory.MISC, ModBlocks.MEAT_PIZZA.get(), 1, ModItems.MEAT_PIZZA_SLICE.get())
                .save(output, id("meat_pizza_from_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BREAD)
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("oat_bread"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OATMEAL_COOKIE.get(), 8)
                .requires(ModItems.RAW_OAT.get())
                .requires(ModItems.RAW_OAT.get())
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("oatmeal_cookie"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ORGANIC_COMPOST.get())
                .requires(Items.DIRT)
                .requires(ModItems.ORGANIC_MASH.get())
                .requires(ModItems.ORGANIC_MASH.get())
                .requires(STRAW.get())
                .requires(STRAW.get())
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .unlockedBy(getHasName(ModItems.ORGANIC_MASH.get()), has(ModItems.ORGANIC_MASH.get()))
                .save(output, id("organic_compost_from_rotten_flesh_mash"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ORGANIC_COMPOST.get())
                .requires(Items.DIRT)
                .requires(STRAW.get())
                .requires(STRAW.get())
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.ORGANIC_MASH.get())
                .requires(ModItems.ORGANIC_MASH.get())
                .requires(TREE_BARK.get())
                .requires(TREE_BARK.get())
                .unlockedBy(getHasName(ModItems.ORGANIC_MASH.get()), has(ModItems.ORGANIC_MASH.get()))
                .save(output, id("organic_compost_from_tree_bark_mash"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PB_J.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/bread")))
                .requires(ModItems.NUT_MASH_BOTTLE.get())
                .requires(ModTags.SWEET_JAM_BOTTLES)
                .unlockedBy(getHasName(ModItems.NUT_MASH_BOTTLE.get()), has(ModItems.NUT_MASH_BOTTLE.get()))
                .save(output, id("pb_j"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemTags.create(ResourceLocation.parse("c:crops/peanut"))), RecipeCategory.FOOD, ModItems.ROASTED_PEANUT.get(), 0.35F, 200)
                .unlockedBy(getHasName(ModItems.PEANUT.get()), has(ModItems.PEANUT.get()))
                .save(output, id("roasted_peanut"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemTags.create(ResourceLocation.parse("c:crops/peanut"))), RecipeCategory.FOOD, ModItems.ROASTED_PEANUT.get(), 0.35F, 100)
                .unlockedBy(getHasName(ModItems.PEANUT.get()), has(ModItems.PEANUT.get()))
                .save(output, id("roasted_peanut_from_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemTags.create(ResourceLocation.parse("c:crops/peanut"))), RecipeCategory.FOOD, ModItems.ROASTED_PEANUT.get(), 0.35F, 600)
                .unlockedBy(getHasName(ModItems.PEANUT.get()), has(ModItems.PEANUT.get()))
                .save(output, id("roasted_peanut_from_campfire_cooking"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SALT_DUST.get(), 3)
                .requires(ModItems.SALT_BUCKET.get())
                .unlockedBy(getHasName(ModItems.SALT_BUCKET.get()), has(ModItems.SALT_BUCKET.get()))
                .save(output, id("salt_bucket_to_salt"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.WATER_BUCKET), RecipeCategory.FOOD, ModItems.SALT_BUCKET.get(), 0.35F, 200)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(output, id("salt_from_smelting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SALTED_COD.get(), 2)
                .requires(Items.COD)
                .requires(Items.COD)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .unlockedBy(getHasName(Items.COD), has(Items.COD))
                .save(output, id("salted_cod"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SALTED_SALMON.get(), 2)
                .requires(Items.SALMON)
                .requires(Items.SALMON)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON))
                .save(output, id("salted_salmon"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STUFFED_BURRITO.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/bread")))
                .requires(BEEF_PATTY.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/tomato")))
                .requires(ItemTags.create(ResourceLocation.parse("c:cheese")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/chili_pepper")))
                .unlockedBy(getHasName(BEEF_PATTY.get()), has(BEEF_PATTY.get()))
                .save(output, id("stuffed_burrito"));
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUCUMBER_DOUGH.get(), 2)
                .requires(ModItems.CUCUMBER.get())
                .requires(Tags.Items.FOODS_DOUGH)
                .unlockedBy(getHasName(ModItems.CUCUMBER.get()), has(ModItems.CUCUMBER.get()))
                .save(output, id("cucumber_dough"));

        jarToBottle(output, "honey_jar_deconstruct", ModItems.HONEY_JAR.get(), Items.HONEY_BOTTLE);
        bottleToJar(output, "honey_jar", Items.HONEY_BOTTLE, ModItems.HONEY_JAR.get());
        jarToBottle(output, "jam/apple_sauce_jar_deconstruct", ModItems.APPLE_SAUCE.get(), ModItems.APPLE_SAUCE_BOTTLE.get());
        bottleToJar(output, "jam/apple_sauce_jar", ModItems.APPLE_SAUCE_BOTTLE.get(), ModItems.APPLE_SAUCE.get());
        jarToBottle(output, "jam/gearo_berry_jam_jar_deconstruct", ModItems.GEARO_BERRY_JAM.get(), ModItems.GEARO_BERRY_JAM_BOTTLE.get());
        bottleToJar(output, "jam/gearo_berry_jam_jar", ModItems.GEARO_BERRY_JAM_BOTTLE.get(), ModItems.GEARO_BERRY_JAM.get());
        jarToBottle(output, "jam/glow_berry_jam_jar_deconstruct", ModItems.GLOW_BERRY_JAM.get(), ModItems.GLOW_BERRY_JAM_BOTTLE.get());
        bottleToJar(output, "jam/glow_berry_jam_jar", ModItems.GLOW_BERRY_JAM_BOTTLE.get(), ModItems.GLOW_BERRY_JAM.get());
        jarToBottle(output, "jam/nut_mash_jar_deconstruct", ModItems.NUT_MASH.get(), ModItems.NUT_MASH_BOTTLE.get());
        bottleToJar(output, "jam/nut_mash_jar", ModItems.NUT_MASH_BOTTLE.get(), ModItems.NUT_MASH.get());
        jarToBottle(output, "jam/pepper_jam_jar_deconstruct", ModItems.PEPPER_JAM_JAR.get(), ModItems.PEPPER_JAM_BOTTLE.get());
        bottleToJar(output, "jam/pepper_jam_jar", ModItems.PEPPER_JAM_BOTTLE.get(), ModItems.PEPPER_JAM_JAR.get());
        jarToBottle(output, "jam/relish_jar_deconstruct", ModItems.RELISH.get(), ModItems.RELISH_BOTTLE.get());
        bottleToJar(output, "jam/relish_jar", ModItems.RELISH_BOTTLE.get(), ModItems.RELISH.get());
        jarToBottle(output, "jam/sweet_berry_jam_jar_deconstruct", ModItems.SWEET_BERRY_JAM.get(), ModItems.SWEET_BERRY_JAM_BOTTLE.get());
        bottleToJar(output, "jam/sweet_berry_jam_jar", ModItems.SWEET_BERRY_JAM_BOTTLE.get(), ModItems.SWEET_BERRY_JAM.get());
        jarToBottle(output, "jam/vinegar_jar_deconstruct", ModItems.VINEGAR.get(), ModItems.VINEGAR_BOTTLE.get());
        bottleToJar(output, "jam/vinegar_jar", ModItems.VINEGAR_BOTTLE.get(), ModItems.VINEGAR.get());
    }

    private void registerSaltLampRecipes(RecipeOutput output) {
        saltLamp(output, "default", null, ModItems.DEFAULT_SALT_LAMP_ITEM.get(), null);
        saltLamp(output, "black", "c:dyes/black", ModItems.BLACK_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_black"));
        saltLamp(output, "blue", "c:dyes/blue", ModItems.BLUE_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_blue"));
        saltLamp(output, "brown", "c:dyes/brown", ModItems.BROWN_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_brown"));
        saltLamp(output, "cyan", "c:dyes/cyan", ModItems.CYAN_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_cyan"));
        saltLamp(output, "gray", "c:dyes/gray", ModItems.GRAY_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_gray"));
        saltLamp(output, "green", "c:dyes/green", ModItems.GREEN_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_green"));
        saltLamp(output, "light_blue", "c:dyes/light_blue", ModItems.LIGHT_BLUE_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_light_blue"));
        saltLamp(output, "light_gray", "c:dyes/light_gray", ModItems.LIGHT_GRAY_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_light_gray"));
        saltLamp(output, "lime", "c:dyes/lime", ModItems.LIME_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_lime"));
        saltLamp(output, "magenta", "c:dyes/magenta", ModItems.MAGENTA_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_magenta"));
        saltLamp(output, "orange", "c:dyes/orange", ModItems.ORANGE_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_orange"));
        saltLamp(output, "pink", "c:dyes/pink", ModItems.PINK_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_pink"));
        saltLamp(output, "purple", "c:dyes/purple", ModItems.PURPLE_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_purple"));
        saltLamp(output, "red", "c:dyes/red", ModItems.RED_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_red"));
        saltLamp(output, "white", "c:dyes/white", ModItems.WHITE_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_white"));
        saltLamp(output, "yellow", "c:dyes/yellow", ModItems.YELLOW_SALT_LAMP_ITEM.get(), id("salt_lamps/salt_lamp_yellow"));
    }

    private void registerCookingPotRecipes(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.APPLE_SAUCE.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(output, id("cooking/apple_sauce_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHEESE_CURDS.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(Items.MILK_BUCKET)
                .addIngredient(ModItems.VINEGAR.get())
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(output, id("cooking/cheese_curds"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHEESE_PASTA.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(CommonTags.Items.FOODS_PASTA)
                .addIngredient(ItemTags.create(ResourceLocation.parse("c:cheese")))
                .addIngredient(ItemTags.create(ResourceLocation.parse("c:cheese")))
                .unlockedBy(getHasName(ModItems.CHEESE_SLICE.get()), has(ModItems.CHEESE_SLICE.get()))
                .save(output, id("cooking/cheese_pasta"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.GEARO_BERRY_JAM.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(ModItems.GEARO_BERRY_ITEM.get())
                .addIngredient(ModItems.GEARO_BERRY_ITEM.get())
                .addIngredient(ModItems.GEARO_BERRY_ITEM.get())
                .addIngredient(ModItems.GEARO_BERRY_ITEM.get())
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.GEARO_BERRY_ITEM.get()), has(ModItems.GEARO_BERRY_ITEM.get()))
                .save(output, id("cooking/gearo_berry_jam_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.GHOSTLY_CHILI.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(Items.CARROT)
                .addIngredient(TOMATO.get())
                .addIngredient(MINCED_BEEF.get())
                .unlockedBy(getHasName(ModItems.GHOST_PEPPER.get()), has(ModItems.GHOST_PEPPER.get()))
                .save(output, id("cooking/ghostly_chili"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.GLOW_BERRY_JAM.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(Items.GLOW_BERRIES), has(Items.GLOW_BERRIES))
                .save(output, id("cooking/glow_berry_jam_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.NUT_MASH.get(), 1, 200, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(ModItems.PEANUT.get())
                .addIngredient(ModItems.PEANUT.get())
                .addIngredient(ModItems.PEANUT.get())
                .unlockedBy(getHasName(ModItems.PEANUT.get()), has(ModItems.PEANUT.get()))
                .save(output, id("cooking/nut_mash_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.NUT_MILK.get(), 1, 400, 2.0F, Items.GLASS_BOTTLE)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(ModItems.PEANUT.get())
                .addIngredient(ModItems.PEANUT.get())
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.PEANUT.get()), has(ModItems.PEANUT.get()))
                .save(output, id("cooking/nut_milk"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.OATMEAL.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(ModItems.RAW_OAT.get())
                .addIngredient(ModItems.RAW_OAT.get())
                .addIngredient(ModItems.RAW_OAT.get())
                .addIngredient(Items.MILK_BUCKET)
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.RAW_OAT.get()), has(ModItems.RAW_OAT.get()))
                .save(output, id("cooking/oatmeal"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.PAD_THAI.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(ModItems.CUCUMBER_NOODLES.get())
                .addIngredient(ModItems.CUCUMBER_NOODLES.get())
                .addIngredient(ModItems.PEANUT.get())
                .addIngredient(Items.EGG)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy(getHasName(ModItems.CUCUMBER_NOODLES.get()), has(ModItems.CUCUMBER_NOODLES.get()))
                .save(output, id("cooking/pad_thai"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.PEPPER_JAM_JAR.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(ModItems.GHOST_PEPPER.get())
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.GHOST_PEPPER.get()), has(ModItems.GHOST_PEPPER.get()))
                .save(output, id("cooking/pepper_jam_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.PICKLE_SOUP.get(), 1, 200, 2.0F, Items.BOWL)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .addIngredient(ModItems.PICKLE.get())
                .addIngredient(ModItems.PICKLE.get())
                .addIngredient(Items.BAKED_POTATO)
                .addIngredient(Items.MILK_BUCKET)
                .unlockedBy(getHasName(ModItems.PICKLE.get()), has(ModItems.PICKLE.get()))
                .save(output, id("cooking/pickle_soup"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.RELISH.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(ModItems.CUCUMBER.get())
                .addIngredient(ModItems.CUCUMBER.get())
                .addIngredient(ModItems.CUCUMBER.get())
                .addIngredient(ModItems.CUCUMBER.get())
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.CUCUMBER.get()), has(ModItems.CUCUMBER.get()))
                .save(output, id("cooking/relish_jar"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SWEET_BERRY_JAM.get(), 1, 400, 2.0F, ModItems.MASON_JAR.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .save(output, id("cooking/sweet_berry_jam_jar"));
    }

    private void registerCuttingRecipes(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.CHEESE_PIZZA.get()), knifeIngredient(), ModItems.CHEESE_PIZZA_SLICE.get(), 1)
                .addResult(ModItems.CHEESE_PIZZA_SLICE.get(), 3)
                .unlockedBy(getHasName(ModBlocks.CHEESE_PIZZA.get()), has(ModBlocks.CHEESE_PIZZA.get()))
                .save(output, id("cutting/cheese_pizza_from_cutting"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.CHEESE_WHEEL.get()), knifeIngredient(), ModItems.CHEESE_SLICE.get(), 4)
                .unlockedBy(getHasName(ModItems.CHEESE_WHEEL.get()), has(ModItems.CHEESE_WHEEL.get()))
                .save(output, id("cutting/cheese_wheel_from_cutting"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.CUCUMBER_DOUGH.get()), knifeIngredient(), ModItems.CUCUMBER_NOODLES.get())
                .unlockedBy(getHasName(ModItems.CUCUMBER.get()), has(ModItems.CUCUMBER.get()))
                .save(output, id("cutting/cucumber_dough_cutting"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.MAGIC_VINE.get()), knifeIngredient(), ModBlocks.STRIPPED_MAGIC_VINE.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_VINE.get()), has(ModBlocks.MAGIC_VINE.get()))
                .save(output, id("cutting/magic_vine"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.MAGIC_VINE_BLOCK.get()), knifeIngredient(), ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_VINE_BLOCK.get()), has(ModBlocks.MAGIC_VINE_BLOCK.get()))
                .save(output, id("cutting/magic_vine_block"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.MEAT_PIZZA.get()), knifeIngredient(), ModItems.MEAT_PIZZA_SLICE.get(), 1)
                .addResult(ModItems.MEAT_PIZZA_SLICE.get(), 3)
                .unlockedBy(getHasName(ModBlocks.MEAT_PIZZA.get()), has(ModBlocks.MEAT_PIZZA.get()))
                .save(output, id("cutting/meat_pizza_from_cutting"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.OAT.get()), knifeIngredient(), ModItems.RAW_OAT.get())
                .addResult(STRAW.get(), 1)
                .unlockedBy(getHasName(ModItems.OAT.get()), has(ModItems.OAT.get()))
                .save(output, id("cutting/oat_cutting"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.PITCHER_PLANT), knifeIngredient(), Items.CYAN_DYE, 2)
                .addResultWithChance(Items.PITCHER_POD, 0.75F)
                .unlockedBy(getHasName(Items.PITCHER_PLANT), has(Items.PITCHER_PLANT))
                .save(output, id("cutting/pitcher_plant"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.STRIPPED_MAGIC_VINE.get()), knifeIngredient(), ModItems.OAT.get(), 1)
                .addResult(TREE_BARK.get(), 1)
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAGIC_VINE.get()), has(ModBlocks.STRIPPED_MAGIC_VINE.get()))
                .save(output, id("cutting/stripped_magic_vine"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get()), knifeIngredient(), ModItems.OAT.get(), 4)
                .addResult(TREE_BARK.get(), 1)
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get()), has(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get()))
                .save(output, id("cutting/stripped_magic_vine_block"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.WILD_CUCUMBERS.get()), knifeIngredient(), ModItems.CUCUMBER.get(), 2)
                .unlockedBy(getHasName(ModBlocks.WILD_CUCUMBERS.get()), has(ModBlocks.WILD_CUCUMBERS.get()))
                .save(output, id("cutting/wild_cucumbers"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.WILD_GHOST_PEPPERS.get()), knifeIngredient(), ModItems.GHOST_PEPPER.get(), 2)
                .unlockedBy(getHasName(ModBlocks.WILD_GHOST_PEPPERS.get()), has(ModBlocks.WILD_GHOST_PEPPERS.get()))
                .save(output, id("cutting/wild_ghost_peppers"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.WILD_OATS.get()), knifeIngredient(), ModItems.OAT.get(), 2)
                .unlockedBy(getHasName(ModBlocks.WILD_OATS.get()), has(ModBlocks.WILD_OATS.get()))
                .save(output, id("cutting/wild_oats"));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModBlocks.WILD_PEANUTS.get()), knifeIngredient(), ModItems.PEANUT.get(), 2)
                .unlockedBy(getHasName(ModBlocks.WILD_PEANUTS.get()), has(ModBlocks.WILD_PEANUTS.get()))
                .save(output, id("cutting/wild_peanuts"));
    }

    private void registerFermentingRecipes(RecipeOutput output, HolderLookup.Provider registries) {
        FermentingRecipeBuilder.fermenting(ModItems.KIMCHI.get(), 4)
                .requires(CABBAGE_LEAF.get())
                .requires(CABBAGE_LEAF.get())
                .requires(CABBAGE_LEAF.get())
                .requires(CABBAGE_LEAF.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/chili_pepper")))
                .withSecondaryOutput(ModItems.PICKLED_PEPPER.get(), 1)
                .processingTime(2400)
                .save(output, id("fermenting/kimchi_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLE.get(), 5)
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/vegetable/cucumber")))
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickle_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLED_BEETROOT.get(), 4)
                .requires(Items.BEETROOT)
                .requires(Items.BEETROOT)
                .requires(Items.BEETROOT)
                .requires(Items.BEETROOT)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickled_beetroot_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLED_EGG.get(), 4)
                .requires(Items.EGG)
                .requires(Items.EGG)
                .requires(Items.EGG)
                .requires(Items.EGG)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickled_egg_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLED_PEPPER.get(), 4)
                .requires(ModItems.GHOST_PEPPER.get())
                .requires(ModItems.GHOST_PEPPER.get())
                .requires(ModItems.GHOST_PEPPER.get())
                .requires(ModItems.GHOST_PEPPER.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickled_ghost_pepper_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLED_ONION.get(), 4)
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:crops/onion")))
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickled_onion_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.PICKLED_PITCHER_POD.get(), 4)
                .requires(Items.PITCHER_POD)
                .requires(Items.PITCHER_POD)
                .requires(Items.PITCHER_POD)
                .requires(Items.PITCHER_POD)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/pickled_pitcher_pod_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.VINEGAR.get(), 1)
                .requires(ItemTags.create(ResourceLocation.parse("c:jam_jars")))
                .requires(ItemTags.create(ResourceLocation.parse("c:mushrooms")))
                .withSecondaryOutput(ModItems.ORGANIC_MASH.get(), 3)
                .processingTime(2400)
                .save(output, id("fermenting/vinegar_from_jam"));

        FermentingRecipeBuilder.fermenting(ModItems.VINEGAR_BOTTLE.get(), 1)
                .withContainer(Items.GLASS_BOTTLE)
                .requires(ItemTags.create(ResourceLocation.parse("c:jam_bottles")))
                .requires(ItemTags.create(ResourceLocation.parse("c:mushrooms")))
                .withSecondaryOutput(ModItems.ORGANIC_MASH.get(), 1)
                .processingTime(2400)
                .save(output, id("fermenting/vinegar_from_jam_bottles"));

        FermentingRecipeBuilder.fermenting(Items.LEATHER)
                .requires(Items.ROTTEN_FLESH)
                .requires(Items.ROTTEN_FLESH)
                .requires(Items.ROTTEN_FLESH)
                .requires(Items.ROTTEN_FLESH)
                .processingTime(4000)
                .save(output, id("fermenting/leather_from_fermenting"));

        FermentingRecipeBuilder.fermenting(Items.FERMENTED_SPIDER_EYE)
                .requires(Items.SPIDER_EYE)
                .requires(ItemTags.create(ResourceLocation.parse("c:mushrooms")))
                .processingTime(1200)
                .save(output, id("fermenting/fermented_spider_eye_from_fermenting"));

        FermentingRecipeBuilder.fermenting(Items.SLIME_BLOCK)
                .requires(ModTags.SLIME_BALL_FERMENTING)
                .requires(ModTags.SLIME_BALL_FERMENTING)
                .requires(ModTags.SLIME_BALL_FERMENTING)
                .requires(ModTags.SLIME_BALL_FERMENTING)
                .requires(ModTags.SLIME_BALL_FERMENTING)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(1200)
                .save(output, id("fermenting/slime_block_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.CENTURY_EGG.get())
                .requires(Items.SNIFFER_EGG)
                .requires(Items.COAL)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(216000)
                .save(output, id("fermenting/century_egg_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.OVERNIGHT_OATS.get())
                .withContainer(Items.BOWL)
                .requires(ModItems.RAW_OAT.get())
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .requires(ItemTags.create(ResourceLocation.parse("c:foods/berry")))
                .requires(PUMPKIN_SLICE.get())
                .requires(Items.MELON_SLICE)
                .requires(Items.APPLE)
                .processingTime(1200)
                .save(output, id("fermenting/overnight_oats_from_fermenting"));

        FermentingRecipeBuilder.fermenting(ModItems.SURSTROMMING.get(), 5)
                .requires(ModTags.RAW_FISH)
                .requires(ModTags.RAW_FISH)
                .requires(ModTags.RAW_FISH)
                .requires(ModTags.RAW_FISH)
                .requires(ModTags.RAW_FISH)
                .requires(ItemTags.create(ResourceLocation.parse("c:salt")))
                .processingTime(2400)
                .save(output, id("fermenting/surstromming_from_fermenting"));

        FermentingRecipeBuilder.fermenting(Items.OCHRE_FROGLIGHT, 3)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .requires(Items.MAGMA_CREAM)
                .requires(ModBlocks.SALT_BLOCK.get())
                .requires(ModItems.VINEGAR_BOTTLE.get())
                .withSecondaryOutput(Items.GLASS_BOTTLE, 1)
                .processingTime(2400)
                .save(output, id("fermenting/ochre_froglight_from_fermenting"));

        FermentingRecipeBuilder.fermenting(Items.PEARLESCENT_FROGLIGHT, 3)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.PRISMARINE_CRYSTALS)
                .requires(Items.SEA_PICKLE)
                .requires(ModBlocks.SALT_BLOCK.get())
                .requires(ModItems.VINEGAR_BOTTLE.get())
                .withSecondaryOutput(Items.GLASS_BOTTLE, 1)
                .processingTime(2400)
                .save(output, id("fermenting/pearlescent_froglight_from_fermenting"));

        FermentingRecipeBuilder.fermenting(Items.VERDANT_FROGLIGHT, 3)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.SLIME_BLOCK)
                .requires(Items.GLOWSTONE_DUST)
                .requires(Items.GLOW_BERRIES)
                .requires(ModBlocks.SALT_BLOCK.get())
                .requires(ModItems.VINEGAR_BOTTLE.get())
                .withSecondaryOutput(Items.GLASS_BOTTLE, 1)
                .processingTime(2400)
                .save(output, id("fermenting/verdant_froglight_from_fermenting"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Berserker\\'s Brew\",\"italic\":false}',\"minecraft:dyed_color\":11141120,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:strength\",amplifier:2,duration:600},{id:\"minecraft:resistance\",amplifier:3,duration:600},{id:\"minecraft:wither\",duration:400}]}}}"))
                .withContainer(Items.GLASS_BOTTLE)
                .requires(Items.BLAZE_POWDER)
                .requires(ModItems.SALT_DUST.get())
                .requires(Items.CRIMSON_FUNGUS)
                .requires(Items.FERMENTED_SPIDER_EYE)
                .requires(Items.GHAST_TEAR)
                .processingTime(400)
                .save(output, id("fermenting/berserks_brew"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Brashing Tonic\",\"italic\":false}',\"minecraft:dyed_color\":13458603,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:regeneration\",amplifier:1,duration:400},{id:\"minecraft:slowness\",amplifier:1,duration:400}]}}}"))
                .withContainer(Items.GLASS_BOTTLE)
                .requires(Items.RED_MUSHROOM)
                .requires(Items.SPIDER_EYE)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SUGAR)
                .requires(TOMATO_SEEDS.get())
                .processingTime(600)
                .save(output, id("fermenting/brashing_tonic"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Dragon\\'s Belch\",\"italic\":false}',\"minecraft:dyed_color\":16087807,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:jump_boost\",amplifier:2,duration:400},{id:\"minecraft:levitation\",duration:400},{id:\"minecraft:nausea\",duration:400}]}}}"))
                .requires(Items.DRAGON_BREATH)
                .requires(Items.RABBIT_FOOT)
                .requires(Items.SUGAR)
                .requires(Items.FIRE_CORAL)
                .requires(ModItems.RAW_OAT.get())
                .processingTime(400)
                .save(output, id("fermenting/dragons_belch"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Frost Fermenta\",\"italic\":false}',\"minecraft:dyed_color\":3937500,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:fire_resistance\",duration:3600},{id:\"minecraft:slowness\",duration:3600}]}}}"))
                .requires(ModItems.GHOST_PEPPER_SEEDS.get())
                .requires(ROTTEN_TOMATO.get())
                .requires(MILK_BOTTLE.get())
                .requires(Items.SNOWBALL)
                .requires(Items.KELP)
                .processingTime(600)
                .save(output, id("fermenting/frost_fermenta"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Goblin\\'s Piss\",\"italic\":false}',\"minecraft:dyed_color\":16771840,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:speed\",amplifier:2,duration:600},{id:\"minecraft:weakness\",amplifier:1,duration:600}]}}}"))
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.HONEY_BOTTLE)
                .requires(ModItems.GEARO_BERRY_ITEM.get())
                .requires(Items.SUGAR)
                .requires(Items.BONE_MEAL)
                .processingTime(600)
                .save(output, id("fermenting/goblins_piss"));

        FermentingRecipeBuilder.fermenting(potionStack(registries, "{id:\"minecraft:potion\",Count:1b,components:{\"minecraft:custom_name\":'{\"text\":\"Oily Oaf\",\"italic\":false}',\"minecraft:dyed_color\":5521732,\"minecraft:potion_contents\":{custom_effects:[{id:\"minecraft:haste\",amplifier:1,duration:1200},{id:\"minecraft:hunger\",duration:1200}]}}}"))
                .withContainer(Items.GLASS_BOTTLE)
                .requires(Items.SUGAR)
                .requires(Items.GOLDEN_CARROT)
                .requires(Items.REDSTONE)
                .requires(ModItems.PICKLED_ONION.get())
                .requires(Items.GLOW_BERRIES)
                .processingTime(600)
                .save(output, id("fermenting/oily_oaf"));
    }

    private void saltLamp(RecipeOutput output, String name, String dyeTag, ItemLike result, ResourceLocation shapedId) {
        ResourceLocation shaped = shapedId != null ? shapedId : id("salt_lamps/salt_lamp_" + name);
        ResourceLocation shapeless = id("salt_lamps/salt_lamp_" + name + ("default".equals(name) ? "2" : (name.equals("brown") || name.equals("cyan") || name.equals("gray") || name.equals("green") || name.equals("lime") ? "2" : "_2")));

        ShapedRecipeBuilder shapedBuilder = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern(" M ")
                .pattern("XQX")
                .pattern(" # ")
                .define('#', Items.DEEPSLATE_TILES)
                .define('Q', Items.GLOWSTONE)
                .define('X', ModBlocks.SALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SALT_BLOCK.get()), has(ModBlocks.SALT_BLOCK.get()));
        if (dyeTag == null) {
            shapedBuilder.define('M', ItemTags.create(ResourceLocation.parse("c:salt")));
        } else {
            shapedBuilder.define('M', ItemTags.create(ResourceLocation.parse(dyeTag)));
        }
        shapedBuilder.save(output, shaped);

        ShapelessRecipeBuilder shapelessBuilder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(ModTags.SALT_LAMP)
                .unlockedBy("has_salt_lamp", has(ModTags.SALT_LAMP));
        if (dyeTag == null) {
            shapelessBuilder.requires(ItemTags.create(ResourceLocation.parse("c:salt")));
        } else {
            shapelessBuilder.requires(ItemTags.create(ResourceLocation.parse(dyeTag)));
        }
        shapelessBuilder.save(output, shapeless);
    }

    private void bottleToJar(RecipeOutput output, String idPath, ItemLike bottle, ItemLike jar) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, jar)
                .pattern("X#")
                .pattern("##")
                .define('X', ModItems.MASON_JAR.get())
                .define('#', bottle)
                .unlockedBy(getHasName(bottle), has(bottle))
                .save(output, id(idPath));
    }

    private void jarToBottle(RecipeOutput output, String idPath, ItemLike jar, ItemLike bottle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, bottle, 3)
                .pattern("X#")
                .pattern("##")
                .define('X', jar)
                .define('#', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(jar), has(jar))
                .save(output, id(idPath));
    }

    private ItemStack potionStack(HolderLookup.Provider registries, String snbt) {
        return FermentingRecipeBuilder.stackWithNbt(registries, snbt);
    }
}
