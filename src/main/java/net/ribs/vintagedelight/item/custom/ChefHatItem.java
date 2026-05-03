package net.ribs.vintagedelight.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ChefHatItem extends Item {
    public ChefHatItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        EquipmentSlot slot = getEquipmentSlotForItem(heldStack);
        if (slot != null) {
            if (player.getItemBySlot(slot).getItem() instanceof ChefHatItem) {
                return swapChefHat(player, heldStack, slot);
            }
            ItemStack currentHelmet = player.getItemBySlot(slot);
            if (!currentHelmet.isEmpty() && currentHelmet.getItem() instanceof ArmorItem
                    && ((ArmorItem) currentHelmet.getItem()).getEquipmentSlot() == EquipmentSlot.HEAD) {
                if (!(currentHelmet.getItem() instanceof ChefHatItem)) {
                    player.getInventory().add(currentHelmet);
                }
            }
            player.setItemSlot(slot, new ItemStack(this, 1));
            player.getInventory().removeItem(heldStack);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldStack);
        }
        return new InteractionResultHolder<>(InteractionResult.PASS, heldStack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    private static EquipmentSlot getEquipmentSlotForItem(ItemStack stack) {
        return stack.getItem().canEquip(stack, EquipmentSlot.HEAD, null) ? EquipmentSlot.HEAD : null;
    }
    private InteractionResultHolder<ItemStack> swapChefHat(Player player, ItemStack newChefHat, EquipmentSlot slot) {
        ItemStack currentChefHat = player.getItemBySlot(slot);
        player.setItemSlot(slot, ItemStack.EMPTY);
        if (!player.getInventory().add(currentChefHat)) {
            player.drop(currentChefHat, false);
        }
        if (!(newChefHat.getItem() instanceof ChefHatItem)) {
            player.setItemSlot(slot, new ItemStack(this, 1));
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, newChefHat);
    }
}

