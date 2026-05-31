package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MoneyitemItem extends Item {
	public MoneyitemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}
}