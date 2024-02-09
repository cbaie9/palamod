
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class HammerforturneEnchantment extends Enchantment {
	public HammerforturneEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()), new ItemStack(PalamodModItems.ENDIUM_HAMMER.get()), new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER.get()), new ItemStack(PalamodModItems.CREATIVE_HAMMER.get()))
				.test(itemstack);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
}
