package palamod.procedures;

public class DbgetneededBlockForPotgProcedure {
	public static double execute(double level_potg) {
		double input_level = 0;
		double output = 0;
		input_level = level_potg;
		if (input_level < 0) {
			input_level = Math.abs(input_level);
		}
		if (input_level > 20) {
			input_level = 20;
		}
		output = 100;
		if (input_level > 1) {
			for (int _i1 = 0; _i1 < (int) (input_level - 1); _i1++) {
				output = Math.round(output * 1.5);
			}
		}
		return output;
	}
}