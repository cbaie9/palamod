package palamod.item;

import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumhammerheadItem extends Item {
	public EndiumhammerheadItem(Item.Properties properties) {
		super(properties.stacksTo(1).fireResistant());
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}
}