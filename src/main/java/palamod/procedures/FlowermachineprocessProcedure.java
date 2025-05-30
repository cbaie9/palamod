package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class FlowermachineprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double random_num = 0;
		double checkminus = 0;
		double flower1slot = 0;
		double flower2slot = 0;
		double flower3slot = 0;
		double flower4slot = 0;
		double iloop = 0;
		ItemStack flower1itelm = ItemStack.EMPTY;
		ItemStack flower2item = ItemStack.EMPTY;
		ItemStack flower3item = ItemStack.EMPTY;
		ItemStack flower4item = ItemStack.EMPTY;
		ItemStack random = ItemStack.EMPTY;
		ItemStack set = ItemStack.EMPTY;
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "setup_verified")) {
			flower1itelm = new ItemStack(Blocks.BARRIER).copy();
			flower2item = new ItemStack(Blocks.BARRIER).copy();
			flower3item = new ItemStack(Blocks.BARRIER).copy();
			flower4item = new ItemStack(Blocks.BARRIER).copy();
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flower_fuel") > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("flower_fuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flower_fuel") - 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("flower_timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flower_timer") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flower_timer") >= 100) {
					while (flower1itelm.getItem() == Blocks.BARRIER.asItem() || flower2item.getItem() == Blocks.BARRIER.asItem() || flower3item.getItem() == Blocks.BARRIER.asItem() || flower4item.getItem() == Blocks.BARRIER.asItem()) {
						random_num = Mth.nextInt(RandomSource.create(), 1, 9);
						checkminus = 0;
						if (random_num == 1) {
							if (flower1itelm.getItem() == Blocks.OXEYE_DAISY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == Blocks.OXEYE_DAISY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.OXEYE_DAISY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.OXEYE_DAISY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + checkminus < 64) {
								random = new ItemStack(Blocks.OXEYE_DAISY).copy();
							} else {
								continue;
							}
						} else if (random_num == 2) {
							if (flower1itelm.getItem() == PalamodModBlocks.ENDIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == PalamodModBlocks.ENDIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.ENDIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.ENDIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + checkminus < 64) {
								random = new ItemStack(PalamodModBlocks.ENDIUMFLOWER.get()).copy();
							} else {
								continue;
							}
						} else if (random_num == 3) {
							if (flower1itelm.getItem() == PalamodModBlocks.PALADIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == PalamodModBlocks.PALADIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.PALADIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.PALADIUMFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + checkminus < 64) {
								random = new ItemStack(PalamodModBlocks.PALADIUMFLOWER.get()).copy();
							} else {
								continue;
							}
						} else if (random_num == 4) {
							if (flower1itelm.getItem() == Blocks.POPPY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == Blocks.POPPY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.POPPY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.POPPY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + checkminus < 64) {
								random = new ItemStack(Blocks.POPPY).copy();
							} else {
								continue;
							}
						} else if (random_num == 5) {
							if (flower1itelm.getItem() == PalamodModBlocks.CLATHRUSARCHERI.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == PalamodModBlocks.CLATHRUSARCHERI.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.CLATHRUSARCHERI.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.CLATHRUSARCHERI.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() + checkminus < 64) {
								random = new ItemStack(PalamodModBlocks.CLATHRUSARCHERI.get()).copy();
							} else {
								continue;
							}
						} else if (random_num == 6) {
							if (flower1itelm.getItem() == PalamodModBlocks.MINERALFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == PalamodModBlocks.MINERALFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.MINERALFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == PalamodModBlocks.MINERALFLOWER.get().asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() + checkminus < 64) {
								random = new ItemStack(PalamodModBlocks.MINERALFLOWER.get()).copy();
							} else {
								continue;
							}
						} else if (random_num == 7) {
							if (flower1itelm.getItem() == Blocks.DANDELION.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == Blocks.DANDELION.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.DANDELION.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.DANDELION.asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() + checkminus < 64) {
								random = new ItemStack(Blocks.DANDELION).copy();
							} else {
								continue;
							}
						} else if (random_num == 8) {
							if (flower1itelm.getItem() == Blocks.LILY_OF_THE_VALLEY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == Blocks.LILY_OF_THE_VALLEY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.LILY_OF_THE_VALLEY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.LILY_OF_THE_VALLEY.asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).getCount() + checkminus < 64) {
								random = new ItemStack(Blocks.LILY_OF_THE_VALLEY).copy();
							} else {
								continue;
							}
						} else if (random_num == 9) {
							if (flower1itelm.getItem() == Blocks.ALLIUM.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower2item.getItem() == Blocks.ALLIUM.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.ALLIUM.asItem()) {
								checkminus = checkminus + 1;
							}
							if (flower3item.getItem() == Blocks.ALLIUM.asItem()) {
								checkminus = checkminus + 1;
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() + checkminus < 64) {
								random = new ItemStack(Blocks.ALLIUM).copy();
							} else {
								continue;
							}
						}
						if (flower1itelm.getItem() == Blocks.BARRIER.asItem()) {
							flower1itelm = random.copy();
							continue;
						} else if (flower2item.getItem() == Blocks.BARRIER.asItem()) {
							flower2item = random.copy();
							continue;
						} else if (flower3item.getItem() == Blocks.BARRIER.asItem()) {
							flower3item = random.copy();
							continue;
						} else if (flower4item.getItem() == Blocks.BARRIER.asItem()) {
							flower4item = random.copy();
							break;
						}
					}
					for (int index1 = 0; index1 < 4; index1++) {
						if (iloop == 0) {
							set = flower1itelm.copy();
						} else if (iloop == 1) {
							set = flower2item.copy();
						} else if (iloop == 2) {
							set = flower3item.copy();
						} else if (iloop == 3) {
							set = flower4item.copy();
						}
						if (set.getItem() == Blocks.OXEYE_DAISY.asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Blocks.OXEYE_DAISY).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(1, _setstack);
							}
						} else if (set.getItem() == PalamodModBlocks.ENDIUMFLOWER.get().asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(PalamodModBlocks.ENDIUMFLOWER.get()).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
						} else if (set.getItem() == PalamodModBlocks.PALADIUMFLOWER.get().asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUMFLOWER.get()).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(3, _setstack);
							}
						} else if (set.getItem() == Blocks.POPPY.asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Blocks.POPPY).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(4, _setstack);
							}
						} else if (set.getItem() == PalamodModBlocks.CLATHRUSARCHERI.get().asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(PalamodModBlocks.CLATHRUSARCHERI.get()).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(5, _setstack);
							}
						} else if (set.getItem() == PalamodModBlocks.MINERALFLOWER.get().asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(PalamodModBlocks.MINERALFLOWER.get()).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(6, _setstack);
							}
						} else if (set.getItem() == Blocks.DANDELION.asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Blocks.DANDELION).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(7, _setstack);
							}
						} else if (set.getItem() == Blocks.LILY_OF_THE_VALLEY.asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Blocks.LILY_OF_THE_VALLEY).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(8, _setstack);
							}
						} else if (set.getItem() == Blocks.ALLIUM.asItem()) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Blocks.ALLIUM).copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).getCount() + 1));
								_itemHandlerModifiable.setStackInSlot(9, _setstack);
							}
						}
						iloop = iloop + 1;
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("flower_timer", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BONE_MEAL) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("flower_fuel", 100);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
			}
			world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
