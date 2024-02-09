package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
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
