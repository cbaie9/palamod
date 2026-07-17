package palamod.procedures;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.CommandEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@EventBusSubscriber
public class BacklogOntpProcedure {
	@SubscribeEvent
	public static void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			execute(event, entity.getX(), entity.getY(), entity.getZ(), entity, event.getParseResults().getReader().getString());
		}
	}

	public static void execute(double x, double y, double z, Entity entity, String command) {
		execute(null, x, y, z, entity, command);
	}

	private static void execute(@Nullable Event event, double x, double y, double z, Entity entity, String command) {
		if (entity == null || command == null)
			return;
		File backfile = new File("");
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		if (command.contains("tp")) {
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
			PalamodMod.LOGGER.info(
					(((((Component.translatable("palamod.procedure.back.logontp").getString()).replace("%4", "" + zpos)).replace("%3", "" + ypos)).replace("%2", "" + xpos)).replace("%1", entity.getDisplayName().getString()) + "- source backlogtp"));
		}
	}
}