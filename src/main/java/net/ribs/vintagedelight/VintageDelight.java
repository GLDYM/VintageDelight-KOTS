package net.ribs.vintagedelight;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.block.entity.ModBlockEntities;
import net.ribs.vintagedelight.item.ModCreativeModTabs;
import net.ribs.vintagedelight.item.ModItems;
import net.ribs.vintagedelight.mobEffects.ModPotions;
import net.ribs.vintagedelight.mobEffects.VDModEffects;
import net.ribs.vintagedelight.recipe.ModRecipes;
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
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        ModTrunkPlacerTypes.register(modEventBus);
        VDModEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
    }

    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.WATER, ModItems.SALT_DUST.get(), ModPotions.DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.REDSTONE, ModPotions.LONG_DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_DEHYDRATED_POTION);
    }
}

