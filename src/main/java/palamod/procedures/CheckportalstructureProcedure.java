package palamod.procedures;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

public class CheckportalstructureProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState angle_block_dep, BlockState shiny_wood_dep) {
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		boolean output = false;
		angle_block = angle_block_dep;
		shiny_wood = shiny_wood_dep;
		if ((!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "portal_powered") || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == PalamodModBlocks.KEY_PORTAL_BLOCK.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(Identifier.parse("palamod:portal_blocks")))) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 3, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 3, y, z - 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 4, y, z - 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x - 4, y, z + 2))).getBlock() == angle_block.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 4, y, z + 1))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 4, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putString("position", "west");
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output = true;
				} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 4, y, z - 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 4, y, z + 2))).getBlock() == angle_block.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 4, y, z + 1))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 4, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putString("position", "east");
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output = true;
				}
			} else if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == shiny_wood.getBlock()) {
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 3))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z - 3))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 4))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z - 4))).getBlock() == angle_block.getBlock()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 4))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z - 4))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 4))).getBlock() == shiny_wood.getBlock()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putString("position", "north");
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output = true;
				} else if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 3))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 3))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 4))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 4))).getBlock() == angle_block.getBlock()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 4))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z + 4))).getBlock() == shiny_wood.getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 4))).getBlock() == shiny_wood.getBlock()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putString("position", "south");
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output = true;
				}
			}
		}
		PalamodMod.LOGGER.debug(("check portal =" + output));
		return output;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}