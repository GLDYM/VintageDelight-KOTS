package net.ribs.vintagedelight.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.ribs.vintagedelight.block.entity.FermentingJarBlockEntity;
import org.joml.Matrix4f;

import java.util.List;
import java.util.Random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FermentingJarBlockEntityRenderer implements BlockEntityRenderer<FermentingJarBlockEntity> {
    private final Random random = new Random();
    private final Map<ItemStack, Float> itemRotations = new HashMap<>();
    private final float maxRotationIncrement = 360.0f; // Maximum rotation degree
    public FermentingJarBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(FermentingJarBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        List<ItemStack> itemStacks = pBlockEntity.getRenderStacks();
        float baseHeight = 0.15f;
        float heightIncrement = 0.06f;

        for (ItemStack stack : itemStacks) {
            // Assign a random rotation angle if this stack is not already in the map
            itemRotations.computeIfAbsent(stack, k -> random.nextFloat() * maxRotationIncrement);

            float rotationAngle = itemRotations.get(stack);

            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, baseHeight, 0.5f);
            pPoseStack.scale(0.4f, 0.4f, 0.4f);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(270));
            pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotationAngle));
            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1);
            pPoseStack.popPose();

            baseHeight += heightIncrement;
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}

