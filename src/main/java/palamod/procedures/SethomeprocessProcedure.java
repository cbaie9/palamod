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

public class SethomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("number_home", (entity.getPersistentData().getDouble("number_home") + 1));
		entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_x"), x);
		entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_y"), y);
		entity.getPersistentData().putDouble(("home_" + StringArgumentType.getString(arguments, "home_name") + "_z"), z);
		entity.getPersistentData().putDouble(("home_id_" + StringArgumentType.getString(arguments, "home_name")), (entity.getPersistentData().getDouble("number_home")));
		entity.getPersistentData().putBoolean((StringArgumentType.getString(arguments, "home_name")), true);
		entity.getPersistentData().putString(("home_name_" + entity.getPersistentData().getDouble("number_home")), (StringArgumentType.getString(arguments, "home_name")));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The home " + "" + StringArgumentType.getString(arguments, "home_name")
							+ " has been created at your position\",\"color\":\"gold\"},{\"text\":\"\\n \"}]"));
	}
}
