package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CrushercustominfopaladiumProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		double output = 0;
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/defaultconfig/"), File.separator + "palamod-configuration-custom.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_obj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					output = main_obj.get("Crusher-paladium-input").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
<<<<<<< Updated upstream
		return getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") + " / " + output;
=======
		if (world instanceof ServerLevel _serverLevelGR7 && _serverLevelGR7.getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
			return getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") + " / " + output + " - " + (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") / output) * 100 + "%";
		}
		return (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_paladium") / output) * 100 + "%";
>>>>>>> Stashed changes
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}