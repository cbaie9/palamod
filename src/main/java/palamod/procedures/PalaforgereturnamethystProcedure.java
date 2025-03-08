package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;

public class PalaforgereturnamethystProcedure {
	public static double execute(ItemStack itemstack) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = itemstack.copy();
		if (input.getItem() == PalamodModItems.AMETHYST_SWORD.get() || input.getItem() == PalamodModItems.AMETHYST_SHOVEL.get() || input.getItem() == PalamodModItems.AMETHYST_STICK.get()) {
			output = 1;
		} else if (input.getItem() == PalamodModItems.AMETHYST_PICKAXE.get() || input.getItem() == PalamodModBlocks.AMETHYST_ORE.get().asItem() || input.getItem() == PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get().asItem()
				|| input.getItem() == PalamodModItems.AMETHYST_AXE.get()) {
			output = 2;
		} else if (input.getItem() == PalamodModItems.AMETHYST_BROADSWORD.get() || input.getItem() == PalamodModItems.AMETHYST_FASTSWORD.get() || input.getItem() == PalamodModBlocks.AMETHYST_SLAB.get().asItem()
				|| input.getItem() == PalamodModBlocks.AMETHYST_SPIKE.get().asItem() || input.getItem() == PalamodModItems.AMETHYST_ARMOR_BOOTS.get()) {
			output = 3;
		} else if (input.getItem() == PalamodModItems.AMETHYST_ARMOR_HELMET.get()) {
			output = 4;
		} else if (input.getItem() == PalamodModItems.AMETHYST_HAMMER.get() || input.getItem() == PalamodModBlocks.AMETHYST_STAIRS.get().asItem()) {
			output = 5;
		} else if (input.getItem() == PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get()) {
			output = 6;
		} else if (input.getItem() == PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get()) {
			output = 7;
		} else if (input.getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()) {
			output = 64;
		}
		return output;
	}
}
