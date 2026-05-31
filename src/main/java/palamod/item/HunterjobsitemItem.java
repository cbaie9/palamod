package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HunterjobsitemItem extends Item {
	public HunterjobsitemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1));
	}
}