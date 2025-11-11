package palamod.procedures;

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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Crusherv2paladiumcustomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
		double input_paladium = 0;
		double output_paladium = 0;
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
					main_obj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					input_paladium = main_obj.get("Crusher-paladium-input").getAsDouble();
					output_paladium = main_obj.get("Crusher-paladium-output").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") >= input_paladium) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + output_paladium));
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("crusher_num_paladium", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _serverLevelGR12 && _serverLevelGR12.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( paladium ) ( custom on )"));
				}
			} else {
				if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") / input_paladium) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + output_paladium));
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("crusher_num_paladium", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ServerLevel _serverLevelGR18 && _serverLevelGR18.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( sucess ) ( paladium ) ( custom on )"));
					}
				} else {
					if (1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium")) {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(Blocks.DIRT).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(2, _setstack);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("crusher_num_paladium", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ServerLevel _serverLevelGR24 && _serverLevelGR24.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
							PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( failed ) ( palamod )  ( custom on )"));
						}
					}
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
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}