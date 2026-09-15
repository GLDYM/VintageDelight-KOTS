package net.ribs.vintagedelight.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.ribs.vintagedelight.VintageDelight;

public class FermentingJarScreen extends AbstractContainerScreen<FermentingJarMenu> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "textures/gui/fermenting_jar_gui.png");
    private static final int BACKGROUND_WIDTH = 176;
    private static final int BACKGROUND_HEIGHT = 166;
    private static final int PROGRESS_ARROW_U = 176;
    private static final int PROGRESS_ARROW_V = 0;
    private static final int PROGRESS_ARROW_HEIGHT = 17;


    public FermentingJarScreen(FermentingJarMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = BACKGROUND_WIDTH;
        this.imageHeight = BACKGROUND_HEIGHT;
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelY = 6;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            int arrowX = x + 84;
            int arrowY = y + 32;
            int drawWidth = menu.getScaledProgress();
            guiGraphics.blit(TEXTURE, arrowX, arrowY, PROGRESS_ARROW_U, PROGRESS_ARROW_V, drawWidth, PROGRESS_ARROW_HEIGHT);
        }
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}

