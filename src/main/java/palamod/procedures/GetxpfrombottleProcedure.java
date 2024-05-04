package palamod.procedures;

import net.minecraft.world.item.ItemStack;

public class GetxpfrombottleProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("xp_jobs");
	}
}
