package palamod.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class CpspassifeffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File jobs = new File("");
		com.google.gson.JsonObject main_clicker = new com.google.gson.JsonObject();
		double coin = 0;
		double cps = 0;
		boolean abort = false;
	}
}
