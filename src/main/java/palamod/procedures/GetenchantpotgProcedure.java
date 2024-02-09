package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class GetenchantpotgProcedure {
	public static void execute(ItemStack itemstack) {
		if (PalamodModItems.PICKAXEOFTHEGODSLV_20.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_19.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_18.get() == itemstack.getItem()
				|| PalamodModItems.PICKAXEOFTHEGODSLV_17.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_16.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_15.get() == itemstack.getItem()
				|| PalamodModItems.PICKAXEOFTHEGODSLV_14.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_13.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) != 0) {
				if (5 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
							_enchantments.remove(Enchantments.BLOCK_EFFICIENCY);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_12.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) != 0) {
				if (4 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
							_enchantments.remove(Enchantments.BLOCK_EFFICIENCY);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 4);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 4);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_11.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) != 0) {
				if (3 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
							_enchantments.remove(Enchantments.BLOCK_EFFICIENCY);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_10.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) != 0) {
				if (2 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
							_enchantments.remove(Enchantments.BLOCK_EFFICIENCY);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_9.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) != 0) {
				if (1 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
							_enchantments.remove(Enchantments.BLOCK_EFFICIENCY);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 1);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 1);
			}
		}
		if (PalamodModItems.PICKAXEOFTHEGODSLV_14.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) != 0) {
				if (1 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
							_enchantments.remove(Enchantments.BLOCK_FORTUNE);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_FORTUNE, 1);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_FORTUNE, 1);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_15.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) != 0) {
				if (2 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
							_enchantments.remove(Enchantments.BLOCK_FORTUNE);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_FORTUNE, 2);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_FORTUNE, 2);
			}
		} else if (PalamodModItems.PICKAXEOFTHEGODSLV_16.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_17.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_18.get() == itemstack.getItem()
				|| PalamodModItems.PICKAXEOFTHEGODSLV_19.get() == itemstack.getItem() || PalamodModItems.PICKAXEOFTHEGODSLV_20.get() == itemstack.getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) != 0) {
				if (3 != itemstack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE)) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
							_enchantments.remove(Enchantments.BLOCK_FORTUNE);
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
				}
			} else {
				itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
			}
		}
	}
}
