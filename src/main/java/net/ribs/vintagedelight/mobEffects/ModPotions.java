package net.ribs.vintagedelight.mobEffects;

import net.minecraft.core.registries.Registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(Registries.POTION, VintageDelight.MODID);

    public static final DeferredHolder<Potion, Potion> DEHYDRATED_POTION = POTIONS.register("dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED, 800, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_DEHYDRATED_POTION = POTIONS.register("long_dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED, 1600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_DEHYDRATED_POTION = POTIONS.register("strong_dehydrated",
            () -> new Potion(new MobEffectInstance(VDModEffects.DEHYDRATED, 800, 1)));
}

