package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EndiumheartItem extends Item {
	public EndiumheartItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}
}