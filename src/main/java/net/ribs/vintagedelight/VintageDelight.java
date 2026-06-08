package net.ribs.vintagedelight;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.ribs.vintagedelight.init.ModBlockEntities;
import net.ribs.vintagedelight.init.ModArmorMaterials;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.init.ModCreativeModTabs;
import net.ribs.vintagedelight.init.ModMenuTypes;
import net.ribs.vintagedelight.init.ModPotions;
import net.ribs.vintagedelight.init.ModRecipes;
import net.ribs.vintagedelight.init.items.ModItems;
import net.ribs.vintagedelight.init.ModModEffects;
import net.ribs.vintagedelight.worldgen.tree.ModTrunkPlacerTypes;

@Mod(VintageDelight.MODID)
public class VintageDelight {
    public static final String MODID = "vintagedelight";

    public VintageDelight(IEventBus modEventBus) {
        ModCreativeModTabs.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        modEventBus.addListener(ModBlockEntities::registerCapabilities);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        ModTrunkPlacerTypes.register(modEventBus);
        ModModEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
    }

    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.WATER, ModItems.SALT_DUST.get(), ModPotions.DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.REDSTONE, ModPotions.LONG_DEHYDRATED_POTION);
        event.getBuilder().addMix(ModPotions.DEHYDRATED_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_DEHYDRATED_POTION);
    }
}

