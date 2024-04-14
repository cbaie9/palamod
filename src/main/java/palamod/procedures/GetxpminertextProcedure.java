package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetxpminertextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return GetxpminerProcedure.execute(entity) + " " + Component.translatable("palamod.procedure.get_nextlvl").getString();
	}
}
