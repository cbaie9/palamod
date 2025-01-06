package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;

public class JobsgetlvlrequiredProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PalamodModVariables.PLAYER_VARIABLES).lvl_required;
	}
}
