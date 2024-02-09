package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ChunkgetnumProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean pos_x = false;
		boolean pos_z = false;
		String chunk = "";
		if (0 < x) {
			pos_x = true;
		} else {
			pos_x = false;
		}
		if (0 < z) {
			pos_z = true;
		} else {
			pos_z = false;
		}
		chunk = "r X " + Math.floor(x / 16) + " Y " + Math.floor(y / 16) + " Z " + Math.floor(z / 16);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(chunk), false);
	}
}
