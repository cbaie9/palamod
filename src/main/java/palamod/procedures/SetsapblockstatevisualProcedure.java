package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SetsapblockstatevisualProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double n = 0;
		if (96 == (getPropertyByName(blockstate, "sap") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1)
				&& 0 != (getPropertyByName(blockstate, "blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1)) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if (0 == (getPropertyByName(blockstate, "sap") instanceof IntegerProperty _getip6 ? blockstate.getValue(_getip6) : -1)) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.DEAD_LOG.get().defaultBlockState(), 3);
		} else {
			n = Math.floor((96 - (getPropertyByName(blockstate, "sap") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1)) / 6d);
			{
				int _value = (int) n;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}