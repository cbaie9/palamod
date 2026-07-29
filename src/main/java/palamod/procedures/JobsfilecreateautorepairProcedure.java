package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class JobsfilecreateautorepairProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		File cache = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_cache = new com.google.gson.JsonObject();
		String jobs_name = "";
		double i = 0;
		PalamodMod.LOGGER.debug("[Palamod] [ Jobs File create autorepair ] Start procedure");
		if (!world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
			jobs = ReadjobsserverProcedure.execute(entity);
			cache = ReadcacheProcedure.execute(entity);
			if (!cache.exists()) {
				try {
					cache.getParentFile().mkdirs();
					cache.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				main.addProperty("last_block_state", (-1));
				main.addProperty("block", (BuiltInRegistries.BLOCK.getKey(Blocks.AIR).toString()));
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(cache);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			} else {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(cache));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_cache = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						if (!main_cache.has("last_block_state")) {
							main.addProperty("last_block_state", (-1));
						}
						if (!main_cache.has("block")) {
							main.addProperty("block", (BuiltInRegistries.BLOCK.getKey(Blocks.AIR).toString()));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(cache);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
			if (!jobs.exists()) {
				try {
					jobs.getParentFile().mkdirs();
					jobs.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				main.addProperty("multi_exp", ((world.getLevelData().getGameRules().getInt(PalamodModGameRules.JOBS_XP_BASE_MULTIPLIER)) / 100d));
				main.addProperty("next_level_miner", 480);
				main.addProperty("next_level_farmer", 480);
				main.addProperty("next_level_hunter", 480);
				main.addProperty("next_level_alchi", 480);
				main.addProperty("lvl_miner", 0);
				main.addProperty("lvl_farmer", 0);
				main.addProperty("lvl_hunter", 0);
				main.addProperty("lvl_alchi", 0);
				main.addProperty("xp_miner", 0);
				main.addProperty("xp_farmer", 0);
				main.addProperty("xp_hunter", 0);
				main.addProperty("xp_alchi", 0);
				main.addProperty("xpstreak_miner", 0);
				main.addProperty("xpstreak_time_miner", 0);
				main.addProperty("xpstreak_time_farmer", 0);
				main.addProperty("xpstreak_farmer", 0);
				main.addProperty("xpstreak_time_hunter", 0);
				main.addProperty("xpstreak_hunter", 0);
				main.addProperty("xpstreak_time_alchi", 0);
				main.addProperty("xpstreak_alchi", 0);
				main.addProperty("last_unlocked_lvl", 0);
				main.addProperty("last_unlocked_type", 0);
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jobs);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			} else {
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
						if (!main.has("multi_exp")) {
							main.addProperty("multi_exp", ((world.getLevelData().getGameRules().getInt(PalamodModGameRules.JOBS_XP_BASE_MULTIPLIER)) / 100d));
						}
						jobs_name = "miner";
						for (int index227 = 0; index227 < 4; index227++) {
							if (!main.has(("next_level_" + jobs_name))) {
								main.addProperty(("next_level_" + jobs_name), 480);
							}
							if (!main.has(("lvl_" + jobs_name))) {
								main.addProperty(("lvl_" + jobs_name), 0);
							}
							if (!main.has(("xp_" + jobs_name))) {
								main.addProperty(("xp_" + jobs_name), 0);
							}
							if (!main.has(("xpstreak_" + jobs_name))) {
								main.addProperty(("xpstreak_" + jobs_name), 0);
							}
							if (!main.has(("xpstreak_time_" + jobs_name))) {
								main.addProperty(("xpstreak_time_" + jobs_name), 0);
							}
							if (i == 0) {
								jobs_name = "farmer";
							} else if (i == 1) {
								jobs_name = "hunter";
							} else if (i == 2) {
								jobs_name = "alchi";
							}
							i = i + 1;
						}
						if (!main.has("last_unlocked_lvl")) {
							main.addProperty("last_unlocked_lvl", 0);
						}
						if (!main.has("last_unlocked_type")) {
							main.addProperty("last_unlocked_type", 0);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jobs);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}