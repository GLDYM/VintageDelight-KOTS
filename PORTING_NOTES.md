# Vintage Delight 0.1.6 Porting Notes

This repository is a community maintenance workspace for Vintage Delight. It is not an official upstream release.

## License And Distribution

- The upstream project metadata declares `mod_license=MIT license`.
- The upstream Git repository does not currently include a standalone `LICENSE` file, so this workspace adds the standard MIT License text to keep redistribution obligations explicit.
- The restored `0.1.6` baseline was reconstructed from the locally owned `vintagedelight-0.1.6.jar` and the public `0.1.0` source tree.
- Decompiled code was used only to identify registry, resource, and behavior differences between `0.1.0` source and the `0.1.6` release jar.
- This workspace should preserve the original author attribution and must not present itself as an official build by the original author.

## Community Safety Checklist

- Keep the `LICENSE` file in source archives and binary distributions.
- Keep visible attribution to Vintage Delight, Ribs, and contributors.
- Mark published builds as community/unofficial unless upstream explicitly accepts them.
- Prefer upstream pull requests or clearly documented forks when distributing changes.
- Do not remove mod IDs, registry names, or translation keys without a migration plan, because old worlds may depend on them.

## Current Baseline

- Minecraft: `1.20.1`
- Loader: Forge `47.x`
- Mod version: `0.1.6`
- Status: builds successfully from source after restoring missing `0.1.6` registry entries and resources.

## Restored From 0.1.6

- `pickled_pitcher_pod`
- `vine_tile_stairs`
- `vine_tile_slab`
- `dehydrated` mob effect
- `dehydrated`, `long_dehydrated`, and `strong_dehydrated` potion entries
- `assets`, `data`, `pack.mcmeta`, mixin config, and access transformer from the `0.1.6` jar
