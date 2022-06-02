package com.mystic.mysticraft.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier PLATINUM = new ForgeTier(3, 1400, 8.5f, 4f,
            10, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get()));

}
