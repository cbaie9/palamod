package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class Uploader_gamerule_check_disable_moneyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.DISABLEMONEYGAMERULE.get())) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.gamerule_disable_").getString());
		}
	}
}