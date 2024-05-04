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
			for (int index0 = 0; index0 < 320; index0++) {
				if ((world.getBlockState(BlockPos.containing(x, y_pos - add_num, z))).is(BlockTags.create(new ResourceLocation("palamod:elevator")))) {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + 0.5), (y_pos - add_num + 1), (z + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + 0.5), (y_pos - add_num + 1), (z + 0.5), _ent.getYRot(), _ent.getXRot());
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
			for (int index1 = 0; index1 < 320; index1++) {
				if ((world.getBlockState(BlockPos.containing(x, y_pos + add_num, z))).is(BlockTags.create(new ResourceLocation("palamod:elevator")))) {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + 0.5), (y_pos + add_num + 1), (z + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + 0.5), (y_pos + add_num + 1), (z + 0.5), _ent.getYRot(), _ent.getXRot());
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
