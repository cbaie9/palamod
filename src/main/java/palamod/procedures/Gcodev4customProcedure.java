package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Gcodev4customProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack temp_itemstack = ItemStack.EMPTY;
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
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
					main_obj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& main_obj.get("Grinder-Capacity").getAsDouble() > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR21 && _serverLevelGR21.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& main_obj.get("Grinder-Capacity").getAsDouble() > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR38 && _serverLevelGR38.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
							&& main_obj.get("Grinder-Capacity").getAsDouble() - 9 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR55 && _serverLevelGR55.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
							&& main_obj.get("Grinder-Capacity").getAsDouble() - 9 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 1 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR72 && _serverLevelGR72.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.ENDIUM_INGOT.get()
							&& main_obj.get("Grinder-Capacity").getAsDouble() - 9 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR89 && _serverLevelGR89.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
							&& main_obj.get("Grinder-Capacity").getAsDouble() > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
							&& (4 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") || 3 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot"))) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl1") >= main_obj.get("Grinder-loading_time1").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(3).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR106 && _serverLevelGR106.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR134 && _serverLevelGR134.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR150 && _serverLevelGR150.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR166 && _serverLevelGR166.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR193 && _serverLevelGR193.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR209 && _serverLevelGR209.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR225 && _serverLevelGR225.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.AXE_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR252 && _serverLevelGR252.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR268 && _serverLevelGR268.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_AXE.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR284 && _serverLevelGR284.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXE_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR311 && _serverLevelGR311.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR327 && _serverLevelGR327.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_PICKAXE.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR343 && _serverLevelGR343.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.SHOVEL_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR370 && _serverLevelGR370.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR386 && _serverLevelGR386.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_SHOVEL_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR402 && _serverLevelGR402.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.SWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR433 && _serverLevelGR433.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR449 && _serverLevelGR449.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") == main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.HEAD_ENDIUM_SWORD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR465 && _serverLevelGR465.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.HAMMER_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR496 && _serverLevelGR496.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR512 && _serverLevelGR512.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_HAMMER_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR528 && _serverLevelGR528.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.BROADSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR559 && _serverLevelGR559.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR575 && _serverLevelGR575.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_BROADSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR591 && _serverLevelGR591.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.FASTSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR622 && _serverLevelGR622.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 63 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)
								&& 2 == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR638 && _serverLevelGR638.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
								if (world instanceof ServerLevel _serverLevel) {
									BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
									if (_be instanceof Container _container) {
										ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_FASTSWORD_HEAD.get()).copy();
										_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
										_container.setItem(2, _setstack);
									}
								}
								if (world instanceof ServerLevel _serverLevelGR654 && _serverLevelGR654.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_AXE.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR673 && _serverLevelGR673.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_AXE.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR690 && _serverLevelGR690.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_AXE.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR709 && _serverLevelGR709.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR731 && _serverLevelGR731.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_HAMMER.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR755 && _serverLevelGR755.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gstate_cl2") >= main_obj.get("Grinder-loading_time2").getAsDouble()) {
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
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(1).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									_container.getItem(0).shrink(1);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
								if (_be instanceof Container _container) {
									ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_HAMMER.get()).copy();
									_setstack.setCount(1);
									_container.setItem(2, _setstack);
								}
							}
							if (world instanceof ServerLevel _serverLevelGR779 && _serverLevelGR779.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
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
					Gcodecustompt2Procedure.execute(world, x, y, z);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
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