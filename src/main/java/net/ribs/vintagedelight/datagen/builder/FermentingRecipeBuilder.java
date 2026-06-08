package net.ribs.vintagedelight.datagen.builder;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.ribs.vintagedelight.recipe.FermentingRecipe;

public class FermentingRecipeBuilder {
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private Ingredient container = Ingredient.EMPTY;
    private final ItemStack output;
    private ItemStack secondaryOutput = ItemStack.EMPTY;
    private int processingTime = 100;

    private FermentingRecipeBuilder(ItemLike result, int count) {
        this.output = new ItemStack(result, count);
    }

    private FermentingRecipeBuilder(ItemStack result) {
        this.output = result.copy();
    }

    public static FermentingRecipeBuilder fermenting(ItemLike result) {
        return new FermentingRecipeBuilder(result, 1);
    }

    public static FermentingRecipeBuilder fermenting(ItemLike result, int count) {
        return new FermentingRecipeBuilder(result, count);
    }

    public static FermentingRecipeBuilder fermenting(ItemStack result) {
        return new FermentingRecipeBuilder(result);
    }

    public FermentingRecipeBuilder requires(ItemLike item) {
        this.ingredients.add(Ingredient.of(item));
        return this;
    }

    public FermentingRecipeBuilder requires(TagKey<Item> tag) {
        this.ingredients.add(Ingredient.of(tag));
        return this;
    }

    public FermentingRecipeBuilder requires(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public FermentingRecipeBuilder withContainer(ItemLike item) {
        this.container = Ingredient.of(item);
        return this;
    }

    public FermentingRecipeBuilder withContainer(TagKey<Item> tag) {
        this.container = Ingredient.of(tag);
        return this;
    }

    public FermentingRecipeBuilder withSecondaryOutput(ItemLike item, int count) {
        this.secondaryOutput = new ItemStack(item, count);
        return this;
    }

    public FermentingRecipeBuilder withSecondaryOutput(ItemStack stack) {
        this.secondaryOutput = stack.copy();
        return this;
    }

    public FermentingRecipeBuilder processingTime(int processingTime) {
        this.processingTime = processingTime;
        return this;
    }

    public void save(RecipeOutput output, ResourceLocation id) {
        output.accept(id, new FermentingRecipe(this.ingredients, this.container, this.output, this.secondaryOutput, this.processingTime), null);
    }

    public static ItemStack stackWithNbt(HolderLookup.Provider provider, String snbt) {
        try {
            CompoundTag tag = TagParser.parseTag(snbt);
            return ItemStack.parseOptional(provider, tag);
        } catch (Exception exception) {
            throw new IllegalArgumentException("Failed to parse ItemStack SNBT: " + snbt, exception);
        }
    }
}
