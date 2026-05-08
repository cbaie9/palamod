package palamod.item;

import palamod.procedures.KeytooltipProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class EndiumPortalKeyItem extends Item {
	public EndiumPortalKeyItem() {
		super(new Item.Properties());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		KeytooltipProcedure.execute(itemstack);
	}
}