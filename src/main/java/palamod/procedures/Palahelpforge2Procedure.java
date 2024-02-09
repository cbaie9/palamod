package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpforge2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Pour cela comme un four inserer du carburant et votre ";
		}
		return "For using the forge insert fuel and your armor and wait";
	}
}
