package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class GetxpalchibreakblockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static double execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static double execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return 0;
		double output = 0;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = GetjobsfileProcedure.execute(world, x, y, z, entity);
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
				lvl = main.get("lvl_alchi").getAsDouble();
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.OSTRYA_WOOD_WOOD.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.OSTRYA_WOOD_LOG.get())
						&& lvl >= 50) {
					output = 50;
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JACARANDA_LOG.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JACARANDA_WOOD.get()) {
					output = 10;
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JUDEECERCIS_WOOD.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JUDEECERCIS_LOG.get()) {
					output = 10;
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ERABLE_LOG.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ERABLE_WOOD.get()) {
					output = 10;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return output;
	}
}