package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetbuypricetextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("palamod.adminshop.getpricebuy").getString() + " " + StockedbaseadminshopbuyProcedure.execute(AdminshopgetitemProcedure.execute(entity));
	}
}