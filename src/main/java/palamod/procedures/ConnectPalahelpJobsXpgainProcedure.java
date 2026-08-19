package palamod.procedures;

import palamod.world.inventory.*;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class ConnectPalahelpJobsXpgainProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double mode = 0;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof PalahelpJobsMenu || entity instanceof Player _plr1 && _plr1.containerMenu instanceof JobsfarmerguiMenu) {
			mode = 1;
		} else if (entity instanceof Player _plr2 && _plr2.containerMenu instanceof JobsminerguiMenu) {
			mode = 2;
		} else if (entity instanceof Player _plr3 && _plr3.containerMenu instanceof JobshunterguiMenu) {
			mode = 3;
		} else if (entity instanceof Player _plr4 && _plr4.containerMenu instanceof JobsalchiguiMenu) {
			mode = 4;
		} else {
			mode = 1;
		}
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("PalahelpJobsxpgain");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new PalahelpJobsxpgainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (mode == 1) {
			LoadFarmerGrowPalahelpJobsXpGainProcedure.execute(entity);
		} else if (mode == 2) {
			LoadMinerMinePalahelpJobsXpGainProcedure.execute(entity);
		} else if (mode == 3) {
			LoadHunterKillPalahelpJobsXpGainProcedure.execute(entity);
		} else if (mode == 4) {
			LoadAlchiCraftPalahelpJobsXpGainProcedure.execute(entity);
		}
	}
}