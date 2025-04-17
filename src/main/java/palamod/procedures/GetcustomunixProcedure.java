package palamod.procedures;

import org.checkerframework.checker.units.qual.s;

import java.util.Calendar;

public class GetcustomunixProcedure {
	public static double execute() {
		return new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(Calendar.getInstance().get(Calendar.YEAR) + "" + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
				+ Calendar.getInstance().get(Calendar.MINUTE) + Calendar.getInstance().get(Calendar.SECOND));
	}
}
