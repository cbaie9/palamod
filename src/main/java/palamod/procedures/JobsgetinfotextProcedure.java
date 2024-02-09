package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;

public class JobsgetinfotextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PalamodModVariables.PlayerVariables())).jobs_get_text;
	}
}
