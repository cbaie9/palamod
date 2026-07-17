package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class ReadHomeFolderProcedure {
	public static File execute(Entity entity, String home_name) {
		if (entity == null || home_name == null)
			return new File("");
		return new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/home/" + entity.getStringUUID()), File.separator + (home_name + ".json"));
	}
}