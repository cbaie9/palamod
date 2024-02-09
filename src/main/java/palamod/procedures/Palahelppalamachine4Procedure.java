package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelppalamachine4Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Voir la page des baton pour les crafts";
		}
		return "See Sticks page for crafts";
	}
}
