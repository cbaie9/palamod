package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.Entity;

public class JobscraftsetupProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Click on a item !!";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_get_text = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = " ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_get_text2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = " ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_get_text3 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = " ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_get_text4 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = " ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_get_text5 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "Durability : ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.jobs_durability = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "Lvl required : ";
			entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lvl_required = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
