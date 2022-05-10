package com.mystic.mysticraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpeedPath extends Block {
    public SpeedPath(Properties properties) {
        super(properties);
    }

    @Override
    public boolean addRunningEffects(BlockState state, Level level, BlockPos pos, Entity entity) {
        return super.addRunningEffects(state, level, pos, entity);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        //making sure on server side
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity entity = ((LivingEntity) pEntity);
                //                                                      effect, time(ticks), amplifier
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0));
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
