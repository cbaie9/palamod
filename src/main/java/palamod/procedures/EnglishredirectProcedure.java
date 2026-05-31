package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class EnglishredirectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("language", "english");
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("The language of the palamod has been changed to english "), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("Due to the game, the langauge is has been only changed to this world, and will be reset on next lunch"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("To change for all world :"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("Type Win+r  : %appdata%\\.minecraft\\config"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("and search for a file name Palamod _client_settings.toml"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("Finally change the language variable to english or french ( only other supported language )"), false);
	}
}