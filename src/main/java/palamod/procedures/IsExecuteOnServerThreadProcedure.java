
package palamod.procedures;

import net.minecraft.world.level.Level;

public class IsExecuteOnServerThreadProcedure {
	public static boolean execute(Level world) {
		if (!world.isClientSide()) {
			return true;
		}
		return false;
	}
}