package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Removemultixp2fileProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
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
					main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					main.addProperty("multi_exp", (main.get("multi_exp").getAsDouble() / 2));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
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
