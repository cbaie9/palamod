package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.ProblemReporter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class PurpleslimepadswapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState blockbase = Blocks.AIR.defaultBlockState();
		BlockState block_rota = Blocks.AIR.defaultBlockState();
		blockbase = PalamodModBlocks.SLIMEPAD_PURPLE.get().defaultBlockState();
		block_rota = PalamodModBlocks.ROTATED_PURPLE_SLIMEPAD.get().defaultBlockState();
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == blockbase.getBlock() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == block_rota.getBlock()) {
			if (((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.UP || (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.DOWN)
					&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == block_rota.getBlock())) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = block_rota;
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH || (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH
					|| (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST || (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST)
					&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == blockbase.getBlock())) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = blockbase;
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (getPropertyByName(blockState, "facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (getPropertyByName(blockState, "axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
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