package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class GenerateBalltopProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.neoforged.neoforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		com.google.gson.JsonObject active_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject balltop_main = new com.google.gson.JsonObject();
		double n4m = 0;
		double n5m = 0;
		double n2m = 0;
		double n3m = 0;
		double n1m = 0;
		double active_money = 0;
		String n2pn = "";
		String n3pn = "";
		String n1pn = "";
		String active_player = "";
		String n4pn = "";
		String n5pn = "";
		String money_folder_path = "";
		File active_file = new File("");
		File balltop = new File("");
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.DISABLEMONEYGAMERULE.get()))) {
			n1m = -1;
			n2m = -1;
			n3m = -1;
			n4m = -1;
			n5m = -1;
			n1pn = "|Player|";
			n2pn = "|Player|";
			n3pn = "|Player|";
			n4pn = "|Player|";
			n5pn = "|Player|";
			money_folder_path = ReadMoneyFolderProcedure.execute();
			balltop = ReadBalltopProcedure.execute();
			{
				File dir_files_ = new File(money_folder_path);
				if (dir_files_.isDirectory())
					for (File file : dir_files_.listFiles()) {
						String stringiterator = file.getPath();
						active_player = "player_name";
						PalamodMod.LOGGER.info(stringiterator);
						active_money = 0;
						active_file = new File(stringiterator);
						{
							try {
								BufferedReader bufferedReader = new BufferedReader(new FileReader(active_file));
								StringBuilder jsonstringbuilder = new StringBuilder();
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									jsonstringbuilder.append(line);
								}
								bufferedReader.close();
								active_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								if (active_main.has("formatVer")) {
									active_money = active_main.get("money").getAsDouble();
									active_player = active_main.get("player_name").getAsString();
									if (active_money > n1m) {
										n5m = n4m;
										n5pn = n4pn;
										n4m = n3m;
										n4pn = n3pn;
										n3m = n2m;
										n3pn = n2pn;
										n2m = n1m;
										n2pn = n1pn;
										n1m = active_money;
										n1pn = active_player;
									} else if (active_money > n2m) {
										n5m = n4m;
										n5pn = n4pn;
										n4m = n3m;
										n4pn = n3pn;
										n3m = n2m;
										n3pn = n2pn;
										n2m = active_money;
										n2pn = active_player;
									} else if (active_money > n3m) {
										n5m = n4m;
										n5pn = n4pn;
										n4m = n3m;
										n4pn = n3pn;
										n3m = active_money;
										n3pn = active_player;
									} else if (active_money > n4m) {
										n5m = n4m;
										n5pn = n4pn;
										n4m = active_money;
										n4pn = active_player;
									} else if (active_money > n5m) {
										n5m = active_money;
										n5pn = active_player;
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
			}
			if (!balltop.exists()) {
				try {
					balltop.getParentFile().mkdirs();
					balltop.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			balltop_main.addProperty("n1money", n1m);
			balltop_main.addProperty("n1player", n1pn);
			balltop_main.addProperty("n2money", n2m);
			balltop_main.addProperty("n2player", n2pn);
			balltop_main.addProperty("n3money", n3m);
			balltop_main.addProperty("n3player", n3pn);
			balltop_main.addProperty("n4money", n4m);
			balltop_main.addProperty("n4player", n4pn);
			balltop_main.addProperty("n5money", n5m);
			balltop_main.addProperty("n5player", n5pn);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(balltop);
					fileWriter.write(mainGSONBuilderVariable.toJson(balltop_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}