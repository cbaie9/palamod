package palamod.procedures;

import palamod.init.PalamodModMenus;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AdminshoppreviewProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double n2 = 0;
		double fac_v = 0;
		double buy = 0;
		double n = 0;
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		String buy_out = "";
		String output = "";
		fac_v = StockedbaseadminshopbuyProcedure.execute(AdminshopgetitemProcedure.execute(world, entity));
		n2 = StockedbaseadminshopsellProcedure.execute(AdminshopgetitemProcedure.execute(world, entity));
		n = Math.round(Math.abs(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number_buy", "") : "")));
		buy = n * fac_v;
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (money.exists()) {
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
					if (buy > main.get("money").getAsDouble()) {
						buy_out = Component.translatable("palamod.adminshop.preview_not_enough_money").getString();
					} else {
						buy_out = "" + Math.round(buy);
					}
					if (n != 0) {
						output = Component.translatable("palamod.adminshop.preview_1").getString() + " " + buy_out + " / " + Component.translatable("palamod.adminshop.preview_2").getString() + " : " + Math.round(n2 * n);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			output = Component.translatable("palamod.adminshop.preview_base").getString();
		}
		return output;
	}
}