package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LightningpotionItem extends Item {
	public LightningpotionItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}
}