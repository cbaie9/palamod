package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetxphuntertextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return GetxphunterProcedure.execute(entity) + " " + Component.translatable("palamod.procedure.get_nextlvl").getString();
	}
}