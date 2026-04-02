package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetsellpricetextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("palamod.adminshop.getpricesell").getString() + " " + StockedbaseadminshopsellProcedure.execute(AdminshopgetitemProcedure.execute(entity));
	}
}