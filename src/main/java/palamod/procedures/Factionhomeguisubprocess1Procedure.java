package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class Factionhomeguisubprocess1Procedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return "Faction :" + getBlockNBTString(world, new BlockPos(0, 9, 0), ("Faction_name_" + getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID())))) + " - "
				+ getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}
