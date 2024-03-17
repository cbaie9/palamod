package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class WorldtickcooldownProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main_jobs = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				main_jobs = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (0 < main_jobs.get("xpstreak_time_miner").getAsDouble()) {
					main_jobs.addProperty("xpstreak_time_miner", (main_jobs.get("xpstreak_time_miner").getAsDouble() - 1));
				} else {
					main_jobs.addProperty("xpstreak_miner", 0);
				}
				if (0 < main_jobs.get("xpstreak_time_farmer").getAsDouble()) {
					main_jobs.addProperty("xpstreak_time_farmer", (main_jobs.get("xpstreak_time_farmer").getAsDouble() - 1));
				} else {
					main_jobs.addProperty("xpstreak_farmer", 0);
				}
				if (0 < main_jobs.get("xpstreak_time_hunter").getAsDouble()) {
					main_jobs.addProperty("xpstreak_time_hunter", (main_jobs.get("xpstreak_time_hunter").getAsDouble() - 1));
				} else {
					main_jobs.addProperty("xpstreak_hunter", 0);
				}
				if (0 < main_jobs.get("xpstreak_time_alchi").getAsDouble()) {
					main_jobs.addProperty("xpstreak_time_alchi", (main_jobs.get("xpstreak_time_alchi").getAsDouble() - 1));
				} else {
					main_jobs.addProperty("xpstreak_alchi", 0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
