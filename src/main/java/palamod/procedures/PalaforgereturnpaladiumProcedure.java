package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;

public class PalaforgereturnpaladiumProcedure {
	public static double execute(ItemStack itemstack) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = itemstack.copy();
		if (input.getItem() == PalamodModItems.PALADIUM_SWORD.get() || input.getItem() == PalamodModItems.PALADIUM_SHOVEL.get()) {
			output = 1;
		} else if (input.getItem() == PalamodModItems.PALADIUM_PICKAXE.get() || input.getItem() == PalamodModBlocks.PALADIUM_ORE.get().asItem() || input.getItem() == PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get().asItem()
				|| input.getItem() == PalamodModItems.PALADIUM_AXE.get()) {
			output = 2;
		} else if (input.getItem() == PalamodModItems.PALADIUMBROADSWORD.get() || input.getItem() == PalamodModItems.PALADIUMFASTSWORD.get() || input.getItem() == PalamodModBlocks.PALADIUM_SLAB.get().asItem()
				|| input.getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem() || input.getItem() == PalamodModItems.PALADIUM_ARMOR_BOOTS.get()) {
			output = 3;
		} else if (input.getItem() == PalamodModItems.PALADIUM_ARMOR_HELMET.get()) {
			output = 4;
		} else if (input.getItem() == PalamodModItems.PALADIUM_HAMMER.get() || input.getItem() == PalamodModBlocks.PALADIUM_STAIRS.get().asItem()) {
			output = 5;
		} else if (input.getItem() == PalamodModItems.PALADIUM_ARMOR_LEGGINGS.get()) {
			output = 6;
		} else if (input.getItem() == PalamodModItems.PALADIUM_ARMOR_CHESTPLATE.get()) {
			output = 7;
		} else if (input.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()) {
			output = 64;
		}
		return output;
	}
}
