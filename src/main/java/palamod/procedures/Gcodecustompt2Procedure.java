package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Gcodecustompt2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack temp_itemstack = ItemStack.EMPTY;
		File file = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/save/serverconfig/palamod/defaultconfig/s/"), File.separator + "palamod-configuration-custom.json");
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PICKAXE_HEAD.get()
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMGREENPICKAXE.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMGREENSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
					if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HEADENDIUMSWORD.get()
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMFASTSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.GREENPALADIUMFASTSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUMFASTSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.GREENPALADIUMBROADSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUMBROADSWORD.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMGREENSHOVEL.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
									|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.STICK)
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main.get("Grinder-loading_time2").getAsDouble()) {
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
								ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUMSHOVEL.get()).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
					if (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0)
							&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 3)
									|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 4)
											&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("moremodfier"))
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= main.get("Grinder-loading_time3").getAsDouble()) {
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
							temp_itemstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
							temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))), 1);
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = temp_itemstack.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(5, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 3)
									|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 4)
											&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("moremodfier"))
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= main.get("Grinder-loading_time3").getAsDouble()) {
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
							temp_itemstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
							temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))),
									(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) + 1);
							temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY),
									(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) + 1);
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = temp_itemstack.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(0, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							&& (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 3)
									|| !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modfier_num") == 4)
											&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("moremodfier"))
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= main.get("Grinder-loading_time3").getAsDouble()) {
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
							temp_itemstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
							temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))),
									(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) + 1);
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = temp_itemstack.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(5, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
					if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_19.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_20.get())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.BIG_HOLE_UPGRADE.get() && !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0)) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= main.get("Grinder-loading_time3").getAsDouble()) {
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
							temp_itemstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
							if (1 == temp_itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))) {
								EnchantmentHelper.updateEnchantments(temp_itemstack, mutableEnchantments -> mutableEnchantments
										.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))));
								temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), 2);
							} else {
								temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), 1);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = temp_itemstack.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(5, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
					if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_17.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_18.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_19.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == PalamodModItems.PICKAXEOFTHEGODSLV_20.get())
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3") >= main.get("Grinder-loading_time3").getAsDouble()) {
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
							temp_itemstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
							temp_itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = temp_itemstack.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(5, _setstack);
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
							if (0 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl3")) {
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}