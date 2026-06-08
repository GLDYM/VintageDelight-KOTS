package net.ribs.vintagedelight.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.ribs.vintagedelight.init.ModBlocks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
;

@Mixin(Feature.class)
public class KeepLushGrassGiantTreeMixin
{
	/**
	 * Due to how Trees generate, this mixin is needed to prevent Rich Soil from becoming Podzol under a Giant Spruce Tree growth.
	 */
	@Inject(at = @At(value = "HEAD"), method = "isGrassOrDirt", cancellable = true)
	private static void keepLushGrass(LevelSimulatedReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (world.isStateAtPosition(pos, state -> state.is(ModBlocks.LUSH_GRASS_BLOCK.get()))) {
			cir.setReturnValue(false);
			cir.cancel();
		}
	}
}
