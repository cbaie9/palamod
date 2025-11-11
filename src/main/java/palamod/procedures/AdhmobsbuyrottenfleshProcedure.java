package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AdhmobsbuyrottenfleshProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double n = 0;
		double fac_v = 0;
		ItemStack item = ItemStack.EMPTY;
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		n = Math.round(Math.abs(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number_buy", "") : "")));
		fac_v = 1;
		item = new ItemStack(Items.ROTTEN_FLESH).copy();
		main = new Object() {
			public com.google.gson.JsonObject parse(String rawJson) {
				try {
					return new com.google.gson.Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
				} catch (Exception e) {
					PalamodMod.LOGGER.error(e);
					return new com.google.gson.Gson().fromJson("{}", com.google.gson.JsonObject.class);
				}
			}
		}.parse("{}");
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (0 == n) {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You cannot bought nothing put a number greater than 0 to continue"), false);
					if (world instanceof ServerLevel _serverLevelGR7 && _serverLevelGR7.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " tried to bought 0  " + item.getDisplayName().getString()));
					}
				}
				if (n * fac_v <= main.get("money").getAsDouble()) {
					main.addProperty("money", (main.get("money").getAsDouble() - n * fac_v));
					if (entity instanceof Player _player) {
						ItemStack _setstack = item.copy();
						_setstack.setCount((int) n);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You succesfuly bought " + n + " " + item.getDisplayName().getString() + " for a total of " + n * fac_v + " $")), false);
					if (world instanceof ServerLevel _serverLevelGR18 && _serverLevelGR18.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " bought " + n + " " + item.getDisplayName().getString() + " for a total of " + n * fac_v + " $"));
					}
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (1 < n) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You don't enough money to buy these items"), false);
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You don't enough money to buy this item"), false);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(money);
				fileWriter.write(mainGSONBuilderVariable.toJson(main));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}