package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class LastunlockedminerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (main.has("last_unlocked_type")) {
						if (!(1 != main.get("last_unlocked_type").getAsDouble())) {
							if (100 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Endium pickaxe";
									_vars.syncPlayerVariables(entity);
								}
							} else if (95 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "God villager";
									_vars.syncPlayerVariables(entity);
								}
							} else if (56 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Paladium Forge";
									_vars.syncPlayerVariables(entity);
								}
							} else if (50 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Xp Bottle";
									_vars.syncPlayerVariables(entity);
								}
							} else if (37 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Dollars Stone";
									_vars.syncPlayerVariables(entity);
								}
							} else if (30 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Voidstone Minage";
									_vars.syncPlayerVariables(entity);
								}
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
