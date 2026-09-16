package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetDescriptionPalamachinePalahelpProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String output = "";
		String item_description = "";
		String translation_key_prefix = "";
		translation_key_prefix = "palamod.procedure.palamachine_";
		if (0 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 1 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "paladium_small_ring";
		} else if (2 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 3 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "paladium_medium_ring";
		} else if (4 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 5 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "paladium_big_ring";
		} else if (6 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 7 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "green_paladium_small_ring";
		} else if (8 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 9 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "green_paladium_medium_ring";
		} else if (10 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 11 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "green_paladium_big_ring";
		} else if (12 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 13 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "endium_small_ring";
		} else if (14 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 15 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "endium_medium_ring";
		} else if (16 == entity.getPersistentData().getDouble("mode_palamachine_craft") || 17 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			item_description = translation_key_prefix + "endium_big_ring";
		} else {
			item_description = translation_key_prefix + "out_of_bound";
		}
		output = (Component.translatable((translation_key_prefix + "description")).getString()).replace("%1", Component.translatable(item_description).getString());
		return output;
	}
}