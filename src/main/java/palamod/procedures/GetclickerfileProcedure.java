package palamod.procedures;

import palamod.PalamodMod;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.File;

public class GetclickerfileProcedure {
	public static File execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return new File("");
		File output = new File("");
		if (IsgameclientsideProcedure.execute(world, x, y, z)) {
			output = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
					File.separator + "clicker_info.json");
		} else if (IsgameserversideProcedure.execute()) {
			output = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/" + entity.getUUID().toString()), File.separator + "clicker_info.json");
		} else {
			PalamodMod.LOGGER.fatal("Palamod renew : NO CLICKER SAVE FILE FOUND");
		}
		return output;
	}
}