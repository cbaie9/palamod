package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BalltopPreReloadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(2)) {
			GenerateBalltopProcedure.execute(world);
			BalltopShowProcedure.execute(world, x, y, z, entity);
		}
	}
}