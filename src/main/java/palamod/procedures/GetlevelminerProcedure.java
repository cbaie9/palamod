package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetlevelminerProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		if (!IsgameserversideProcedure.execute()) {
			jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\jobs\\" + entity.getUUID().toString()),
					File.separator + "jobs.json");
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
						jobs_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						lvl = jobs_main.get("lvl_miner").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			lvl = 101;
		}
		return Component.translatable("palamod.procedure.jobsgetlvl").getString() + "" + Math.round(lvl);
	}
}
