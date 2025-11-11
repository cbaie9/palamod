package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Spawnpanel_get_spawnProcedure {
	public static String execute(LevelAccessor world) {
		return "X: " + getBlockNBTNumber(world, new BlockPos(0, 10, 0), "spawn_x") + "Y: " + getBlockNBTNumber(world, new BlockPos(0, 10, 0), "spawn_y") + "Z: " + getBlockNBTNumber(world, new BlockPos(0, 10, 0), "spawn_z");
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}