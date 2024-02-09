package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher8Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "le charbon de titane pour le paladium et celui de paladium pour l'endium";
		}
		return "coal for paladium and paladium mixed coal for endium";
	}
}
