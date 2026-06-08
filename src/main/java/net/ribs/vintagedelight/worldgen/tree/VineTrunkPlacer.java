package net.ribs.vintagedelight.worldgen.tree;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.ribs.vintagedelight.init.ModBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class VineTrunkPlacer extends TrunkPlacer {
    public VineTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }
    public static final MapCodec<VineTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            trunkPlacerParts(instance).apply(instance, VineTrunkPlacer::new));

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.VINE_TRUNK_PLACER.get();
    }
    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos startPos, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();
        int height = getTreeHeight(random);
        BlockPos topPosition = null;
        for (int y = 0; y < height; y++) {
            int thickness = calculateThickness(y, height);
            int xOffset = calculateOffset(y, height, random);
            int zOffset = calculateOffset(y, height, random);
            if (thickness >= 1) {
                for (int x = -thickness; x <= thickness; x++) {
                    for (int z = -thickness; z <= thickness; z++) {
                        if (x * x + z * z <= thickness * thickness) {
                            mutablePos.set(startPos.getX() + xOffset + x, startPos.getY() + y, startPos.getZ() + zOffset + z);
                            placeLog(level, blockSetter, random, mutablePos, config);
                        }
                    }
                }
            } else {
                mutablePos.set(startPos.getX() + xOffset, startPos.getY() + y, startPos.getZ() + zOffset);
                placeLog(level, blockSetter, random, mutablePos, config);
            }
            if (y == height - 1) {
                topPosition = mutablePos.immutable();
            }
        }
        if (topPosition != null && random.nextFloat() < 0.5) {
            BlockState goldBlockState = ModBlocks.GOLDEN_EGG.get().defaultBlockState();
            blockSetter.accept(topPosition, goldBlockState);
        }

        return foliageAttachments;
    }
    private int calculateThickness(int currentHeight, int maxHeight) {
        double stage1 = 0.4 * maxHeight; // Up to 20% of height, thickness is 5x5
        double stage2 = 0.6 * maxHeight; // Up to 50% of height, thickness is 3x3
        double stage3 = 0.8 * maxHeight; // Up to 80% of height, thickness is 2x2

        if (currentHeight < stage1) {
            return 2;
        } else if (currentHeight < stage2) {
            return 1;
        } else if (currentHeight < stage3) {
            return 1;
        } else {
            return 0;
        }
    }
    private int calculateOffset(int currentHeight, int maxHeight, RandomSource random) {
        double windinessFactor = 0.3;
        int maxOffset = 4;
        double frequency = 3.0;
        return (int)(Math.sin(currentHeight / (double)maxHeight * Math.PI * frequency) * maxOffset * windinessFactor);
    }

}

