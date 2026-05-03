package net.ribs.vintagedelight.mobEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ribs.vintagedelight.VintageDelight;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, VintageDelight.MODID);

    public static final RegistryObject<Potion> DEHYDRATED_POTION = POTIONS.register("dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED.get(), 800, 0)));
    public static final RegistryObject<Potion> LONG_DEHYDRATED_POTION = POTIONS.register("long_dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED.get(), 1600, 0)));
    public static final RegistryObject<Potion> STRONG_DEHYDRATED_POTION = POTIONS.register("strong_dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED.get(), 800, 1)));
}
