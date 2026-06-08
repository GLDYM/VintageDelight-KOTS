package net.ribs.vintagedelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ribs.vintagedelight.init.items.ModItems;

public class CheeseMoldBlock extends Block implements WorldlyContainerHolder, SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 5);
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 5, 15);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final int PROCESSING_TIME_TICKS = 8400;

    public CheeseMoldBlock(Properties properties) {
        super(properties.randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0)
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int level = state.getValue(LEVEL);

        if (itemStack.getItem() == ModItems.CHEESE_CURDS.get() && level < 4) {
            BlockState newState = state.setValue(LEVEL, level + 1);
            world.playSound(null, pos, SoundEvents.WART_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlock(pos, newState, 3);
            if (level == 3) {
                world.scheduleTick(pos, this, PROCESSING_TIME_TICKS);
            }
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }

            player.swing(hand);
            return ItemInteractionResult.sidedSuccess(world.isClientSide);
        }
        if (itemStack.getItem() == ModItems.CHEESE_WHEEL.get() && level == 0) {
            world.setBlock(pos, state.setValue(LEVEL, 5), 3);
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            player.swing(hand);
            return ItemInteractionResult.sidedSuccess(world.isClientSide);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int level = state.getValue(LEVEL);
        if (level == 5) {
            if (!world.isClientSide) {
                ItemStack cheeseItem = new ItemStack(ModItems.CHEESE_WHEEL.get());
                ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, cheeseItem);
                itemEntity.setDefaultPickUpDelay();
                world.addFreshEntity(itemEntity);
                world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlock(pos, state.setValue(LEVEL, 0), 3);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(state, world, pos, random);
        int level = state.getValue(LEVEL);
        if (level == 4) {
            world.setBlock(pos, state.setValue(LEVEL, 5), 3);
        }
    }

    @Override
    public WorldlyContainer getContainer(BlockState state, LevelAccessor world, BlockPos pos) {
        int level = state.getValue(LEVEL);
        if (level < 4) {
            return new InputContainer(state, world, pos);
        } else {
            return new OutputContainer(state, world, pos, new ItemStack(ModItems.CHEESE_WHEEL.get()));
        }
    }

    static class InputContainer extends SimpleContainer implements WorldlyContainer {
        private final BlockState state;
        private final LevelAccessor level;
        private final BlockPos pos;

        public InputContainer(BlockState state, LevelAccessor level, BlockPos pos) {
            super(1);
            this.state = state;
            this.level = level;
            this.pos = pos;
        }

        @Override
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.UP ? new int[]{0} : new int[0];
        }

        @Override
        public boolean canPlaceItemThroughFace(int index, ItemStack stack, Direction direction) {
            return direction == Direction.UP && stack.getItem() == ModItems.CHEESE_CURDS.get();
        }

        @Override
        public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
            return false;
        }
        @Override
        public void setChanged() {
            ItemStack itemStack = this.getItem(0);
            if (!itemStack.isEmpty() && itemStack.getItem() == ModItems.CHEESE_CURDS.get()) {
                int currentLevel = this.state.getValue(CheeseMoldBlock.LEVEL);
                if (currentLevel < 4) {
                    BlockState newState = this.state.setValue(CheeseMoldBlock.LEVEL, currentLevel + 1);
                    this.level.setBlock(this.pos, newState, 3);
                    this.removeItemNoUpdate(0);
                    if (currentLevel == 3) {
                        if (this.level instanceof ServerLevel) {
                            this.level.scheduleTick(this.pos, newState.getBlock(), PROCESSING_TIME_TICKS);
                        }
                    }
                }
            }
        }
    }

    static class OutputContainer extends SimpleContainer implements WorldlyContainer {
        private final BlockState state;
        private final LevelAccessor level;
        private final BlockPos pos;
        private final ItemStack output;

        public OutputContainer(BlockState state, LevelAccessor level, BlockPos pos, ItemStack output) {
            super(output);
            this.state = state;
            this.level = level;
            this.pos = pos;
            this.output = output;
        }
        @Override
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.DOWN ? new int[]{0} : new int[0];
        }
        @Override
        public boolean canPlaceItemThroughFace(int index, ItemStack stack, Direction direction) {
            return false;
        }
        @Override
        public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
            return direction == Direction.DOWN && this.state.getValue(LEVEL) == 5 && this.output.getItem() == ModItems.CHEESE_WHEEL.get();
        }

        @Override
        public void setChanged() {
            if (this.output.isEmpty()) {
                this.level.setBlock(this.pos, this.state.setValue(LEVEL, 0), 3);
            }
        }
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LEVEL, FACING, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }
}

