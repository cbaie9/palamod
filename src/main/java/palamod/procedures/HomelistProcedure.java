package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class HomelistProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double cycle_loop = 0;
		double lvl = 0;
		File home = new File("");
		File jobs = new File("");
		home = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/home/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (home.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(home));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					cycle_loop = cycle_loop + 1;
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Home list\",\"color\":\"dark_green\"},{\"text\":\"\\n\"},{\"text\":\"" + "" + Math.round(main.get("number_home").getAsDouble())
										+ "\",\"color\":\"dark_green\"},{\"text\":\" were home found\",\"color\":\"aqua\"},{\"text\":\"\\n \"}]"));
					for (int index0 = 0; index0 < (int) (main.get("number_home").getAsDouble() + 1); index0++) {
						if (main.has(("home_name_" + cycle_loop))) {
							if ((main.get(("home_name_" + cycle_loop)).getAsString()).equals("[deleted_home_open]") || (main.get(("home_name_" + cycle_loop)).getAsString()).equals("[deleted_home_request]")) {
								cycle_loop = cycle_loop + 1;
								continue;
							}
						} else {
							cycle_loop = cycle_loop + 1;
							continue;
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @p [\"\",{\"text\":\"Home n\u00B0" + "" + Math.round(cycle_loop) + " - \",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home "
											+ main.get(("home_name_" + cycle_loop)).getAsString() + "\"}},{\"text\":\"" + main.get(("home_name_" + cycle_loop)).getAsString()
											+ "\",\"color\":\"dark_green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home " + main.get(("home_name_" + cycle_loop)).getAsString() + "\"}}]"));
						cycle_loop = cycle_loop + 1;
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
