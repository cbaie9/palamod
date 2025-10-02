package palamod.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class FurnaceupgradeItem extends Item {
	public FurnaceupgradeItem() {
		super(new Item.Properties().stacksTo(16));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}