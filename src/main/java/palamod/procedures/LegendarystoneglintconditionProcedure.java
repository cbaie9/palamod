package palamod.procedures;

import net.minecraft.world.item.ItemStack;

public class LegendarystoneglintconditionProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cooldown") == 0) {
			return true;
		}
		return false;
	}
}
