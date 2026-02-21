package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SeeddropsProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FERN
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.1) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.EGGPLANT_SEED.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FERN
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.05) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.CHERVIL_SEED.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FERN
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.01) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.KIWANO_SEED.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FERN
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.005) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}