package net.ribs.vintagedelight.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;

public class ModTags {
    public static final TagKey<Item> CONTAINER_ITEMS = createTag("vintagedelight:container_items");
    public static final TagKey<Item> CHEF_HATS = createTag("vintagedelight:chef_hats");
    public static final TagKey<Item> RAW_FISH = createTag("vintagedelight:raw_fish");
    public static final TagKey<Item> SALT_LAMP = createTag("vintagedelight:salt_lamp");
    public static final TagKey<Item> SAVORY_JAM = createTag("vintagedelight:savory_jam");
    public static final TagKey<Item> SAVORY_JAM_BOTTLES = createTag("vintagedelight:savory_jam_bottles");
    public static final TagKey<Item> SLIME_BALL_FERMENTING = createTag("vintagedelight:slime_ball_fermenting");
    public static final TagKey<Item> SWEET_JAM = createTag("vintagedelight:sweet_jam");
    public static final TagKey<Item> SWEET_JAM_BOTTLES = createTag("vintagedelight:sweet_jam_bottles");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(ResourceLocation.parse(name));
    }
}
