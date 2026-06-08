package net.ribs.vintagedelight.init;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ribs.vintagedelight.VintageDelight;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    private static final EnumMap<ArmorItem.Type, Integer> CHEF_HAT_DEFENSE = Util.make(new EnumMap<>(ArmorItem.Type.class), defense -> {
        defense.put(ArmorItem.Type.BOOTS, 0);
        defense.put(ArmorItem.Type.LEGGINGS, 0);
        defense.put(ArmorItem.Type.CHESTPLATE, 0);
        defense.put(ArmorItem.Type.HELMET, 0);
        defense.put(ArmorItem.Type.BODY, 0);
    });

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, VintageDelight.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BLACK_CHEF_HAT = registerChefHat("black_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BLUE_CHEF_HAT = registerChefHat("blue_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BROWN_CHEF_HAT = registerChefHat("brown_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CYAN_CHEF_HAT = registerChefHat("cyan_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> GRAY_CHEF_HAT = registerChefHat("gray_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> GREEN_CHEF_HAT = registerChefHat("green_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> LIGHT_BLUE_CHEF_HAT = registerChefHat("light_blue_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> LIGHT_GRAY_CHEF_HAT = registerChefHat("light_gray_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> LIME_CHEF_HAT = registerChefHat("lime_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> MAGENTA_CHEF_HAT = registerChefHat("magenta_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ORANGE_CHEF_HAT = registerChefHat("orange_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PINK_CHEF_HAT = registerChefHat("pink_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PURPLE_CHEF_HAT = registerChefHat("purple_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> RED_CHEF_HAT = registerChefHat("red_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> WHITE_CHEF_HAT = registerChefHat("white_chef_hat");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> YELLOW_CHEF_HAT = registerChefHat("yellow_chef_hat");

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> registerChefHat(String name) {
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(
                CHEF_HAT_DEFENSE,
                0,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                () -> Ingredient.EMPTY,
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(VintageDelight.MODID, name))),
                0.0F,
                0.0F
        ));
    }

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
