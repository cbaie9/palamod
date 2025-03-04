package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Clickergetdizp5Procedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		File clicker_buildings = new File("");
		com.google.gson.JsonObject main_clicker_buildings = new com.google.gson.JsonObject();
		double exit = 0;
		double input = 0;
		clicker_buildings = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
				File.separator + "clicker_build.json");
		if (clicker_buildings.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(clicker_buildings));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_clicker_buildings = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					input = main_clicker_buildings.get(("building_p" + Math.round(PalamodModVariables.MapVariables.get(world).clicker_page) + "_n5")).getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (9 >= input && 0 <= input) {
				exit = 0;
			} else if (19 >= input && 10 <= input) {
				exit = 1;
			} else if (29 >= input && 20 <= input) {
				exit = 2;
			} else if (39 >= input && 30 <= input) {
				exit = 3;
			} else if (49 >= input && 40 <= input) {
				exit = 4;
			} else if (59 >= input && 50 <= input) {
				exit = 5;
			} else if (69 >= input && 60 <= input) {
				exit = 6;
			} else if (79 >= input && 70 <= input) {
				exit = 7;
			} else if (89 >= input && 80 <= input) {
				exit = 8;
			} else if (99 >= input && 90 <= input) {
				exit = 9;
			} else {
				exit = 10;
			}
		}
		return exit;
	}
}
