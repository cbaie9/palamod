package palamod.procedures;

import java.util.Calendar;

public class GetcustomunixProcedure {
	public static double execute() {
		return parseDouble(Calendar.getInstance().get(Calendar.YEAR) + "" + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
				+ Calendar.getInstance().get(Calendar.MINUTE) + Calendar.getInstance().get(Calendar.SECOND));
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}