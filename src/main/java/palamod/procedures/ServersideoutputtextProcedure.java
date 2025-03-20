package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ServersideoutputtextProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("This is server side game, this commande only exist to avoid crash for file system, creating a text output that command can detect, and return appropriet path for the file"), false);
	}
}
