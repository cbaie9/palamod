package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class GetTextItemName2PalahelpXpGainProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return GetTextNameGainJobsPalahelpProcedure.execute(entity, 2);
	}
}