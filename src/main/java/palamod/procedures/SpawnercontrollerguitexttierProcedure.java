package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class SpawnercontrollerguitexttierProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return Component.translatable("palamod.procedure.spawner_tier").getString() + "" + Math.round(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "spawner_tier"));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}