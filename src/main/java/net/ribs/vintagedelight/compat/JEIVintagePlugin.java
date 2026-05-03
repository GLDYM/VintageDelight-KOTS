package net.ribs.vintagedelight.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.item.ModItems;
import net.ribs.vintagedelight.recipe.FermentingRecipe;
import net.ribs.vintagedelight.screen.FermentingJarScreen;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JEIVintagePlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FermentingCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("vintagedelight." + key, args);
    }
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        registration.addIngredientInfo(new ItemStack(ModBlocks.SALT_BLOCK.get()), VanillaTypes.ITEM_STACK, getTranslation("jei.info.salt_block"));
        registration.addIngredientInfo(new ItemStack(ModBlocks.EVAPORATOR.get()), VanillaTypes.ITEM_STACK, getTranslation("jei.info.evaporator"));
        registration.addIngredientInfo(new ItemStack(ModItems.CHEESE_WHEEL.get()), VanillaTypes.ITEM_STACK, getTranslation("jei.info.cheese_wheel"));
        registration.addIngredientInfo(new ItemStack(ModItems.ORGANIC_MASH.get()), VanillaTypes.ITEM_STACK, getTranslation("jei.info.organic_compost"));
        List<FermentingRecipe> fermentingRecipes = recipeManager.getAllRecipesFor(FermentingRecipe.Type.INSTANCE).stream()
                .map(holder -> holder.value())
                .toList();
        registration.addRecipes(FermentingCategory.FERMENTING_TYPE, fermentingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FermentingJarScreen.class, 90, 47, 30, 20,
                FermentingCategory.FERMENTING_TYPE);
    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ItemStack fermentingJarStack = new ItemStack(ModBlocks.FERMENTING_JAR.get());
        RecipeType<FermentingRecipe> fermentingRecipeType = FermentingCategory.FERMENTING_TYPE;
        registration.addRecipeCatalyst(fermentingJarStack, fermentingRecipeType);
    }
}
