package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

import java.io.File;

public class GetXpcraftjobsentityProcedure {
	public static double execute(Entity entity, double level_alchimist, double level_farmer, double level_hunter, double level_miner) {
		if (entity == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		double output = 0;
		double lvl = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		lvl = level_miner;
		lvl_farmer = level_farmer;
		lvl_hunter = level_hunter;
		lvl_alchi = level_alchimist;
		if (entity instanceof Cow || entity instanceof Chicken || entity instanceof Sheep || entity instanceof Pig || entity instanceof Rabbit || entity instanceof GlowSquid || entity instanceof Horse || entity instanceof Squid) {
			output = 14;
		} else if (entity instanceof Creeper) {
			output = 40;
		} else if (entity instanceof WitherBoss) {
			output = 1000;
		} else if (entity instanceof SnowGolem) {
			output = 1;
		} else if (entity instanceof Zombie && lvl_alchi >= 7) {
			output = 15;
		} else if (entity instanceof Skeleton && lvl_alchi >= 11) {
			output = 20;
		} else if (entity instanceof Spider && !(entity instanceof CaveSpider) && lvl_alchi >= 13) {
			output = 8;
		} else if (entity instanceof Blaze && lvl_alchi >= 14) {
			output = 25;
		} else if (entity instanceof Witch && lvl_alchi >= 14) {
			output = 8;
		} else if (entity instanceof CaveSpider && lvl_alchi >= 14) {
			output = 15;
		}
		PalamodMod.LOGGER.info(("[Palamod] [GetXpCraftJobs] return : " + output + " | " + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()));
		return output;
	}
}