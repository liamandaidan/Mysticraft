package com.mystic.mysticraft.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class CoalChunkItem extends Item {
    //1/4 as fast as coal.
    private final int BURN_TIME = 400;

    public CoalChunkItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.BURN_TIME;
    }

    public int getBURN_TIME() {
        int burn = BURN_TIME;
        return burn;
    }
}
