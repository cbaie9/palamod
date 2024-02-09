package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class DeathposValueProcedure {
	public static String execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		double ypos = 0;
		double xpos = 0;
		double zpos = 0;
		xpos = x;
		ypos = y;
		zpos = z;
		entity.getPersistentData().putDouble("death_pos_x", x);
		entity.getPersistentData().putDouble("death_pos_y", y);
		entity.getPersistentData().putDouble("death_pos_z", z);
		return "Death position = x : " + xpos + "y :" + ypos + "z : " + zpos;
	}
}
