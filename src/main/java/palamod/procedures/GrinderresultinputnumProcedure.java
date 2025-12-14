package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class GrinderresultinputnumProcedure {
	public static double execute(ItemStack input_grinder) {
		ItemStack input = ItemStack.EMPTY;
		double output = 0;
		input = input_grinder.copy();
		if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_armor_chestplate")))) {
			output = 8;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_armor_helmet")))) {
			output = 5;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_armor_boots")))) {
			output = 4;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_armor_legging")))) {
			output = 7;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_ingot")))) {
			output = 1;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_tool_cost2")))) {
			output = 2;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_tool_cost3")))) {
			output = 3;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_tool_cost6")))) {
			output = 6;
		} else if (input.is(ItemTags.create(ResourceLocation.parse("palamod:grinder_type_block")))) {
			output = 9;
		} else if (input.getItem() == PalamodModBlocks.ENDIUM_BLOCK.get().asItem()) {
			output = 81;
		} else if (input.getItem() == PalamodModItems.ENDIUM_SWORD.get() || input.getItem() == PalamodModItems.ENDIUM_HOE.get() || input.getItem() == PalamodModItems.HEADENDIUMSWORD.get()) {
			output = 18;
		} else if (input.getItem() == PalamodModItems.ENDIUM_PICKAXE.get() || input.getItem() == PalamodModItems.ENDIUM_AXE.get() || input.getItem() == PalamodModItems.HEAD_ENDIUM_PICKAXE.get()
				|| input.getItem() == PalamodModItems.HEAD_ENDIUM_AXE.get()) {
			output = 27;
		}
		return output;
	}
}