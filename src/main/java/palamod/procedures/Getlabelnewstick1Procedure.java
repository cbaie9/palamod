package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class Getlabelnewstick1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("mode_stick") == 1) {
			return Component.translatable("palamod.palahelp_stick_speed").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 2) {
			return Component.translatable("palamod.palahelp_stick_jump").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 3) {
			return Component.translatable("palamod.palahelp_stick_hyper_speed").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 4) {
			return Component.translatable("palamod.palahelp_stick_heal").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 5) {
			return Component.translatable("palamod.palahelp_stick_damage").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 6) {
			return Component.translatable("palamod.palahelp_stick_strenght").getString();
		} else if (entity.getPersistentData().getDouble("mode_stick") == 7) {
			return "Stick of gods : Give speed V for 3 secondes, strenght, saturation and \\nregenation";
		}
		return Component.translatable("palamod.palahelp_stick_oob").getString();
	}
}