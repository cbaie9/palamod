package palamod.procedures;

import palamod.network.PalamodModVariables;

public class GetgolempvleveltreeProcedure {
	public static String execute() {
		return "Golem level : " + PalamodModVariables.Golem_level + " Golem pv : " + PalamodModVariables.Golem_pv;
	}
}
