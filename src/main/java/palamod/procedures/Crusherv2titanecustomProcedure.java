package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Crusherv2titanecustomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		com.google.gson.JsonObject Main_obj = new com.google.gson.JsonObject();
		double input_titane = 0;
		double output_titane = 0;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/defaultconfig/"), File.separator + "palamod-configuration-custom.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
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
					Main_obj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					input_titane = Main_obj.get("Crusher-titane-input").getAsDouble();
					output_titane = Main_obj.get("Crusher-titane-output").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "crusher_num_titane") >= input_titane) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent != null) {
						final int _slotid = 2;
						final ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
						_setstack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
								return _retval.get();
							}
						}.getAmount(world, BlockPos.containing(x, y, z), 2) + output_titane));
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("crusher_num_titane", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( titane ) (custom on )"));
				}
			} else {
				if (Math.random() < (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "crusher_num_titane")) / input_titane) {
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount((int) (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, BlockPos.containing(x, y, z), 2) + output_titane));
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("crusher_num_titane", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( sucess ) ( titane ) ( custom on )"));
					}
				} else {
					if (1 <= new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "crusher_num_titane")) {
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
							if (_ent != null) {
								final int _slotid = 2;
								final ItemStack _setstack = new ItemStack(Blocks.DIRT).copy();
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, BlockPos.containing(x, y, z), 2) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("crusher_num_titane", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
							PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( failed ) ( titane ) (custom on )"));
						}
					}
				}
			}
		}
	}
}
