package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetsellpricetextProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("palamod.adminshop.getpricesell").getString() + " " + StockedbaseadminshopsellProcedure.execute(AdminshopgetitemProcedure.execute(world, entity));
	}
}