package palamod.procedures;

import palamod.PalamodMod;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class BackCommandProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject readmain = new com.google.gson.JsonObject();
		File backfile = new File("");
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		if (entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(2)) {
			xpos = x;
			ypos = y;
			zpos = z;
			backfile = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/back/"), File.separator + (entity.getUUID().toString() + ".json"));
			if (backfile.exists()) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backfile));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						readmain = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						{
							Entity _ent = entity;
							_ent.teleportTo(readmain.get("x_pos").getAsDouble(), readmain.get("y_pos").getAsDouble(), readmain.get("z_pos").getAsDouble());
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(readmain.get("x_pos").getAsDouble(), readmain.get("y_pos").getAsDouble(), readmain.get("z_pos").getAsDouble(), _ent.getYRot(), _ent.getXRot());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				main.addProperty("x_pos", xpos);
				main.addProperty("y_pos", ypos);
				main.addProperty("z_pos", zpos);
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(backfile);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
				PalamodMod.LOGGER.info((((((Component.translatable("palamod.procedure.back.logontp").getString()).replace("%4", "" + zpos)).replace("%3", "" + ypos)).replace("%2", "" + xpos)).replace("%1", entity.getDisplayName().getString())));
				MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.back.tp").getString());
			}
		}
	}
}