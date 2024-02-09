package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder26Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Couche 2";
		}
		return "Layer 2";
	}
}
