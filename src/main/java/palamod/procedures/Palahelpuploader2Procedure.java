package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpuploader2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "vous pouvez l'automatisez avec votre compte bancaire palamod";
		}
		return "you can automatise it with your palamod bank account";
	}
}
