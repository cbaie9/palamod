package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class TankbreakpreloaddataProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack output = ItemStack.EMPTY;
		output = new ItemStack(PalamodModItems.TANKITEM.get()).copy();
		if (PalamodModBlocks.GOLDEN_TANK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			{
				final String _tagName = "tank_type";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if (PalamodModBlocks.AMETHYST_TANK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			{
				final String _tagName = "tank_type";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if (PalamodModBlocks.TITANE_TANK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			{
				final String _tagName = "tank_type";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "tank_type";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		{
			final String _tagName = "type";
			final String _tagValue = (getBlockNBTString(world, BlockPos.containing(x, y, z), "type"));
			CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = "stock";
			final double _tagValue = (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock"));
			CustomData.update(DataComponents.CUSTOM_DATA, output, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			Entity _entity14 = entity;
			_entity14.getPersistentData().put("tank_preload", output.saveOptional(_entity14.level().registryAccess()));
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}