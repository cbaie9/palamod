package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetalchibreakblocklogicProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		boolean output = false;
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
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
					lvl = main.get("lvl_alchi").getAsDouble();
					if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.OSTRYA_WOOD_WOOD.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.OSTRYA_WOOD_LOG.get())
							&& lvl >= 50) {
						output = true;
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JACARANDA_LOG.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JACARANDA_WOOD.get()) {
						output = true;
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JUDEECERCIS_WOOD.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.JUDEECERCIS_LOG.get()) {
						output = true;
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ERABLE_LOG.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ERABLE_WOOD.get()) {
						output = true;
					} else {
						output = false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}
