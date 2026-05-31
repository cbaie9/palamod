package palamod.item;

import palamod.procedures.UnclaimfinderprocessProcedure;
import palamod.procedures.LegendarystonestickProcedure;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class UnclaimfinderblueItem extends Item {
	public UnclaimfinderblueItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).durability(8400));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			UnclaimfinderprocessProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		LegendarystonestickProcedure.execute(entity, itemstack);
	}
}