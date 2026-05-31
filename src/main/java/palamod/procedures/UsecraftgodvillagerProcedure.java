package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UsecraftgodvillagerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (PalamodModItems.ENDIUM_NUGGET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem()) {
			PalamodMod.LOGGER.info("use craft");
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[limit=1,sort=arbitrary,distance=0..10,type=palamod:godvillager]");
		}
	}
}