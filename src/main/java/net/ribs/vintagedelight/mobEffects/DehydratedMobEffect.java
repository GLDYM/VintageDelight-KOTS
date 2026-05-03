package net.ribs.vintagedelight.mobEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;

public class DehydratedMobEffect extends MobEffect {
    private static final int MAX_RADIUS = 9;

    public DehydratedMobEffect() {
        super(MobEffectCategory.NEUTRAL, 0xE0D1A7);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 30 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            absorbWaterAroundEntity(serverLevel, entity.blockPosition(), amplifier);
        }
    }

    private void absorbWaterAroundEntity(ServerLevel level, BlockPos entityPos, int amplifier) {
        if (amplifier == 0) {
            absorbWaterAtPos(level, entityPos);
            absorbWaterAtPos(level, entityPos.above());
            return;
        }

        int radius = Math.min(amplifier, MAX_RADIUS);
        BlockPos.betweenClosed(entityPos.offset(-radius, 0, -radius), entityPos.offset(radius, 1, radius))
                .forEach(pos -> absorbWaterAtPos(level, pos));
    }

    private void absorbWaterAtPos(ServerLevel level, BlockPos pos) {
        if (level.getBlockState(pos).is(Blocks.WATER)) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.5F, 1.0F);
            level.sendParticles(ParticleTypes.SPLASH,
                    pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    5, 0.2D, 0.2D, 0.2D, 0.0D);
        }
    }
}
