package net.ribs.vintagedelight.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, VintageDelight.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<VineTrunkPlacer>> VINE_TRUNK_PLACER =
            TRUNK_PLACER.register("vine_trunk_placer", () -> new TrunkPlacerType<>(VineTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}

