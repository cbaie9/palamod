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
			for (int index91 = 0; index91 < 2; index91++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_3.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index92 = 0; index92 < 3; index92++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_4.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index93 = 0; index93 < 4; index93++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_5.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index94 = 0; index94 < 5; index94++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_6.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index95 = 0; index95 < 6; index95++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_7.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index96 = 0; index96 < 7; index96++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_8.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index97 = 0; index97 < 8; index97++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_9.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index98 = 0; index98 < 9; index98++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_10.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index99 = 0; index99 < 10; index99++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_11.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index100 = 0; index100 < 11; index100++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_12.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index101 = 0; index101 < 12; index101++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_13.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index102 = 0; index102 < 13; index102++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}