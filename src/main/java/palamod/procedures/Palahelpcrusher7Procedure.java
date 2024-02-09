package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher7Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "l'amethyste, le charbon d'amethyste pour le titane";
		}
		return "amethyst mixed coal for titane, titane mixed";
	}
}
