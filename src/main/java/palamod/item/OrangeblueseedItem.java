package palamod.item;

import palamod.procedures.OrangeblueseedprocessProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class OrangeblueseedItem extends Item {
	public OrangeblueseedItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		OrangeblueseedprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}