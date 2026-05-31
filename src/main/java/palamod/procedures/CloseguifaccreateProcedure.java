package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class CloseguifaccreateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (parseDouble(PalamodModVariables.faction_create_ing) > 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack.setCount((int) parseDouble(PalamodModVariables.faction_create_ing));
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
		} else if ((PalamodModVariables.faction_create_ing).equals("You can now create the faction")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack.setCount(100);
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
		}
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal(("[ Palamod ] La faction" + entity.getPersistentData().getStringOr("temp_fact_name", "") + "n'a pas pus \u00EAtre creer")), true);
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}