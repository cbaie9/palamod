package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.function.Supplier;
import java.util.Map;

public class DropitemcraftProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double idrop = 0;
		for (int index0 = 0; index0 < 9; index0++) {
			for (int index1 = 0; index1 < new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount((int) idrop); index1++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) idrop)).getItem() : ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			idrop = idrop + 1;
		}
	}
}
