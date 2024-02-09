package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelppalamachine3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Ceci est l'interface de la palamachine";
		}
		return "This is the gui of the palamachine";
	}
}
