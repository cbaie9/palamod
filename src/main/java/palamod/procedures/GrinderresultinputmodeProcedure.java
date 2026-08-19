package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class GrinderresultinputmodeProcedure {
	public static double execute(ItemStack input_grinder) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = input_grinder.copy();
		if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_class_paladium")))) {
			output = 1;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_class_green_paladium")))) {
			output = 2;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_class_endium")))) {
			output = 3;
		}
		return output;
	}
}