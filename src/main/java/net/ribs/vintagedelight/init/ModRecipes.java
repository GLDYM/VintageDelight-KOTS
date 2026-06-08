package net.ribs.vintagedelight.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ribs.vintagedelight.VintageDelight;
import net.ribs.vintagedelight.recipe.FermentingRecipe;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, VintageDelight.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FermentingRecipe>> FERMENTING_SERIALIZER =
            SERIALIZERS.register("fermenting", () -> FermentingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

