package palamod.procedures;

public class MineralflowerBoneMealSuccessConditionProcedure {
	public static boolean execute() {
		if (Math.random() < 0.3) {
			return true;
		}
		return false;
	}
}
