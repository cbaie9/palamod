package palamod.item;

import palamod.procedures.RingprocessProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class SmallringItem extends Item {
	public SmallringItem() {
		super(new Item.Properties().durability(400));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingprocessProcedure.execute(world, entity, itemstack);
	}
}