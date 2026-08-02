package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class ReadjobsserverProcedure {
	public static File execute(Entity entity) {
		if (entity == null)
			return new File("");
		File jobs = new File("");
		return new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/" + entity.getStringUUID()), File.separator + "jobs.json");
	}
}