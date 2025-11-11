package palamod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class DownloaderprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (getBlockNBTString(world, BlockPos.containing(x, y, z), "downloader_linked_account_uuid") + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "downloader_filter") && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "downloader_state")
						&& getBlockNBTLogic(world, BlockPos.containing(x, y, z), "downloader_linked")) {
					if (main.get("money").getAsDouble() >= StockedbaseadminshopbuyProcedure.execute(world, x, y, z)
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 64
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem())) {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).copy();
							_setstack.setCount(1 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount());
							_itemHandlerModifiable.setStackInSlot(1, _setstack);
						}
						main.addProperty("money", (main.get("money").getAsDouble() - StockedbaseadminshopbuyProcedure.execute(world, x, y, z)));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putBoolean("Has_money", true);
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
								_blockEntity.getPersistentData().putBoolean("Has_money", false);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(money);
				fileWriter.write(mainGSONBuilderVariable.toJson(main));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
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