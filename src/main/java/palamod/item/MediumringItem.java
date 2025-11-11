package palamod.item;

import palamod.procedures.RingprocessProcedure;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class MediumringItem extends Item {
	public MediumringItem(Item.Properties properties) {
		super(properties.durability(1000));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		RingprocessProcedure.execute(world, entity, itemstack);
	}
}