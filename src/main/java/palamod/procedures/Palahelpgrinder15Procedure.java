package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder15Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "minerais min\u00E9s -> hammer";
		}
		return "mined ores -> hammer";
	}
}
