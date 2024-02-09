package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder12Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "et la broadsword. Vous pouvez y ajouter";
		}
		return "and the broadsword. You can add upgrades";
	}
}
