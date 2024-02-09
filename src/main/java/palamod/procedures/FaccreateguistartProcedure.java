package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class FaccreateguistartProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.get("text:faction_name_input_bow") instanceof EditBox _tf)
			_tf.setValue((entity.getPersistentData().getString("temp_fact_name")));
		PalamodModVariables.faction_create_ing = "remaining to insert : 100";
	}
}
