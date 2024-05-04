package palamod.procedures;

import net.minecraft.world.item.ItemStack;

public class GetjobsfrombottleProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("jobs_type");
	}
}
