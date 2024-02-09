package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder19Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Damage : Boost les degats des fastsword et des broadsword";
		}
		return "Damage : add more damage to the fastsword and the broadsword";
	}
}
