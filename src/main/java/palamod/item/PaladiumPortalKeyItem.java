package palamod.item;

import palamod.procedures.KeytooltipProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class PaladiumPortalKeyItem extends Item {
	public PaladiumPortalKeyItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		KeytooltipProcedure.execute(itemstack);
	}
}