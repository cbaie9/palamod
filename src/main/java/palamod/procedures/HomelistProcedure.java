package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
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
		File home = new File("");
		String folder = "";
		double cycle_loop = 0;
		double lvl = 0;
		folder = FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/home/" + entity.getUUID().toString();
		if (!("null").equals(folder)) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Home list\",\"color\":\"dark_green\"}]");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\"}]");
			{
				File dir_files_ = new File(folder);
				if (dir_files_.isDirectory())
					for (File file : dir_files_.listFiles()) {
						String stringiterator = file.getPath();
						home = new File(stringiterator);
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
								if (main.has("deleted")) {
									if (!main.get("deleted").getAsBoolean()) {
										cycle_loop = cycle_loop + 1;
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("tellraw @p [\"\",{\"text\":\"Home N\u00B0" + "" + Math.round(cycle_loop) + " - \\u0020\",\"color\":\"aqua\"},{\"text\":\"" + home.getName().replace(".json", "")
															+ " \\u0020 \\u0020\",\"color\":\"dark_green\"},{\"text\":\"[TP]\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home " + home.getName().replace(".json", "")
															+ "\"}},{\"text\":\" \",\"color\":\"gold\"},{\"text\":\"[INFO]\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home info "
															+ home.getName().replace(".json", "")
															+ "\"}},{\"text\":\" \",\"color\":\"gold\"},{\"text\":\"[DELETE]\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/delhome "
															+ home.getName().replace(".json", "") + "\"}}]"));
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [{\"text\":\"" + "" + Math.round(cycle_loop) + "\",\"color\":\"dark_green\"},{\"text\":\" were home found\",\"color\":\"aqua\"},{\"text\":\"\"}]"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\"}]");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"An exepected error has happened, please report this to Palamod Renew developper\",\"color\":\"dark_green\"},{\"text\":\"\"}]");
		}
	}
}