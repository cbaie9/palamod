
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CompressedendiumItem extends Item {
	public CompressedendiumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
