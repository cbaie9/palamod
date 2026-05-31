package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CreateMoneyFileProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File money = new File("");
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		money = ReadMoneyFileProcedure.execute(entity);
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.DISABLEMONEYGAMERULE.get())) && !money.exists()) {
			try {
				money.getParentFile().mkdirs();
				money.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			money_main.addProperty("money", 0);
			money_main.addProperty("player_name", (entity.getDisplayName().getString()));
			money_main.addProperty("formatVer", 1);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					money_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (!money_main.has("formatVer")) {
						PalamodMod.LOGGER.info("Upgrade money file format to v1");
						money_main.addProperty("player_name", (entity.getDisplayName().getString()));
						money_main.addProperty("formatVer", 1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}