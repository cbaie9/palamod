package palamod.procedures;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AdhmobsbuyslimeballProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
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
		}.convert(guistate.containsKey("text:number_buy") ? ((EditBox) guistate.get("text:number_buy")).getValue() : "")));
		fac_v = 8;
		item = new ItemStack(Items.SLIME_BALL);
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
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " tried to bought 0 " + item.getDisplayName().getString()));
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
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
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
