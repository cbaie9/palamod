package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MsgtellrawautosendspecialselectorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, String selecteur, String text) {
		if (selecteur == null || text == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					(("tellraw %1 [\"\",{\"text\":\"[ Bem ]\",\"color\":\"light_purple\"},{\"text\":\" : %2\",\"color\":\"white\"}]".replace("%2", text)).replace("%1", selecteur)));
	}
}