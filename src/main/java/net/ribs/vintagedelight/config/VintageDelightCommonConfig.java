package net.ribs.vintagedelight.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class VintageDelightCommonConfig {
    public static final ModConfigSpec SPEC;
    private static final ModConfigSpec.BooleanValue MAGIC_VINE_CONVERTS_DIRT_TO_LUSH_GRASS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("worldgen");
        MAGIC_VINE_CONVERTS_DIRT_TO_LUSH_GRASS = builder
                .comment("Whether magic vine trees convert nearby dirt-like blocks into lush grass during generation.")
                .define("magicVineConvertsDirtToLushGrass", true);
        builder.pop();

        SPEC = builder.build();
    }

    private VintageDelightCommonConfig() {
    }

    public static boolean magicVineConvertsDirtToLushGrass() {
        return MAGIC_VINE_CONVERTS_DIRT_TO_LUSH_GRASS.get();
    }
}
