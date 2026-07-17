package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.io.File;

public class GetdirectoryjobsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + GetjobsfileProcedure.execute(entity))), false);
	}
}