package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetnextlevelxpProcedure {
	public static double execute(LevelAccessor world, Entity entity, double jobs_id) {
		if (entity == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double output = 0;
		double lvl = 0;
		String jobs_str = "";
		if (jobs_id == 1) {
			jobs_str = "miner";
		} else if (jobs_id == 2) {
			jobs_str = "farmer";
		} else if (jobs_id == 3) {
			jobs_str = "hunter";
		} else {
			jobs_str = "alchi";
		}
		jobs = GetjobsfileProcedure.execute(entity);
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
					lvl = main.get(("lvl_" + jobs_str)).getAsDouble() + 1;
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.JOBS_LEVEL_BASE)) {/*true=lv sur 100*/
						if (0 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 9 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(435.6292733199 * lvl, 1.30951646);
						} else if (10 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 14 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(171.2616392443 * lvl, 1.7688843774);
						} else if (15 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 19 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(121.6760052337 * lvl, 1.8976294404);
						} else if (20 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 29 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(88.4059273476 * lvl, 2.0044827636);
						} else if (30 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 39 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(67.1551422088 * lvl, 2.0862726528);
						} else if (40 <= main.get(("lvl_" + jobs_str)).getAsDouble() && 49 >= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(56.7868999727 * lvl, 2.1320486715);
						} else if (50 <= main.get(("lvl_" + jobs_str)).getAsDouble()) {
							output = Math.pow(45.0822595645 * lvl, 2.19000911781);
						}
					} else {/*false=lv sur 20*/
						output = -0.0726 * Math.pow(lvl, 5) + 2.8895 * Math.pow(lvl, 4) + 32.403 * Math.pow(lvl, 3) + 5886.4 * Math.pow(lvl, 2) + 1944.3 * lvl + 13715;
						PalamodMod.LOGGER.debug(("getnextlevel:output:" + output + " - Level actuelle - " + lvl));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output * ((world.getLevelData().getGameRules().getInt(PalamodModGameRules.BASE_JOB_LEVEL_MULTIPLIER)) / 1000d);
	}
}