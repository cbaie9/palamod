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

public class LastunlockedgetspriteProcedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double output = 0;
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
					if (100 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Endium pickaxe";
							_vars.syncPlayerVariables(entity);
						}
						output = 24;
					} else if (95 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "God villager";
							_vars.syncPlayerVariables(entity);
						}
						output = 23;
					} else if (74 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Sponge Tnt";
							_vars.syncPlayerVariables(entity);
						}
						output = 22;
					} else if (65 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Paladium excavator";
							_vars.syncPlayerVariables(entity);
						}
						output = 21;
					} else if (56 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Paladium Forge";
							_vars.syncPlayerVariables(entity);
						}
						output = 20;
					} else if (50 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Xp Bottle";
							_vars.syncPlayerVariables(entity);
						}
						output = 19;
					} else if (48 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Wither Tnt";
							_vars.syncPlayerVariables(entity);
						}
						output = 18;
					} else if (45 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Titane excavator";
							_vars.syncPlayerVariables(entity);
						}
						output = 17;
					} else if (44 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Slime Obsidian";
							_vars.syncPlayerVariables(entity);
						}
						output = 16;
					} else if (42 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Sulfuric obsidian";
							_vars.syncPlayerVariables(entity);
						}
						output = 15;
					} else if (39 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Lava obsidian";
							_vars.syncPlayerVariables(entity);
						}
						output = 14;
					} else if (37 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Dollars Stone";
							_vars.syncPlayerVariables(entity);
						}
						output = 13;
					} else if (34 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "All spike types";
							_vars.syncPlayerVariables(entity);
						}
						output = 12;
					} else if (30 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Voidstone Minage";
							_vars.syncPlayerVariables(entity);
						}
						output = 11;
					} else if (25 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Cobblebreaker";
							_vars.syncPlayerVariables(entity);
						}
						output = 10;
					} else if (23 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Mega boom obsidian";
							_vars.syncPlayerVariables(entity);
						}
						output = 9;
					} else if (22 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Compact obsidian";
							_vars.syncPlayerVariables(entity);
						}
						output = 8;
					} else if (18 <= main.get("lvl_miner").getAsDouble()) {
						output = 7;
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
						output = 6;
					} else if (12 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "/nether";
							_vars.syncPlayerVariables(entity);
						}
						output = 5;
					} else if (10 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Cave block";
							_vars.syncPlayerVariables(entity);
						}
						output = 4;
					} else if (5 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Amethyst excavator";
							_vars.syncPlayerVariables(entity);
						}
						output = 3;
					} else if (3 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Voidstone";
							_vars.syncPlayerVariables(entity);
						}
						output = 2;
					} else if (1 <= main.get("lvl_miner").getAsDouble()) {
						{
							PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
							_vars.last_unlocked_miner = "Pickaxe of the gods";
							_vars.syncPlayerVariables(entity);
						}
						output = 1;
					} else {
						output = 0;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}
