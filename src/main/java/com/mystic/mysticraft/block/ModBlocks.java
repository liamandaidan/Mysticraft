package com.mystic.mysticraft.block;

import com.mystic.mysticraft.Mysticraft;
import com.mystic.mysticraft.block.custom.SpeedPath;
import com.mystic.mysticraft.item.ModCreativeModeTab;
import com.mystic.mysticraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Mysticraft.MOD_ID);

    private static final CreativeModeTab MOD_TAB = ModCreativeModeTab.MYSTIC_TAB;

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(5f)
                    .requiresCorrectToolForDrops()),
            MOD_TAB);
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()),
            MOD_TAB);
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.5F, 4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).color(MaterialColor.DEEPSLATE)),
            MOD_TAB);
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()), MOD_TAB);
    public static final RegistryObject<Block> SPEED_PATH = registerBlock("speed_path",
            () -> new SpeedPath(BlockBehaviour.Properties.of(Material.STONE).strength(2F)
                    .requiresCorrectToolForDrops()), MOD_TAB);
    /**
     * This will only register a block which is rendered in the world.
     *
     * @param name  block name
     * @param block block type
     * @param tab   tab the block belongs in
     * @param <T>   extends type block
     * @return RegistryObject
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    /**
     * Returns a registered block item aka when broken.
     *
     * @param name  block name
     * @param block block type
     * @param tab   tab the block belongs in
     * @param <T>   extends block type
     * @return a registered block via eventBus
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register((name), () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
