package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ResetXpStreakProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = GetjobsfileProcedure.execute(entity);
		if (jobs.exists() && !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
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
					main.addProperty("xpstreak_miner", 0);
					main.addProperty("xpstreak_farmer", 0);
					main.addProperty("xpstreak_hunter", 0);
					main.addProperty("xpstreak_alchi", 0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			PalamodMod.LOGGER.debug(("[ResetXpStreak] Reseted Xp streak for %1".replace("%1", entity.getDisplayName().getString())));
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