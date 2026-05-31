package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.Identifier;

public class GetcobblebreakableProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(Identifier.parse("palamod:cobblebreakable"))) || itemstack.getItem() == PalamodModItems.MINAGE_VOIDSTONE.get()) {
			return true;
		}
		return false;
	}
}