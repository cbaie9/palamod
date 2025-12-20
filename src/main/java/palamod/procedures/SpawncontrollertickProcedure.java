package palamod.procedures;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SpawncontrollertickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double tier_witch = 0;
		double tier_zombie = 0;
		double tier_skelette = 0;
		double tier_creeper = 0;
		double nb_spawn = 0;
		double nb_witch = 0;
		double nb_creeper = 0;
		double nb_skeleton = 0;
		double nb_zombie = 0;
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
		PalamodMod.LOGGER.info(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick")));
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") % 120 == 0) {
			PalamodMod.LOGGER.info("chtick");
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") > 400) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("checktick", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("spawner_tier", CheckstructurespawnercontrollerProcedure.execute(world, x, y, z));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			int horizontalRadiusHemiTop = (int) 4 - 1;
			int verticalRadiusHemiTop = (int) 3;
			int yIterationsHemiTop = verticalRadiusHemiTop;
			for (int i = 0; i < yIterationsHemiTop; i++) {
				if (i == verticalRadiusHemiTop) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiTop; xi <= horizontalRadiusHemiTop; xi++) {
					for (int zi = -horizontalRadiusHemiTop; zi <= horizontalRadiusHemiTop; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop) + (i * i) / (double) (verticalRadiusHemiTop * verticalRadiusHemiTop)
								+ (zi * zi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.EMPTY_SPAWNER.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 50) {
									if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type")).equals("witch")) {
										if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 50) {
											tier_witch = tier_witch + 1;
											nb_witch = nb_witch + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 150 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 100) {
											tier_witch = tier_witch + 2;
											nb_witch = nb_witch + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 200 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 150) {
											tier_witch = tier_witch + 3;
											nb_witch = nb_witch + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 200) {
											tier_witch = tier_witch + 4;
											nb_witch = nb_witch + 1;
										}
									} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type")).equals("zombie")) {
										if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 50) {
											tier_zombie = tier_zombie + 1;
											nb_zombie = nb_zombie + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 150 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 100) {
											tier_zombie = tier_zombie + 2;
											nb_zombie = nb_zombie + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 200 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 150) {
											tier_zombie = tier_zombie + 3;
											nb_zombie = nb_zombie + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 200) {
											tier_zombie = tier_zombie + 4;
											nb_zombie = nb_zombie + 1;
										}
									} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type")).equals("skeleton")) {
										if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 50) {
											tier_skelette = tier_skelette + 1;
											nb_skeleton = nb_skeleton + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 150 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 100) {
											tier_skelette = tier_skelette + 2;
											nb_skeleton = nb_skeleton + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 200 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 150) {
											tier_zombie = tier_skelette + 3;
											nb_skeleton = nb_skeleton + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 200) {
											tier_skelette = tier_skelette + 4;
											nb_skeleton = nb_skeleton + 1;
										}
									} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type")).equals("creeper")) {
										if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 50) {
											tier_creeper = tier_creeper + 1;
											nb_creeper = nb_creeper + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 150 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 100) {
											tier_creeper = tier_creeper + 2;
											nb_creeper = nb_creeper + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 200 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 150) {
											tier_creeper = tier_creeper + 3;
											nb_creeper = nb_creeper + 1;
										} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") >= 200) {
											tier_creeper = tier_creeper + 4;
											nb_creeper = nb_creeper + 1;
										}
									}
									nb_spawn = nb_spawn + 1;
								}
							}
						}
					}
				}
			}
			if (nb_spawn > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("tier_witch", tier_witch);
						_blockEntity.getPersistentData().putDouble("tier_creeper", tier_creeper);
						_blockEntity.getPersistentData().putDouble("tier_skeleton", tier_skelette);
						_blockEntity.getPersistentData().putDouble("tier_zombie", tier_zombie);
						_blockEntity.getPersistentData().putDouble("nb_spawner", nb_spawn);
						_blockEntity.getPersistentData().putDouble("nb_witch", nb_witch);
						_blockEntity.getPersistentData().putDouble("nb_creeper", nb_creeper);
						_blockEntity.getPersistentData().putDouble("nb_skeleton", nb_skeleton);
						_blockEntity.getPersistentData().putDouble("nb_zombie", nb_zombie);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("checktick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("checktick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") == 480) {
			PalamodMod.LOGGER.info(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner")));
			PalamodMod.LOGGER.info(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie")));
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner") > 0) {
				for (int index0 = 0; index0 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner"); index0++) {
					if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_witch") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_witch")) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
					if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_creeper") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_creeper")) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.CREEPER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
					if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_skeleton") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_skeleton")) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
					if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie")) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
			}
		}
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