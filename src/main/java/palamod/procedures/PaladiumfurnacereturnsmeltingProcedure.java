package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PaladiumfurnacereturnsmeltingProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "smelting : " + getBlockNBTLogic(world, BlockPos.containing(x, y, z), "smelting");
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}