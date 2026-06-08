package net.ribs.vintagedelight.init;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.custom.*;
import net.ribs.vintagedelight.block.custom.mason_jars.*;
import net.ribs.vintagedelight.block.custom.salt_lamps.*;
import net.ribs.vintagedelight.init.items.ModItems;
import net.ribs.vintagedelight.worldgen.tree.MagicVineGrower;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VintageDelight.MODID);

    //salt lamps
    public static final DeferredBlock<Block> DEFAULT_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_default",
            DefaultSaltLampBlock::new);
    public static final DeferredBlock<Block> BLACK_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_black",
            BlackSaltLampBlock::new);
    public static final DeferredBlock<Block> BLUE_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_blue",
            BlueSaltLampBlock::new);
    public static final DeferredBlock<Block> BROWN_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_brown",
            BrownSaltLampBlock::new);
    public static final DeferredBlock<Block> CYAN_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_cyan",
            CyanSaltLampBlock::new);
    public static final DeferredBlock<Block> GRAY_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_gray",
            GraySaltLampBlock::new);
    public static final DeferredBlock<Block> GREEN_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_green",
            GreenSaltLampBlock::new);
    public static final DeferredBlock<Block> LIGHT_BLUE_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_light_blue",
            LightBlueSaltLampBlock::new);
    public static final DeferredBlock<Block> LIGHT_GRAY_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_light_gray",
            LightGraySaltLampBlock::new);
    public static final DeferredBlock<Block> LIME_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_lime",
            LimeSaltLampBlock::new);
    public static final DeferredBlock<Block> MAGENTA_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_magenta",
            MagentaSaltLampBlock::new);
    public static final DeferredBlock<Block> ORANGE_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_orange",
            OrangeSaltLampBlock::new);
    public static final DeferredBlock<Block> PINK_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_pink",
            PinkSaltLampBlock::new);
    public static final DeferredBlock<Block> PURPLE_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_purple",
            PurpleSaltLampBlock::new);
    public static final DeferredBlock<Block> RED_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_red",
            RedSaltLampBlock::new);
    public static final DeferredBlock<Block> WHITE_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_white",
            WhiteSaltLampBlock::new);
    public static final DeferredBlock<Block> YELLOW_SALT_LAMP = BLOCKS.<Block>register("salt_lamp_yellow",
            YellowSaltLampBlock::new);

    //crates
    public static final DeferredBlock<Block> OAT_BAG = registerBlock("oat_bag",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GEARO_BERRY_BAG = registerBlock("gearo_berry_bag",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PEANUT_CRATE = registerBlock("peanut_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
public static final DeferredBlock<Block> CUCUMBER_CRATE = registerBlock("cucumber_crate",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> GHOST_PEPPER_CRATE = registerBlock("ghost_pepper_crate",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> OAT_BALE = registerBlock("oat_bale",
            () -> new HayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> CHEESE_MOLD = registerBlock("cheese_mold",
            () -> new CheeseMoldBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> FERMENTING_JAR = registerBlock("fermenting_jar",
            () -> new FermentingJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(0.2f).sound(SoundType.GLASS).noOcclusion().lightLevel(state -> 0).isViewBlocking((state, level, pos) -> false)));
    //wild crops
    public static final DeferredBlock<Block> WILD_PEANUTS = registerBlock("wild_peanuts",
            () -> new WildCropBlock(MobEffects.DAMAGE_RESISTANCE, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_GHOST_PEPPERS = registerBlock("wild_ghost_peppers",
            () -> new GhostPepperWildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Block.Properties.ofFullCopy(Blocks.WARPED_FUNGUS)));
    public static final DeferredBlock<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers",
            () -> new WildCropBlock(MobEffects.JUMP, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> WILD_OATS = registerBlock("wild_oats",
            () -> new WildCropBlock(MobEffects.SATURATION, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    //crops
    public static final DeferredBlock<Block> OAT_CROP = BLOCKS.<Block>register("oat_crop",
            () -> new OatBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> PEANUT_CROP = BLOCKS.<Block>register("peanut_crop",
            () -> new PeanutBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> GHOST_PEPPER_CROP = BLOCKS.<Block>register("ghost_pepper_crop",
            () -> new GhostPepperBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> CUCUMBER_CROP = BLOCKS.<Block>register("cucumber_crop",
            () -> new CucumberBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> GEARO_BERRY_BUSH = BLOCKS.<Block>register("gearo_berry_bush",
            () -> new GearoBerryBushBlock(Block.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));
    public static final DeferredBlock<Block> LUSH_GRASS_BLOCK = registerBlock("lush_grass_block",
            () -> new LushGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> EMPTY_MASON_JAR = registerBlock("empty_mason_jar",
            () -> new EmptyMasonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> VINEGAR_JAR = registerBlock("vinegar_jar",
            () -> new VinegarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> PEPPER_JAM_JAR = registerBlock("pepper_jam_jar",
            () -> new PepperJamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> GEARO_BERRY_JAM_JAR = registerBlock("gearo_berry_jam_jar",
            () -> new GearoBerryJamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> SWEET_BERRY_JAM_JAR = registerBlock("sweet_berry_jam_jar",
            () -> new SweetBerryJamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> GLOW_BERRY_JAM_JAR = registerBlock("glow_berry_jam_jar",
            () -> new GlowBerryJamBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> APPLE_SAUCE_JAR = registerBlock("apple_sauce_jar",
            () -> new AppleSauceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> NUT_MASH_JAR = registerBlock("nut_mash_jar",
            () -> new NutMashBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> RELISH_JAR = registerBlock("relish_jar",
            () -> new RelishBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> HONEY_JAR = registerBlock("honey_jar",
            () -> new HoneyJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
                    .strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> CHEESE_WHEEL = BLOCKS.<Block>register("cheese_wheel",
            () -> new PieBlock(Block.Properties.ofFullCopy(Blocks.CAKE), ModItems.CHEESE_SLICE));
    public static final DeferredBlock<Block> MAGIC_VINE = registerBlock("magic_vine",
            () -> new MagicVineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).strength(1.5f)));
    public static final DeferredBlock<Block> STRIPPED_MAGIC_VINE = registerBlock("stripped_magic_vine",
            () -> new MagicVineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK).strength(1.5f)));
    public static final DeferredBlock<Block> MAGIC_VINE_BLOCK = registerBlock("magic_vine_block",
            () -> new MagicVineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK).strength(1.5f)));
    public static final DeferredBlock<Block> STRIPPED_MAGIC_VINE_BLOCK = registerBlock("stripped_magic_vine_block",
            () -> new MagicVineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK).strength(1.5f)));

    public static final DeferredBlock<Block> MAGIC_PEANUT = registerBlock("magic_peanut",
            () -> new SaplingBlock(MagicVineGrower.MAGIC_VINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> VINE_NET = registerBlock("vine_net",
            () -> new VineNetBlock(Block.Properties.ofFullCopy(Blocks.GREEN_CARPET).strength(0.2F).sound(SoundType.VINE)));
    public static final DeferredBlock<Block> GOLDEN_EGG = registerBlock("golden_egg",
            () -> new GoldenEggBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRAGON_EGG).strength(0.3f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> EVAPORATOR = registerBlock("evaporator",
            () -> new SaltBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), 50.0F));
    public static final DeferredBlock<Block> SALT_LAYER = registerBlock("salt",
            () -> new SaltLayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final DeferredBlock<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new SaltBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND), 10.0F));
    public static final DeferredBlock<Block> SMOOTH_SALT_BLOCK = registerBlock("smooth_salt_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> VINE_TILE = registerBlock("vine_tile",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> VINE_TILE_STAIRS = registerBlock("vine_tile_stairs",
            () -> new StairBlock(VINE_TILE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> VINE_TILE_SLAB = registerBlock("vine_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> SALT_PILLAR = registerBlock("salt_pillar",
            () -> new SaltPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SALT_BRICKS = registerBlock("salt_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SALT_BRICK_STAIRS = registerBlock("salt_brick_stairs",
            () -> new StairBlock(SALT_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_STAIRS)));
    public static final DeferredBlock<Block> SALT_BRICK_SLAB = registerBlock("salt_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB)));
    public static final DeferredBlock<Block> SALT_BRICK_WALL = registerBlock("salt_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_WALL)));
    public static final DeferredBlock<Block> MIXED_SALT_BRICKS = registerBlock("mixed_salt_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MIXED_SALT_BRICK_STAIRS = registerBlock("mixed_salt_brick_stairs",
            () -> new StairBlock(MIXED_SALT_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_STAIRS)));
    public static final DeferredBlock<Block> MIXED_SALT_BRICK_SLAB = registerBlock("mixed_salt_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB)));
    public static final DeferredBlock<Block> MIXED_SALT_BRICK_WALL = registerBlock("mixed_salt_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_WALL)));

    public static final DeferredBlock<Block> CHEESE_PIZZA = BLOCKS.<Block>register("cheese_pizza",
            () -> new PizzaBlock(Block.Properties.ofFullCopy(Blocks.CAKE), ModItems.CHEESE_PIZZA_SLICE));
    public static final DeferredBlock<Block> MEAT_PIZZA = BLOCKS.<Block>register("meat_pizza",
            () -> new PizzaBlock(Block.Properties.ofFullCopy(Blocks.CAKE), ModItems.MEAT_PIZZA_SLICE));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.<Item>register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

