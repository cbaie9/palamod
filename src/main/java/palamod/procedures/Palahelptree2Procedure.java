package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Jacaranda : Permet de crafter le portail";
		}
		return "Jacaranda : Allow to craft the Amethyst";
	}
}
