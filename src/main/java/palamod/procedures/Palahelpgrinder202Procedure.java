package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder202Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "broadsword + fastsword";
		}
		return "broadsword + fastsword";
	}
}
