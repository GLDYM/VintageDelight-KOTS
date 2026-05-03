package net.ribs.vintagedelight.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;

public class ModTags {
    public static final TagKey<Item> CONTAINER_ITEMS = createTag("vintagedelight:container_items");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(ResourceLocation.parse(name));
    }
}

