package net.ribs.vintagedelight.compat;


import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.recipe.FermentingRecipe;
import java.awt.*;

public class FermentingCategory implements IRecipeCategory<FermentingRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "fermenting");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "textures/gui/fermenting_jar_gui.png");
    public static final RecipeType<FermentingRecipe> FERMENTING_TYPE =
            new RecipeType<>(UID, FermentingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;
    private final int offsetX = 10;
    private final int offsetY = 10;
    public FermentingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, offsetX, offsetY, 154, 65);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FERMENTING_JAR.get()));
    }

    @Override
    public RecipeType<FermentingRecipe> getRecipeType() {
        return FERMENTING_TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.translatable("block.vintagedelight.fermenting_jar");
    }
    @Override
    public IDrawable getBackground() {
        return this.background;
    }
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FermentingRecipe recipe, IFocusGroup focuses) {
        int inputBaseX = 6;
        int firstRowY = 7;
        int secondRowY = firstRowY + 18;
        int inputSpacing = 18;
        int outputOffsetX = 90;
        int secondaryOutputX = outputOffsetX + inputSpacing;
        int additionalSpacing = 2;
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            int row = i / 3;
            int col = i % 3;
            int x = inputBaseX + (col * inputSpacing) + offsetX;
            int y = (row == 0) ? firstRowY + offsetY : secondRowY + offsetY;
            builder.addSlot(RecipeIngredientRole.INPUT, x, y)
                    .addIngredients(recipe.getIngredients().get(i));
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, inputBaseX + outputOffsetX + offsetX, secondRowY + offsetY)
                .addItemStack(recipe.getResultItem(null));
        if (!recipe.getSecondaryResultItem().isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, inputBaseX + secondaryOutputX + offsetX, secondRowY + offsetY)
                    .addItemStack(recipe.getSecondaryResultItem());
        }
        int containerSlotX = inputBaseX + (2 * inputSpacing) + inputSpacing + additionalSpacing + offsetX;
        int containerSlotY = firstRowY + offsetY;
        ItemStack containerItemStack = recipe.getContainerItemStack();
        if (!containerItemStack.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.INPUT, containerSlotX, containerSlotY)
                    .addItemStack(containerItemStack);
        }
    }
    @Override
    public void draw(FermentingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        int processingTime = recipe.getProcessingTime();
        if (processingTime > 0) {
            int minutes = processingTime / (20 * 60);
            String processingTimeText = String.format("%dmin", minutes);
            guiGraphics.drawString(Minecraft.getInstance().font, processingTimeText, 100 + offsetX, 10 + offsetY, Color.gray.getRGB(), false);
        }
    }

}
