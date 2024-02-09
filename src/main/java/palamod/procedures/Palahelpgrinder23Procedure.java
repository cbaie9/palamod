package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder23Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Il faudra crafter avec ceci: 1 grinder block, 20 grinder frame";
		}
		return "And with that you craft 20 grinder frame, 5grinder casing";
	}
}
