package palamod.procedures;

import palamod.init.PalamodModMobEffects;
import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class RecalcJobsXpBaseMultiplierProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double base = 0;
		double actual_multi_exp = 0;
		jobs = GetjobsfileProcedure.execute(entity);
		base = (world instanceof ServerLevel _serverLevelGR0 ? _serverLevelGR0.getGameRules().getInt(PalamodModGameRules.JOBS_XP_BASE_MULTIPLIER) : 0) / 100d;
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PalamodModMobEffects.MULTIEXP_2)) {
			base = base * 2;
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PalamodModMobEffects.MULTIEXP_10)) {
			base = base * 10;
		}
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
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					actual_multi_exp = main.get("multi_exp").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (actual_multi_exp != base) {
				main.addProperty("multi_exp", base);
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jobs);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}