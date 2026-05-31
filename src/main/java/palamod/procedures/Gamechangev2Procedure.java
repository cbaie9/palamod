package palamod.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class Gamechangev2Procedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "gamenumber") == 0 && !(entity instanceof Player _plr1 && _plr1.gameMode() == GameType.SURVIVAL)) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
		} else if (DoubleArgumentType.getDouble(arguments, "gamenumber") == 1 && !(entity instanceof Player _plr4 && _plr4.gameMode() == GameType.CREATIVE)) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
		} else if (DoubleArgumentType.getDouble(arguments, "gamenumber") == 2 && !(entity instanceof Player _plr7 && _plr7.gameMode() == GameType.ADVENTURE)) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
		} else if (DoubleArgumentType.getDouble(arguments, "gamenumber") == 3 && !(entity instanceof Player _plr10 && _plr10.gameMode() == GameType.SPECTATOR)) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
		}
	}
}