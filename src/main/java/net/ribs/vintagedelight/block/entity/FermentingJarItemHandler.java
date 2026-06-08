package net.ribs.vintagedelight.block.entity;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class FermentingJarItemHandler implements IItemHandler {
    private final IItemHandler itemHandler;

    public FermentingJarItemHandler(IItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }

    public IItemHandler forSide(@Nullable Direction side) {
        if (side == null) {
            return itemHandler;
        }

        int[] exposedSlots = createExposedSlots(side);
        return new IItemHandler() {
            @Override
            public int getSlots() {
                return exposedSlots.length;
            }

            @Override
            public ItemStack getStackInSlot(int slot) {
                return FermentingJarItemHandler.this.getStackInSlot(slot, exposedSlots);
            }

            @Override
            public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
                return FermentingJarItemHandler.this.insertItem(slot, stack, side, simulate, exposedSlots);
            }

            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return FermentingJarItemHandler.this.extractItem(slot, amount, exposedSlots, simulate);
            }

            @Override
            public int getSlotLimit(int slot) {
                return FermentingJarItemHandler.this.getSlotLimit(slot, exposedSlots);
            }

            @Override
            public boolean isItemValid(int slot, ItemStack stack) {
                return FermentingJarItemHandler.this.isItemValid(slot, stack, exposedSlots);
            }
        };
    }

    private static int[] createExposedSlots(@Nullable Direction side) {
        if (side == Direction.UP) {
            int[] inputSlots = new int[FermentingJarBlockEntity.INPUT_SLOT_COUNT];
            for (int i = 0; i < inputSlots.length; i++) {
                inputSlots[i] = FermentingJarBlockEntity.FIRST_INGREDIENT_SLOT + i;
            }
            return inputSlots;
        }

        if (side == Direction.DOWN) {
            return new int[]{FermentingJarBlockEntity.FIRST_OUTPUT_SLOT, FermentingJarBlockEntity.SECOND_OUTPUT_SLOT};
        }

        return new int[]{FermentingJarBlockEntity.CONTAINER_SLOT};
    }

    private int mapSlot(int slot, int[] exposedSlots) {
        if (slot < 0 || slot >= exposedSlots.length) {
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + exposedSlots.length + ")");
        }
        return exposedSlots[slot];
    }

    private boolean isInputView(@Nullable Direction side, int[] exposedSlots) {
        return side == Direction.UP && exposedSlots.length == FermentingJarBlockEntity.INPUT_SLOT_COUNT;
    }

    public ItemStack getStackInSlot(int slot, int[] exposedSlots) {
        return itemHandler.getStackInSlot(mapSlot(slot, exposedSlots));
    }

    public ItemStack insertItem(int slot, ItemStack stack, @Nullable Direction side, boolean simulate,
                                int[] exposedSlots) {
        if (isInputView(side, exposedSlots) && !stack.isEmpty()) {
            ItemStack remaining = stack.copy();
            ItemStack single = stack.copyWithCount(1);
            int[] emptyCandidates = new int[exposedSlots.length];
            int emptyCount = 0;

            for (int exposedSlot : exposedSlots) {
                if (!itemHandler.getStackInSlot(exposedSlot).isEmpty()) {
                    continue;
                }
                if (!itemHandler.insertItem(exposedSlot, single, true).isEmpty()) {
                    continue;
                }
                emptyCandidates[emptyCount++] = exposedSlot;
            }

            for (int i = 0; i < emptyCount && !remaining.isEmpty(); ++i) {
                if (itemHandler.insertItem(emptyCandidates[i], single, simulate).isEmpty()) {
                    remaining.shrink(1);
                }
            }

            while (!remaining.isEmpty()) {
                int bestSlot = -1;
                int bestCount = Integer.MAX_VALUE;

                for (int exposedSlot : exposedSlots) {
                    ItemStack slotStack = itemHandler.getStackInSlot(exposedSlot);
                    if (slotStack.isEmpty()) {
                        continue;
                    }
                    if (!ItemStack.isSameItemSameComponents(slotStack, remaining)) {
                        continue;
                    }
                    if (!itemHandler.insertItem(exposedSlot, single, true).isEmpty()) {
                        continue;
                    }

                    int count = slotStack.getCount();
                    if (count < bestCount) {
                        bestCount = count;
                        bestSlot = exposedSlot;
                    }
                }

                if (bestSlot == -1) {
                    break;
                }

                int beforeCount = remaining.getCount();
                remaining = itemHandler.insertItem(bestSlot, remaining, simulate);
                if (remaining.getCount() == beforeCount) {
                    break;
                }
            }

            return remaining;
        }

        return itemHandler.insertItem(mapSlot(slot, exposedSlots), stack, simulate);
    }

    public ItemStack insertItem(int slot, ItemStack stack, @Nullable Direction side, boolean simulate) {
        return insertItem(slot, stack, side, simulate, createExposedSlots(side));
    }

    public ItemStack extractItem(int slot, int amount, int[] exposedSlots, boolean simulate) {
        return itemHandler.extractItem(mapSlot(slot, exposedSlots), amount, simulate);
    }

    public int getSlotLimit(int slot, int[] exposedSlots) {
        return itemHandler.getSlotLimit(mapSlot(slot, exposedSlots));
    }

    public boolean isItemValid(int slot, ItemStack stack, int[] exposedSlots) {
        return itemHandler.isItemValid(mapSlot(slot, exposedSlots), stack);
    }

    @Override
    public int getSlots() {
        return itemHandler.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return itemHandler.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return itemHandler.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
        return itemHandler.getSlotLimit(slot);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return itemHandler.isItemValid(slot, stack);
    }
}
