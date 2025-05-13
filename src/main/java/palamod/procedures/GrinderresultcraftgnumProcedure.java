package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class GrinderresultcraftgnumProcedure {
	public static double execute(ItemStack input_grinder_slot1, ItemStack input_grinder_slot2) {
		ItemStack input_item_slot1 = ItemStack.EMPTY;
		ItemStack input_item_slot2 = ItemStack.EMPTY;
		double output = 0;
		input_item_slot1 = input_grinder_slot1.copy();
		input_item_slot2 = input_grinder_slot2.copy();
		if (input_item_slot1.getItem() == PalamodModItems.AXE_PATERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 2;
		} else if (input_item_slot1.getItem() == PalamodModItems.PICKAXE_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 2;
		} else if (input_item_slot1.getItem() == PalamodModItems.BROADSWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 3;
		} else if (input_item_slot1.getItem() == PalamodModItems.BLOCK_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 9;
		} else if (input_item_slot1.getItem() == PalamodModItems.FASTSWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 3;
		} else if (input_item_slot1.getItem() == PalamodModItems.INGOT_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.HAMMER_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 6;
		} else if (input_item_slot1.getItem() == PalamodModItems.SWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.SHOVEL_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get()) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.HAMMER_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.AXE_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.PICKAXE_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.FASTSWORD_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.BROADSWORD_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.SHOVEL_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.SHOVEL_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK)) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.HEADENDIUMSWORD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.HEAD_ENDIUM_PICKAXE.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.HEAD_ENDIUM_AXE.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.ENDIUM_BROADSWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		} else if (input_item_slot1.getItem() == PalamodModItems.ENDIUM_HAMMER_HEAD.get() && input_item_slot1.getItem() == Items.STICK) {
			output = 1;
		}
		return output;
	}
}
