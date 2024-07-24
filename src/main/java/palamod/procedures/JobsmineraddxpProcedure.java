package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class JobsmineraddxpProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double xp = 0;
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
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					xp = main.get("xp_miner").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			main.addProperty("xp_miner", (xp + DoubleArgumentType.getDouble(arguments, "num")));
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
