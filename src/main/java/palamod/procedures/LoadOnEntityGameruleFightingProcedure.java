package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LoadOnEntityGameruleFightingProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("MaxFightingTime", (world instanceof ServerLevel _serverLevelGR0 ? _serverLevelGR0.getGameRules().getInt(PalamodModGameRules.DEFAULT_FIGHTING_TIME) : 0));
	}
}