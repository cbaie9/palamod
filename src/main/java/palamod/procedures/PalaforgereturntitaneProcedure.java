package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;

public class PalaforgereturntitaneProcedure {
	public static double execute(ItemStack itemstack) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = itemstack.copy();
		if (input.getItem() == PalamodModItems.TITANE_SWORD.get() || input.getItem() == PalamodModItems.TITANE_SHOVEL.get() || input.getItem() == PalamodModItems.TITANE_STICK.get()) {
			output = 1;
		} else if (input.getItem() == PalamodModItems.TITANE_PICKAXE.get() || input.getItem() == PalamodModBlocks.TITANE_ORE.get().asItem() || input.getItem() == PalamodModBlocks.DEEPSLATE_TITANE_ORE.get().asItem()
				|| input.getItem() == PalamodModItems.TITANE_AXE.get()) {
			output = 2;
		} else if (input.getItem() == PalamodModItems.TITANEBROADSWORD.get() || input.getItem() == PalamodModItems.TITANEFASTSWORD.get() || input.getItem() == PalamodModBlocks.TITANE_SLAB.get().asItem()
				|| input.getItem() == PalamodModBlocks.TITANE_SPIKE.get().asItem() || input.getItem() == PalamodModItems.TITANE_ARMOR_BOOTS.get()) {
			output = 3;
		} else if (input.getItem() == PalamodModItems.TITANE_ARMOR_HELMET.get()) {
			output = 4;
		} else if (input.getItem() == PalamodModItems.TITANE_HAMMER.get() || input.getItem() == PalamodModBlocks.TITANE_STAIRS.get().asItem()) {
			output = 5;
		} else if (input.getItem() == PalamodModItems.TITANE_ARMOR_LEGGINGS.get()) {
			output = 6;
		} else if (input.getItem() == PalamodModItems.TITANE_ARMOR_CHESTPLATE.get()) {
			output = 7;
		} else if (input.getItem() == PalamodModItems.COMPRESSED_TITANE.get()) {
			output = 64;
		}
		return output;
	}
}
