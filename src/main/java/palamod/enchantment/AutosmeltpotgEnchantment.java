
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class AutosmeltpotgEnchantment extends Enchantment {
	public AutosmeltpotgEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.VANISHABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get()), new ItemStack(PalamodModItems.CREATIVEPOTG.get())).test(itemstack);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
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
