package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class NewadminshopguigettitleProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return AdminshopgetitemProcedure.execute(entity).getDisplayName().getString();
	}
}