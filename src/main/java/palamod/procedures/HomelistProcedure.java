package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class HomelistProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double cycle_loop = 0;
		cycle_loop = cycle_loop + 1;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Home list\",\"color\":\"dark_green\"},{\"text\":\"\\n\"},{\"text\":\"" + "" + Math.round(entity.getPersistentData().getDouble("number_home"))
							+ "\",\"color\":\"dark_green\"},{\"text\":\" were home found\",\"color\":\"aqua\"},{\"text\":\"\\n \"}]"));
		for (int index0 = 0; index0 < (int) entity.getPersistentData().getDouble("number_home"); index0++) {
			if (("home_name_" + cycle_loop).equals("[deleted_home_open]") || ("home_name_" + cycle_loop).equals("[deleted_home_request]")) {
				cycle_loop = cycle_loop + 1;
				continue;
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"Home n\u00B0" + "" + Math.round(cycle_loop) + " - \",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home "
								+ entity.getPersistentData().getString(("home_name_" + cycle_loop)) + "\"}},{\"text\":\"" + entity.getPersistentData().getString(("home_name_" + cycle_loop))
								+ "\",\"color\":\"dark_green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home " + entity.getPersistentData().getString(("home_name_" + cycle_loop)) + "\"}}]"));
			cycle_loop = cycle_loop + 1;
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
	}
}
