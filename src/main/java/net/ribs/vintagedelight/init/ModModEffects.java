package net.ribs.vintagedelight.init;

import net.minecraft.core.registries.Registries;

import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.mobEffects.DehydratedMobEffect;

public class ModModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, VintageDelight.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> DEHYDRATED =
            MOB_EFFECTS.register("dehydrated", DehydratedMobEffect::new);
}

