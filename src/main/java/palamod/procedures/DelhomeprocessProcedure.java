package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class DelhomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double id = 0;
		if (entity.getPersistentData().getBoolean((StringArgumentType.getString(arguments, "home_name"))) == true) {
			entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "x"), 0);
			entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "y"), 256);
			entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "z"), 0);
			entity.getPersistentData().putBoolean((StringArgumentType.getString(arguments, "home_name")), false);
			if (entity.getPersistentData().getDouble(("number_id_" + StringArgumentType.getString(arguments, "home_name"))) == entity.getPersistentData().getDouble("number_home")) {
				entity.getPersistentData().putString(("home_name_" + entity.getPersistentData().getDouble(("number_id_" + StringArgumentType.getString(arguments, "home_name")))), "[deleted_home_open]");
				entity.getPersistentData().putDouble("number_home", (entity.getPersistentData().getDouble("number_home") - 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home has been deleted\",\"color\":\"gold\"}]");
			} else {
				entity.getPersistentData().putString(("home_name_" + entity.getPersistentData().getDouble(("number_id_" + StringArgumentType.getString(arguments, "home_name")))), "[deleted_home_request]");
				entity.getPersistentData().putDouble(("home_id_" + StringArgumentType.getString(arguments, "home_name")), (-1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home has been deleted\",\"color\":\"gold\"}]");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home you've tried to delete doesn't exist\",\"color\":\"gold\"},{\"text\":\"\\n \"}]");
		}
	}
}
