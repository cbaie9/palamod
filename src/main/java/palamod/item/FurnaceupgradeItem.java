package palamod.item;

import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class FurnaceupgradeItem extends Item {
	public FurnaceupgradeItem(Item.Properties properties) {
		super(properties.stacksTo(16));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}
}