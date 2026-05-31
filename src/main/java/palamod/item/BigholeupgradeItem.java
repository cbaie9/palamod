package palamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class BigholeupgradeItem extends Item {
	public BigholeupgradeItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}
}