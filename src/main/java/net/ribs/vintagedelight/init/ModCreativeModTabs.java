package net.ribs.vintagedelight.init;

import net.ribs.vintagedelight.VintageDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.init.items.ModItems;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VintageDelight.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VINTAGE_TAB = CREATIVE_MODE_TABS.register("vintage_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PEANUT.get()))
                    .title(Component.translatable("creativetab.vintage_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.FERMENTING_JAR.get());
                        pOutput.accept(ModBlocks.CHEESE_MOLD.get());
                        pOutput.accept(ModBlocks.LUSH_GRASS_BLOCK.get());
                        pOutput.accept(ModBlocks.MAGIC_VINE.get());
                        pOutput.accept(ModBlocks.STRIPPED_MAGIC_VINE.get());
                        pOutput.accept(ModBlocks.MAGIC_VINE_BLOCK.get());
                        pOutput.accept(ModBlocks.STRIPPED_MAGIC_VINE_BLOCK.get());
                        pOutput.accept(ModBlocks.VINE_TILE.get());
                        pOutput.accept(ModBlocks.VINE_TILE_STAIRS.get());
                        pOutput.accept(ModBlocks.VINE_TILE_SLAB.get());
                        pOutput.accept(ModBlocks.VINE_NET.get());
                        pOutput.accept(ModBlocks.GOLDEN_EGG.get());
                        pOutput.accept(ModBlocks.OAT_BAG.get());
                        pOutput.accept(ModBlocks.OAT_BALE.get());
                        pOutput.accept(ModBlocks.GEARO_BERRY_BAG.get());
                        pOutput.accept(ModBlocks.GHOST_PEPPER_CRATE.get());
                        pOutput.accept(ModBlocks.CUCUMBER_CRATE.get());
                        pOutput.accept(ModBlocks.PEANUT_CRATE.get());

                        pOutput.accept(ModBlocks.EVAPORATOR.get());
                        pOutput.accept(ModBlocks.SALT_BLOCK.get());
                        pOutput.accept(ModBlocks.SMOOTH_SALT_BLOCK.get());
                        pOutput.accept(ModBlocks.SALT_PILLAR.get());
                        pOutput.accept(ModBlocks.SALT_BRICKS.get());
                        pOutput.accept(ModBlocks.SALT_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.SALT_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.SALT_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.MIXED_SALT_BRICKS.get());
                        pOutput.accept(ModBlocks.MIXED_SALT_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.MIXED_SALT_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.MIXED_SALT_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.WILD_PEANUTS.get());
                        pOutput.accept(ModBlocks.WILD_GHOST_PEPPERS.get());
                        pOutput.accept(ModBlocks.WILD_CUCUMBERS.get());
                        pOutput.accept(ModBlocks.WILD_OATS.get());


                        pOutput.accept(ModItems.DEFAULT_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.BLACK_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.BLUE_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.BROWN_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.CYAN_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.GRAY_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.GREEN_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.LIGHT_BLUE_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.LIGHT_GRAY_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.LIME_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.MAGENTA_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.ORANGE_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.PINK_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.PURPLE_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.RED_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.WHITE_SALT_LAMP_ITEM.get());
                        pOutput.accept(ModItems.YELLOW_SALT_LAMP_ITEM.get());

                        pOutput.accept(ModItems.SALT_DUST.get());
                        pOutput.accept(ModItems.SALT_BUCKET.get());
                        pOutput.accept(ModItems.OAT.get());
                        pOutput.accept(ModItems.RAW_OAT.get());
                        pOutput.accept(ModItems.PEANUT.get());
                        pOutput.accept(ModItems.GHOST_PEPPER.get());
                        pOutput.accept(ModItems.CUCUMBER.get());
                        pOutput.accept(ModItems.GEARO_BERRY_ITEM.get());
                        pOutput.accept(ModItems.OAT_SEEDS.get());
                        pOutput.accept(ModItems.GHOST_PEPPER_SEEDS.get());
                        pOutput.accept(ModItems.CUCUMBER_SEEDS.get());
                        pOutput.accept(ModBlocks.MAGIC_PEANUT.get());

                        pOutput.accept(ModItems.ROASTED_PEANUT.get());
                        pOutput.accept(ModItems.HONEY_ROASTED_PEANUT.get());
                        pOutput.accept(ModItems.PICKLED_PEPPER.get());
                        pOutput.accept(ModItems.GHOST_CHARCOAL.get());
                        pOutput.accept(ModItems.PICKLE.get());
                        pOutput.accept(ModItems.CUCUMBER_NOODLES.get());
                        pOutput.accept(ModItems.KIMCHI.get());
                        pOutput.accept(ModItems.PICKLED_ONION.get());
                        pOutput.accept(ModItems.PICKLED_PITCHER_POD.get());
                        pOutput.accept(ModItems.PICKLED_BEETROOT.get());
                        pOutput.accept(ModItems.PICKLED_EGG.get());
                        pOutput.accept(ModItems.CENTURY_EGG.get());
                        pOutput.accept(ModItems.SALTED_COD.get());
                        pOutput.accept(ModItems.SALTED_SALMON.get());
                        pOutput.accept(ModItems.SURSTROMMING.get());

                        pOutput.accept(ModItems.OAT_DOUGH.get());
                        pOutput.accept(ModItems.OATMEAL.get());
                        pOutput.accept(ModItems.OATMEAL_COOKIE.get());
                        pOutput.accept(ModItems.OVERNIGHT_OATS.get());
                        pOutput.accept(ModItems.CHOCOLATE_NUT_GRANOLA_BAR.get());
                        pOutput.accept(ModItems.FRUITY_GRANOLA_BAR.get());
                        pOutput.accept(ModItems.DELUXE_GRANOLA_BAR.get());

                        pOutput.accept(ModItems.MASON_JAR.get());
                        pOutput.accept(ModItems.APPLE_SAUCE.get());
                        pOutput.accept(ModItems.GEARO_BERRY_JAM.get());
                        pOutput.accept(ModItems.SWEET_BERRY_JAM.get());
                        pOutput.accept(ModItems.GLOW_BERRY_JAM.get());
                        pOutput.accept(ModItems.PEPPER_JAM_JAR.get());
                        pOutput.accept(ModItems.RELISH.get());
                        pOutput.accept(ModItems.NUT_MASH.get());
                        pOutput.accept(ModItems.HONEY_JAR.get());
                        pOutput.accept(ModItems.VINEGAR.get());

                        pOutput.accept(ModItems.NUT_MILK.get());
                        pOutput.accept(ModItems.APPLE_SAUCE_BOTTLE.get());
                        pOutput.accept(ModItems.GEARO_BERRY_JAM_BOTTLE.get());
                        pOutput.accept(ModItems.SWEET_BERRY_JAM_BOTTLE.get());
                        pOutput.accept(ModItems.GLOW_BERRY_JAM_BOTTLE.get());
                        pOutput.accept(ModItems.PEPPER_JAM_BOTTLE.get());
                        pOutput.accept(ModItems.RELISH_BOTTLE.get());
                        pOutput.accept(ModItems.NUT_MASH_BOTTLE.get());
                        pOutput.accept(ModItems.VINEGAR_BOTTLE.get());
                        pOutput.accept(ModItems.ORGANIC_MASH.get());

                        pOutput.accept(ModItems.CHEESE_CURDS.get());
                        pOutput.accept(ModItems.CHEESE_WHEEL.get());
                        pOutput.accept(ModItems.CHEESE_SLICE.get());

                        pOutput.accept(ModItems.CHEESE_PIZZA.get());
                        pOutput.accept(ModItems.CHEESE_PIZZA_SLICE.get());
                        pOutput.accept(ModItems.MEAT_PIZZA.get());
                        pOutput.accept(ModItems.MEAT_PIZZA_SLICE.get());

                        pOutput.accept(ModItems.PICKLE_SOUP.get());
                        pOutput.accept(ModItems.GHOSTLY_CHILI.get());
                        pOutput.accept(ModItems.PAD_THAI.get());
                        pOutput.accept(ModItems.CHEESE_PASTA.get());
                        pOutput.accept(ModItems.CUCUMBER_SALAD.get());
                        pOutput.accept(ModItems.PB_J.get());
                        pOutput.accept(ModItems.CHEESE_BURGER.get());
                        pOutput.accept(ModItems.DELUXE_BURGER.get());
                        pOutput.accept(ModItems.STUFFED_BURRITO.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

