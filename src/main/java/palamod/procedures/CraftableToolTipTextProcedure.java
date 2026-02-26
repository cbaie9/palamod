package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class CraftableToolTipTextProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack item = ItemStack.EMPTY;
		String textreturn = "";
		textreturn = "";
		item = itemstack.copy();
		textreturn = JobCraftRestrictionManagerProcedure.getRequirementText(item);
		if (!(" ").equals(textreturn)) {
			return Component.translatable("palamod.item.craft_via_jobs").getString() + " " + textreturn;
		}
		return textreturn;
	}
}