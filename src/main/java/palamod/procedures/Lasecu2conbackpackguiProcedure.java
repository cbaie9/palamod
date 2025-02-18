package palamod.procedures;

import palamod.world.inventory.BackpacktitaneMenu;
import palamod.world.inventory.BackpackpaladiumMenu;
import palamod.world.inventory.BackpackendiumMenu;
import palamod.world.inventory.BackpackamethystguiMenu;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Lasecu2conbackpackguiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof BackpackamethystguiMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_BACKPACK.get())
				|| entity instanceof Player _plr3 && _plr3.containerMenu instanceof BackpacktitaneMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_BACKPACK.get())
				|| entity instanceof Player _plr6 && _plr6.containerMenu instanceof BackpackpaladiumMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADUM_BACKPACK.get())
				|| entity instanceof Player _plr9 && _plr9.containerMenu instanceof BackpackendiumMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_BACKPACK.get())) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
