package palamod.procedures;

public class GetLevelPotgProcedure {
	public static double execute(double xppotg) {
		double output = 0;
		double xpneeded = 0;
		double input_xp = 0;
		input_xp = xppotg;
		output = 1;
		xpneeded = 100;
		for (int _i1 = 0; _i1 < 20; _i1++) {
			xpneeded = Math.round(xpneeded * 1.5);
			if (input_xp >= xpneeded) {
				output = output + 1;
			} else {
				break;
			}
		}
		return output;
	}
}