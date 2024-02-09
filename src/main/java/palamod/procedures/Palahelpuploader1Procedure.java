package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpuploader1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "C'est comme vous faisez un achat \u00E0 l'adminshop mais";
		}
		return "It's like you buy something in the adminshop but";
	}
}
