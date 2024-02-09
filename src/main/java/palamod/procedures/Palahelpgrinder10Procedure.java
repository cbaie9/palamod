package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder10Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Le grinder est une machine permettant de";
		}
		return "The Grinder is a machine that can make";
	}
}
