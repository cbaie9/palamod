package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class AdminshopgetitemProcedure {
	public static ItemStack execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack item = ItemStack.EMPTY;
		double num = 0;
		return !(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((getBlockNBTString(world, new BlockPos(0, 10, 0), ("mode_adminshop_" + entity.getUUID().toString())))).toLowerCase(java.util.Locale.ENGLISH))) == Blocks.AIR.asItem())
				? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((getBlockNBTString(world, new BlockPos(0, 10, 0), ("mode_adminshop_" + entity.getUUID().toString())))).toLowerCase(java.util.Locale.ENGLISH))))
				: new ItemStack(Blocks.COMMAND_BLOCK);
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}