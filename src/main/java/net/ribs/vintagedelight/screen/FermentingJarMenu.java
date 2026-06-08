package net.ribs.vintagedelight.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.block.entity.FermentingJarBlockEntity;
import net.ribs.vintagedelight.item.ModTags;

import static net.ribs.vintagedelight.block.entity.FermentingJarBlockEntity.*;
public class FermentingJarMenu extends AbstractContainerMenu {
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int INPUT_SLOT_INDEX_START = TE_INVENTORY_FIRST_SLOT_INDEX + FIRST_INGREDIENT_SLOT;
    private static final int INPUT_SLOT_INDEX_END = INPUT_SLOT_INDEX_START + INPUT_SLOT_COUNT;
    private static final int CONTAINER_SLOT_INDEX = TE_INVENTORY_FIRST_SLOT_INDEX + CONTAINER_SLOT;
    private static final int OUTPUT_SLOT_INDEX_START = TE_INVENTORY_FIRST_SLOT_INDEX + FIRST_OUTPUT_SLOT;

    public final FermentingJarBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public FermentingJarMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(8));
    }
    public FermentingJarMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FERMENTING_MENU.get(), pContainerId);
        checkContainerSize(inv, 7);
        blockEntity = ((FermentingJarBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        var iItemHandler = this.blockEntity.getItemHandler(null);
            int inputBaseX = 26;
            int yOffset = 6;
            int firstRowY = 21 + yOffset;
            int secondRowY = firstRowY + 18;
            int inputSpacing = 18;
            int outputOffsetX = 90;
            int secondaryOutputX = outputOffsetX + inputSpacing;
            for (int i = 0; i < 6; i++) {
                int row = i / 3;
                int col = i % 3;
                int x = inputBaseX + (col * inputSpacing);
                int y = (row == 0) ? firstRowY : secondRowY;
                this.addSlot(new SlotItemHandler(iItemHandler, i, x, y));
            }
            int containerSlotX = inputBaseX + (3 * inputSpacing) + 2;
            this.addSlot(new SlotItemHandler(iItemHandler, CONTAINER_SLOT, containerSlotX, firstRowY) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.is(ModTags.CONTAINER_ITEMS);
                }
            });

            this.addSlot(new SlotItemHandler(iItemHandler, FIRST_OUTPUT_SLOT, inputBaseX + outputOffsetX, secondRowY));
            this.addSlot(new SlotItemHandler(iItemHandler, SECOND_OUTPUT_SLOT, inputBaseX + secondaryOutputX, secondRowY));
        addDataSlots(data);
    }
    public boolean isCrafting() {
        return data.get(0) > 0;
    }
    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowWidth = 25;
        return maxProgress > 0 ? progress * arrowWidth / maxProgress : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot slot = this.slots.get(index);
        if (slot == null || !slot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack stack = slot.getItem();
        ItemStack originalStack = stack.copy();

        if (index < VANILLA_SLOT_COUNT) {
            if (stack.is(ModTags.CONTAINER_ITEMS)) {
                if (!moveItemStackTo(stack, CONTAINER_SLOT_INDEX, CONTAINER_SLOT_INDEX + 1, false)
                        && !moveItemStackTo(stack, INPUT_SLOT_INDEX_START, INPUT_SLOT_INDEX_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(stack, INPUT_SLOT_INDEX_START, INPUT_SLOT_INDEX_END, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < OUTPUT_SLOT_INDEX_START) {
            if (!moveItemStackTo(stack, VANILLA_FIRST_SLOT_INDEX, VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!moveItemStackTo(stack, VANILLA_FIRST_SLOT_INDEX, VANILLA_SLOT_COUNT, true)) {
                if (!moveItemStackTo(stack, VANILLA_FIRST_SLOT_INDEX, VANILLA_SLOT_COUNT, false)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }
        if (stack.getCount() != originalStack.getCount()) {
            slot.onTake(playerIn, stack);
        }
        return originalStack;
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.FERMENTING_JAR.get());
    }
    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }
    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}

