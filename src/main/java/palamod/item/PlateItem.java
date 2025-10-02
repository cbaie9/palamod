package palamod.item;

import net.minecraft.world.item.Item;

public class PlateItem extends Item {
	public PlateItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}
}