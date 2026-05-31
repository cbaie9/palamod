package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.Identifier;

public class CobblebreakerInventorySlotAutomationPlaceConditionProcedure {
	public static boolean execute(ItemStack itemstack, double index) {
		boolean output = false;
		return !(8 == index) || 8 == index && itemstack.is(ItemTags.create(Identifier.parse("palamod:cobblebreaker_upgrades")));
	}
}