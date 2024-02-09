package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder25Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Couche 1";
		}
		return "Layer 1";
	}
}
