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
			for (int index279 = 0; index279 < 2; index279++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_3.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index280 = 0; index280 < 3; index280++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_4.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index281 = 0; index281 < 4; index281++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_5.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index282 = 0; index282 < 5; index282++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_6.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index283 = 0; index283 < 6; index283++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_7.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index284 = 0; index284 < 7; index284++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_8.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index285 = 0; index285 < 8; index285++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_9.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index286 = 0; index286 < 9; index286++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_10.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index287 = 0; index287 < 10; index287++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_11.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index288 = 0; index288 < 11; index288++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_12.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index289 = 0; index289 < 12; index289++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_13.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index290 = 0; index290 < 13; index290++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}