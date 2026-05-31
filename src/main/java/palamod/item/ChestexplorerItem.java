package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ChestexplorerItem extends Item {
	public ChestexplorerItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}
}