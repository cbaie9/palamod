
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MoneyitemItem extends Item {
	public MoneyitemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
