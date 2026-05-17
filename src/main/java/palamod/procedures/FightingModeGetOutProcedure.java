package palamod.procedures;

import palamod.init.PalamodModAttributes;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FightingModeGetOutProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(0 == (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(PalamodModAttributes.IS_FIGHTING) ? _livingEntity0.getAttribute(PalamodModAttributes.IS_FIGHTING).getValue() : 0))) {
			if (0 == (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity1.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0)
					|| getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR) {
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(PalamodModAttributes.IS_FIGHTING))
					_livingEntity4.getAttribute(PalamodModAttributes.IS_FIGHTING).setBaseValue(0);
				MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.infight.out").getString());
			} else {
				if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME))
					_livingEntity7.getAttribute(PalamodModAttributes.FIGHTING_TIME).setBaseValue(
							((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity6.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0)
									- 1));
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}