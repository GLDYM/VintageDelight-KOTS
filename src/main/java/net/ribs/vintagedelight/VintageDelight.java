package net.ribs.vintagedelight;


import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.block.entity.ModBlockEntities;
import net.ribs.vintagedelight.item.ModCreativeModTabs;
import net.ribs.vintagedelight.item.ModItems;
import net.ribs.vintagedelight.mobEffects.CustomPotionBrewing;
import net.ribs.vintagedelight.mobEffects.ModPotions;
import net.ribs.vintagedelight.mobEffects.VDModEffects;
import net.ribs.vintagedelight.recipe.ModRecipes;
import net.ribs.vintagedelight.screen.FermentingJarScreen;
import net.ribs.vintagedelight.screen.ModMenuTypes;
import net.ribs.vintagedelight.worldgen.tree.ModTrunkPlacerTypes;

@Mod(VintageDelight.MODID)
public class VintageDelight {
    public static final String MODID = "vintagedelight";

    public VintageDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModTrunkPlacerTypes.register(modEventBus);
        VDModEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.PEANUT.get(), 0.4F);
            ComposterBlock.COMPOSTABLES.put(ModItems.GEARO_BERRY_ITEM.get(), 0.4F);
            ComposterBlock.COMPOSTABLES.put(ModItems.GHOST_PEPPER.get(), 0.4F);
            ComposterBlock.COMPOSTABLES.put(ModItems.GHOST_PEPPER_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CUCUMBER.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CUCUMBER_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.OAT_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLE.get(), 0.4F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLED_PEPPER.get(), 0.4F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLED_BEETROOT.get(), 0.6F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLED_EGG.get(), 0.6F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLED_ONION.get(), 0.6F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PICKLED_PITCHER_POD.get(), 0.6F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CENTURY_EGG.get(), 0.9F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MAGIC_PEANUT.get(), 0.85F);
            ComposterBlock.COMPOSTABLES.put(ModItems.OAT.get(), 0.3F);


        });
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CustomPotionBrewing.addMix(Potions.WATER, ModItems.SALT_DUST.get(), ModPotions.DEHYDRATED_POTION.get());
            CustomPotionBrewing.addMix(ModPotions.DEHYDRATED_POTION.get(), Items.REDSTONE, ModPotions.LONG_DEHYDRATED_POTION.get());
            CustomPotionBrewing.addMix(ModPotions.DEHYDRATED_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_DEHYDRATED_POTION.get());
        });
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.FERMENTING_MENU.get(), FermentingJarScreen::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.FERMENTING_JAR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGIC_PEANUT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OAT_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_OATS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEARO_BERRY_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEANUT_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_PEANUTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GHOST_PEPPER_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_GHOST_PEPPERS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBER_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CUCUMBERS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EMPTY_MASON_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEPPER_JAM_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEARO_BERRY_JAM_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SWEET_BERRY_JAM_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOW_BERRY_JAM_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.APPLE_SAUCE_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.NUT_MASH_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RELISH_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VINEGAR_JAR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.HONEY_JAR.get(), RenderType.cutout());
        }
    }

}
