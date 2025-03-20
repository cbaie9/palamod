package palamod.procedures;

import net.neoforged.fml.loading.FMLEnvironment;

public class IsgameserversideProcedure {
	public static boolean execute() {
		boolean exit = false;
		if (FMLEnvironment.dist.isDedicatedServer()) {
			exit = true;
		} else if (FMLEnvironment.dist.isClient()) {
			exit = false;
		}
		return exit;
	}
}
