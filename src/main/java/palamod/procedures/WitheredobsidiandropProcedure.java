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
			for (int index84 = 0; index84 < 2; index84++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_3.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index85 = 0; index85 < 3; index85++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_4.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index86 = 0; index86 < 4; index86++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_5.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index87 = 0; index87 < 5; index87++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_6.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index88 = 0; index88 < 6; index88++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_7.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index89 = 0; index89 < 7; index89++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_8.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index90 = 0; index90 < 8; index90++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_9.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index91 = 0; index91 < 9; index91++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_10.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index92 = 0; index92 < 10; index92++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_11.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index93 = 0; index93 < 11; index93++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_12.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index94 = 0; index94 < 12; index94++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (PalamodModBlocks.WITHERED_OBSIDIAN_13.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			for (int index95 = 0; index95 < 13; index95++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}