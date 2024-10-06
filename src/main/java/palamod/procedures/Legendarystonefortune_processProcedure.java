package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

public class Legendarystonefortune_processProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		double number = 0;
		if (itemstack.getOrCreateTag().getDouble("cooldown") == 0 || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (Math.random() < 0.1) {
				item = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
			} else if (Math.random() < 0.15) {
				item = new ItemStack(PalamodModItems.TITANE_INGOT.get());
			} else if (Math.random() < 0.25) {
				item = new ItemStack(PalamodModItems.AMETHYST.get());
			} else if (Math.random() < 0.5) {
				item = new ItemStack(Items.DIAMOND);
			} else {
				item = new ItemStack(Items.GOLD_INGOT);
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()));
			if (entity instanceof Player _player) {
				ItemStack _setstack = item.copy();
				_setstack.setCount(Mth.nextInt(RandomSource.create(), 10, 64));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			itemstack.getOrCreateTag().putString("name", (new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()).getDisplayName().getString()));
			itemstack.getOrCreateTag().putDouble("cooldown", 48000);
		}
	}
}
