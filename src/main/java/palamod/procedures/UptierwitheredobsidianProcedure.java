package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class UptierwitheredobsidianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean uptier = false;
		if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		} else if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
		} else if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
		} else if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
		} else if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
		} else if (PalamodModBlocks.PALADIUM_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()) {
			uptier = true;
			world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
		}
		if (uptier) {
			if (PalamodModBlocks.WITHEREDOBSIDIAN_0.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_1.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_1.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_2.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_2.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_3.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_3.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_4.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_4.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_5.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_5.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_6.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_6.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_7.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_7.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_8.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_8.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_9.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_9.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_10.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_10.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_11.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_11.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_12.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else if (PalamodModBlocks.WITHEREDOBSIDIAN_12.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = PalamodModBlocks.WITHEREDOBSIDIAN_13.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		}
	}
}
