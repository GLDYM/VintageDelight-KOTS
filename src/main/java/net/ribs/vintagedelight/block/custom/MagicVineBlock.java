package net.ribs.vintagedelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.ribs.vintagedelight.block.ModBlocks;
import org.jetbrains.annotations.Nullable;


public class MagicVineBlock extends RotatedPillarBlock {
    public MagicVineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(itemAbility == ItemAbilities.AXE_STRIP && context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.MAGIC_VINE.get())) {
                return ModBlocks.STRIPPED_MAGIC_VINE.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

        }
        if(itemAbility == ItemAbilities.AXE_STRIP && context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.MAGIC_VINE_BLOCK.get())) {
                return ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}

