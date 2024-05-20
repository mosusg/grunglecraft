package net.mosus.grunglecraft.item;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class GrungleChargeItem extends Item {
    public GrungleChargeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        boolean bl = false;
        if (CampfireBlock.canBeLit(blockState) || CandleBlock.canBeLit(blockState) || CandleCakeBlock.canBeLit(blockState)) {
            this.playUseSound(world, blockPos);
            world.setBlockState(blockPos, (BlockState) blockState.with(Properties.LIT, true));
            world.emitGameEvent((Entity) context.getPlayer(), GameEvent.BLOCK_CHANGE, blockPos);
            bl = true;
        } else if (AbstractFireBlock.canPlaceAt(world, blockPos = blockPos.offset(context.getSide()), context.getHorizontalPlayerFacing())) {
            this.playUseSound(world, blockPos);
            world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
            world.emitGameEvent((Entity) context.getPlayer(), GameEvent.BLOCK_PLACE, blockPos);
            bl = true;
        }
        if (bl) {
            context.getStack().decrement(1);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.FAIL;
    }

    private void playUseSound(World world, BlockPos pos) {
        Random random = world.getRandom();
        world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f);
    }
}

/*
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            //boolean onFire = false;
            //if(BlockState.PROPERTIES.equals(fire)) {

            //}
        }

        return super.useOnBlock(context);
    }
}*/
