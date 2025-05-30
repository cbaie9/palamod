
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ExtractorItem extends Item {
	public ExtractorItem() {
		super(new Item.Properties().durability(145).rarity(Rarity.COMMON));
	}
}
