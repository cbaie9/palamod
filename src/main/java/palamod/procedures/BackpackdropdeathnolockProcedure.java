package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class BackpackdropdeathnolockProcedure {
	public static void execute(LevelAccessor world, Entity entity, double slot_num) {
		if (entity == null)
			return;
		double ifull_backup = 0;
		double i2 = 0;
		double i = 0;
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack = new File("");
		File backpack_paladium = new File("");
		File backpack_backup = new File("");
		com.google.gson.JsonObject main_backpaclk1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack2 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack3 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack4 = new com.google.gson.JsonObject();
		backpack = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_1.json");
		backpack_titane = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_2.json");
		backpack_paladium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_3.json");
		backpack_endium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_4.json");
		backpack_backup = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backup.json");
		if (backpack.exists()) {
			i2 = slot_num;
			i = 0;
			if (i2 >= 0) {
				for (int index0 = 0; index0 < 9; index0++) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get((int) i).getItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(getAmountInGUISlot(entity, (int) i));
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
					i = i + 1;
				}
			}
			if (i2 >= 9) {
				for (int index1 = 0; index1 < 18; index1++) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get((int) i).getItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(getAmountInGUISlot(entity, (int) i));
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
					i = i + 1;
				}
			}
			if (i2 >= 27) {
				for (int index2 = 0; index2 < 18; index2++) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get((int) i).getItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(getAmountInGUISlot(entity, (int) i));
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
					i = i + 1;
				}
			}
			if (i2 >= 55) {
				for (int index3 = 0; index3 < 18; index3++) {
					i = i + 1;
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get((int) i).getItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(getAmountInGUISlot(entity, (int) i));
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
				}
			}
			BackpackcreatefileProcedure.execute(world, entity);
			main_backpack4.addProperty("noSave", true);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack_backup);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack4));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PalamodModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}