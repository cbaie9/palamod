package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class BacklogOnCustomTpProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File backfile = new File("");
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		xpos = x;
		ypos = y;
		zpos = z;
		backfile = GetBackLogFileProcedure.execute(entity);
		if (!backfile.exists()) {
			try {
				backfile.getParentFile().mkdirs();
				backfile.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		main.addProperty("x_pos", xpos);
		main.addProperty("y_pos", ypos);
		main.addProperty("z_pos", zpos);
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(backfile);
				fileWriter.write(mainGSONBuilderVariable.toJson(main));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		PalamodMod.LOGGER.info((((((Component.translatable("palamod.procedure.back.logontp").getString()).replace("%4", "" + zpos)).replace("%3", "" + ypos)).replace("%2", "" + xpos)).replace("%1", entity.getDisplayName().getString())
				+ "- source custom tp service"));
	}
}