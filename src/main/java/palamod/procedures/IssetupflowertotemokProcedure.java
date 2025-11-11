package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class IssetupflowertotemokProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean xp_bush = false;
		boolean allium = false;
		boolean blue_orchidee = false;
		boolean poppy_var = false;
		boolean white_tulip_var = false;
		boolean dandelion_var = false;
		boolean mineral_flower_var = false;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK && (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK
				&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.PODZOL
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.PODZOL && (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.PODZOL
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.PODZOL) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("palamod:xp_bush")))) {
				xp_bush = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ALLIUM || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.ALLIUM
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.ALLIUM || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.ALLIUM
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.ALLIUM || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.ALLIUM
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.ALLIUM || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.ALLIUM
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.ALLIUM) {
				allium = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BLUE_ORCHID
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BLUE_ORCHID
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BLUE_ORCHID
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BLUE_ORCHID
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BLUE_ORCHID) {
				blue_orchidee = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POPPY || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.POPPY
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.POPPY || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.POPPY
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.POPPY || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.POPPY
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.POPPY || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.POPPY
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.POPPY) {
				poppy_var = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WHITE_TULIP || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.WHITE_TULIP
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.WHITE_TULIP || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.WHITE_TULIP
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.WHITE_TULIP || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WHITE_TULIP
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WHITE_TULIP || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WHITE_TULIP
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WHITE_TULIP) {
				white_tulip_var = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DANDELION || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.DANDELION
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.DANDELION || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.DANDELION
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.DANDELION || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.DANDELION
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.DANDELION || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.DANDELION
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.DANDELION) {
				dandelion_var = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.MINERALFLOWER.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == PalamodModBlocks.MINERALFLOWER.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == PalamodModBlocks.MINERALFLOWER.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == PalamodModBlocks.MINERALFLOWER.get()) {
				mineral_flower_var = true;
			}
		}
		if (xp_bush && allium && blue_orchidee && white_tulip_var && poppy_var && dandelion_var && mineral_flower_var) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("setup_verified", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			return true;
		}
		return false;
	}
}