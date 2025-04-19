
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CustomairItem extends Item {
	public CustomairItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
