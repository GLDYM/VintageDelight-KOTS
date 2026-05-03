package net.ribs.vintagedelight.item;


import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.block.ModBlocks;
import net.ribs.vintagedelight.item.custom.*;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.FuelBlockItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

import static vectorwing.farmersdelight.common.registry.ModItems.registerWithTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VintageDelight.MODID);
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }
    public static Item.Properties basicItem(FoodProperties food) {
        return new Item.Properties().food(food).stacksTo(64);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }
    public static Item.Properties bottleItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(32);
    }
    public static Item.Properties jarItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(ModItems.MASON_JAR.get()).stacksTo(16);
    }

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }
    public static final RegistryObject<Item> MASON_JAR = ITEMS.register("mason_jar",
            MasonJarItem::new);
    public static final RegistryObject<Item> SALT_BUCKET = ITEMS.register("salt_bucket",
            () -> new Item(new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> OAT = ITEMS.register("oat",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OAT_SEEDS = ITEMS.register("oat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.OAT_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> OAT_DOUGH = ITEMS.register("oat_dough",
            () -> new Item(new Item.Properties().food(ModFoods.OAT_DOUGH)));
    public static final RegistryObject<Item> RAW_OAT = ITEMS.register("raw_oats",
            () -> new Item(new Item.Properties().food(ModFoods.OAT)));
    public static final RegistryObject<Item> GEARO_BERRY_ITEM = ITEMS.register("gearo_berry",
            () -> new ItemNameBlockItem(ModBlocks.GEARO_BERRY_BUSH.get(), (new Item.Properties()).food(ModFoods.GEARO_BERRY)));
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut",
            () -> new ItemNameBlockItem(ModBlocks.PEANUT_CROP.get(), new Item.Properties().food(ModFoods.PEANUT)));
    public static final RegistryObject<Item> ROASTED_PEANUT = ITEMS.register("roasted_peanut",
            () -> new Item(new Item.Properties().food(ModFoods.ROASTED_PEANUT)));
    public static final RegistryObject<Item> HONEY_ROASTED_PEANUT = ITEMS.register("honey_roasted_peanut",
            () -> new Item(new Item.Properties().food(ModFoods.HONEY_ROASTED_PEANUT)));
    public static final RegistryObject<Item> GHOST_PEPPER = ITEMS.register("ghost_pepper",
            () -> new ItemNameBlockItem(ModBlocks.GHOST_PEPPER_CROP.get(), new Item.Properties().food(ModFoods.GHOST_PEPPER)));
    public static final RegistryObject<Item> GHOST_PEPPER_SEEDS = ITEMS.register("ghost_pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GHOST_PEPPER_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PICKLED_PEPPER = ITEMS.register("pickled_pepper",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.PICKLED_PEPPER), true));
    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));
    public static final RegistryObject<Item> CUCUMBER_NOODLES = ITEMS.register("cucumber_noodles",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER_NOODLES)));
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.PICKLE), true));
    public static final RegistryObject<Item> KIMCHI = ITEMS.register("kimchi",
            () -> new Item(new Item.Properties().food(ModFoods.KIMCHI)));
    public static final RegistryObject<Item> PICKLED_ONION = ITEMS.register("pickled_onion",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.PICKLED_ONION), true));
    public static final RegistryObject<Item> PICKLED_PITCHER_POD = ITEMS.register("pickled_pitcher_pod",
            () -> new ConsumableItem(new Item.Properties().food(ModFoods.PICKLED_PITCHER_POD), true));
    public static final RegistryObject<Item> PICKLED_EGG = ITEMS.register("pickled_egg",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.PICKLED_EGG), true));
    public static final RegistryObject<Item> CENTURY_EGG = ITEMS.register("century_egg",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.CENTURY_EGG), true));
    public static final RegistryObject<Item> PICKLED_BEETROOT = ITEMS.register("pickled_beetroot",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.PICKLED_BEETROOT), true));
    public static final RegistryObject<Item> OVERNIGHT_OATS = ITEMS.register("overnight_oats",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.OVERNIGHT_OATS), true));
    public static final RegistryObject<Item> OATMEAL = ITEMS.register("oatmeal",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.OATMEAL), true));
    public static final RegistryObject<Item> OATMEAL_COOKIE = ITEMS.register("oatmeal_cookie",
            () -> new Item(new Item.Properties().food(ModFoods.OATMEAL_COOKIE)));
    public static final RegistryObject<Item> CHOCOLATE_NUT_GRANOLA_BAR = ITEMS.register("chocolate_nut_granola_bar",
            () -> new ConsumableItem(basicItem(ModFoods.CHOCOLATE_NUT_GRANOLA_BAR), true));
    public static final RegistryObject<Item> FRUITY_GRANOLA_BAR = ITEMS.register("fruity_granola_bar",
            () -> new ConsumableItem(basicItem(ModFoods.FRUITY_GRANOLA_BAR), true));
    public static final RegistryObject<Item> DELUXE_GRANOLA_BAR = ITEMS.register("deluxe_granola_bar",
            () -> new ConsumableItem(basicItem(ModFoods.DELUXE_GRANOLA_BAR), true));
    public static final RegistryObject<Item> RELISH = ITEMS.register("relish_mason_jar",
            RelishItem::new);
    public static final RegistryObject<Item> RELISH_BOTTLE = ITEMS.register("relish_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.RELISH_BOTTLE), true));
    public static final RegistryObject<Item> APPLE_SAUCE = ITEMS.register("apple_sauce_mason_jar",
            AppleSauceItem::new);

    public static final RegistryObject<Item> HONEY_JAR = ITEMS.register("honey_mason_jar",
            HoneyItem::new);
    public static final RegistryObject<Item> APPLE_SAUCE_BOTTLE = ITEMS.register("apple_sauce_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.APPLE_SAUCE_BOTTLE), true));

    public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_mason_jar",
            SweetBerryJamItem::new);
    public static final RegistryObject<Item> SWEET_BERRY_JAM_BOTTLE = ITEMS.register("sweet_berry_jam_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.SWEET_BERRY_JAM_BOTTLE), true));

    public static final RegistryObject<Item> GLOW_BERRY_JAM = ITEMS.register("glow_berry_mason_jar",
            GlowBerryJamItem::new);
    public static final RegistryObject<Item> GLOW_BERRY_JAM_BOTTLE = ITEMS.register("glow_berry_jam_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.GLOW_BERRY_JAM_BOTTLE), true));

    public static final RegistryObject<Item> GEARO_BERRY_JAM = ITEMS.register("gearo_berry_mason_jar",
            GearoBerryJamItem::new);
    public static final RegistryObject<Item> GEARO_BERRY_JAM_BOTTLE = ITEMS.register("gearo_berry_jam_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.GEARO_BERRY_JAM_BOTTLE), true));
    public static final RegistryObject<Item> PEPPER_JAM_JAR = ITEMS.register("pepper_jam_mason_jar",
            PepperJamItem::new);
    public static final RegistryObject<Item> PEPPER_JAM_BOTTLE = ITEMS.register("pepper_jam_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.PEPPER_JAM_BOTTLE), true));
    public static final RegistryObject<Item> NUT_MASH = ITEMS.register("nut_mash_mason_jar",
            NutMashItem::new);
    public static final RegistryObject<Item> NUT_MASH_BOTTLE = ITEMS.register("nut_mash_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.NUT_MASH_BOTTLE), true));
    public static final RegistryObject<Item> NUT_MILK = ITEMS.register("nut_milk_bottle",
            () -> new MilkBottleItem(drinkItem(ModFoods.NUT_MILK)));
    public static final RegistryObject<Item> SALT_DUST = ITEMS.register("salt_dust",
            () -> new SaltDustItem(new Item.Properties()));
    public static final RegistryObject<Item> VINEGAR = ITEMS.register("vinegar_mason_jar",
            VinegarItem::new);
    public static final RegistryObject<Item> VINEGAR_BOTTLE = ITEMS.register("vinegar_bottle",
            () -> new ConsumableItem(bottleItem(ModFoods.VINEGAR), true));
    public static final RegistryObject<Item> ORGANIC_MASH = ITEMS.register("organic_mash",
            () -> new OrganicMashItem(new Item.Properties()));

    public static final RegistryObject<Item> CHEESE_CURDS = ITEMS.register("cheese_curds",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_CURDS)));
    public static final RegistryObject<Item> CHEESE_WHEEL = ITEMS.register("cheese_wheel",
            () -> new BlockItem(ModBlocks.CHEESE_WHEEL.get(), basicItem()));
    public static final RegistryObject<Item> CHEESE_SLICE = ITEMS.register("cheese_slice",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_SLICE)));
    public static final RegistryObject<Item> PICKLE_SOUP = ITEMS.register("pickle_soup",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.PICKLE_SOUP), true));
    public static final RegistryObject<Item> PB_J = ITEMS.register("pb_j",
            () -> new Item(new Item.Properties().food(ModFoods.PB_J)));
    public static final RegistryObject<Item> CHEESE_BURGER = ITEMS.register("cheese_burger",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESEBURGER)));
    public static final RegistryObject<Item> DELUXE_BURGER = ITEMS.register("deluxe_burger",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.DELUXE_BURGER), true));


    public static final RegistryObject<Item> CHEESE_PASTA = ITEMS.register("cheese_pasta",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.CHEESE_PASTA), true));
    public static final RegistryObject<Item> GHOSTLY_CHILI = ITEMS.register("ghostly_chili",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.GHOSTLY_CHILI), true));
    public static final RegistryObject<Item> PAD_THAI = ITEMS.register("pad_thai",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.PAD_THAI), true));
    public static final RegistryObject<Item> CUCUMBER_SALAD = ITEMS.register("cucumber_salad",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.CUCUMBER_SALAD), true));

    public static final RegistryObject<Item> SALTED_COD = ITEMS.register("salted_cod",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_COD)));
    public static final RegistryObject<Item> SALTED_SALMON = ITEMS.register("salted_salmon",
            () -> new Item(new Item.Properties().food(ModFoods.SALTED_SALMON)));
    public static final RegistryObject<Item> SURSTROMMING = ITEMS.register("surstromming",
            () -> new Item(new Item.Properties().food(ModFoods.SURSTROMMING)));
    public static final RegistryObject<Item> STUFFED_BURRITO = ITEMS.register("stuffed_burrito",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.STUFFED_BURRITO), true));
    public static final RegistryObject<Item> CHEESE_PIZZA_SLICE = ITEMS.register("cheese_pizza_slice",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.CHEESE_PIZZA_SLICE), true));
    public static final RegistryObject<Item> MEAT_PIZZA_SLICE = ITEMS.register("meat_pizza_slice",
            () -> new ConsumableItem( new Item.Properties().food(ModFoods.MEAT_PIZZA_SLICE), true));
    public static final RegistryObject<Item> CHEESE_PIZZA = ITEMS.register("cheese_pizza",
            () -> new BlockItem(ModBlocks.CHEESE_PIZZA.get(), basicItem()));
    public static final RegistryObject<Item> MEAT_PIZZA = ITEMS.register("meat_pizza",
            () -> new BlockItem(ModBlocks.MEAT_PIZZA.get(), basicItem()));
    public static final RegistryObject<Item> BLACK_CHEF_HAT = ITEMS.register("black_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUE_CHEF_HAT = ITEMS.register("blue_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROWN_CHEF_HAT = ITEMS.register("brown_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CYAN_CHEF_HAT = ITEMS.register("cyan_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GRAY_CHEF_HAT = ITEMS.register("gray_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GREEN_CHEF_HAT = ITEMS.register("green_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_BLUE_CHEF_HAT = ITEMS.register("light_blue_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_GRAY_CHEF_HAT = ITEMS.register("light_gray_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIME_CHEF_HAT = ITEMS.register("lime_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAGENTA_CHEF_HAT = ITEMS.register("magenta_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ORANGE_CHEF_HAT = ITEMS.register("orange_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PINK_CHEF_HAT = ITEMS.register("pink_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PURPLE_CHEF_HAT = ITEMS.register("purple_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RED_CHEF_HAT = ITEMS.register("red_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WHITE_CHEF_HAT = ITEMS.register("white_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YELLOW_CHEF_HAT = ITEMS.register("yellow_chefs_hat", () ->
            new ChefHatItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DEFAULT_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_default",
            () -> new BlockItem(ModBlocks.DEFAULT_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACK_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_black",
            () -> new BlockItem(ModBlocks.BLACK_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_blue",
            () -> new BlockItem(ModBlocks.BLUE_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BROWN_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_brown",
            () -> new BlockItem(ModBlocks.BROWN_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CYAN_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_cyan",
            () -> new BlockItem(ModBlocks.CYAN_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_gray",
            () -> new BlockItem(ModBlocks.GRAY_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_green",
            () -> new BlockItem(ModBlocks.GREEN_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_BLUE_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_light_blue",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_GRAY_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_light_gray",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIME_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_lime",
            () -> new BlockItem(ModBlocks.LIME_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAGENTA_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_magenta",
            () -> new BlockItem(ModBlocks.MAGENTA_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_orange",
            () -> new BlockItem(ModBlocks.ORANGE_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINK_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_pink",
            () -> new BlockItem(ModBlocks.PINK_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_purple",
            () -> new BlockItem(ModBlocks.PURPLE_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_red",
            () -> new BlockItem(ModBlocks.RED_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_white",
            () -> new BlockItem(ModBlocks.WHITE_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_SALT_LAMP_ITEM = ITEMS.register("salt_lamp_yellow",
            () -> new BlockItem(ModBlocks.YELLOW_SALT_LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GHOST_CHARCOAL = ITEMS.register("ghost_charcoal",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
