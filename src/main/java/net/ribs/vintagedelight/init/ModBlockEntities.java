package net.ribs.vintagedelight.init;

import net.minecraft.core.registries.Registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.entity.FermentingJarBlockEntity;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, VintageDelight.MODID);



    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FermentingJarBlockEntity>> FERMENTING_JAR_BE =
            BLOCK_ENTITIES.register("fermenting_be", () ->
                    BlockEntityType.Builder.of(FermentingJarBlockEntity::new,
                            ModBlocks.FERMENTING_JAR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                FERMENTING_JAR_BE.get(),
                FermentingJarBlockEntity::getItemHandler);
    }
}

