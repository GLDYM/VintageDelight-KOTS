package net.ribs.vintagedelight.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.*;

public class ModFoods {
    private static final int EXTRA_LONG_DURATION = 9600;
    public static final FoodProperties SALTED_COD = new FoodProperties.Builder().nutrition(6).fast()
            .saturationMod(0.7f).build();
    public static final FoodProperties SALTED_SALMON = new FoodProperties.Builder().nutrition(7).fast()
            .saturationMod(0.85f).build();
    public static final FoodProperties SURSTROMMING = new FoodProperties.Builder().nutrition(9).fast()
            .saturationMod(0.85f).build();
    public static final FoodProperties GEARO_BERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties GHOST_PEPPER = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).build();
    public static final FoodProperties PICKLED_PEPPER = (new FoodProperties.Builder()).fast()
            .nutrition(6).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties CUCUMBER = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).build();
    public static final FoodProperties CUCUMBER_NOODLES = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).build();
    public static final FoodProperties OAT = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).build();
    public static final FoodProperties OAT_DOUGH = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).build();
    public static final FoodProperties PEANUT = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties ROASTED_PEANUT = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties HONEY_ROASTED_PEANUT = new FoodProperties.Builder().nutrition(5).fast()
            .saturationMod(0.3f).build();
    public static final FoodProperties PICKLE_SOUP = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.85f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PICKLE = (new FoodProperties.Builder()).fast()
            .nutrition(6).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties OATMEAL = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties OATMEAL_COOKIE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).build();
    public static final FoodProperties OVERNIGHT_OATS = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), EXTRA_LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHOCOLATE_NUT_GRANOLA_BAR = (new FoodProperties.Builder()).fast()
            .nutrition(4).saturationMod(0.6f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties FRUITY_GRANOLA_BAR = (new FoodProperties.Builder()).fast()
            .nutrition(3).saturationMod(0.6f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties DELUXE_GRANOLA_BAR = (new FoodProperties.Builder())
            .fast().nutrition(5).saturationMod(0.65f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHEESE_CURDS = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.8f).build();
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.8f).build();
    public static final FoodProperties APPLE_SAUCE = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties APPLE_SAUCE_BOTTLE = (new FoodProperties.Builder())
            .nutrition(3).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties SWEET_BERRY_JAM = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties SWEET_BERRY_JAM_BOTTLE = (new FoodProperties.Builder())
            .nutrition(2).fast()
            .saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties HONEY_JAR = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.1f).build();
    public static final FoodProperties GLOW_BERRY_JAM = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties GLOW_BERRY_JAM_BOTTLE = (new FoodProperties.Builder())
            .nutrition(2).fast()
            .saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties GEARO_BERRY_JAM = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties GEARO_BERRY_JAM_BOTTLE = (new FoodProperties.Builder())
            .nutrition(2).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties NUT_MASH = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties NUT_MASH_BOTTLE = (new FoodProperties.Builder())
            .nutrition(3).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties NUT_MILK = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).alwaysEat().build();
    public static final FoodProperties VINEGAR = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties VINEGAR_JAR = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties PEPPER_JAM = (new FoodProperties.Builder())
            .nutrition(9).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties PEPPER_JAM_BOTTLE = (new FoodProperties.Builder())
            .nutrition(3).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties RELISH = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties RELISH_BOTTLE = (new FoodProperties.Builder())
            .nutrition(2).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties KIMCHI = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.3f).build();
    public static final FoodProperties PICKLED_ONION = (new FoodProperties.Builder()).fast()
            .nutrition(6).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties PICKLED_PITCHER_POD = (new FoodProperties.Builder()).fast()
            .nutrition(8).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 0.6F).build();
    public static final FoodProperties PICKLED_BEETROOT = (new FoodProperties.Builder()).fast()
            .nutrition(5).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties PICKLED_EGG= (new FoodProperties.Builder()).fast()
            .nutrition(6).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties CENTURY_EGG= (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, BRIEF_DURATION, 2), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 2), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 2), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0F)
            .build();

    public static final FoodProperties PB_J = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.7f).build();
    public static final FoodProperties CHEESEBURGER = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.95f).build();
    public static final FoodProperties DELUXE_BURGER = (new FoodProperties.Builder())
            .nutrition(15).saturationMod(0.95f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties STUFFED_BURRITO = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHEESE_PASTA = (new FoodProperties.Builder())
            .nutrition(9).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHEESE_PIZZA_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.75f).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties MEAT_PIZZA_SLICE = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.75f).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties GHOSTLY_CHILI = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PAD_THAI = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties CUCUMBER_SALAD = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 2), 1.0F).build();
}
