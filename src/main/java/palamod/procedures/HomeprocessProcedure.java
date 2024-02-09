package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class HomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double cycle_loop = 0;
		if (entity.getPersistentData().getBoolean((StringArgumentType.getString(arguments, "home_name"))) == true) {
			if (BoolArgumentType.getBool(arguments, "old_version")) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "x"))),
							(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "y"))),
							(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "z"))));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "x"))),
								(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "y"))),
								(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "z"))), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You have been teleported to your home " + "" + StringArgumentType.getString(arguments, "home_name") + "\",\"color\":\"gold\"}]"));
			} else {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_x"))),
							(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))),
							(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_z"))));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_x"))),
								(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))),
								(entity.getPersistentData().getDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_z"))), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You have been teleported to your home " + "" + StringArgumentType.getString(arguments, "home_name") + "\",\"color\":\"gold\"}]"));
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home " + "" + StringArgumentType.getString(arguments, "home_name")
								+ " witch you tried to teleported doesn't exist or has been deleted\",\"color\":\"gold\"}]"));
		}
	}
}
