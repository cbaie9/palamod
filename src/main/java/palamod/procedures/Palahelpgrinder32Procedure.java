package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder32Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "et 5 grinder casing ";
		}
		return "and a grinder block";
	}
}
