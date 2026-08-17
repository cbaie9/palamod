package palamod.procedures;

public class GetFortuneBonusAmountProcedure {
	public static double execute(double input) {
		double output = 0;
		double fortune = 0;
		fortune = input;
		output = 1;
		if (fortune == 0) {
			output = 1;
		} else if (fortune == 1) {
			output = 1;
			if (Math.random() < 0.33) {
				output = output + 1;
			}
		} else if (fortune == 2) {
			output = 1;
			if (Math.random() < 0.5) {
				output = output + 1;
			} else {
				if (Math.random() < 0.25) {
					output = output + 2;
				} else {
					output = output + 3;
				}
			}
		} else if (fortune == 3) {
			output = 1;
			if (Math.random() < 0.4) {
				output = output + 1;
			} else {
				if (Math.random() < 0.2) {
					output = output + 2;
				} else if (Math.random() < 0.2) {
					output = output + 3;
				} else {
					output = output + 4;
				}
			}
		}
		return output;
	}
}