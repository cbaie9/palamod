package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class GetclickerfileProcedure {
	public static File execute(Entity entity) {
		if (entity == null)
			return new File("");
		File output = new File("");
		return new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/" + entity.getUUID().toString()), File.separator + "clicker_info.json");
	}
}