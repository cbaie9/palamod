
package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DiamondparticleItem extends Item {
	public DiamondparticleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
