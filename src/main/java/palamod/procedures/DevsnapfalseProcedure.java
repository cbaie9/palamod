package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class DevsnapfalseProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getDisplayName().getString()).equals("cbaie9") || (entity.getDisplayName().getString()).equals("FufuBS1") || (entity.getDisplayName().getString()).equals("Dev")) {
			return false;
		}
		return true;
	}
}
