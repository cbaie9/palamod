package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class DeleteallProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PalamodModVariables.PlayerVariables())).buyslot == 0) {
			{
				double _setval = 1;
				entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.buyslot = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(0)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(20, () -> {
				{
					double _setval = 0;
					entity.getCapability(PalamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.buyslot = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
