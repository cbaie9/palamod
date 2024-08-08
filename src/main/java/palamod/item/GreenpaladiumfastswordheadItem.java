
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class GreenpaladiumfastswordheadItem extends Item {
	public GreenpaladiumfastswordheadItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}