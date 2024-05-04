package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@Mod.EventBusSubscriber
public class OpenModProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file = new File("");
		File file2 = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main2 = new com.google.gson.JsonObject();
		file2 = new File((FMLPaths.GAMEDIR.get().toString() + "/config/palamod/"), File.separator + "palamod-configuration-client.json");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/defaultconfig/"), File.separator + "palamod-configuration-custom.json");
		if (!file2.exists()) {
			try {
				file2.getParentFile().mkdirs();
				file2.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			main2.addProperty("Devmod", false);
			main2.addProperty("language", "english");
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file2);
					fileWriter.write(mainGSONBuilderVariable.toJson(main2));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			main.addProperty("Crusher-Custom", false);
			main.addProperty("Crusher-amethyst-input", 32);
			main.addProperty("Crusher-titane-input", 32);
			main.addProperty("Crusher-paladium-input", 64);
			main.addProperty("Crusher-endium-input", 128);
			main.addProperty("Crusher-amethyst-output", 5);
			main.addProperty("Crusher-titane-output", 15);
			main.addProperty("Crusher-paladium-output", 15);
			main.addProperty("Crusher-endium-output", 1);
			main.addProperty("Grinder-Custom", false);
			main.addProperty("Grinder-Capacity", 100);
			main.addProperty("Grinder-loading_time1", 4);
			main.addProperty("Grinder-loading_time2", 10);
			main.addProperty("Grinder-loading_time3", 10);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
