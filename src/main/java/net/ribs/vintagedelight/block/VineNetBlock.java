package net.ribs.vintagedelight.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.SafetyNetBlock;
import javax.annotation.Nullable;

public class VineNetBlock extends SafetyNetBlock {
    public static final EnumProperty<Position> POSITION = EnumProperty.create("position", Position.class);

    public VineNetBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POSITION, Position.MIDDLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POSITION);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockpos);
        Direction direction = context.getClickedFace();
        double hitY = context.getClickLocation().y - (double)blockpos.getY();

        Position position;
        if (direction == Direction.DOWN || hitY > 0.66) {
            position = Position.TOP;
        } else if (direction == Direction.UP || hitY < 0.33) {
            position = Position.BOTTOM;
        } else {
            position = Position.MIDDLE;
        }

        return this.defaultBlockState()
                .setValue(POSITION, position)
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = switch (state.getValue(POSITION)) {
            case TOP -> Block.box(0.0, 13.0, 0.0, 16.0, 15.9, 16.0);
            case MIDDLE -> Block.box(0.0, 7.0, 0.0, 16.0, 9.0, 16.0);
            case BOTTOM -> Block.box(0.0, 0.1, 0.0, 16.0, 3.0, 16.0);
        };
        return shape;
    }

    public enum Position implements StringRepresentable {
        TOP, MIDDLE, BOTTOM;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase();
        }
    }
}
