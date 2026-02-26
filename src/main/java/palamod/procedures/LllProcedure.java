package palamod.procedures;

import net.minecraft.world.item.ItemStack;

public class LllProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack pop = ItemStack.EMPTY;
		return "pop" + itemstack;
	}
}