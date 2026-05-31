package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SethomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File home = new File("");
		home = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/home/" + entity.getUUID().toString()), File.separator + (StringArgumentType.getString(arguments, "home_name") + ".json"));
		if (home.exists()) {
			main.addProperty("home_x", x);
			main.addProperty("home_y", y);
			main.addProperty("home_z", z);
			main.addProperty("deleted", false);
			main.addProperty("dim_id", ("" + entity.level().dimension()));
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(home);
					fileWriter.write(mainGSONBuilderVariable.toJson(main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home " + "" + StringArgumentType.getString(arguments, "home_name")
								+ " has been created at your position\",\"color\":\"gold\"},{\"text\":\"\\n \"}]"));
			if (world instanceof ServerLevel _serverLevelGR14 && _serverLevelGR14.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.debug((((((((Component.translatable("palamod.procedure.home.run").getString()).replace("%6", "" + entity.level().dimension())).replace("%5", "" + z)).replace("%4", "" + y)).replace("%3", "" + x)).replace("%2",
						"'" + StringArgumentType.getString(arguments, "home_name") + "'")).replace("%1", entity.getDisplayName().getString())));
			}
		} else {
			try {
				home.getParentFile().mkdirs();
				home.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Creating a file for saving home " + StringArgumentType.getString(arguments, "home_name") + ". . .")), false);
			if (world instanceof ServerLevel _serverLevelGR23 && _serverLevelGR23.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.debug(((((Component.translatable("palamod.procedure.home.createfile").getString()).replace("%3", entity.getDisplayName().getString())).replace("%2", "'" + StringArgumentType.getString(arguments, "home_name") + "'"))
						.replace("%1", "'" + home.getPath() + "'")));
			}
			SethomeprocessProcedure.execute(world, x, y, z, arguments, entity);
		}
	}
}