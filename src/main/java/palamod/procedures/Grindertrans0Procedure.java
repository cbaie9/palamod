package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Grindertrans0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Inventaire";
		}
		return "Inventory";
	}
}
