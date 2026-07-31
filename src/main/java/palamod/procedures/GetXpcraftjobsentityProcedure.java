package palamod.procedures;

import palamod.PalamodMod;

import java.io.File;

public class GetXpcraftjobsentityProcedure {
	public static double execute(double level_alchimist, double level_farmer, double level_hunter, double level_miner, String entity_registry) {
		if (entity_registry == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		double output = 0;
		double lvl = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		String entity_reg = "";
		String prefix = "";
		lvl = level_miner;
		lvl_farmer = level_farmer;
		lvl_hunter = level_hunter;
		lvl_alchi = level_alchimist;
		entity_reg = entity_registry;
		prefix = "minecraft:";
		if (!(prefix + "player").equals(entity_reg)) {
			if ((prefix + "cow").equals(entity_reg) || (prefix + "chicken").equals(entity_reg) || (prefix + "sheep").equals(entity_reg) || (prefix + "pig").equals(entity_reg) || (prefix + "rabbit").equals(entity_reg)
					|| (prefix + "glow_squid").equals(entity_reg) || (prefix + "horse").equals(entity_reg) || (prefix + "squid").equals(entity_reg)) {
				output = 14;
			} else if ((prefix + "creeper").equals(entity_reg)) {
				output = 40;
			} else if ((prefix + "wither").equals(entity_reg)) {
				output = 1000;
			} else if ((prefix + "snow_golem").equals(entity_reg)) {
				output = 1;
			} else if ((prefix + "zombie").equals(entity_reg) && lvl_hunter >= 7) {
				output = 15;
			} else if ((prefix + "skeleton").equals(entity_reg) && lvl_hunter >= 11) {
				output = 20;
			} else if ((prefix + "spider").equals(entity_reg) && lvl_hunter >= 13) {
				output = 8;
			} else if ((prefix + "blaze").equals(entity_reg) && lvl_hunter >= 14) {
				output = 25;
			} else if ((prefix + "witch").equals(entity_reg) && lvl_hunter >= 14) {
				output = 8;
			} else if ((prefix + "cave_spider").equals(entity_reg) && lvl_hunter >= 18) {
				output = 15;
			}
			PalamodMod.LOGGER.info(("[Palamod] [GetXpCraftJobs] return : " + output + " | " + entity_reg));
		}
		return output;
	}
}