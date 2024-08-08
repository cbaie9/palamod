
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class HeadendiumaxeItem extends Item {
	public HeadendiumaxeItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}