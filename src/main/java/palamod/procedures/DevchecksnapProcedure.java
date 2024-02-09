package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class DevchecksnapProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getDisplayName().getString()).equals("cbaie9") || (entity.getDisplayName().getString()).equals("cbaie9") || (entity.getDisplayName().getString()).equals("FufuBS1")) {
			return true;
		}
		return false;
	}
}
