
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class SpeedmodifierItem extends Item {
	public SpeedmodifierItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}