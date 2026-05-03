package net.ribs.vintagedelight.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FermentingRecipe implements Recipe<FermentingRecipeInput> {
    private static final int FIRST_INPUT_SLOT = 0;
    private static final int LAST_INPUT_SLOT = 5;
    private static final int CONTAINER_SLOT = 6;
    private static final int DEFAULT_PROCESSING_TIME = 100;

    private final NonNullList<Ingredient> inputItems;
    private final Ingredient containerIngredient;
    private final ItemStack output;
    private final ItemStack secondaryOutput;
    private final int processingTime;

    public FermentingRecipe(NonNullList<Ingredient> inputItems, Ingredient containerIngredient, ItemStack output, ItemStack secondaryOutput, int processingTime) {
        this.inputItems = inputItems;
        this.containerIngredient = containerIngredient;
        this.output = output;
        this.secondaryOutput = secondaryOutput;
        this.processingTime = processingTime;
    }

    @Override
    public boolean matches(FermentingRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        NonNullList<Ingredient> requiredIngredients = NonNullList.create();
        requiredIngredients.addAll(inputItems);
        for (int i = FIRST_INPUT_SLOT; i <= LAST_INPUT_SLOT; i++) {
            ItemStack itemInSlot = input.getItem(i);
            if (!itemInSlot.isEmpty()) {
                boolean matched = false;
                for (Ingredient ingredient : requiredIngredients) {
                    if (ingredient.test(itemInSlot)) {
                        requiredIngredients.remove(ingredient);
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    return false;
                }
            }
        }

        if (!containerIngredient.isEmpty() && !containerIngredient.test(input.getItem(CONTAINER_SLOT))) {
            return false;
        }

        return requiredIngredients.isEmpty();
    }

    public boolean matches(SimpleContainer container, Level level) {
        return matches(new FermentingRecipeInput(container), level);
    }

    public ItemStack getSecondaryResultItem() {
        return secondaryOutput.copy();
    }

    public int getProcessingTime() {
        return processingTime;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(FermentingRecipeInput input, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public ItemStack getContainerItemStack() {
        return containerIngredient.getItems().length > 0 ? containerIngredient.getItems()[0] : ItemStack.EMPTY;
    }

    public static class Type implements RecipeType<FermentingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermentingRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        private static final MapCodec<FermentingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.LIST_CODEC_NONEMPTY.xmap(ingredients -> {
                    NonNullList<Ingredient> list = NonNullList.create();
                    list.addAll(ingredients);
                    return list;
                }, ingredients -> ingredients).fieldOf("ingredients").forGetter(FermentingRecipe::getIngredients),
                Ingredient.CODEC.optionalFieldOf("container", Ingredient.EMPTY).forGetter(recipe -> recipe.containerIngredient),
                ItemStack.STRICT_CODEC.fieldOf("output").forGetter(recipe -> recipe.output),
                ItemStack.OPTIONAL_CODEC.optionalFieldOf("secondaryOutput", ItemStack.EMPTY).forGetter(recipe -> recipe.secondaryOutput),
                Codec.INT.optionalFieldOf("processingTime", DEFAULT_PROCESSING_TIME).forGetter(FermentingRecipe::getProcessingTime)
        ).apply(instance, FermentingRecipe::new));

        private static final StreamCodec<RegistryFriendlyByteBuf, FermentingRecipe> STREAM_CODEC =
                StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        @Override
        public MapCodec<FermentingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FermentingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static FermentingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readVarInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            ItemStack secondaryOutput = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            int processingTime = buffer.readVarInt();
            Ingredient containerIngredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            return new FermentingRecipe(inputs, containerIngredient, output, secondaryOutput, processingTime);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, FermentingRecipe recipe) {
            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.secondaryOutput);
            buffer.writeVarInt(recipe.processingTime);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.containerIngredient);
        }
    }
}
