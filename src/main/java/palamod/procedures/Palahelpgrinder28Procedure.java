package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder28Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Construiser la couche 1 puis la couche 2 et enfin la couche 3";
		}
		return "Build the layer 1 then the 2 above it and layer 3 above it too";
	}
}
