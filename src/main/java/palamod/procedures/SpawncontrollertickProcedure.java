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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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
		double i_loop_speed_upgrades = 0;
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
		PalamodMod.LOGGER.info(("" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick")));
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") % 120 == 0) {
			PalamodMod.LOGGER.info("chtick");
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") >= 800) {
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
			int horizontalRadiusSquare = (int) 10 - 1;
			int verticalRadiusSquare = (int) 3 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == PalamodModBlocks.EMPTY_SPAWNER.get()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") > 50) {
								if ((getBlockNBTString(world, BlockPos.containing(x + xi, y + i, z + zi), "spawner_type")).equals("witch")) {
									if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 50) {
										tier_witch = tier_witch + 1;
										nb_witch = nb_witch + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 150 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 100) {
										tier_witch = tier_witch + 2;
										nb_witch = nb_witch + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 200 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 150) {
										tier_witch = tier_witch + 3;
										nb_witch = nb_witch + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 200) {
										tier_witch = tier_witch + 4;
										nb_witch = nb_witch + 1;
									}
									nb_spawn = nb_spawn + 1;
								} else if ((getBlockNBTString(world, BlockPos.containing(x + xi, y + i, z + zi), "spawner_type")).equals("zombie")) {
									if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 50) {
										tier_zombie = tier_zombie + 1;
										nb_zombie = nb_zombie + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 150 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 100) {
										tier_zombie = tier_zombie + 2;
										nb_zombie = nb_zombie + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 200 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 150) {
										tier_zombie = tier_zombie + 3;
										nb_zombie = nb_zombie + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 200) {
										tier_zombie = tier_zombie + 4;
										nb_zombie = nb_zombie + 1;
									}
									nb_spawn = nb_spawn + 1;
								} else if ((getBlockNBTString(world, BlockPos.containing(x + xi, y + i, z + zi), "spawner_type")).equals("skeleton")) {
									if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 50) {
										tier_skelette = tier_skelette + 1;
										nb_skeleton = nb_skeleton + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 150 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 100) {
										tier_skelette = tier_skelette + 2;
										nb_skeleton = nb_skeleton + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 200 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 150) {
										tier_zombie = tier_skelette + 3;
										nb_skeleton = nb_skeleton + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 200) {
										tier_skelette = tier_skelette + 4;
										nb_skeleton = nb_skeleton + 1;
									}
									nb_spawn = nb_spawn + 1;
								} else if ((getBlockNBTString(world, BlockPos.containing(x + xi, y + i, z + zi), "spawner_type")).equals("creeper")) {
									if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 100 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 50) {
										tier_creeper = tier_creeper + 1;
										nb_creeper = nb_creeper + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 150 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 100) {
										tier_creeper = tier_creeper + 2;
										nb_creeper = nb_creeper + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") < 200 && getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 150) {
										tier_creeper = tier_creeper + 3;
										nb_creeper = nb_creeper + 1;
									} else if (getBlockNBTNumber(world, BlockPos.containing(x + xi, y + i, z + zi), "soul") >= 200) {
										tier_creeper = tier_creeper + 4;
										nb_creeper = nb_creeper + 1;
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
			PalamodMod.LOGGER.info(("nb zombie" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie") + "\n" + "tier zombie" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie") + "\n" + "nb spawner"
					+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner") + "\n" + "calc"
					+ (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie") * 4) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie") + "\n" + "slime"
					+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_slime_upgrades") + "\n" + "speed" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_speed_upgrades")));
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
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "checktick") >= 800 * (1 - 0.1 * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_speed_upgrades"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner") > 0) {
				for (int index0 = 0; index0 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_witch"); index0++) {
					if (Math.random() < 1 - (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_witch") * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_witch")) / 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10) - 5, y, z + Mth.nextInt(RandomSource.create(), 1, 10) - 5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
				for (int index1 = 0; index1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_creeper"); index1++) {
					if (Math.random() < 1 - (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_creeper") * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_creeper")) / 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.CREEPER.spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10) - 5, y, z + Mth.nextInt(RandomSource.create(), 1, 10) - 5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
				for (int index2 = 0; index2 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_skeleton"); index2++) {
					if (Math.random() < (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_skeleton") * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_skeleton")) / 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10) - 5, y, z + Mth.nextInt(RandomSource.create(), 1, 10) - 5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
				for (int index3 = 0; index3 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie"); index3++) {
					if (Math.random() < (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_zombie") * 4) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie")) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10) - 5, y, z + Mth.nextInt(RandomSource.create(), 1, 10) - 5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_slime_upgrades") > 0) {
					for (int index4 = 0; index4 < (int) Math.ceil(0.25 * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_slime_upgrades") * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner")); index4++) {
						if (Math.random() < (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_spawner") * 4)
								/ (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_zombie") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_skeleton")
										+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_creeper") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tier_witch"))) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SLIME.spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10) - 5, y, z + Mth.nextInt(RandomSource.create(), 1, 10) - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
								}
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