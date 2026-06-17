package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;

public class SetImageErableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.id_img_palahelp_tree = 2;
			_vars.markSyncDirty();
		}
	}
}