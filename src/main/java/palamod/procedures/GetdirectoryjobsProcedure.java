package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.io.File;

public class GetdirectoryjobsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
							+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\jobs\\" + entity.getUUID().toString())),
					false);
	}
}
