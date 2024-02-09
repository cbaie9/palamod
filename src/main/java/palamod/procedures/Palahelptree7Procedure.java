package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree7Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "en Endium";
		}
		return "portal";
	}
}
