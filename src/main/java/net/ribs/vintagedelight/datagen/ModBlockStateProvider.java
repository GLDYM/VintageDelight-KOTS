package net.ribs.vintagedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.block.custom.CheeseMoldBlock;
import net.ribs.vintagedelight.block.custom.GearoBerryBushBlock;
import net.ribs.vintagedelight.block.custom.MasonJarBlock;
import net.ribs.vintagedelight.block.custom.OatBlock;
import net.ribs.vintagedelight.block.custom.SaltLayerBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VintageDelight.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleExistingBlock(ModBlocks.FERMENTING_JAR.get(), "fermenting_jar");
        cheeseMoldBlock();
        simpleBlock(ModBlocks.DEFAULT_SALT_LAMP.get(), existingModel("salt_lamp_default"));
        simpleTintedParentBlock(ModBlocks.BLACK_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_black");
        simpleTintedParentBlock(ModBlocks.BLUE_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_blue");
        simpleTintedParentBlock(ModBlocks.BROWN_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_brown");
        simpleTintedParentBlock(ModBlocks.CYAN_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_cyan");
        simpleTintedParentBlock(ModBlocks.GRAY_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_gray");
        simpleTintedParentBlock(ModBlocks.GREEN_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_green");
        simpleTintedParentBlock(ModBlocks.LIGHT_BLUE_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_light_blue");
        simpleTintedParentBlock(ModBlocks.LIGHT_GRAY_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_light_gray");
        simpleTintedParentBlock(ModBlocks.LIME_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_lime");
        simpleTintedParentBlock(ModBlocks.MAGENTA_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_magenta");
        simpleTintedParentBlock(ModBlocks.ORANGE_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_orange");
        simpleTintedParentBlock(ModBlocks.PINK_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_pink");
        simpleTintedParentBlock(ModBlocks.PURPLE_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_purple");
        simpleTintedParentBlock(ModBlocks.RED_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_red");
        simpleTintedParentBlock(ModBlocks.WHITE_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_white");
        simpleTintedParentBlock(ModBlocks.YELLOW_SALT_LAMP.get(), "salt_lamp_default", "salt_lamp_yellow");
        simpleBlock(ModBlocks.OAT_BAG.get(), models().cube("oat_bag",
                modLoc("block/oat_bag_side"),
                modLoc("block/oat_bag_top"),
                modLoc("block/oat_bag_bottom"),
                modLoc("block/oat_bag_side_tied"),
                modLoc("block/oat_bag_side"),
                modLoc("block/oat_bag_side_tied")));
        simpleBlock(ModBlocks.GEARO_BERRY_BAG.get(), models().cube("gearo_berry_bag",
                modLoc("block/oat_bag_side"),
                modLoc("block/gearo_berry_bag_top"),
                modLoc("block/oat_bag_bottom"),
                modLoc("block/oat_bag_side_tied"),
                modLoc("block/oat_bag_side"),
                modLoc("block/oat_bag_side_tied")));
        simpleBlock(ModBlocks.PEANUT_CRATE.get(), models().cubeBottomTop("peanut_crate",
                modLoc("block/peanut_crate_side"),
                modLoc("block/crate_bottom"),
                modLoc("block/peanut_crate_top")));
        simpleBlock(ModBlocks.CUCUMBER_CRATE.get(), models().cubeBottomTop("cucumber_crate",
                modLoc("block/cucumber_crate_side"),
                modLoc("block/crate_bottom"),
                modLoc("block/cucumber_crate_top")));
        simpleBlock(ModBlocks.GHOST_PEPPER_CRATE.get(), models().cubeBottomTop("ghost_pepper_crate",
                modLoc("block/ghost_pepper_crate_side"),
                modLoc("block/crate_bottom"),
                modLoc("block/ghost_pepper_crate_top")));
        axisBlock((RotatedPillarBlock) ModBlocks.OAT_BALE.get(),
                modLoc("block/oat_block_side"),
                modLoc("block/oat_block_top"));
        simpleExistingBlock(ModBlocks.LUSH_GRASS_BLOCK.get(), "lush_grass_block");
        jarModels("mason_jar", "mason_jar_texture");
        jarModels("vinegar_jar", "vinegar_interior_texture");
        jarModels("pepper_jam_jar", "pepper_jam_interior_texture");
        jarModels("gearo_berry_jam_jar", "gearo_berry_jam_interior_texture");
        jarModels("sweet_berry_jam_jar", "sweet_berry_jam_interior_texture");
        jarModels("glow_berry_jam_jar", "glow_berry_jam_interior_texture");
        jarModels("apple_sauce_jar", "apple_sauce_interior_texture");
        jarModels("relish_jar", "relish_interior_texture");
        jarModels("honey_jar", "honey_interior_texture");
        jarModels("nut_mash_jar", "nut_mash_interior_texture");

        simpleGeneratedBlock(ModBlocks.EMPTY_MASON_JAR.get(), "mason_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.VINEGAR_JAR.get(), "vinegar_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.PEPPER_JAM_JAR.get(), "pepper_jam_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.GEARO_BERRY_JAM_JAR.get(), "gearo_berry_jam_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.SWEET_BERRY_JAM_JAR.get(), "sweet_berry_jam_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.GLOW_BERRY_JAM_JAR.get(), "glow_berry_jam_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.APPLE_SAUCE_JAR.get(), "apple_sauce_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.RELISH_JAR.get(), "relish_jar_one_jar");
        simpleGeneratedBlock(ModBlocks.HONEY_JAR.get(), "honey_jar_one_jar");
        simpleExistingBlock(ModBlocks.GOLDEN_EGG.get(), "golden_egg");
        simpleBlock(ModBlocks.EVAPORATOR.get(), models().cubeBottomTop("evaporator",
                modLoc("block/evaporator_side"),
                modLoc("block/evaporator_bottom"),
                modLoc("block/evaporator_top")));
        simpleGeneratedBlock(ModBlocks.MAGIC_PEANUT.get(), "magic_peanut_sapling");

        simpleBlock(ModBlocks.SALT_BLOCK.get());
        simpleBlock(ModBlocks.SMOOTH_SALT_BLOCK.get());
        axisBlock((RotatedPillarBlock) ModBlocks.SALT_PILLAR.get(), blockTexture(ModBlocks.SALT_PILLAR.get()),
                modLoc("block/salt_pillar_top"));
        simpleBlock(ModBlocks.SALT_BRICKS.get());
        stairsBlock((StairBlock) ModBlocks.SALT_BRICK_STAIRS.get(), blockTexture(ModBlocks.SALT_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.SALT_BRICK_SLAB.get(), blockTexture(ModBlocks.SALT_BRICKS.get()),
                blockTexture(ModBlocks.SALT_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.SALT_BRICK_WALL.get(), blockTexture(ModBlocks.SALT_BRICKS.get()));
        simpleBlockItem(ModBlocks.SALT_BRICK_WALL.get(), models().wallInventory(name(ModBlocks.SALT_BRICK_WALL.get()) + "_inventory",
                blockTexture(ModBlocks.SALT_BRICKS.get())));

        simpleBlock(ModBlocks.MIXED_SALT_BRICKS.get());
        stairsBlock((StairBlock) ModBlocks.MIXED_SALT_BRICK_STAIRS.get(), blockTexture(ModBlocks.MIXED_SALT_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.MIXED_SALT_BRICK_SLAB.get(), blockTexture(ModBlocks.MIXED_SALT_BRICKS.get()),
                blockTexture(ModBlocks.MIXED_SALT_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.MIXED_SALT_BRICK_WALL.get(), blockTexture(ModBlocks.MIXED_SALT_BRICKS.get()));
        simpleBlockItem(ModBlocks.MIXED_SALT_BRICK_WALL.get(), models().wallInventory(name(ModBlocks.MIXED_SALT_BRICK_WALL.get()) + "_inventory",
                blockTexture(ModBlocks.MIXED_SALT_BRICKS.get())));

        axisBlock((RotatedPillarBlock) ModBlocks.MAGIC_VINE.get(),
                models().cubeColumn("magic_vine", modLoc("block/magic_vine"), modLoc("block/magic_vine_top")),
                models().cubeColumnHorizontal("magic_vine_horizontal", modLoc("block/magic_vine"), modLoc("block/magic_vine_top")));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAGIC_VINE.get(),
                models().cubeColumn("stripped_magic_vine", modLoc("block/stripped_magic_vine"), modLoc("block/stripped_magic_vine_top")),
                models().cubeColumnHorizontal("stripped_magic_vine_horizontal", modLoc("block/stripped_magic_vine"), modLoc("block/stripped_magic_vine_top")));
        axisBlock((RotatedPillarBlock) ModBlocks.MAGIC_VINE_BLOCK.get(),
                models().cubeColumn("magic_vine_block", modLoc("block/magic_vine"), modLoc("block/magic_vine")),
                models().cubeColumnHorizontal("magic_vine_block_horizontal", modLoc("block/magic_vine"), modLoc("block/magic_vine")));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get(),
                models().cubeColumn("stripped_magic_vine_block", modLoc("block/stripped_magic_vine"), modLoc("block/stripped_magic_vine")),
                models().cubeColumnHorizontal("stripped_magic_vine_block_horizontal", modLoc("block/stripped_magic_vine"), modLoc("block/stripped_magic_vine")));
        simpleBlock(ModBlocks.VINE_TILE.get());
        stairsBlock((StairBlock) ModBlocks.VINE_TILE_STAIRS.get(), blockTexture(ModBlocks.VINE_TILE.get()));
        slabBlock((SlabBlock) ModBlocks.VINE_TILE_SLAB.get(), blockTexture(ModBlocks.VINE_TILE.get()),
                blockTexture(ModBlocks.VINE_TILE.get()));
        simpleExistingBlock(ModBlocks.VINE_NET.get(), "vine_net_middle");

        cross("cucumber_stage0");
        cross("cucumber_stage1");
        cross("cucumber_stage2");
        cross("cucumber_stage3");
        cross("cucumber_stage4");
        cross("ghost_pepper_stage0");
        cross("ghost_pepper_stage1");
        cross("ghost_pepper_stage2");
        cross("ghost_pepper_stage3");
        cross("ghost_pepper_stage4");
        cross("gearo_berry_bush_stage0");
        cross("gearo_berry_bush_stage1");
        cross("gearo_berry_bush_stage2");
        cross("gearo_berry_bush_stage3");
        cross("gearo_berry_bush_stage4");
        cross("wild_cucumbers");
        cross("wild_ghost_peppers");
        cross("wild_oats");
        cross("wild_peanuts");
        cross("magic_peanut_sapling");
        models().withExistingParent("oat_stage7", modLoc("block/tall_crop"))
                .texture("tall_crop", modLoc("block/oat_stage7"));

        ageMappedBlock(ModBlocks.CUCUMBER_CROP.get(), BlockStateProperties.AGE_7,
                "cucumber_stage0", "cucumber_stage1", "cucumber_stage1", "cucumber_stage2",
                "cucumber_stage2", "cucumber_stage3", "cucumber_stage3", "cucumber_stage4");
        ageMappedBlock(ModBlocks.GHOST_PEPPER_CROP.get(), BlockStateProperties.AGE_7,
                "ghost_pepper_stage0", "ghost_pepper_stage1", "ghost_pepper_stage1", "ghost_pepper_stage2",
                "ghost_pepper_stage2", "ghost_pepper_stage3", "ghost_pepper_stage3", "ghost_pepper_stage4");
        ageMappedBlock(ModBlocks.OAT_CROP.get(), OatBlock.AGE,
                "oat_stage0", "oat_stage1", "oat_stage2", "oat_stage3",
                "oat_stage4", "oat_stage5", "oat_stage6", "oat_stage7");
        ageMappedBlock(ModBlocks.PEANUT_CROP.get(), OatBlock.AGE,
                "peanuts_stage0", "peanuts_stage0", "peanuts_stage1", "peanuts_stage1",
                "peanuts_stage2", "peanuts_stage3", "peanuts_stage3", "peanuts_stage4");
        ageMappedBlock(ModBlocks.GEARO_BERRY_BUSH.get(), GearoBerryBushBlock.AGE,
                "gearo_berry_bush_stage0", "gearo_berry_bush_stage1", "gearo_berry_bush_stage2",
                "gearo_berry_bush_stage3", "gearo_berry_bush_stage4");

        simpleGeneratedBlock(ModBlocks.WILD_CUCUMBERS.get(), "wild_cucumbers");
        simpleGeneratedBlock(ModBlocks.WILD_GHOST_PEPPERS.get(), "wild_ghost_peppers");
        simpleGeneratedBlock(ModBlocks.WILD_OATS.get(), "wild_oats");
        simpleGeneratedBlock(ModBlocks.WILD_PEANUTS.get(), "wild_peanuts");

        pieBlock(ModBlocks.CHEESE_PIZZA.get(), "cheese_pizza", "cheese_pizza_slice1", "cheese_pizza_slice2", "cheese_pizza_slice3");
        pieBlock(ModBlocks.MEAT_PIZZA.get(), "meat_pizza", "meat_pizza_slice1", "meat_pizza_slice2", "meat_pizza_slice3");
        pieBlock(ModBlocks.CHEESE_WHEEL.get(), "cheese_wheel", "cheese_slice1", "cheese_slice2", "cheese_slice3");

        jarBlock(ModBlocks.NUT_MASH_JAR.get(), "nut_mash_jar_one_jar", "nut_mash_jar_two_jar",
                "nut_mash_jar_three_jar", "nut_mash_jar_four_jar");
        saltLayerBlock(ModBlocks.SALT_LAYER.get());
    }

    private void simpleGeneratedBlock(Block block, String modelName) {
        ModelFile model = existingModel(modelName);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void cheeseMoldBlock() {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(ModBlocks.CHEESE_MOLD.get());
        ModelFile baseModel = existingModel("cheese_mold");
        builder.part().modelFile(baseModel).addModel().end();
        for (int level = 1; level <= 5; level++) {
            builder.part()
                    .modelFile(existingModel("cheese_stage" + level))
                    .addModel()
                    .condition(CheeseMoldBlock.LEVEL, level)
                    .end();
        }
        simpleBlockItem(ModBlocks.CHEESE_MOLD.get(), baseModel);
    }

    private void simpleExistingBlock(Block block, String modelName) {
        ModelFile model = new ModelFile.UncheckedModelFile(modLoc("block/" + modelName));
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
        simpleBlockItem(block, model);
    }

    private void simpleTintedParentBlock(Block block, String parent, String textureName) {
        ModelFile model = models().withExistingParent(name(block), modLoc("block/" + parent))
                .texture("0", modLoc("block/" + textureName))
                .texture("particle", modLoc("block/" + textureName));
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }
    private String name(Block block) {
        return ModBlocks.BLOCKS.getEntries().stream()
                .filter(holder -> holder.get() == block)
                .findFirst()
                .map(holder -> holder.getId().getPath())
                .orElseThrow();
    }

    private void ageMappedBlock(Block block, IntegerProperty property, String... modelNames) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(existingModel(modelNames[state.getValue(property)]))
                .build());
    }

    private void pieBlock(Block block, String wholeModel, String sliceOne, String sliceTwo, String sliceThree) {
        String[] models = {wholeModel, sliceOne, sliceTwo, sliceThree};
        getVariantBuilder(block).forAllStates(state -> {
            int bites = state.getValue(PieBlock.BITES);
            int rotation = ((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()) % 360;
            return ConfiguredModel.builder()
                    .modelFile(existingModel(models[bites]))
                    .rotationY(rotation)
                    .build();
        });
    }

    private void jarBlock(Block block, String one, String two, String three, String four) {
        String[] models = {one, two, three, four};
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(existingModel(models[state.getValue(MasonJarBlock.JARS) - 1]))
                .build());
    }

    private void saltLayerBlock(Block block) {
        String[] models = {
                "salt_height2",
                "salt_height4",
                "salt_height6",
                "salt_height8",
                "salt_height10",
                "salt_height12",
                "salt_height14",
                "salt_block"
        };
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(existingModel(models[state.getValue(SaltLayerBlock.LAYERS) - 1]))
                .build());
    }

    private void jarModels(String prefix, String interiorTexture) {
        List.of("one", "two", "three", "four").forEach(size -> models()
                .withExistingParent(prefix + "_" + size + "_jar", modLoc("block/template_mason_jar_" + size))
                .renderType("cutout")
                .texture("2", modLoc("block/" + interiorTexture)));
    }

    private void cross(String modelName) {
        models().cross(modelName, modLoc("block/" + modelName)).renderType("cutout");
    }

    private ModelFile existingModel(String modelName) {
        return new ModelFile.UncheckedModelFile(modLoc("block/" + modelName));
    }
}
