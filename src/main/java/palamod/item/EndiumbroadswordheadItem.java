package palamod.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumbroadswordheadItem extends Item {
	public EndiumbroadswordheadItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}