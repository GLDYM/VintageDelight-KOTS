package net.ribs.vintagedelight.block.custom.mason_jars;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.ribs.vintagedelight.block.custom.MasonJarBlock;
import net.ribs.vintagedelight.item.ModItems;

public class VinegarBlock extends MasonJarBlock {
    public VinegarBlock(Properties properties) {
        super(properties);
    }
    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.VINEGAR.get());
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide) {
            int jars = state.getValue(JARS);
            if (jars > 1) {
                world.setBlock(pos, state.setValue(JARS, jars - 1), 3);
                popResource(world, pos, new ItemStack(ModItems.VINEGAR.get()));
                return InteractionResult.SUCCESS;
            } else if (jars == 1) {
                world.removeBlock(pos, false);
                popResource(world, pos, new ItemStack(ModItems.VINEGAR.get()));
                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, world, pos, player, hit);
    }
}


