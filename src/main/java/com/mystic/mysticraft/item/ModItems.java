package com.mystic.mysticraft.item;

import com.mystic.mysticraft.Mysticraft;
import com.mystic.mysticraft.item.custom.CoalChunkItem;
import com.mystic.mysticraft.item.custom.DowsingRodItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //list of all items added in from our mod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mysticraft.MOD_ID);
    private static final CreativeModeTab MOD_TAB = ModCreativeModeTab.MYSTIC_TAB;

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            () -> new Item(new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(MOD_TAB).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> COAL_CHUNK = ITEMS.register("coal_chunk",
            () -> new CoalChunkItem(new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item(new Item.Properties().tab(MOD_TAB).food(ModFoods.TURNIP)));
    /**
     * Tools
     */
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModTiers.PLATINUM, 2, 0f,
                    new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModTiers.PLATINUM, 2, 0f,
                    new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModTiers.PLATINUM, 2, 0f,
                    new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModTiers.PLATINUM, 2, 0f,
                    new Item.Properties().tab(MOD_TAB)));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModTiers.PLATINUM, 4, 0f, new Item.Properties().tab(MOD_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
