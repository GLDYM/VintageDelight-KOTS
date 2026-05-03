package net.ribs.vintagedelight.mobEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ribs.vintagedelight.VintageDelight;

public class VDModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, VintageDelight.MODID);

    public static final RegistryObject<MobEffect> DEHYDRATED =
            MOB_EFFECTS.register("dehydrated", DehydratedMobEffect::new);
}
