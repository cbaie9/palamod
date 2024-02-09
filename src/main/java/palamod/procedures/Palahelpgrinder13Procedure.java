package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder13Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "des upgrades qui ameliorent les outils :";
		}
		return "that add abilities to the tools :";
	}
}
