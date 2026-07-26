package palamod.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PaladiumFurnacetakeitemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		CraftGiveXpJobsProcedure.execute(world, entity, itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy(), "smelt");
		if (entity instanceof Player _player)
			_player.giveExperiencePoints((int) (2 * amount));
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}