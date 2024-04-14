package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class GetxpminerProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double xp_miner = 0;
		double nextlvl_xp = 0;
		String output = "";
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
					main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					xp_miner = main.get("xp_miner").getAsDouble();
					nextlvl_xp = main.get("next_level_miner").getAsDouble();
					output = Math.round(main.get("xp_miner").getAsDouble()) + " / " + Math.round(main.get("next_level_miner").getAsDouble());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			output = "conf Error : file does not exist";
		}
		return output;
	}
}
