package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class Clear1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(1).remove(1);
			_menu.getSlots().get(2).remove(1);
			_menu.getSlots().get(3).remove(1);
			_menu.getSlots().get(4).remove(1);
			_menu.getSlots().get(5).remove(1);
			_menu.getSlots().get(6).remove(1);
			_menu.getSlots().get(7).remove(1);
			_player.containerMenu.broadcastChanges();
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(8).remove(1);
			_menu.getSlots().get(9).remove(1);
			_player.containerMenu.broadcastChanges();
		}
	}
}