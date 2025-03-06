package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class XpberryprocessProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.giveExperiencePoints(10);
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
	}
}
