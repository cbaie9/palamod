package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class HomeinfoprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double cycle_loop = 0;
		double lvl = 0;
		File home = new File("");
		File jobs = new File("");
		home = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\home\\" + entity.getUUID().toString()), File.separator + (StringArgumentType.getString(arguments, "home_name") + ".json"));
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
					if (main.has("home_x") && main.has("home_y") && main.has("home_z")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @p [\"\",{\"text\":\"----------------------\\n \\u0020 \\u0020 \",\"color\":\"dark_green\"},{\"text\":\"home : " + "" + StringArgumentType.getString(arguments, "home_name")
											+ "\",\"color\":\"gold\"},{\"text\":\"\\n\"},{\"text\":\"x : \",\"color\":\"dark_green\"},{\"text\":\"" + main.get("home_x").getAsDouble()
											+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"y : \",\"color\":\"dark_green\"},{\"text\":\"" + main.get("home_y").getAsDouble()
											+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"z : \",\"color\":\"dark_green\"},{\"text\":\"" + main.get("home_z").getAsDouble()
											+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\\n\"},{\"text\":\"----------------------\",\"color\":\"dark_green\"}]"));
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
