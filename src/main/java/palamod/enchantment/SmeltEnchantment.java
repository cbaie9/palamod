
package palamod.enchantment;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class SmeltEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("palamod_smelt",
			item -> Ingredient
					.of(new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()), new ItemStack(PalamodModItems.CREATIVE_HAMMER.get()), new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER.get()), new ItemStack(PalamodModItems.ENDIUM_HAMMER.get()))
					.test(new ItemStack(item)));

	public SmeltEnchantment() {
		super(Enchantment.Rarity.COMMON, ENCHANTMENT_CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMinCost(int level) {
		return 1 + level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return 6 + level * 10;
	}
}
