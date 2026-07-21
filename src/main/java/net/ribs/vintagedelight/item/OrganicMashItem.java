package net.ribs.vintagedelight.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.EventHooks;

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
        BlockState blockState = level.getBlockState(blockpos);

        if (!(blockState.getBlock() instanceof BonemealableBlock bonemealableBlock)
            || !bonemealableBlock.isValidBonemealTarget(level, blockpos, blockState)) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide) {
            return InteractionResult.sidedSuccess(true);
        }

        boolean success = false;
        int numberOfApplications = 3;
        for (int i = 0; i < numberOfApplications; i++) {
            success |= applyBonemealWithoutConsume(itemStack, level, blockpos, player);
        }
        if (success) {
            level.levelEvent(2005, blockpos, 0);
            itemStack.shrink(1);
            return InteractionResult.sidedSuccess(false);
        }

        return InteractionResult.PASS;
    }

    private static boolean applyBonemealWithoutConsume(ItemStack stack, Level level, BlockPos pos, Player player) {
        BlockState blockState = level.getBlockState(pos);
        var event = EventHooks.fireBonemealEvent(player, level, pos, blockState, stack);
        if (event.isCanceled()) {
            return event.isSuccessful();
        }

        if (!(blockState.getBlock() instanceof BonemealableBlock bonemealableBlock)
            || !bonemealableBlock.isValidBonemealTarget(level, pos, blockState)) {
            return false;
        }

        if (level instanceof ServerLevel serverLevel && bonemealableBlock.isBonemealSuccess(level, level.random, pos, blockState)) {
            bonemealableBlock.performBonemeal(serverLevel, level.random, pos, blockState);
        }

        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}

