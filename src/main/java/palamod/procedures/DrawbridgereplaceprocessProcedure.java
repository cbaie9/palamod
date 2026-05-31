package palamod.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DrawbridgereplaceprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Numvar = 0;
		if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
			for (int index0 = 0; index0 < 16; index0++) {
				if (!(world.getBlockState(BlockPos.containing(x, y, z - (Numvar + 1)))).is(BlockTags.create(Identifier.parse("forge:unbreakable"))) && itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) Numvar).getCount() == 0
						&& !((world.getBlockState(BlockPos.containing(x, y, z - (Numvar + 1)))).getBlock() == Blocks.AIR)) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - (Numvar + 1)))).getBlock())).copy();
							_setstack.setCount(1);
							_container.setItem((int) Numvar, _setstack);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z - (Numvar + 1)), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean(("pickup_locked" + Math.round(Numvar)), true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				Numvar = Numvar + 1;
			}
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
			for (int index1 = 0; index1 < 16; index1++) {
				if (!(world.getBlockState(BlockPos.containing(x, y, z + Numvar + 1))).is(BlockTags.create(Identifier.parse("forge:unbreakable"))) && itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) Numvar).getCount() == 0
						&& !((world.getBlockState(BlockPos.containing(x, y, z + Numvar + 1))).getBlock() == Blocks.AIR)) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + Numvar + 1))).getBlock())).copy();
							_setstack.setCount(1);
							_container.setItem((int) Numvar, _setstack);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z + Numvar + 1), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean(("pickup_locked" + Math.round(Numvar)), true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				Numvar = Numvar + 1;
			}
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
			for (int index2 = 0; index2 < 16; index2++) {
				if (!(world.getBlockState(BlockPos.containing(x - (Numvar + 1), y, z))).is(BlockTags.create(Identifier.parse("forge:unbreakable"))) && itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) Numvar).getCount() == 0
						&& !((world.getBlockState(BlockPos.containing(x - (Numvar + 1), y, z))).getBlock() == Blocks.AIR)) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(x - (Numvar + 1), y, z))).getBlock())).copy();
							_setstack.setCount(1);
							_container.setItem((int) Numvar, _setstack);
						}
					}
					world.setBlock(BlockPos.containing(x - (Numvar + 1), y, z), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean(("pickup_locked" + Math.round(Numvar)), true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				Numvar = Numvar + 1;
			}
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
			for (int index3 = 0; index3 < 16; index3++) {
				if (!(world.getBlockState(BlockPos.containing(x + Numvar + 1, y, z))).is(BlockTags.create(Identifier.parse("forge:unbreakable"))) && itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) Numvar).getCount() == 0
						&& !((world.getBlockState(BlockPos.containing(x + Numvar + 1, y, z))).getBlock() == Blocks.AIR)) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(x + Numvar + 1, y, z))).getBlock())).copy();
							_setstack.setCount(1);
							_container.setItem((int) Numvar, _setstack);
						}
					}
					world.setBlock(BlockPos.containing(x + Numvar + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean(("pickup_locked" + Math.round(Numvar)), true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				Numvar = Numvar + 1;
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (getPropertyByName(blockState, "facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (getPropertyByName(blockState, "axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
		}
		return ItemStack.EMPTY;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}