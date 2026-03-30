package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Crushertextad4Procedure {
	public static boolean execute() {
		File file = new File("");
		double output = 0;
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
					output = main_obj.get("Crusher-amethyst-input").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (32 != output) {
			return true;
		}
		return false;
	}
<<<<<<< Updated upstream
=======

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
>>>>>>> Stashed changes
}