package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "en amethyste";
		}
		return "portal";
	}
}
