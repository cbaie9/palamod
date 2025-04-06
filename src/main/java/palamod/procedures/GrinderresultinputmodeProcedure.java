package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;

public class GrinderresultinputmodeProcedure {
	public static double execute(ItemStack input_grinder) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = input_grinder.copy();
		if (input.getItem() == PalamodModItems.PALADIUM_INGOT.get()) {
			output = 1;
		} else if (input.getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()) {
			output = 1;
		} else if (input.getItem() == PalamodModItems.PALADIUMRAWORE.get()) {
			output = 1;
		} else if (input.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()) {
			output = 2;
		} else if (input.getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()) {
			output = 2;
		} else if (input.getItem() == PalamodModItems.GREENPALADIUMRAWORE.get()) {
			output = 2;
		} else if (input.getItem() == PalamodModItems.ENDIUM_NUGGET.get()) {
			output = 3;
		} else if (input.getItem() == PalamodModItems.ENDIUM_INGOT.get()) {
			output = 3;
		} else if (input.getItem() == PalamodModBlocks.ENDIUM_BLOCK.get().asItem()) {
			output = 3;
		}
		return output;
	}
}
