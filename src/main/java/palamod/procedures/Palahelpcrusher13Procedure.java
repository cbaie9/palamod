package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher13Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "que le nugget n'apparaise pas [ 128 \u00E9tant 100% d'apparition ]";
		}
		return "is a chance the nugget don't appear [ 128 is 100% to appear ]";
	}
}
