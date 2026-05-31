package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.Permissions;

public class BalltopPreReloadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (hasEntityPermissionLevel(entity, 2)) {
			GenerateBalltopProcedure.execute(world);
			BalltopShowProcedure.execute(world, x, y, z, entity);
		}
	}

	private static boolean hasEntityPermissionLevel(Entity entity, int permissionLevel) {
		if (entity instanceof Player _player) {
			return switch (permissionLevel) {
				case 0 -> true;
				case 1 -> _player.permissions().hasPermission(Permissions.COMMANDS_MODERATOR);
				case 2 -> _player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
				case 3 -> _player.permissions().hasPermission(Permissions.COMMANDS_ADMIN);
				default -> _player.permissions().hasPermission(Permissions.COMMANDS_OWNER);
			};
		}
		return false;
	}
}