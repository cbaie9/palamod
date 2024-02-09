package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "des fruits et du carburant pour obtenir";
		}
		return "and fruits to obtain modded ingots like";
	}
}
