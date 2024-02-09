package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpforge1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "pour les transformer en lingot pour les re-utiliser";
		}
		return "to transform into ingot for re-using them";
	}
}
