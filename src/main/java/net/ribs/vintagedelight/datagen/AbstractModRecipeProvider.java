package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public abstract class AbstractModRecipeProvider extends RecipeProvider {
    private final String modId;

    protected AbstractModRecipeProvider(PackOutput output, String modId, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
        this.modId = modId;
    }

    protected ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(this.modId, path);
    }

    protected void foodCooking(String recipeName, ItemLike input, ItemLike result, float xp, RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, result, xp, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName + "_from_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, result, xp, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName + "_from_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, result, xp, 600)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName + "_from_campfire_cooking"));
    }

    protected void foodCookingNoCampfire(String recipeName, ItemLike input, ItemLike result, float xp, RecipeOutput output) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, result, xp, 200)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName + "_from_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, result, xp, 100)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName + "_from_smoking"));
    }

    protected void stoneCutting(String recipeName, ItemLike input, ItemLike result, int count, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, count)
                .unlockedBy(getHasName(input), has(input))
                .save(output, id(recipeName));
    }

    protected ShapedRecipeBuilder threeByThree(RecipeCategory category, ItemLike result, ItemLike ingredient, int count) {
        return ShapedRecipeBuilder.shaped(category, result, count)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected ShapelessRecipeBuilder unpack(RecipeCategory category, ItemLike result, int count, ItemLike ingredient) {
        return ShapelessRecipeBuilder.shapeless(category, result, count)
                .requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected ShapedRecipeBuilder twoByTwo(RecipeCategory category, ItemLike result, int count, ItemLike ingredient) {
        return ShapedRecipeBuilder.shaped(category, result, count)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected ShapedRecipeBuilder stairs(RecipeCategory category, ItemLike result, ItemLike ingredient) {
        return ShapedRecipeBuilder.shaped(category, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected ShapedRecipeBuilder slab(RecipeCategory category, ItemLike result, ItemLike ingredient) {
        return ShapedRecipeBuilder.shaped(category, result, 6)
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected ShapedRecipeBuilder wall(RecipeCategory category, ItemLike result, ItemLike ingredient) {
        return ShapedRecipeBuilder.shaped(category, result, 6)
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));
    }

    protected String itemName(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

    protected Ingredient knifeIngredient() {
        return Ingredient.of(ItemTags.create(ResourceLocation.parse("c:tools/knives")));
    }

    protected Ingredient bottleIngredient() {
        return Ingredient.of(Items.GLASS_BOTTLE);
    }

    protected Ingredient itemIngredient(ItemLike item) {
        return Ingredient.of(item);
    }

    protected Ingredient tagIngredient(net.minecraft.tags.TagKey<Item> tag) {
        return Ingredient.of(tag);
    }
}
