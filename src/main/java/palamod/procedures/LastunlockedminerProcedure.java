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
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
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
							} else if (74 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Sponge Tnt";
									_vars.syncPlayerVariables(entity);
								}
							} else if (65 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Paladium excavator";
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
							} else if (48 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Wither Tnt";
									_vars.syncPlayerVariables(entity);
								}
							} else if (45 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Titane excavator";
									_vars.syncPlayerVariables(entity);
								}
							} else if (44 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Slime Obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (42 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Sulfuric obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (39 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Lava obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (37 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Dollars Stone";
									_vars.syncPlayerVariables(entity);
								}
							} else if (34 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "All spike types";
									_vars.syncPlayerVariables(entity);
								}
							} else if (30 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Voidstone Minage";
									_vars.syncPlayerVariables(entity);
								}
							} else if (25 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Cobblebreaker";
									_vars.syncPlayerVariables(entity);
								}
							} else if (23 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Mega boom obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (22 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Compact obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (18 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Tnt compact";
									_vars.syncPlayerVariables(entity);
								}
							} else if (15 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Boom obsidian";
									_vars.syncPlayerVariables(entity);
								}
							} else if (12 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "/nether";
									_vars.syncPlayerVariables(entity);
								}
							} else if (10 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Cave block";
									_vars.syncPlayerVariables(entity);
								}
							} else if (5 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Amethyst excavator";
									_vars.syncPlayerVariables(entity);
								}
							} else if (3 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Voidstone";
									_vars.syncPlayerVariables(entity);
								}
							} else if (1 <= main.get("lvl_miner").getAsDouble()) {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Pickaxe of the gods";
									_vars.syncPlayerVariables(entity);
								}
							} else {
								{
									PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
									_vars.last_unlocked_miner = "Go farm";
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
		return entity.getData(PalamodModVariables.PLAYER_VARIABLES).last_unlocked_miner;
	}
}
