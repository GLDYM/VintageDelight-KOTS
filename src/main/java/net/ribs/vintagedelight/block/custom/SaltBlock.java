package net.ribs.vintagedelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.ribs.vintagedelight.init.ModBlocks;

public class SaltBlock extends Block {
    private final float growthSpeed;

    public SaltBlock(Properties properties, float growthSpeed) {
        super(properties.strength(0.5F).sound(SoundType.SAND).randomTicks());
        this.growthSpeed = growthSpeed;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(state, world, pos, random);
        if (!world.isClientSide) {
            if (random.nextFloat() < calculateGrowthProbability()) {
                this.checkAndGrowSaltLayer(world, pos);
            }
        }
    }
    private float calculateGrowthProbability() {
        return Math.min(1.0F, growthSpeed / 100.0F);
    }
    private boolean hasWaterAround(LevelReader world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (direction != Direction.UP && direction != Direction.DOWN) {
                BlockPos adjacentPos = pos.relative(direction);
                if (world.getFluidState(adjacentPos).is(FluidTags.WATER)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkAndGrowSaltLayer(ServerLevel world, BlockPos pos) {
        boolean isWaterNearby = hasWaterAround(world, pos);
        BlockPos abovePos = pos.above();

        if (isWaterNearby && world.isEmptyBlock(abovePos) || canGrowSaltLayer(world, abovePos)) {
            BlockState aboveState = world.getBlockState(abovePos);
            if (aboveState.is(ModBlocks.SALT_LAYER.get())) {
                int layers = aboveState.getValue(SaltLayerBlock.LAYERS);
                if (layers < SaltLayerBlock.MAX_HEIGHT) {
                    world.setBlock(abovePos, aboveState.setValue(SaltLayerBlock.LAYERS, layers + 1), 3);
                }
            } else {
                world.setBlock(abovePos, ModBlocks.SALT_LAYER.get().defaultBlockState().setValue(SaltLayerBlock.LAYERS, 1), 3);
            }
        }
    }

    private boolean canGrowSaltLayer(ServerLevel world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.is(ModBlocks.SALT_LAYER.get()) && state.getValue(SaltLayerBlock.LAYERS) < SaltLayerBlock.MAX_HEIGHT;
    }
}

