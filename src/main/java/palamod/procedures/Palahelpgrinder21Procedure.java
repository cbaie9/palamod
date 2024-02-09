package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder21Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Comment crafter le grinder";
		}
		return "How to craft the grinder";
	}
}
