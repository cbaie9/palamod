package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder24Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Puis il faut build un structure les images suivantes";
		}
		return "After you will build a structure with the pictures ";
	}
}
