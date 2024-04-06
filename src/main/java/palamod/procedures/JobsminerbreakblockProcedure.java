package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class JobsminerbreakblockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject jobs_main2 = new com.google.gson.JsonObject();
		boolean logic1 = false;
		boolean logic2 = false;
		double xp = 0;
		double time = 0;
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				jobs_main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (world.dayTime() > jobs_main.get("xpstreak_time_miner").getAsDouble()) {
					logic1 = true;
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE) {
					logic2 = true;
					xp = jobs_main2.get("xpstreak_miner").getAsDouble();
					time = jobs_main2.get("xp_miner").getAsDouble();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (logic1) {
			jobs_main2.addProperty("xpstreak_miner", 0);
		}
		if (logic2) {
			jobs_main2.addProperty("xp_miner", (0.5 + time));
			jobs_main2.addProperty("xpstreak_miner", (0.5 + xp));
			jobs_main2.addProperty("xpstreak_time_miner", (world.dayTime() + 80));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + (0.5 + xp) + Component.translatable("palamod.procedure.jobswin2").getString() + " " + Blocks.STONE)), true);
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(jobs);
				fileWriter.write(mainGSONBuilderVariable.toJson(jobs_main2));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
