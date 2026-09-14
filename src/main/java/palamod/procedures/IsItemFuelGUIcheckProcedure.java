package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class IsItemFuelGUIcheckProcedure {
	public static boolean execute(LevelAccessor world, ItemStack itemstack) {
		return !(0 < itemstack.getBurnTime(null));
	}
}