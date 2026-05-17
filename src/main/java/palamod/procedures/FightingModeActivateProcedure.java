package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModAttributes;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
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
public class FightingModeActivateProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof ServerPlayer || entity instanceof Player) && (sourceentity instanceof ServerPlayer || sourceentity instanceof Player)) {
			if (!(getEntityGameType(sourceentity) == GameType.CREATIVE || getEntityGameType(sourceentity) == GameType.SPECTATOR)) {
				PalamodMod.LOGGER.info("Putting source in fight mode");
				if (sourceentity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(PalamodModAttributes.IS_FIGHTING))
					_livingEntity7.getAttribute(PalamodModAttributes.IS_FIGHTING).setBaseValue(1);
				if ((sourceentity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity8.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0) == 0) {
					MsgtellrawautosendspecialselectorProcedure.execute(world, x, y, z, sourceentity.getDisplayName().getString(),
							((Component.translatable("palamod.procedure.infight.source").getString()).replace("%2", "" + (world.getLevelData().getGameRules().getInt(PalamodModGameRules.DEFAULT_FIGHTING_TIME)) / 20d)).replace("%1",
									entity.getDisplayName().getString()));
				}
				if (sourceentity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME))
					_livingEntity14.getAttribute(PalamodModAttributes.FIGHTING_TIME).setBaseValue((world.getLevelData().getGameRules().getInt(PalamodModGameRules.DEFAULT_FIGHTING_TIME)));
			}
			if (!(getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR)) {
				PalamodMod.LOGGER.info("Putting victim/target in fight mode");
				if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(PalamodModAttributes.IS_FIGHTING))
					_livingEntity18.getAttribute(PalamodModAttributes.IS_FIGHTING).setBaseValue(1);
				if ((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity19.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0) == 0) {
					MsgtellrawautosendspecialselectorProcedure.execute(world, x, y, z, entity.getDisplayName().getString(),
							((Component.translatable("palamod.procedure.infight.victim").getString()).replace("%2", "" + (world.getLevelData().getGameRules().getInt(PalamodModGameRules.DEFAULT_FIGHTING_TIME)) / 20d)).replace("%1",
									sourceentity.getDisplayName().getString()));
				}
				if (entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME))
					_livingEntity25.getAttribute(PalamodModAttributes.FIGHTING_TIME).setBaseValue((world.getLevelData().getGameRules().getInt(PalamodModGameRules.DEFAULT_FIGHTING_TIME)));
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