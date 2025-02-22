package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class JobsfarmergetxpprogressbarProcedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double nextlvl_xp = 0;
		double xp_miner = 0;
		double output = 0;
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
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
					xp_miner = main.get("xp_farmer").getAsDouble();
					nextlvl_xp = main.get("next_level_farmer").getAsDouble();
					output = Math.round((main.get("xp_farmer").getAsDouble() / main.get("next_level_farmer").getAsDouble()) * 100);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			output = 50;
		}
		return output;
	}
}
