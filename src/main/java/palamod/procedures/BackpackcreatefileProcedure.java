package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class BackpackcreatefileProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack = new File("");
		File backpack_paladium = new File("");
		File backpack_backup = new File("");
		com.google.gson.JsonObject main_backpack_ame = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_titane = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_pala = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_endium = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_backup = new com.google.gson.JsonObject();
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
		try {
			backpack.getParentFile().mkdirs();
			backpack.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		try {
			backpack_titane.getParentFile().mkdirs();
			backpack_titane.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		try {
			backpack_paladium.getParentFile().mkdirs();
			backpack_paladium.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		try {
			backpack_endium.getParentFile().mkdirs();
			backpack_endium.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		try {
			backpack_backup.getParentFile().mkdirs();
			backpack_backup.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		for (int index0 = 0; index0 < 81; index0++) {
			if (i >= 0 && i <= 8) {
				main_backpack_ame.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
				main_backpack_ame.addProperty(("backpack_num_" + i), 0);
				main_backpack_backup.addProperty("backpack_backup1", 0);
			} else if (i >= 9 && i <= 26) {
				main_backpack_titane.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
				main_backpack_titane.addProperty(("backpack_num_" + i), 0);
				main_backpack_backup.addProperty("backpack_backup2", 0);
			} else if (i >= 27 && i <= 54) {
				main_backpack_pala.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
				main_backpack_pala.addProperty(("backpack_num_" + i), 0);
				main_backpack_backup.addProperty("backpack_backup3", 0);
			} else if (i >= 55 && i <= 80) {
				main_backpack_endium.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
				main_backpack_endium.addProperty(("backpack_num_" + i), 0);
				main_backpack_backup.addProperty("backpack_backup4", 0);
			}
			i = i + 1;
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backpack);
				fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_ame));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backpack_titane);
				fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_titane));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backpack_paladium);
				fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_pala));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backpack_endium);
				fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_endium));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backpack_backup);
				fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_backup));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
