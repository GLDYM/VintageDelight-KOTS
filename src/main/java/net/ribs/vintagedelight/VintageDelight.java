package net.ribs.vintagedelight;


import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.block.entity.ModBlockEntities;
import net.ribs.vintagedelight.item.ModCreativeModTabs;
import net.ribs.vintagedelight.item.ModItems;
import net.ribs.vintagedelight.mobEffects.ModPotions;
import net.ribs.vintagedelight.mobEffects.VDModEffects;
import net.ribs.vintagedelight.recipe.ModRecipes;
import net.ribs.vintagedelight.screen.FermentingJarScreen;
import net.ribs.vintagedelight.screen.ModMenuTypes;
import net.ribs.vintagedelight.worldgen.tree.ModTrunkPlacerTypes;

@Mod(VintageDelight.MODID)
public class VintageDelight {
    public static final String MODID = "vintagedelight";

    public VintageDelight(IEventBus modEventBus) {
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        modEventBus.addListener(ModBlockEntities::registerCapabilities);
        modEventBus.addListener(this::commonSetup);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
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

    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.WATER, ModItems.SALT_DUST.get(), ModPotions.DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.REDSTONE, ModPotions.LONG_DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_DEHYDRATED_POTION);
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
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

        @SubscribeEvent
        public static void registerMenuScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.FERMENTING_MENU.get(), FermentingJarScreen::new);
        }
    }

}

