package net.ribs.vintagedelight.worldgen.tree;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.ribs.vintagedelight.config.VintageDelightCommonConfig;

import java.util.List;

public class ConfigurableAlterGroundDecorator extends TreeDecorator {
    public static final MapCodec<ConfigurableAlterGroundDecorator> CODEC = BlockStateProvider.CODEC
            .fieldOf("provider")
            .xmap(ConfigurableAlterGroundDecorator::new, decorator -> decorator.provider);

    private final BlockStateProvider provider;

    public ConfigurableAlterGroundDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecoratorTypes.CONFIGURABLE_ALTER_GROUND.get();
    }

    @Override
    public void place(Context context) {
        if (!VintageDelightCommonConfig.magicVineConvertsDirtToLushGrass()) {
            return;
        }

        List<BlockPos> logs = context.logs();
        if (logs.isEmpty()) {
            return;
        }

        int baseY = logs.getFirst().getY();
        logs.stream()
                .filter(pos -> pos.getY() == baseY)
                .forEach(pos -> this.placeAroundBase(context, pos));
    }

    private void placeAroundBase(Context context, BlockPos basePos) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (x * x + z * z > 6) {
                    continue;
                }

                convertGround(context, basePos.offset(x, 0, z));
            }
        }
    }

    private void convertGround(Context context, BlockPos targetPos) {
        // Search a small vertical band so the decorator still works on uneven terrain.
        for (int y = 2; y >= -3; y--) {
            BlockPos pos = targetPos.offset(0, y, 0);
            if (context.isAir(pos)) {
                continue;
            }

            if (context.level().isStateAtPosition(pos, ConfigurableAlterGroundDecorator::canReplace)) {
                context.setBlock(pos, this.provider.getState(context.random(), pos));
            }
            break;
        }
    }

    private static boolean canReplace(BlockState state) {
        return state.is(BlockTags.DIRT)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.MYCELIUM)
                || state.is(Blocks.PODZOL);
    }
}
