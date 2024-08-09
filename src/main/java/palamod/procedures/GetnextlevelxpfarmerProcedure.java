package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetnextlevelxpfarmerProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double output = 0;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = main.get("lvl_farmer").getAsDouble() + 1;
					if (0 <= main.get("lvl_farmer").getAsDouble() && 9 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(435.6292733199 * lvl, 1.30951646);
					} else if (10 <= main.get("lvl_farmer").getAsDouble() && 14 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(171.2616392443 * lvl, 1.7688843774);
					} else if (15 <= main.get("lvl_farmer").getAsDouble() && 19 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(121.6760052337 * lvl, 1.8976294404);
					} else if (20 <= main.get("lvl_farmer").getAsDouble() && 29 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(88.4059273476 * lvl, 2.0044827636);
					} else if (30 <= main.get("lvl_farmer").getAsDouble() && 39 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(67.1551422088 * lvl, 2.0862726528);
					} else if (40 <= main.get("lvl_farmer").getAsDouble() && 49 >= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(56.7868999727 * lvl, 2.1320486715);
					} else if (50 <= main.get("lvl_farmer").getAsDouble()) {
						output = Math.pow(45.0822595645 * lvl, 2.19000911781);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}
