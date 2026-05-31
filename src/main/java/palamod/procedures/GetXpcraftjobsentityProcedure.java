package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.monster.spider.CaveSpider;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetXpcraftjobsentityProcedure {
	public static double execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		double output = 0;
		double lvl = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		jobs = GetjobsfileProcedure.execute(sourceentity);
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					jobs_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = jobs_main.get("lvl_miner").getAsDouble();
					lvl_farmer = jobs_main.get("lvl_farmer").getAsDouble();
					lvl_hunter = jobs_main.get("lvl_hunter").getAsDouble();
					lvl_alchi = jobs_main.get("lvl_alchi").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			PalamodMod.LOGGER.info(((entity instanceof Pig) + " " + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()));
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
		}
		PalamodMod.LOGGER.info(("[Palamod] [GetXpCraftJobs] return : " + output + " | " + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()));
		return output;
	}
}