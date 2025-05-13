package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class GrinderresultcraftresultProcedure {
	public static ItemStack execute(ItemStack input_grinder_slot1, ItemStack input_grinder_slot2, double gnum, double mode_grinder) {
		double gnum_local = 0;
		double mode = 0;
		ItemStack input_item_slot1 = ItemStack.EMPTY;
		ItemStack input_item_slot2 = ItemStack.EMPTY;
		ItemStack output = ItemStack.EMPTY;
		gnum_local = gnum;
		mode = mode_grinder;
		input_item_slot1 = input_grinder_slot1.copy();
		input_item_slot2 = input_grinder_slot2.copy();
		if (input_item_slot1.getItem() == PalamodModItems.AXE_PATERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 2) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.AXE_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.HEAD_ENDIUM_AXE.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.PICKAXE_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 2) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.PICKAXE_HEAD.get()).copy();
			} else if (gnum_local == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get()).copy();
			} else if (gnum_local == 3) {
				output = new ItemStack(PalamodModItems.HEAD_ENDIUM_PICKAXE.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.BROADSWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 3) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.BROADSWORD_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_BROADSWORD_HEAD.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.BLOCK_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 9) {
			if (mode == 1) {
				output = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.FASTSWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 3) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.FASTSWORD_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_FASTSWORD_HEAD.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.INGOT_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 1) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.HAMMER_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 6) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.HAMMER_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_HAMMER_HEAD.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.SWORD_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 1) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.SWORD_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.HEADENDIUMSWORD.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.SHOVEL_PATTERN.get() && input_item_slot2.getItem() == PalamodModItems.SOCKET_PATTERN.get() && gnum_local > 1) {
			if (mode == 1) {
				output = new ItemStack(PalamodModItems.SHOVEL_HEAD.get()).copy();
			} else if (mode == 2) {
				output = new ItemStack(PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get()).copy();
			} else if (mode == 3) {
				output = new ItemStack(PalamodModItems.ENDIUM_SHOVEL_HEAD.get()).copy();
			}
		} else if (input_item_slot1.getItem() == PalamodModItems.HAMMER_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.AXE_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.PALADIUM_AXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.PICKAXE_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.FASTSWORD_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.FASTSWORD_HEAD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.BROADSWORD_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.PALADIUMBROADSWORD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.SHOVEL_HEAD.get() && (input_item_slot1.getItem() == PalamodModItems.PALADIUM_STICK.get() || input_item_slot1.getItem() == Items.STICK && mode == 1 && gnum_local > 1)) {
			output = new ItemStack(PalamodModItems.PALADIUM_SHOVEL.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.GREENPALADIUMBROADSWORD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.PALADIUMGREENSWORD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.PALADIUMGREENPICKAXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.PALADIUMGREENAXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.PALADIUMGREENSHOVEL.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get() && input_item_slot1.getItem() == Items.STICK && mode == 2 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.HEADENDIUMSWORD.get() && input_item_slot1.getItem() == Items.STICK && mode == 3 && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.ENDIUM_SWORD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.HEAD_ENDIUM_PICKAXE.get() && input_item_slot1.getItem() == Items.STICK && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.ENDIUM_PICKAXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.HEAD_ENDIUM_AXE.get() && input_item_slot1.getItem() == Items.STICK && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.ENDIUM_AXE.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.ENDIUM_BROADSWORD_HEAD.get() && input_item_slot1.getItem() == Items.STICK && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.ENDIUMBROADSWORD.get()).copy();
		} else if (input_item_slot1.getItem() == PalamodModItems.ENDIUM_HAMMER_HEAD.get() && input_item_slot1.getItem() == Items.STICK && gnum_local > 1) {
			output = new ItemStack(PalamodModItems.ENDIUM_HAMMER.get()).copy();
		}
		return output;
	}
}
