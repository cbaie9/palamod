package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import java.io.File;

public class ReadBalltopProcedure {
	public static File execute() {
		return new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/balltop/"), File.separator + "balltop.json");
	}
}