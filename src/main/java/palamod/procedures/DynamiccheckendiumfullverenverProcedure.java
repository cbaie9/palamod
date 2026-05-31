package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

public class DynamiccheckendiumfullverenverProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((getBlockNBTLogic(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_" + entity.getDisplayName().getString()))
				|| (world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("palamod:forestender")) || world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("palamod:frozenforest"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("palamod:roofedforest")) || world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("plains"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("plains"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(Identifier.parse("ocean"))) && getBlockNBTLogic(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_hide_" + entity.getDisplayName().getString())))
				&& entity.getY() < 128 && entity.getY() > -64) {
			return false;
		}
		return true;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}