package net.ribs.vintagedelight.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ribs.vintagedelight.VintageDelight;

public final class ModTreeDecoratorTypes {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, VintageDelight.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<ConfigurableAlterGroundDecorator>> CONFIGURABLE_ALTER_GROUND =
            TREE_DECORATOR_TYPES.register("configurable_alter_ground", () -> new TreeDecoratorType<>(ConfigurableAlterGroundDecorator.CODEC));

    private ModTreeDecoratorTypes() {
    }

    public static void register(IEventBus eventBus) {
        TREE_DECORATOR_TYPES.register(eventBus);
    }
}
