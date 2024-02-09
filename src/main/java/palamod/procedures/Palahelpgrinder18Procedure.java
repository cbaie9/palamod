package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder18Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Flame : Aura de feu pour les fastsword et les broadsword";
		}
		return "Flame : Fire aspect for the fastsword and the broadsword";
	}
}
