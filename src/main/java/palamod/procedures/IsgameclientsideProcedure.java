package palamod.procedures;

import net.neoforged.fml.loading.FMLEnvironment;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class IsgameclientsideProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level)
			_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		if (FMLEnvironment.dist.isClient() == !FMLEnvironment.dist.isDedicatedServer()) {
			return true;
		}
		return false;
	}
}