package net.ribs.vintagedelight.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.ribs.vintagedelight.init.ModBlockEntities;
import net.ribs.vintagedelight.init.ModTags;
import net.ribs.vintagedelight.recipe.FermentingRecipe;
import net.ribs.vintagedelight.recipe.FermentingRecipeInput;
import net.ribs.vintagedelight.screen.FermentingJarMenu;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FermentingJarBlockEntity extends BlockEntity implements MenuProvider {
    public static final int FIRST_INGREDIENT_SLOT = 0;
    public static final int LAST_INPUT_SLOT = 5;
    public static final int INPUT_SLOT_COUNT = LAST_INPUT_SLOT - FIRST_INGREDIENT_SLOT + 1;
    public static final int CONTAINER_SLOT = 6;
    public static final int FIRST_OUTPUT_SLOT = 7;
    public static final int SECOND_OUTPUT_SLOT = 8;
    public static final int SLOT_COUNT = 9;

    private final ItemStackHandler itemHandler = new ItemStackHandler(SLOT_COUNT) {
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (slot == FIRST_OUTPUT_SLOT || slot == SECOND_OUTPUT_SLOT) {
                return false;
            }
            if (slot == CONTAINER_SLOT) {
                return stack.is(ModTags.CONTAINER_ITEMS);
            }
            return true;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                if (isInputSlot(slot) && !isRecipeValid()) {
                    resetProgress();
                }
            }
        }
    };
    private final FermentingJarItemHandler sidedItemHandler = new FermentingJarItemHandler(itemHandler);
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public FermentingJarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FERMENTING_JAR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> FermentingJarBlockEntity.this.progress;
                    case 1 -> FermentingJarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> FermentingJarBlockEntity.this.progress = pValue;
                    case 1 -> FermentingJarBlockEntity.this.maxProgress = pValue;
                    default -> {
                    }
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public List<ItemStack> getRenderStacks() {
        List<ItemStack> stacks = new ArrayList<>();
        for (int i = 0; i <= LAST_INPUT_SLOT; i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                stacks.add(stack);
            }
        }
        if (!itemHandler.getStackInSlot(FIRST_OUTPUT_SLOT).isEmpty()) {
            stacks.add(itemHandler.getStackInSlot(FIRST_OUTPUT_SLOT));
        }
        return stacks;
    }

    public IItemHandler getItemHandler(@Nullable Direction side) {
        return sidedItemHandler.forSide(side);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.vintagedelight.fermenting_jar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FermentingJarMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider registries) {
        super.saveAdditional(pTag, registries);
        pTag.put("inventory", itemHandler.serializeNBT(registries));
        pTag.putInt("fermenting_jar.progress", progress);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider registries) {
        super.loadAdditional(pTag, registries);
        itemHandler.deserializeNBT(registries, pTag.getCompound("inventory"));
        progress = pTag.getInt("fermenting_jar.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide && hasRecipe()) {
            Optional<FermentingRecipe> recipeOpt = getCurrentRecipe();
            if (recipeOpt.isPresent()) {
                FermentingRecipe recipe = recipeOpt.get();
                ItemStack result = recipe.getResultItem(pLevel.registryAccess());
                ItemStack secondaryResult = recipe.getSecondaryResultItem();
                maxProgress = recipe.getProcessingTime();
                increaseCraftingProgress();
                if (hasProgressFinished() && canOutput(result, secondaryResult)) {
                    craftItem();
                    resetProgress();
                }
            } else {
                resetProgress();
            }
        }
    }

    private boolean canOutput(ItemStack result, ItemStack secondaryResult) {
        boolean canOutputPrimary = result.isEmpty()
                || (canInsertItemIntoOutputSlot(result.getItem(), FIRST_OUTPUT_SLOT)
                && canInsertAmountIntoOutputSlot(result.getCount(), FIRST_OUTPUT_SLOT));
        boolean canOutputSecondary = secondaryResult.isEmpty()
                || (canInsertItemIntoOutputSlot(secondaryResult.getItem(), SECOND_OUTPUT_SLOT)
                && canInsertAmountIntoOutputSlot(secondaryResult.getCount(), SECOND_OUTPUT_SLOT));

        return canOutputPrimary && canOutputSecondary;
    }

    private boolean isRecipeValid() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<FermentingRecipe> currentRecipe = getCurrentRecipe();
        return currentRecipe.isPresent() && currentRecipe.get().matches(inventory, level);
    }

    private boolean isInputSlot(int slot) {
        return slot >= FIRST_INGREDIENT_SLOT && slot <= CONTAINER_SLOT;
    }

    private void craftItem() {
        Optional<FermentingRecipe> recipeOpt = getCurrentRecipe();
        if (recipeOpt.isEmpty() || level == null) {
            return;
        }

        FermentingRecipe recipe = recipeOpt.get();
        ItemStack result = recipe.getResultItem(level.registryAccess());
        ItemStack secondaryResult = recipe.getSecondaryResultItem();

        if (canOutput(result, secondaryResult)) {
            if (!result.isEmpty()) {
                itemHandler.insertItem(FIRST_OUTPUT_SLOT, result, false);
            }
            if (!secondaryResult.isEmpty()) {
                itemHandler.insertItem(SECOND_OUTPUT_SLOT, secondaryResult, false);
            }
            for (int i = FIRST_INGREDIENT_SLOT; i <= CONTAINER_SLOT; i++) {
                itemHandler.extractItem(i, 1, false);
            }
        }
    }

    private boolean hasRecipe() {
        return getCurrentRecipe().isPresent();
    }

    private Optional<FermentingRecipe> getCurrentRecipe() {
        if (level == null) {
            return Optional.empty();
        }
        RecipeManager recipeManager = level.getRecipeManager();
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        return recipeManager.getAllRecipesFor(FermentingRecipe.Type.INSTANCE).stream()
                .filter(recipe -> recipe.value().matches(new FermentingRecipeInput(inventory), level))
                .map(net.minecraft.world.item.crafting.RecipeHolder::value)
                .findFirst();
    }

    private boolean canInsertItemIntoOutputSlot(Item item, int slot) {
        ItemStack existingStack = itemHandler.getStackInSlot(slot);
        if (existingStack.isEmpty()) {
            return true;
        }
        if (!existingStack.is(item)) {
            return false;
        }
        int itemCount = existingStack.getCount();
        int maxStackSize = existingStack.getMaxStackSize();
        return itemCount < maxStackSize;
    }

    private boolean canInsertAmountIntoOutputSlot(int count, int slot) {
        ItemStack existingStack = itemHandler.getStackInSlot(slot);
        if (existingStack.isEmpty()) {
            return true;
        }
        int existingCount = existingStack.getCount();
        int maxStackSize = existingStack.getMaxStackSize();
        return existingCount + count <= maxStackSize;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void resetProgress() {
        progress = 0;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }
}
