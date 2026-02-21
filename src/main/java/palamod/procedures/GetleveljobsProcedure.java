package palamod.procedures;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetleveljobsProcedure {
	public static double execute(Entity entity, String jobs_name) {
		if (entity == null || jobs_name == null)
			return 0;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		jobs = GetjobsfileProcedure.execute(entity);
		if (jobs.exists() && ((jobs_name).equals("miner") || (jobs_name).equals("farmer") || (jobs_name).equals("hunter") || (jobs_name).equals("alchi"))) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					jobs_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = jobs_main.get(("lvl_" + jobs_name)).getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return Math.round(lvl);
		} else {
			lvl = -1;
		}
		return lvl;
	}
}