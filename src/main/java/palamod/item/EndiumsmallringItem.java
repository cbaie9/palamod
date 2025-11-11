package palamod.item;

import palamod.procedures.RingprocessendiumProcedure;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class EndiumsmallringItem extends Item {
	public EndiumsmallringItem(Item.Properties properties) {
		super(properties.durability(800).fireResistant());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		RingprocessendiumProcedure.execute(world, entity, itemstack);
	}
}