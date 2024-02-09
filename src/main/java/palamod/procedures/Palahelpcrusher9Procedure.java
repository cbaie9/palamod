package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher9Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Pour finaliser la creation du minerais appuyer le bouton \"start fusion\"";
		}
		return "To finish the creation of the ingot press the \"start fusion\" button";
	}
}
