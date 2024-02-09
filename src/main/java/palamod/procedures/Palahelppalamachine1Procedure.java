package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelppalamachine1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "des batons qui vous permeteront d'avoir des";
		}
		return "some sticks who give you specials effets";
	}
}
