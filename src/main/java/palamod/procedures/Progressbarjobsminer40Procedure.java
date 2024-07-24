package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Progressbarjobsminer40Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File file = new File("");
		File jobs = new File("");
		double nlm = 0;
		double xp = 0;
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
					xp = main.get("xp_miner").getAsDouble();
					nlm = main.get("next_level_miner").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (xp > 0.39 * nlm && xp <= 0.4 * nlm) {
				return true;
			}
		}
		return false;
	}
}
