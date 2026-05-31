package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class Gcodev4Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack tempo_Item_stack = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (0 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gpala_num")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gpala_num")));
					_blockEntity.getPersistentData().putDouble("gpala_num", 0);
					_blockEntity.getPersistentData().putDouble("g_ingot", 4);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		PalamodModVariables.g_num = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum");
		PalamodModVariables.Grinder_ingot = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot");
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && 100 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR17 && _serverLevelGR17.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + " Insert paladium ingot into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 1));
						_blockEntity.getPersistentData().putDouble("g_ingot", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get() && 100 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR32 && _serverLevelGR32.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert green paladium ingot into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 1));
						_blockEntity.getPersistentData().putDouble("g_ingot", 2);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && 94 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR47 && _serverLevelGR47.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert paladium block into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 9));
						_blockEntity.getPersistentData().putDouble("g_ingot", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem() && 94 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR62 && _serverLevelGR62.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert green paladium block into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 9));
						_blockEntity.getPersistentData().putDouble("g_ingot", 2);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.ENDIUM_INGOT.get() && 94 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR77 && _serverLevelGR77.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert endium nugget  into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 9));
						_blockEntity.getPersistentData().putDouble("g_ingot", 3);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get() && 100 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
				&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") == 4) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR92 && _serverLevelGR92.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert endium nugget  into grinder"));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") + 1));
						_blockEntity.getPersistentData().putDouble("g_ingot", 3);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.INGOT_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get() && 1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR119 && _serverLevelGR119.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt paladium ingot"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR134 && _serverLevelGR134.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt green paladium ingot"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR149 && _serverLevelGR149.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt endium ingot"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.BLOCK_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get() && 9 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 9));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR175 && _serverLevelGR175.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium block"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 9));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR190 && _serverLevelGR190.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt green paladium block"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 9));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR205 && _serverLevelGR205.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium ingot"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AXE_PATERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get() && 3 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AXE_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.AXE_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR231 && _serverLevelGR231.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt axe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR246 && _serverLevelGR246.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt green paladium axe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_AXE.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_AXE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR261 && _serverLevelGR261.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Insert smelt endium axe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PICKAXE_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get() && 3 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.PICKAXE_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXE_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR287 && _serverLevelGR287.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium pickaxe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR302 && _serverLevelGR302.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt  green paladium pickaxe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_PICKAXE.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_PICKAXE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR317 && _serverLevelGR317.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium pickaxe head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.SHOVEL_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get() && 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.SHOVEL_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.SHOVEL_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR343 && _serverLevelGR343.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt paladium shovel head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR358 && _serverLevelGR358.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt green paladium shovel head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_SHOVEL_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_SHOVEL_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR373 && _serverLevelGR373.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  endium shovel head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.SWORD_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get()
				&& (2 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && (1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))
						|| 18 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.SWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.SWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR403 && _serverLevelGR403.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium sword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR418 && _serverLevelGR418.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt  green paladium sword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_SWORD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 18));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_SWORD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR433 && _serverLevelGR433.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium sword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HAMMER_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get()
				&& (6 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && (1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))
						|| 54 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.HAMMER_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 6));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.HAMMER_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR463 && _serverLevelGR463.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium hammer head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 6));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR478 && _serverLevelGR478.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt  green paladium hammer head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_HAMMER_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 54));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_HAMMER_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR493 && _serverLevelGR493.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium hammer head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.BROADSWORD_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get()
				&& (4 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && (1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))
						|| 36 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.BROADSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 4));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.BROADSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR523 && _serverLevelGR523.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium sword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 4));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR538 && _serverLevelGR538.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt  green paladium broadsword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_BROADSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 36));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_BROADSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR553 && _serverLevelGR553.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium broadsword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.FASTSWORD_PATTERN.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.SOCKET_PATTERN.get()
				&& (4 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && (1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))
						|| 36 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.FASTSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 4));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.FASTSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR583 && _serverLevelGR583.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt paladium fastsword head"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 63
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 4));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR598 && _serverLevelGR598.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt  green paladium fastsword head ( err:0g4)"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_FASTSWORD_HEAD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 63
					|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) && 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 36));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_FASTSWORD_HEAD.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR613 && _serverLevelGR613.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ] smelt endium fastsword head ( err:0e4 )"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AXE_HEAD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_AXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR631 && _serverLevelGR631.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt paladium axe [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_AXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR647 && _serverLevelGR647.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt green paladium axe [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_AXE.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_AXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ServerLevel _serverLevelGR665 && _serverLevelGR665.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt endium axe [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HAMMER_HEAD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() && 1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR686 && _serverLevelGR686.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt paladium hammer [ type2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() && 1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR709 && _serverLevelGR709.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt green paladium hammer [ type2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_HAMMER_HEAD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() && 1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
						_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_HAMMER.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR732 && _serverLevelGR732.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "[ Craft ]  smelt endium hammer [ type2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PICKAXE_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR757 && _serverLevelGR757.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "assemble paladium pickaxe [type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_PICKAXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR782 && _serverLevelGR782.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble green paladium pickaxe [ type 2]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_PICKAXE.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_PICKAXE.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR807 && _serverLevelGR807.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble endium pickaxe [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.SWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_SWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR832 && _serverLevelGR832.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble paladium sword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR857 && _serverLevelGR857.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble green paladium sword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HEAD_ENDIUM_SWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_SWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR882 && _serverLevelGR882.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble endium sword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.FASTSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_FASTSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR907 && _serverLevelGR907.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble paladium fastsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_FASTSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR932 && _serverLevelGR932.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble green paladium fastsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_FASTSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_FASTSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR957 && _serverLevelGR957.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble endium fastsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.BROADSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMBROADSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR982 && _serverLevelGR982.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble paladium broadsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_BROADSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR1007 && _serverLevelGR1007.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble green paladium broadsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_BROADSWORD_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", false);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_BROADSWORD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR1032 && _serverLevelGR1032.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble endium broadsword [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.SHOVEL_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", true);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", false);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_SHOVEL.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR1057 && _serverLevelGR1057.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble paladium shovel [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", true);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", false);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SHOVEL.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR1082 && _serverLevelGR1082.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble green paladium shovel [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_SHOVEL_HEAD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
				&& 1 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_norelock", true);
					_blockEntity.getPersistentData().putBoolean("grinder_norequirement", false);
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", 0);
						_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_SHOVEL.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (world instanceof ServerLevel _serverLevelGR1107 && _serverLevelGR1107.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Assemble endium shovel [ type 2 ]"));
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norelock") == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		PalamodModVariables.g_num = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum");
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norequirement")) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") > 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") >= 5) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "grinder_state_nofuel") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("grinder_state_nofuel", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_tick")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("grinder_nolock", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0)
					&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 3)
							|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 4)
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("moremodfier", false))
					&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.ENDIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PALADIUM_HAMMER.get())
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.SMELT_MODIFIER.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_nolock", true);
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", false);
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					tempo_Item_stack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))), 1);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = tempo_Item_stack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR1150 && _serverLevelGR1150.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "upgrade hammer ( smelt )"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_nolock") == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if ((!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) != 0)
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) < 3)
					&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 3)
							|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 4)
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("moremodfier", false))
					&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.ENDIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PALADIUM_HAMMER.get())
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.SPEED_MODIFIER.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_nolock", true);
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", false);
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					tempo_Item_stack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					if (1 == tempo_Item_stack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))) {
						EnchantmentHelper.updateEnchantments(tempo_Item_stack, mutableEnchantments -> mutableEnchantments
								.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))));
						EnchantmentHelper.updateEnchantments(tempo_Item_stack,
								mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY))));
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))), 2);
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 3);
					} else if (2 == tempo_Item_stack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))) {
						EnchantmentHelper.updateEnchantments(tempo_Item_stack, mutableEnchantments -> mutableEnchantments
								.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))));
						EnchantmentHelper.updateEnchantments(tempo_Item_stack,
								mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY))));
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))), 3);
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 4);
					} else {
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))), 1);
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 1);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = tempo_Item_stack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR1195 && _serverLevelGR1195.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "upgrade  hammer ( speed ) 1"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_nolock") == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if ((!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) != 0)
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) < 3)
					&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 3)
							|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("modfier_num", 0) == 4)
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("moremodfier", false))
					&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.ENDIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PALADIUM_HAMMER.get())
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.FORTUNE_MODIFIER.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_nolock", true);
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", false);
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					tempo_Item_stack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					if (1 == tempo_Item_stack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))) {
						EnchantmentHelper.updateEnchantments(tempo_Item_stack, mutableEnchantments -> mutableEnchantments
								.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))));
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))), 2);
					} else if (2 == tempo_Item_stack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))) {
						EnchantmentHelper.updateEnchantments(tempo_Item_stack, mutableEnchantments -> mutableEnchantments
								.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))));
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))), 3);
					} else {
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))), 1);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = tempo_Item_stack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR1235 && _serverLevelGR1235.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "upgrade hammer ( forturne )"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_nolock") == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV19.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV20.get())
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.BIG_HOLE_UPGRADE.get()
					&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0
							&& 2 > (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))
							|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_nolock", true);
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", false);
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					tempo_Item_stack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					if (1 == tempo_Item_stack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))) {
						EnchantmentHelper.updateEnchantments(tempo_Item_stack, mutableEnchantments -> mutableEnchantments
								.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))));
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), 2);
					} else {
						tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), 1);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = tempo_Item_stack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR1266 && _serverLevelGR1266.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Add BIg Hole Upgrade to potg"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_nolock") == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV17.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV18.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV19.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXE_OF_THE_GODS_LV20.get())
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.AUTO_SMELT_UPGRADE_POTG.get() && !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0)) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("grinder_nolock", true);
						_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", false);
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= 10) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					tempo_Item_stack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					tempo_Item_stack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = tempo_Item_stack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
					if (world instanceof ServerLevel _serverLevelGR1294 && _serverLevelGR1294.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug(("Grinder at X:" + x + " Y:" + y + " Z:" + z + "Add Auto Smelt Upgrade to potg"));
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_nolock") == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("grinder_norequirement2", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			PalamodModVariables.g_num = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum");
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "grinder_norequirement2") == true) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") >= 5) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") > 0) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gstate_cl3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") - 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_nofuel2") > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gstate_nofuel2", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
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

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}