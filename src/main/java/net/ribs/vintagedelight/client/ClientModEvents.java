package net.ribs.vintagedelight.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.entity.ModBlockEntities;
import net.ribs.vintagedelight.block.entity.renderer.FermentingJarBlockEntityRenderer;
import net.ribs.vintagedelight.screen.FermentingJarScreen;
import net.ribs.vintagedelight.screen.ModMenuTypes;

@EventBusSubscriber(modid = VintageDelight.MODID, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.FERMENTING_JAR_BE.get(), FermentingJarBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.FERMENTING_MENU.get(), FermentingJarScreen::new);
    }
}
