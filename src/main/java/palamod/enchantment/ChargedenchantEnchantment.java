
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class ChargedenchantEnchantment extends Enchantment {
	public ChargedenchantEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_INVISIBLE.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()),
				new ItemStack(PalamodModItems.LEGENDARY_STONE_JOBS.get()), new ItemStack(PalamodModItems.LEGENDARY_STONE_TELEPORTATION.get())).test(itemstack);
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
