package palamod.procedures;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import java.io.File;

public class AdshoppreviewamountbaseProcedure {
	public static String execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
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
		}.convert(guistate.containsKey("text:number_buy") ? ((EditBox) guistate.get("text:number_buy")).getValue() : "")));
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
			return "Amount : buy :" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString()))) * fac_v + " / sell : " + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString()))) * n2;
		}
		return "Amount : insert number in the bar";
	}
}
