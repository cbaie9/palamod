package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder20Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Knockback : ajoute un effet de pouss\u00E9 \u00E0 chaque coup ->";
		}
		return "Damage : add more knockback effet on each hit ->";
	}
}
