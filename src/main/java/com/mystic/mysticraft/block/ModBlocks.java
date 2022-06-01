package com.mystic.mysticraft.block;

import com.mystic.mysticraft.Mysticraft;
import com.mystic.mysticraft.block.custom.SpeedPath;
import com.mystic.mysticraft.item.ModCreativeModeTab;
import com.mystic.mysticraft.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Mysticraft.MOD_ID);

    private static final CreativeModeTab MOD_TAB = ModCreativeModeTab.MYSTIC_TAB;

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(5f)
                    .requiresCorrectToolForDrops()),
            MOD_TAB);
    public static final RegistryObject<Block> PLATINUM_STAIRS = registerBlock("platinum_stairs",
            () -> new StairBlock(() -> ModBlocks.PLATINUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(5F)
                            .requiresCorrectToolForDrops().color(MaterialColor.METAL)),
            MOD_TAB);
    public static final RegistryObject<Block> PLATINUM_SLAB = registerBlock("platinum_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5F)
                    .requiresCorrectToolForDrops().color(MaterialColor.METAL)),
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
                    .requiresCorrectToolForDrops()), MOD_TAB,
            "tooltip.block.speed_path");
    public static final RegistryObject<Block> CHERRY_WOOD_PLANKS = registerBlock("cherry_wood_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F,
                    3.0F).sound(SoundType.WOOD)), MOD_TAB);
    public static final RegistryObject<Block> CHERRY_WOOD_BUTTON = registerBlock("cherry_wood_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F,
                    3.0F).noCollission().sound(SoundType.WOOD)), MOD_TAB);
    public static final RegistryObject<Block> CHERRY_WOOD_PRESSURE_PLATE = registerBlock("cherry_wood_pressure_plate",
            () -> new PressurePlateBlock((PressurePlateBlock.Sensitivity.EVERYTHING), BlockBehaviour.Properties
                    .of(Material.WOOD, MaterialColor.COLOR_PINK).noCollission().strength(2.0F,
                            3.0F).sound(SoundType.WOOD)), MOD_TAB);
    public static final RegistryObject<Block> CHERRY_WOOD_FENCE = registerBlock("cherry_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F,
                    3.0F).sound(SoundType.WOOD)), MOD_TAB);
    public static final RegistryObject<Block> CHERRY_WOOD_FENCE_GATE = registerBlock("cherry_wood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F,
                    3.0F).sound(SoundType.WOOD)), MOD_TAB);
    public static final RegistryObject<Block> CHERRY_WOOD_WALL = registerBlock("cherry_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F,
                    3.0F).sound(SoundType.WOOD)), MOD_TAB);


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


    /**
     * This will only register a block which is rendered in the world.
     *
     * @param name    block name
     * @param block   block type
     * @param tab     tab the block belongs in
     * @param <T>     extends type block
     * @param tooltip String
     * @return RegistryObject
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab,
                                                                     String tooltip) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltip);
        return toReturn;
    }

    /**
     * Returns a registered block item aka when broken.
     *
     * @param name    block name
     * @param block   block type
     * @param tab     tab the block belongs in
     * @param <T>     extends block type
     * @param tooltip String
     * @return a registered block via eventBus
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltip) {
        return ModItems.ITEMS.register((name), () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltip));
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
