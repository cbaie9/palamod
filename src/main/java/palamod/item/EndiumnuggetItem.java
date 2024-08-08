
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class EndiumnuggetItem extends Item {
	public EndiumnuggetItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}