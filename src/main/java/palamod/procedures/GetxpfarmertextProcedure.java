package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetxpfarmertextProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		return GetxpfarmerProcedure.execute(world, x, y, z, entity) + " " + Component.translatable("palamod.procedure.get_nextlvl").getString();
	}
}
