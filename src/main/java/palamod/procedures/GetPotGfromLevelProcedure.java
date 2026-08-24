package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;

public class GetPotGfromLevelProcedure {
	public static ItemStack execute(double level_potg) {
		ItemStack output = ItemStack.EMPTY;
		double level_input = 0;
		level_input = level_potg;
		if (level_input == 1) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV1.get()).copy();
		} else if (level_input == 2) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV2.get()).copy();
		} else if (level_input == 3) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV3.get()).copy();
		} else if (level_input == 4) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV4.get()).copy();
		} else if (level_input == 5) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV5.get()).copy();
		} else if (level_input == 6) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV6.get()).copy();
		} else if (level_input == 7) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV7.get()).copy();
		} else if (level_input == 8) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV8.get()).copy();
		} else if (level_input == 9) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV9.get()).copy();
		} else if (level_input == 10) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV10.get()).copy();
		} else if (level_input == 11) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV11.get()).copy();
		} else if (level_input == 12) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV12.get()).copy();
		} else if (level_input == 13) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV13.get()).copy();
		} else if (level_input == 14) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV14.get()).copy();
		} else if (level_input == 15) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV15.get()).copy();
		} else if (level_input == 16) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV16.get()).copy();
		} else if (level_input == 17) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV18.get()).copy();
		} else if (level_input == 18) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV18.get()).copy();
		} else if (level_input == 19) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV19.get()).copy();
		} else if (level_input == 20) {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV20.get()).copy();
		} else {
			output = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV1.get()).copy();
		}
		return output;
	}
}