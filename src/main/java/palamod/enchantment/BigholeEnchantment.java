
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class BigholeEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("palamod_bighole",
			item -> Ingredient.of(new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get()),
					new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get()), new ItemStack(PalamodModItems.CREATIVEPOTG.get())).test(new ItemStack(item)));

	public BigholeEnchantment() {
		super(Enchantment.Rarity.VERY_RARE, ENCHANTMENT_CATEGORY, EquipmentSlot.values());
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
	public int getMaxLevel() {
		return 2;
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
