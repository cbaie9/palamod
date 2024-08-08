
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class GoldparticleItem extends Item {
	public GoldparticleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}