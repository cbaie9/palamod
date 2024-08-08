
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class ShovelheadItem extends Item {
	public ShovelheadItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}