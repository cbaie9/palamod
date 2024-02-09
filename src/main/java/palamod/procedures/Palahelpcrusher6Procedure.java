package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "carburant comme le chabon d'or infusee pour";
		}
		return "fuel like gold mixed coal to create amethsyt,";
	}
}
