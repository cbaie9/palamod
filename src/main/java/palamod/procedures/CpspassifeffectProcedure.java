package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class CpspassifeffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject main_clicker = new com.google.gson.JsonObject();
		double coin = 0;
		double cps = 0;
		boolean abort = false;
		if (IsgameclientsideProcedure.execute()) {
			if (0 == PalamodModVariables.MapVariables.get(world).cps_cooldown) {
				jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
						+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
						File.separator + "clicker_info.json");
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
							main_clicker = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							if ((main_clicker.get("coin").isJsonPrimitive() ? main_clicker.get("coin").getAsJsonPrimitive().isNumber() : false)
									&& (main_clicker.get("cps").isJsonPrimitive() ? main_clicker.get("cps").getAsJsonPrimitive().isNumber() : false)) {
								coin = main_clicker.get("coin").getAsDouble();
								cps = main_clicker.get("cps").getAsDouble();
								PalamodModVariables.MapVariables.get(world).cps_cooldown = 20;
								PalamodModVariables.MapVariables.get(world).syncData(world);
							} else {
								PalamodModVariables.MapVariables.get(world).cps_cooldown = 20;
								PalamodModVariables.MapVariables.get(world).syncData(world);
								abort = true;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (!abort) {
						main_clicker.addProperty("coin", (coin + cps));
						{
							com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(jobs);
								fileWriter.write(mainGSONBuilderVariable.toJson(main_clicker));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
					}
				}
			}
			if (0 < PalamodModVariables.MapVariables.get(world).cps_cooldown) {
				PalamodModVariables.MapVariables.get(world).cps_cooldown = PalamodModVariables.MapVariables.get(world).cps_cooldown - 1;
				PalamodModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
