package net.ribs.vintagedelight.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class JamBlock extends MasonJarBlock {
    public JamBlock(BlockBehaviour.Properties properties, Supplier<? extends Item> jarItem) {
        super(properties, jarItem);
    }
}
