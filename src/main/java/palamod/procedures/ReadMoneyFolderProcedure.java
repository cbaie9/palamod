package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

public class ReadMoneyFolderProcedure {
	public static String execute() {
		return FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/";
	}
}