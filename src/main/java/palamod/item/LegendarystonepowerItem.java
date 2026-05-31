package palamod.item;

import palamod.procedures.LegendarystonestickProcedure;
import palamod.procedures.Legendarystonepower_add_potionProcedure;
import palamod.procedures.LegendarystoneglintconditionProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class LegendarystonepowerItem extends Item {
	public LegendarystonepowerItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return LegendarystoneglintconditionProcedure.execute(itemstack);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		Legendarystonepower_add_potionProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		LegendarystonestickProcedure.execute(entity, itemstack);
	}
}