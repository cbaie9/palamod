package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetxpminertextProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return GetxpminerProcedure.execute(world, entity) + " " + Component.translatable("palamod.procedure.get_nextlvl").getString();
	}
}