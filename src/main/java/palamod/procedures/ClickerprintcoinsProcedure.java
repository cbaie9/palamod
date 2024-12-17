package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ClickerprintcoinsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		double lvl = 0;
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
				main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				lvl = main.get("coin").getAsDouble();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "" + lvl;
	}
}
