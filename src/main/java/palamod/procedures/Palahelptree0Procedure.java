package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Erable : Permet de crafter le portail";
		}
		return "Erable : Allow to craft the Paladium";
	}
}
