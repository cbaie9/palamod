package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class DynamiccheckendiumfullverProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_" + entity.getDisplayName().getString())) || (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("palamod:forestender"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("palamod:frozenforest")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("palamod:roofedforest"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("forest"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("ocean"))) && new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_hide_" + entity.getDisplayName().getString()))) && entity.getY() < 128 && entity.getY() > -64) {
			return true;
		}
		return false;
	}
}
