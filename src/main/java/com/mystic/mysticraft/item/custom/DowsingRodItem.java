package com.mystic.mysticraft.item.custom;

import com.mystic.mysticraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }
    //right click with item, look down in ground
    //print coords


    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                //get the block in the loop ranging from -64 Y to your current Y click.
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();
                if (isValueableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                //the string component can be found in en_us.json.
                //good programming practice
                player.sendMessage(new TranslatableComponent("item.mysticraft.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }
        //takes 1 dmg each time used
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return super.useOn(pContext);
    }

    /**
     * Helper method to output a valuable located.
     *
     * @param blockPos   position of block
     * @param player     the player
     * @param blockBelow the block found below the player
     */
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at (" + blockPos.getX() +
                ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    /**
     * Helper method used to check if block is valuable
     *
     * @param block The block to compare
     * @return boolean of if block = valuable
     */
    private boolean isValueableBlock(Block block) {

        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE ||
                block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE ||
                block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE ||
                block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.DEEPSLATE_IRON_ORE ||
                block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.DEEPSLATE_COPPER_ORE;

    }

}
