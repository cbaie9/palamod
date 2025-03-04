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

public class Clickergetnump2Procedure {
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
					input = main_clicker_buildings.get(("building_p" + Math.round(PalamodModVariables.MapVariables.get(world).clicker_page) + "_n2")).getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (int index0 = 0; index0 < 10; index0++) {
				if (9 >= input) {
					break;
				} else {
					input = input - 10;
					continue;
				}
			}
			if (0 == input) {
				exit = 0;
			} else if (1 == input) {
				exit = 1;
			} else if (2 == input) {
				exit = 2;
			} else if (3 == input) {
				exit = 3;
			} else if (4 == input) {
				exit = 4;
			} else if (5 == input) {
				exit = 5;
			} else if (6 == input) {
				exit = 6;
			} else if (7 == input) {
				exit = 7;
			} else if (8 == input) {
				exit = 8;
			} else if (9 == input) {
				exit = 9;
			} else {
				exit = 10;
			}
		}
		return exit;
	}
}
