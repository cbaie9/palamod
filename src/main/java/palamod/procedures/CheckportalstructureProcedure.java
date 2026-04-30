package palamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class CheckportalstructureProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState angle_block_dep, BlockState shiny_wood_dep) {
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		angle_block = angle_block_dep;
		shiny_wood = shiny_wood_dep;
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
				return true;
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
				return true;
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
				return true;
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
				return true;
			}
		}
		return false;
	}
}