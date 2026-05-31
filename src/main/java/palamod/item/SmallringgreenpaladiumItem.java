package palamod.item;

import palamod.procedures.RingprocessgreenpaladiumProcedure;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class SmallringgreenpaladiumItem extends Item {
	public SmallringgreenpaladiumItem(Item.Properties properties) {
		super(properties.durability(400));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		RingprocessgreenpaladiumProcedure.execute(world, entity, itemstack);
	}
}