package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndiumnuggetItem extends Item {
	public EndiumnuggetItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).fireResistant());
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}
}