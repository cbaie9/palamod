package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class FertilizedbmplantProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean apply = false;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.FERTILZED_DIRT.get() && (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(Identifier.parse("forge:plant")))) {
			if (Math.random() < 0.05) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.EGGPLANT_0.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.EGGPLANT_1.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.EGGPLANT_1.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.EGGPLANT_2.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.EGGPLANT_2.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.EGGPLANT_3.get().defaultBlockState();
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
					apply = true;
				}
			}
			if (Math.random() < 0.025) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.CHERVIL_0.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.CHERVIL_1.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.CHERVIL_1.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.CHERVIL_2.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.CHERVIL_2.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.CHERVIL_3.get().defaultBlockState();
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
					apply = true;
				}
			}
			if (Math.random() < 0.01) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.KIWANO_0.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.KIWANO_1.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.KIWANO_1.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.KIWANO_2.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.KIWANO_2.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.KIWANO_3.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.KIWANO_3.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.KIWANO_4.get().defaultBlockState();
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
					apply = true;
				}
			}
			if (Math.random() < 0.005) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.ORANGEBLUE_0.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.ORANGEBLUE_1.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.ORANGEBLUE_1.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.ORANGEBLUE_2.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.ORANGEBLUE_2.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.ORANGEBLUE_3.get().defaultBlockState();
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
					apply = true;
				} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.ORANGEBLUE_3.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = PalamodModBlocks.ORANGEBLUE_4.get().defaultBlockState();
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
					apply = true;
				}
			}
			if (Math.random() < 0.1 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof BonemealableBlock) {
				if (world instanceof ServerLevel _level) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), _level, _bp, null) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						_level.levelEvent(2005, _bp, 0);
					}
				}
				apply = true;
			}
		}
		if (apply) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.COMPOSTER, x, (y + 1.6), z, 5, 3, 3, 3, 1);
		}
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 13);
	}
}