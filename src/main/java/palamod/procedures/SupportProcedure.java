package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SupportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"[ Palamod Renew ]\",\"color\":\"dark_red\"},{\"text\":\"\\n\"},{\"text\":\"Support du mod : \",\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Clicker pour les lien\"}},{\"text\":\"\\n\"},{\"text\":\"Discord\",\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/dVvNDrQENA\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"( la o\u00F9 y'a les maj )\"}},{\"text\":\" \\n\"},{\"text\":\"Github\",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/cbaie9/palamod18\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"( oui le projet est open source )\"}},{\"text\":\" \",\"color\":\"aqua\"}]");
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("v3.2.2___1.19cat"), false);
	}
}
