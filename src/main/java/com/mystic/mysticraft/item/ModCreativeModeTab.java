package com.mystic.mysticraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab MYSTIC_TAB = new CreativeModeTab("mysticraft") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATINUM_INGOT.get());
        }
    };

}
