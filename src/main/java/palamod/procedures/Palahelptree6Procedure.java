package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Ostrya : Permet de crafter le portail";
		}
		return "Ostrya : Allow to craft the Endium";
	}
}
