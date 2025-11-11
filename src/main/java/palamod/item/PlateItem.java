package palamod.item;

import net.minecraft.world.item.Item;

public class PlateItem extends Item {
	public PlateItem(Item.Properties properties) {
		super(properties.stacksTo(1).fireResistant().enchantable(1));
	}
}