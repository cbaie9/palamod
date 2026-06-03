package palamod.procedures;

import net.neoforged.fml.loading.FMLEnvironment;

public class IsgameclientsideProcedure {
	public static boolean execute() {
		return !FMLEnvironment.getDist().isDedicatedServer();
	}
}