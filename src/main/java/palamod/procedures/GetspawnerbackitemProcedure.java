package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class GetspawnerbackitemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack output = ItemStack.EMPTY;
		PalamodMod.LOGGER.info(("" + entity.getPersistentData().getDouble("cache.soul")));
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul") > 0) {
			output = new ItemStack(PalamodModItems.EMPTY_SPAWNER_ITEM.get()).copy();
			{
				final String _tagName = "soul";
				final double _tagValue = (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul"));
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "spawner_type";
				final String _tagValue = (getBlockNBTString(world, BlockPos.containing(x, y, z), "spawner_type"));
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putString(_tagName, _tagValue));
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, output);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if (entity.getPersistentData().getDouble("cache.soul") > 0) {
			output = new ItemStack(PalamodModItems.EMPTY_SPAWNER_ITEM.get()).copy();
			{
				final String _tagName = "soul";
				final double _tagValue = (entity.getPersistentData().getDouble("cache.soul"));
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "spawner_type";
				final String _tagValue = (entity.getPersistentData().getString("cache.spawner_type"));
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putString(_tagName, _tagValue));
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, output);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, new ItemStack(PalamodModBlocks.EMPTY_SPAWNER.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		world.destroyBlock(BlockPos.containing(x, y, z), false);
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