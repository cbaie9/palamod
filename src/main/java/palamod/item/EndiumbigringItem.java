package palamod.item;

import palamod.procedures.RingprocessendiumProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class EndiumbigringItem extends Item {
	public EndiumbigringItem() {
		super(new Item.Properties().durability(6400).fireResistant());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingprocessendiumProcedure.execute(world, entity, itemstack);
	}
}