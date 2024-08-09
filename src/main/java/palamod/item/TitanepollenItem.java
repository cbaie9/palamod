
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TitanepollenItem extends Item {
	public TitanepollenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
