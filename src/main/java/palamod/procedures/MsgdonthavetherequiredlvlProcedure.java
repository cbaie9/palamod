package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MsgdonthavetherequiredlvlProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"[ \",\"color\":\"dark_red\"},{\"text\":\"Palamod\",\"color\":\"gold\"},{\"text\":\" ]\",\"color\":\"dark_red\"},{\"text\":\" :\",\"color\":\"white\"},{\"text\":\" You don't have the required jobs level do that action, refer the jobs craft gui to know the exact level \",\"color\":\"#FF5800\"},{\"text\":\" \"}]");
		if (entity.hasPermissions(2)) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"[ \",\"color\":\"dark_red\"},{\"text\":\"Palamod\",\"color\":\"gold\"},{\"text\":\" ]\",\"color\":\"dark_red\"},{\"text\":\" ->\",\"color\":\"green\"},{\"text\":\" [ \",\"color\":\"dark_blue\"},{\"text\":\"hint\",\"color\":\"aqua\"},{\"text\":\" ]\",\"color\":\"dark_blue\"},{\"text\":\" : \"},{\"text\":\"you seem to be an operator on this server, \",\"color\":\"#FF5E00\"},{\"text\":\"change the gamerule \\\"Locked_use\\\" to allow everyone to use the items without retriction \",\"color\":\"#FF5E00\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/gamerule lockeduse false\"}},{\"text\":\" \"}]");
		}
	}
}
