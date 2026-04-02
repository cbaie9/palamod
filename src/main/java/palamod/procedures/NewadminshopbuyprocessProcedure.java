package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
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

public class NewadminshopbuyprocessProcedure {
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
		item = AdminshopgetitemProcedure.execute(entity).copy();
		fac_v = StockedbaseadminshopbuyProcedure.execute(item);
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
				if (n * fac_v <= main.get("money").getAsDouble() && !(0 == n)) {
					main.addProperty("money", (main.get("money").getAsDouble() - n * fac_v));
					if (entity instanceof Player _player) {
						ItemStack _setstack = item.copy();
						_setstack.setCount((int) n);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								(Component.translatable("palamod.adminshop_buy_1").getString() + " " + n + " " + item.getDisplayName().getString() + " " + Component.translatable("palamod.adminshop_buy_2").getString() + " " + n * fac_v + " $")),
								false);
					if (world instanceof ServerLevel _serverLevelGR14 && _serverLevelGR14.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " " + Component.translatable("palamod.adminshop_buy_3").getString() + " " + n + " " + item.getDisplayName().getString() + " "
								+ Component.translatable("palamod.adminshop_buy_2").getString() + " " + n * fac_v + " $"));
					}
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (0 == n) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("palamod.adminshop_logs0_player").getString())), false);
						if (world instanceof ServerLevel _serverLevelGR23 && _serverLevelGR23.getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
							PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " " + Component.translatable("palamod.adminshop_logs0").getString() + " " + item.getDisplayName().getString()));
						}
					} else {
						if (1 < n) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((Component.translatable("palamod.adminshop_buy_4").getString())), false);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((Component.translatable("palamod.adminshop_buy_5").getString())), false);
						}
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