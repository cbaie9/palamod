package palamod.procedures;

import palamod.init.PalamodModEnchantments;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class PaladiumhammerToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("hammer_smelt") == 1) {
			itemstack.enchant(PalamodModEnchantments.SMELT.get(), 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed") == 1) {
			itemstack.enchant(PalamodModEnchantments.SPEED.get(), 1);
			itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed") == 2) {
			itemstack.enchant(PalamodModEnchantments.SPEED.get(), 2);
			itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed") == 3) {
			itemstack.enchant(PalamodModEnchantments.SPEED.get(), 3);
			itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune") == 1) {
			itemstack.enchant(PalamodModEnchantments.HAMMER_FORTUNE.get(), 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune") == 2) {
			itemstack.enchant(PalamodModEnchantments.HAMMER_FORTUNE.get(), 2);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune") == 3) {
			itemstack.enchant(PalamodModEnchantments.HAMMER_FORTUNE.get(), 3);
		}
	}
}
