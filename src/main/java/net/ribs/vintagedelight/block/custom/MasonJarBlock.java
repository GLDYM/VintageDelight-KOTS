package net.ribs.vintagedelight.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.ribs.vintagedelight.item.ModItems;

import java.util.ArrayList;
import java.util.List;

public class MasonJarBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty JARS = IntegerProperty.create("jars", 1, 4);
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    private static final VoxelShape ONE_JAR_AABB = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.75D, 11.0D);
    private static final VoxelShape TWO_JAR_AABB = Shapes.or(Block.box(9.0D, 0.0D, 9.0D, 15.0D, 11.75D, 15.0D), Block.box(1.0D, 0.0D, 9.0D, 9.0D, 11.75D, 15.0D));
    private static final VoxelShape THREE_JAR_AABB = Shapes.or(TWO_JAR_AABB, Block.box(1.0D, 0.0D, 1.0D, 7.0D, 11.75D, 7.0D));
    private static final VoxelShape FOUR_JAR_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.75D, 15.0D);
    public static final int MAX_JARS = 4;
    public MasonJarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(JARS, 1)
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(JARS, FACING, WATERLOGGED);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean isWaterlogged = fluidstate.getType() == Fluids.WATER;
        if (blockstate.is(this)) {
            int jars = blockstate.getValue(JARS);
            if (jars < MAX_JARS) {
                return blockstate.setValue(JARS, jars + 1).setValue(WATERLOGGED, isWaterlogged);
            }
        }
        Direction facing = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, facing).setValue(JARS, 1).setValue(WATERLOGGED, isWaterlogged);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        VoxelShape shape;
        switch (state.getValue(JARS)) {
            case 1:
                shape = ONE_JAR_AABB;
                break;
            case 2:
                shape = TWO_JAR_AABB;
                break;
            case 3:
                shape = THREE_JAR_AABB;
                break;
            case 4:
            default:
                shape = FOUR_JAR_AABB;
                break;
        }
        return rotateShape(shape, direction);
    }
    private VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        if (direction == Direction.NORTH) {
            return shape;
        }
        List<VoxelShape> rotatedShapes = new ArrayList<>();
        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            double[] rotated = rotate(minX, minZ, maxX, maxZ, direction);
            rotatedShapes.add(Shapes.box(rotated[0], minY, rotated[1], rotated[2], maxY, rotated[3]));
        });

        return rotatedShapes.stream().reduce(Shapes::or).orElse(Shapes.empty());
    }
    private double[] rotate(double minX, double minZ, double maxX, double maxZ, Direction direction) {
        switch (direction) {
            case EAST:
                return new double[]{1 - maxZ, minX, 1 - minZ, maxX};
            case SOUTH:
                return new double[]{1 - maxX, 1 - maxZ, 1 - minX, 1 - minZ};
            case WEST:
                return new double[]{minZ, 1 - maxX, maxZ, 1 - minX};
            default:
                return new double[]{minX, minZ, maxX, maxZ};
        }
    }
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().getItem() == this.asItem() && state.getValue(JARS) < MAX_JARS;
    }
    public boolean tryPlaceJar(Level world, BlockPos pos, Player player, ItemStack itemStack) {
        if (!world.getBlockState(pos).is(this)) {
            pos = pos.relative(player.getDirection().getOpposite());
        }
        BlockState state = world.getBlockState(pos);
        if (state.is(this)) {
            int jars = state.getValue(JARS);
            if (jars < MAX_JARS) {
                world.setBlock(pos, state.setValue(JARS, jars + 1), 3);
                itemStack.shrink(1);
                return true;
            }
        } else if (world.isEmptyBlock(pos)) {
            world.setBlock(pos, this.defaultBlockState(), 3);
            itemStack.shrink(1);
            return true;
        }
        return false;
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide) {
            int jars = state.getValue(JARS);
            if (jars > 1) {
                world.setBlock(pos, state.setValue(JARS, jars - 1), 3);
                popResource(world, pos, new ItemStack(ModItems.MASON_JAR.get()));
                return InteractionResult.SUCCESS;
            } else if (jars == 1) {
                world.removeBlock(pos, false);
                popResource(world, pos, new ItemStack(ModItems.MASON_JAR.get()));
                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, world, pos, player, hit);
    }

}



