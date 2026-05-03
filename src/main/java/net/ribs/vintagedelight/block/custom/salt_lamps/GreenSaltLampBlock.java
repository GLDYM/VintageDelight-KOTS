package net.ribs.vintagedelight.block.custom.salt_lamps;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.ribs.vintagedelight.block.custom.SaltLampBlock;

public class GreenSaltLampBlock extends SaltLampBlock {
    public GreenSaltLampBlock() {
        super(Properties.ofFullCopy(Blocks.GLOWSTONE).strength(0.3f).sound(SoundType.GLASS).noOcclusion().lightLevel(state -> 0).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false));
    }
}

