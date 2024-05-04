package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class OpenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File money = new File("");
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (!jobs.exists()) {
			try {
				jobs.getParentFile().mkdirs();
				jobs.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			main.addProperty("next_level_miner", 50);
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
