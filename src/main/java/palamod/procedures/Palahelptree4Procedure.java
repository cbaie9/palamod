package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelptree4Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Judeecercis : Permet de crafter le portail";
		}
		return "Judeecercis : Allow to craft the Titane";
	}
}
