
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PlateItem extends Item {
	public PlateItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
