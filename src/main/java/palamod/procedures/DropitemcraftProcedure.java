package palamod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;
import java.util.Map;

public class DropitemcraftProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double idrop = 0;
		for (int index0 = 0; index0 < 9; index0++) {
			if (!(getAmountInGUISlot(entity, (int) idrop) == 0)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) idrop)).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(getAmountInGUISlot(entity, (int) idrop));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("dropped :" + idrop)), false);
			}
			idrop = idrop + 1;
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
