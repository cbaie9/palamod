package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpuploader0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "L'uploader est une machine permattant de \"t\u00E9l\u00E9charger\"";
		}
		return "The uploader is a machine who allow you to \"download\"";
	}
}
