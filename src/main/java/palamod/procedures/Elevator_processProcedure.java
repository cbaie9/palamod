package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class Elevator_processProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double add_num = 0;
		double y_pos = 0;
		if (entity.isShiftKeyDown()) {
			entity.getPersistentData().putBoolean("player.jumping", false);
			y_pos = y;
			add_num = 1;
			for (int index260 = 0; index260 < 320; index260++) {
				if ((world.getBlockState(BlockPos.containing(x, y_pos - add_num, z))).is(BlockTags.create(ResourceLocation.parse("palamod:elevator")))) {
					{
						Entity _ent = entity;
						double _tx = (x + 0.5);
						double _ty = (y_pos - add_num + 1);
						double _tz = (z + 0.5);
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					break;
				} else {
					add_num = add_num + 1;
					continue;
				}
			}
		} else if (entity.getPersistentData().getBoolean("player.jumping")) {
			entity.getPersistentData().putBoolean("player.jumping", false);
			y_pos = y;
			add_num = 1;
			for (int index261 = 0; index261 < 320; index261++) {
				if ((world.getBlockState(BlockPos.containing(x, y_pos + add_num, z))).is(BlockTags.create(ResourceLocation.parse("palamod:elevator")))) {
					{
						Entity _ent = entity;
						double _tx = (x + 0.5);
						double _ty = (y_pos + add_num + 1);
						double _tz = (z + 0.5);
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					break;
				} else {
					add_num = add_num + 1;
					continue;
				}
			}
		}
	}
}