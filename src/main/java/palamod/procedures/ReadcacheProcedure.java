package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class ReadcacheProcedure {
	public static File execute(Entity entity) {
		if (entity == null)
			return new File("");
		File cache = new File("");
		return new File((FMLPaths.GAMEDIR.get().toString() + "\\caches\\jobs\\" + entity.getUUID().toString()), File.separator + "cache_jobs.json");
	}
}
