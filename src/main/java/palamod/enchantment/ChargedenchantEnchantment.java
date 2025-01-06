
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class ChargedenchantEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("palamod_chargedenchant",
			item -> Ingredient.of(new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_INVISIBLE.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()),
					new ItemStack(PalamodModItems.LEGENDARY_STONE_JOBS.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_TELEPORTATION.get())).test(new ItemStack(item)));

	public ChargedenchantEnchantment() {
		super(Enchantment.Rarity.COMMON, ENCHANTMENT_CATEGORY, EquipmentSlot.values());
	}

	@Override
	public int getMinCost(int level) {
		return 1 + level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return 6 + level * 10;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
