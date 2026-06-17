package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;

public class GetImagePalahelpTreeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(PalamodModVariables.PLAYER_VARIABLES).id_img_palahelp_tree;
	}
}