package palamod.item;

import palamod.procedures.KeytooltipProcedure;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public class EndiumPortalKeyItem extends Item {
	public EndiumPortalKeyItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		KeytooltipProcedure.execute(itemstack);
	}
}