package palamod.procedures;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class OrelayershowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
		boolean boo = false;
		return entity.getPersistentData().getBoolean("orelayer");
	}
}