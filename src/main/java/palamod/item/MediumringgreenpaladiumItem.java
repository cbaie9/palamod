package palamod.item;

import palamod.procedures.RingprocessgreenpaladiumProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class MediumringgreenpaladiumItem extends Item {
	public MediumringgreenpaladiumItem() {
		super(new Item.Properties().durability(1000));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingprocessgreenpaladiumProcedure.execute(world, entity, itemstack);
	}
}