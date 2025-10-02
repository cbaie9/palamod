package palamod.procedures;

import palamod.init.PalamodModMenus;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.io.File;

public class AdshoppreviewamountbaseProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ItemStack item = ItemStack.EMPTY;
		double fac_v = 0;
		double n = 0;
		double n2 = 0;
		double lvl = 0;
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		fac_v = 1;
		n2 = 1;
		n = Math.round(Math.abs(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number_buy", "") : "")));
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
		if (n != 0) {
			return "Amount : buy :" + getBlockNBTNumber(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString())) * fac_v + " / sell : "
					+ getBlockNBTNumber(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString())) * n2;
		}
		return "Amount : insert number in the bar";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}