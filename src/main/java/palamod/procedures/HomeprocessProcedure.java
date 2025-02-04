package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class HomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
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
					if (main.has((StringArgumentType.getString(arguments, "home_name")))) {
						{
							Entity _ent = entity;
							_ent.teleportTo(main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_x")).getAsDouble(), main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_y")).getAsDouble(),
									main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_z")).getAsDouble());
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_x")).getAsDouble(),
										main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_y")).getAsDouble(), main.get(("home_" + StringArgumentType.getString(arguments, "home_name") + "_z")).getAsDouble(), _ent.getYRot(),
										_ent.getXRot());
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You have been teleported to your home " + "" + StringArgumentType.getString(arguments, "home_name") + "\",\"color\":\"gold\"}]"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home " + "" + StringArgumentType.getString(arguments, "home_name")
											+ " witch you tried to teleported doesn't exist or has been deleted\",\"color\":\"gold\"}]"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
