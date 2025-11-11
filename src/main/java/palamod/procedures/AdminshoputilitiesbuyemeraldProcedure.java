package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class AdminshoputilitiesbuyemeraldProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double n = 0;
		double fac_v = 0;
		ItemStack item = ItemStack.EMPTY;
		n = Math.round(Math.abs(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number_buy", "") : "")));
		fac_v = 55;
		item = new ItemStack(Items.EMERALD).copy();
		if (0 == n) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You cannot bought nothing put a number greater than 0 to continue"), false);
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " tried to bought 0  " + item.getDisplayName().getString()));
			}
		}
		if (n * fac_v <= getBlockNBTNumber(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString()))) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble(("money_" + entity.getDisplayName().getString()), (getBlockNBTNumber(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString())) - n * fac_v));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = item.copy();
				_setstack.setCount((int) n);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You succesfuly bought " + n + " " + item.getDisplayName().getString() + " for a total of " + n * fac_v + " $")), false);
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " bought " + n + " " + item.getDisplayName().getString() + " for a total of " + n * fac_v + " $"));
			}
		} else {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (1 < n) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You don't enough money to buy these items"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You don't enough money to buy this item"), false);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}