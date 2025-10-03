package palamod.item;

import palamod.procedures.UnclaimfinderprocessProcedure;
import palamod.procedures.LegendarystonestickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class UnclaimfinderItem extends Item {
	public UnclaimfinderItem() {
		super(new Item.Properties().durability(10000).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			UnclaimfinderprocessProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		LegendarystonestickProcedure.execute(entity, itemstack);
	}
}