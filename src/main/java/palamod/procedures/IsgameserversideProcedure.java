package palamod.procedures;

import net.neoforged.fml.loading.FMLEnvironment;

public class IsgameserversideProcedure {
	public static boolean execute() {
		boolean exit = false;
		boolean debug = false;
		return FMLEnvironment.getDist().isDedicatedServer();
	}
}