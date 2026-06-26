package net.ribs.vintagedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.Tags;
import net.ribs.vintagedelight.block.GearoBerryBushBlock;
import net.ribs.vintagedelight.block.OatBlock;
import net.ribs.vintagedelight.block.SaltLayerBlock;
import net.ribs.vintagedelight.init.ModBlocks;
import net.ribs.vintagedelight.init.items.ModItems;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.FERMENTING_JAR.get());

        dropSelf(ModBlocks.DEFAULT_SALT_LAMP.get());
        dropSelf(ModBlocks.BLACK_SALT_LAMP.get());
        dropSelf(ModBlocks.BLUE_SALT_LAMP.get());
        dropSelf(ModBlocks.BROWN_SALT_LAMP.get());
        dropSelf(ModBlocks.CYAN_SALT_LAMP.get());
        dropSelf(ModBlocks.GRAY_SALT_LAMP.get());
        dropSelf(ModBlocks.GREEN_SALT_LAMP.get());
        dropSelf(ModBlocks.LIGHT_BLUE_SALT_LAMP.get());
        dropSelf(ModBlocks.LIGHT_GRAY_SALT_LAMP.get());
        dropSelf(ModBlocks.LIME_SALT_LAMP.get());
        dropSelf(ModBlocks.MAGENTA_SALT_LAMP.get());
        dropSelf(ModBlocks.ORANGE_SALT_LAMP.get());
        dropSelf(ModBlocks.PINK_SALT_LAMP.get());
        dropSelf(ModBlocks.PURPLE_SALT_LAMP.get());
        dropSelf(ModBlocks.RED_SALT_LAMP.get());
        dropSelf(ModBlocks.WHITE_SALT_LAMP.get());
        dropSelf(ModBlocks.YELLOW_SALT_LAMP.get());

        dropSelf(ModBlocks.OAT_BAG.get());
        dropSelf(ModBlocks.GEARO_BERRY_BAG.get());
        dropSelf(ModBlocks.PEANUT_CRATE.get());
        dropSelf(ModBlocks.CUCUMBER_CRATE.get());
        dropSelf(ModBlocks.GHOST_PEPPER_CRATE.get());
        dropSelf(ModBlocks.OAT_BALE.get());
        dropSelf(ModBlocks.CHEESE_MOLD.get());
        add(ModBlocks.LUSH_GRASS_BLOCK.get(), lushGrassBlockDrops());
        dropSelf(ModBlocks.EMPTY_MASON_JAR.get());
        dropSelf(ModBlocks.VINEGAR_JAR.get());
        dropSelf(ModBlocks.PEPPER_JAM_JAR.get());
        dropSelf(ModBlocks.GEARO_BERRY_JAM_JAR.get());
        dropSelf(ModBlocks.SWEET_BERRY_JAM_JAR.get());
        dropSelf(ModBlocks.GLOW_BERRY_JAM_JAR.get());
        dropSelf(ModBlocks.APPLE_SAUCE_JAR.get());
        dropSelf(ModBlocks.NUT_MASH_JAR.get());
        dropSelf(ModBlocks.RELISH_JAR.get());
        dropSelf(ModBlocks.HONEY_JAR.get());
        add(ModBlocks.GOLDEN_EGG.get(), goldenEggDrops());
        dropSelf(ModBlocks.EVAPORATOR.get());
        dropSelf(ModBlocks.SALT_BLOCK.get());
        dropSelf(ModBlocks.SMOOTH_SALT_BLOCK.get());
        dropSelf(ModBlocks.SALT_PILLAR.get());
        dropSelf(ModBlocks.SALT_BRICKS.get());
        dropSelf(ModBlocks.SALT_BRICK_STAIRS.get());
        add(ModBlocks.SALT_BRICK_SLAB.get(), createSlabItemTable(ModBlocks.SALT_BRICK_SLAB.get()));
        dropSelf(ModBlocks.SALT_BRICK_WALL.get());
        dropSelf(ModBlocks.MIXED_SALT_BRICKS.get());
        dropSelf(ModBlocks.MIXED_SALT_BRICK_STAIRS.get());
        add(ModBlocks.MIXED_SALT_BRICK_SLAB.get(), createSlabItemTable(ModBlocks.MIXED_SALT_BRICK_SLAB.get()));
        dropSelf(ModBlocks.MIXED_SALT_BRICK_WALL.get());
        dropSelf(ModBlocks.MAGIC_VINE.get());
        dropSelf(ModBlocks.STRIPPED_MAGIC_VINE.get());
        dropSelf(ModBlocks.MAGIC_VINE_BLOCK.get());
        dropSelf(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_PEANUT.get());
        dropSelf(ModBlocks.VINE_TILE.get());
        dropSelf(ModBlocks.VINE_TILE_STAIRS.get());
        add(ModBlocks.VINE_TILE_SLAB.get(), createSlabItemTable(ModBlocks.VINE_TILE_SLAB.get()));
        dropSelf(ModBlocks.VINE_NET.get());

        add(ModBlocks.WILD_PEANUTS.get(), wildCropDrops(ModBlocks.WILD_PEANUTS.get(), ModItems.PEANUT.get(), null));
        add(ModBlocks.WILD_OATS.get(), wildCropDrops(ModBlocks.WILD_OATS.get(), ModItems.OAT_SEEDS.get(), ModItems.OAT.get()));
        add(ModBlocks.WILD_CUCUMBERS.get(), wildCropDrops(ModBlocks.WILD_CUCUMBERS.get(), ModItems.CUCUMBER_SEEDS.get(), ModItems.CUCUMBER.get()));
        add(ModBlocks.WILD_GHOST_PEPPERS.get(), wildCropDrops(ModBlocks.WILD_GHOST_PEPPERS.get(), ModItems.GHOST_PEPPER_SEEDS.get(), ModItems.GHOST_PEPPER.get()));
        add(ModBlocks.OAT_CROP.get(), oatCropDrops());
        add(ModBlocks.PEANUT_CROP.get(), createCropDrops(ModBlocks.PEANUT_CROP.get(), ModItems.PEANUT.get(), ModItems.PEANUT.get(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PEANUT_CROP.get()).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(OatBlock.AGE, 7))));
        add(ModBlocks.CUCUMBER_CROP.get(), createCropDrops(ModBlocks.CUCUMBER_CROP.get(), ModItems.CUCUMBER.get(), ModItems.CUCUMBER_SEEDS.get(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CUCUMBER_CROP.get()).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(OatBlock.AGE, 7))));
        add(ModBlocks.GHOST_PEPPER_CROP.get(), createCropDrops(ModBlocks.GHOST_PEPPER_CROP.get(), ModItems.GHOST_PEPPER.get(), ModItems.GHOST_PEPPER_SEEDS.get(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GHOST_PEPPER_CROP.get()).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(OatBlock.AGE, 7))));
        add(ModBlocks.GEARO_BERRY_BUSH.get(), gearoBerryBushDrops());
        add(ModBlocks.CHEESE_WHEEL.get(), pieLikeDrops(ModBlocks.CHEESE_WHEEL.get(), ModItems.CHEESE_SLICE.get()));
        add(ModBlocks.CHEESE_PIZZA.get(), pieLikeDrops(ModBlocks.CHEESE_PIZZA.get(), ModItems.CHEESE_PIZZA_SLICE.get()));
        add(ModBlocks.MEAT_PIZZA.get(), pieLikeDrops(ModBlocks.MEAT_PIZZA.get(), ModItems.MEAT_PIZZA_SLICE.get()));
        add(ModBlocks.SALT_LAYER.get(), saltLayerDrops());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get()).toList();
    }

    private LootPool.Builder shearsOrFortuneCropDrops(Block block, Item seedItem) {
        var fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                        LootItem.lootTableItem(block).when(hasShears()),
                        applyExplosionCondition(block, LootItem.lootTableItem(seedItem)
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune, 2)))
                ));
    }

    private LootPool.Builder optionalWildProduce(Item produceItem) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(applyExplosionCondition(produceItem, LootItem.lootTableItem(produceItem))
                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
                        .when(InvertedLootItemCondition.invert(hasShears())));
    }

    private LootTable.Builder wildCropDrops(Block block, Item seedItem, Item produceItem) {
        var table = LootTable.lootTable();
        if (produceItem != null) {
            table.withPool(optionalWildProduce(produceItem));
        }
        return table.withPool(shearsOrFortuneCropDrops(block, seedItem));
    }

    private MatchTool.Builder hasShears() {
        return MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(Tags.Items.TOOLS_SHEAR));
    }

    private MatchTool.Builder hasKnife() {
        return MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item()
                .of(net.minecraft.tags.TagKey.create(Registries.ITEM, net.minecraft.resources.ResourceLocation.parse("farmersdelight:tools/knives"))));
    }

    private LootTable.Builder lushGrassBlockDrops() {
        return createSilkTouchDispatchTable(ModBlocks.LUSH_GRASS_BLOCK.get(), applyExplosionCondition(ModBlocks.LUSH_GRASS_BLOCK.get(),
                LootItem.lootTableItem(vectorwing.farmersdelight.common.registry.ModBlocks.RICH_SOIL.get())));
    }

    private LootTable.Builder oatCropDrops() {
        var ripe = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.OAT_CROP.get())
                .setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(OatBlock.AGE, OatBlock.MAX_AGE));

        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(ModItems.RAW_OAT.get()).when(ripe).when(hasKnife()),
                                LootItem.lootTableItem(ModItems.OAT.get()).when(ripe)
                        )))
                .withPool(applyExplosionCondition(ModBlocks.OAT_CROP.get(), LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.OAT_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)).when(ripe).when(hasKnife())))));
    }

    private LootTable.Builder gearoBerryBushDrops() {
        var age3 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GEARO_BERRY_BUSH.get())
                .setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(GearoBerryBushBlock.AGE, 3));
        var age4 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GEARO_BERRY_BUSH.get())
                .setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(GearoBerryBushBlock.AGE, GearoBerryBushBlock.MAX_AGE));
        var fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);

        return LootTable.lootTable()
                .withPool(applyExplosionCondition(ModBlocks.GEARO_BERRY_BUSH.get(), LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(age4)
                        .add(LootItem.lootTableItem(ModItems.GEARO_BERRY_ITEM.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune, 1)))))
                .withPool(applyExplosionCondition(ModBlocks.GEARO_BERRY_BUSH.get(), LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(age3)
                        .add(LootItem.lootTableItem(ModItems.GEARO_BERRY_ITEM.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune, 1)))));
    }

    private LootTable.Builder goldenEggDrops() {
        var fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);

        return createSilkTouchDispatchTable(ModBlocks.GOLDEN_EGG.get(), applyExplosionCondition(ModBlocks.GOLDEN_EGG.get(),
                LootItem.lootTableItem(net.minecraft.world.item.Items.GOLD_NUGGET)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0F, 32.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(fortune, 1))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(doesNotHaveSilkTouch())
                        .add(LootItem.lootTableItem(net.minecraft.world.item.Items.GOLD_INGOT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 15.0F)))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(doesNotHaveSilkTouch())
                        .add(LootItem.lootTableItem(net.minecraft.world.item.Items.GOLDEN_APPLE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 7.0F)))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(doesNotHaveSilkTouch())
                        .add(LootItem.lootTableItem(net.minecraft.world.item.Items.GOLDEN_CARROT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 16.0F)))));
    }

    private LootTable.Builder pieLikeDrops(Block block, Item sliceItem) {
        var table = LootTable.lootTable();
        for (int bites = 0; bites < 4; bites++) {
            int remainingSlices = 4 - bites;
            var state = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                    .setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, bites));
            table.withPool(applyExplosionCondition(block, LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(state)
                    .add(LootItem.lootTableItem(sliceItem)
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(remainingSlices))))));
        }
        return table;
    }

    private LootTable.Builder saltLayerDrops() {
        var table = LootTable.lootTable();
        for (int layers = 1; layers <= 8; layers++) {
            var state = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SALT_LAYER.get())
                    .setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(SaltLayerBlock.LAYERS, layers));
            table.withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(AlternativesEntry.alternatives(
                            LootItem.lootTableItem(ModItems.SALT_DUST.get())
                                    .when(state)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers)))
                    )));
        }
        return table;
    }
}
