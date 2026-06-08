package net.ribs.vintagedelight.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.ribs.vintagedelight.VintageDelight;

import java.util.Optional;

public final class MagicVineGrower {
    public static final TreeGrower MAGIC_VINE = new TreeGrower(
            VintageDelight.MODID + ":magic_vine",
            Optional.empty(),
            Optional.of(ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, "magic_vine_tree"))),
            Optional.empty());

    private MagicVineGrower() {
    }
}
