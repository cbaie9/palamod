
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ChestexplorerItem extends Item {
	public ChestexplorerItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
