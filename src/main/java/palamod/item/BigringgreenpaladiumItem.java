package palamod.item;

import palamod.procedures.RingprocessgreenpaladiumProcedure;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class BigringgreenpaladiumItem extends Item {
	public BigringgreenpaladiumItem(Item.Properties properties) {
		super(properties.durability(3200));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		RingprocessgreenpaladiumProcedure.execute(world, entity, itemstack);
	}
}