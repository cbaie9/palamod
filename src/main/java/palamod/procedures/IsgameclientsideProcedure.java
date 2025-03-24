package palamod.procedures;

import net.neoforged.fml.loading.FMLEnvironment;

public class IsgameclientsideProcedure {
	public static boolean execute() {
		boolean exit = false;
		boolean debug = false;
		if (FMLEnvironment.dist.isDedicatedServer()) {
			exit = false;
		} else if (FMLEnvironment.dist.isClient()) {
			exit = true;
		}
		return exit;
	}
}
