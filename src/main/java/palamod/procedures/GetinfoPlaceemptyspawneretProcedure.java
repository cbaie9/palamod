package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetinfoPlaceemptyspawneretProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PalamodMod.LOGGER.info(("empty spawner get info : " + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul")));
		PalamodMod.LOGGER.info(("empty spawner get info : " + getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type")));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}