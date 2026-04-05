package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ExtractorprocesstickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean pass_block = false;
		double x_bloc = 0;
		double z_bloc = 0;
		if (blockstate.getBlock().getStateDefinition().getProperty("fiole") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			x_bloc = x;
			z_bloc = z;
			if (Direction.NORTH == (getDirectionFromBlockState(blockstate))) {/*north =z+1*/
				if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("palamod:can_be_extracted")))) {
					pass_block = true;
					z_bloc = z + 1;
				}
			} else if (Direction.SOUTH == (getDirectionFromBlockState(blockstate))) {/*south =z-1*/
				if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("palamod:can_be_extracted")))) {
					pass_block = true;
					z_bloc = z - 1;
				}
			} else if (Direction.WEST == (getDirectionFromBlockState(blockstate))) {/*west =x+1*/
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:can_be_extracted")))) {
					pass_block = true;
					x_bloc = x + 1;
				}
			} else if (Direction.EAST == (getDirectionFromBlockState(blockstate))) {/*east =x-1*/
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:can_be_extracted")))) {
					pass_block = true;
					x_bloc = x - 1;
				}
			}
			if (pass_block && 15 > (blockstate.getBlock().getStateDefinition().getProperty("extracted_sap") instanceof IntegerProperty _getip23 ? blockstate.getValue(_getip23) : -1)) {
				if (5 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						int _value = ((world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getBlock().getStateDefinition().getProperty("sap") instanceof IntegerProperty _getip27
								? (world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getValue(_getip27)
								: -1) - 1;
						BlockPos _pos = BlockPos.containing(x_bloc, y, z_bloc);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("sap") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					{
						int _value = (blockstate.getBlock().getStateDefinition().getProperty("extracted_sap") instanceof IntegerProperty _getip30 ? blockstate.getValue(_getip30) : -1) + 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("extracted_sap") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if ((world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getBlock() == PalamodModBlocks.OSTRYA_WOOD_LOG.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("type", 1);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getBlock() == PalamodModBlocks.JUDEECERCIS_LOG.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("type", 2);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getBlock() == PalamodModBlocks.JACARANDA_LOG.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("type", 3);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((world.getBlockState(BlockPos.containing(x_bloc, y, z_bloc))).getBlock() == PalamodModBlocks.ERABLE_LOG.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("type", 4);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					{
						int _value = (int) (1 + Math.round(((blockstate.getBlock().getStateDefinition().getProperty("extracted_sap") instanceof IntegerProperty _getip45 ? blockstate.getValue(_getip45) : -1) / 15d) * 12));
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}