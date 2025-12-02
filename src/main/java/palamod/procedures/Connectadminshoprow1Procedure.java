package palamod.procedures;

import palamod.world.inventory.NewAdminshopguiMenu;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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

public class Connectadminshoprow1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rownum = 0;
		double num_connect = 0;
		rownum = 0;
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
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(PalamodModItems.PALADIUM_INGOT.get()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(PalamodModItems.TITANE_INGOT.get()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 2) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(PalamodModItems.AMETHYST.get()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 3) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Items.DIAMOND).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 4) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 5) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 6) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Items.SLIME_BALL).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 7) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Blocks.DIRT.asItem()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 8) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Blocks.GRAVEL.asItem()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 9) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Blocks.CACTUS.asItem()).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (num_connect == 10) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString(("mode_adminshop_" + entity.getUUID().toString()), (BuiltInRegistries.ITEM.getKey(Items.MELON_SLICE).toString()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}