package palamod.item;

import palamod.procedures.XpberryprocessProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class XpberryItem extends Item {
	public XpberryItem(Item.Properties properties) {
		super(properties.durability(1));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		XpberryprocessProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}