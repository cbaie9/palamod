package palamod.procedures;

import palamod.init.PalamodModEnchantments;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Hammer1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.SMELT.get(), itemstack) != 0 && EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get(), itemstack) != 0) {
			if (itemstack.getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
				HamsfProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
				Hamsf2Procedure.execute(world, x, y, z, entity);
			} else if (itemstack.getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
				Hamsf3Procedure.execute(world, x, y, z, entity);
			}
		} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.SMELT.get(), itemstack) != 0) {
			HammersmeltProcedure.execute(world, x, y, z, entity);
		} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get(), itemstack) != 0) {
			FortunehammerProcedure.execute(world, x, y, z, entity);
		} else {
			HammernormalProcedure.execute(world, x, y, z, entity);
		}
	}
}
