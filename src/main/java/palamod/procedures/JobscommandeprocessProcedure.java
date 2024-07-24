package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class JobscommandeprocessProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double lvl = 0;
		File jobs = new File("");
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
					if (1 == DoubleArgumentType.getDouble(arguments, "jobs")) {
						if (BoolArgumentType.getBool(arguments, "set")) {
							main.addProperty("lvl_miner", (DoubleArgumentType.getDouble(arguments, "num")));
						} else {
							main.addProperty("lvl_miner", (main.get("lvl_miner").getAsDouble() + DoubleArgumentType.getDouble(arguments, "num")));
						}
					} else if (2 == DoubleArgumentType.getDouble(arguments, "jobs")) {
						if (BoolArgumentType.getBool(arguments, "set")) {
							main.addProperty("lvl_farmer", (DoubleArgumentType.getDouble(arguments, "num")));
						} else {
							main.addProperty("lvl_farmer", (main.get("lvl_farmer").getAsDouble() + DoubleArgumentType.getDouble(arguments, "num")));
						}
					} else if (3 == DoubleArgumentType.getDouble(arguments, "jobs")) {
						if (BoolArgumentType.getBool(arguments, "set")) {
							main.addProperty("lvl_hunter", (DoubleArgumentType.getDouble(arguments, "num")));
						} else {
							main.addProperty("lvl_hunter", (main.get("lvl_hunter").getAsDouble() + DoubleArgumentType.getDouble(arguments, "num")));
						}
					} else if (4 == DoubleArgumentType.getDouble(arguments, "jobs")) {
						if (BoolArgumentType.getBool(arguments, "set")) {
							main.addProperty("lvl_alchi", (DoubleArgumentType.getDouble(arguments, "num")));
						} else {
							main.addProperty("lvl_alchi", (main.get("lvl_alchi").getAsDouble() + DoubleArgumentType.getDouble(arguments, "num")));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
