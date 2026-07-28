package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class WitheredobsidiandropProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PalamodModBlocks.WITHERED_OBSIDIAN_1.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_2.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index524 = 0; index524 < 2; index524++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_3.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index525 = 0; index525 < 3; index525++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_4.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index526 = 0; index526 < 4; index526++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_5.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index527 = 0; index527 < 5; index527++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_6.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index528 = 0; index528 < 6; index528++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_7.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index529 = 0; index529 < 7; index529++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_8.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index530 = 0; index530 < 8; index530++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_9.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index531 = 0; index531 < 9; index531++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_10.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index532 = 0; index532 < 10; index532++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_11.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index533 = 0; index533 < 11; index533++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_12.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index534 = 0; index534 < 12; index534++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_13.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index535 = 0; index535 < 13; index535++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}