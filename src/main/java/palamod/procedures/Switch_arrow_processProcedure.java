package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class Switch_arrow_processProcedure {
	public static void execute(Entity immediatesourceentity, Entity sourceentity) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		double x_luncher = 0;
		double y_luncher = 0;
		double z_luncher = 0;
		double x_source = 0;
		double y_source = 0;
		double z_source = 0;
		x_luncher = immediatesourceentity.getX();
		y_luncher = immediatesourceentity.getY();
		z_luncher = immediatesourceentity.getZ();
		x_source = sourceentity.getX();
		y_source = sourceentity.getY();
		z_source = sourceentity.getZ();
		{
			Entity _ent = immediatesourceentity;
			_ent.teleportTo(x_source, y_source, z_source);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x_source, y_source, z_source, _ent.getYRot(), _ent.getXRot());
		}
		{
			Entity _ent = sourceentity;
			_ent.teleportTo(x_luncher, y_luncher, z_luncher);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x_luncher, y_luncher, z_luncher, _ent.getYRot(), _ent.getXRot());
		}
	}
}
