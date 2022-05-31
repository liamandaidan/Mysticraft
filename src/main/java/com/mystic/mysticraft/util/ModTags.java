package com.mystic.mysticraft.util;


import com.mystic.mysticraft.Mysticraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeItemTagsProvider;

public class ModTags {
    public static void register() {

    }

    public class Blocks {
        public static final TagKey<Block> DOWSING_ROD_VALUABLES = tag("dowsing_rod_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Mysticraft.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {

            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> PLATINUM_INGOT = forgeTag("ingots/platinum");
        public static final TagKey<Item> PLATINUM_NUGGETS = forgeTag("nuggets/platinum");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Mysticraft.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}

