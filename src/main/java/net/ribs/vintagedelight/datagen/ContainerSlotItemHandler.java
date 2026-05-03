package net.ribs.vintagedelight.datagen;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.ribs.vintagedelight.item.ModTags;
import org.jetbrains.annotations.NotNull;

public class ContainerSlotItemHandler extends SlotItemHandler {
    public ContainerSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        // Custom validation logic for the container slot
        return stack.is(ModTags.CONTAINER_ITEMS);
    }
}


