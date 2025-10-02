package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WeightedBoots_eventProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().getY());
	}

	public static void execute(double y) {
		execute(null, y);
	}

	private static void execute(@Nullable Event event, double y) {
		PalamodModVariables.jump_y = y;
	}
}