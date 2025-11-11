package palamod.item;

import net.minecraft.world.item.Item;

public class ExtractorItem extends Item {
	public ExtractorItem(Item.Properties properties) {
		super(properties.durability(145));
	}
}