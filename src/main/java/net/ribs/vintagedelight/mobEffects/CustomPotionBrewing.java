package net.ribs.vintagedelight.mobEffects;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;

import java.lang.reflect.Method;

public class CustomPotionBrewing {
    public static void addMix(Potion input, Item ingredient, Potion output) {
        try {
            Method addMixMethod = PotionBrewing.class.getDeclaredMethod("addMix", Potion.class, Item.class, Potion.class);
            addMixMethod.setAccessible(true);
            addMixMethod.invoke(null, input, ingredient, output);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to register Vintage Delight potion recipe", e);
        }
    }
}

