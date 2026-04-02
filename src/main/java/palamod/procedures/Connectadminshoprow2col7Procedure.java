package palamod.procedures;

import palamod.world.inventory.NewAdminshopguiMenu;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class Connectadminshoprow2col7Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rownum = 0;
		double num_connect = 0;
		rownum = 6;
		num_connect = rownum + ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "slider", 0.0) : 0.0);
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("NewAdminshopgui");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new NewAdminshopguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (num_connect == 0) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.STONE.asItem()).toString()));
		} else if (num_connect == 1) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.COAL).toString()));
		} else if (num_connect == 2) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.OAK_LOG.asItem()).toString()));
		} else if (num_connect == 3) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.ENDER_PEARL).toString()));
		} else if (num_connect == 4) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.COOKED_BEEF).toString()));
		} else if (num_connect == 5) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.REDSTONE).toString()));
		} else if (num_connect == 6) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.SUGAR_CANE.asItem()).toString()));
		} else if (num_connect == 7) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.GRASS_BLOCK.asItem()).toString()));
		} else if (num_connect == 8) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.BLACKSTONE.asItem()).toString()));
		} else if (num_connect == 9) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.POTATO).toString()));
		} else if (num_connect == 10) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.WHEAT).toString()));
		} else if (num_connect == 11) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Blocks.BROWN_MUSHROOM.asItem()).toString()));
		} else if (num_connect == 12) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.STRING).toString()));
		} else if (num_connect == 13) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.SPIDER_EYE).toString()));
		} else if (num_connect == 14) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.WITHER_SKELETON_SKULL).toString()));
		} else if (num_connect == 15) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(Items.GLOW_INK_SAC).toString()));
		} else if (num_connect == 16) {
			entity.getPersistentData().putString("mode_adminshop", (BuiltInRegistries.ITEM.getKey(PalamodModItems.DISC_ANTI_FUZE.get()).toString()));
		}
	}
}