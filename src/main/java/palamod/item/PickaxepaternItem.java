
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class PickaxepaternItem extends Item {
	public PickaxepaternItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}