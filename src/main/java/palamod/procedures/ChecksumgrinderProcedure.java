package palamod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ChecksumgrinderProcedure {
	public static boolean execute(LevelAccessor world) {
		double output = 0;
		boolean valid = false;
		boolean crusher_valid = false;
		boolean Grinder_valid = false;
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/saves/" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "/serverconfig/"), File.separator + "palamod-configuration-custom.json");
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
					if (main_obj.get("Grinder-Custom").getAsBoolean()) {
						if (0 < main_obj.get("Grinder-Capacity").getAsDouble() && 0 < main_obj.get("Grinder-loading_time1").getAsDouble() && 0 < main_obj.get("Grinder-loading_time2").getAsDouble()
								&& 0 < main_obj.get("Grinder-loading_time3").getAsDouble()) {
							Grinder_valid = true;
						} else {
							Grinder_valid = false;
						}
					} else {
						valid = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (Grinder_valid || valid) {
			return true;
		}
		return false;
	}
}
