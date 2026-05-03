package net.ribs.vintagedelight.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class OrganicMashItem extends BoneMealItem {
    public OrganicMashItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();

        if (!level.isClientSide) {
            boolean success = false;
            int numberOfApplications = 3;
            for (int i = 0; i < numberOfApplications; i++) {
                success |= super.applyBonemeal(itemStack, level, blockpos, player);
            }
            if (success) {
                level.levelEvent(2005, blockpos, 0);
                itemStack.shrink(1);
                return InteractionResult.sidedSuccess(false);
            }
        }
        return InteractionResult.PASS;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}

