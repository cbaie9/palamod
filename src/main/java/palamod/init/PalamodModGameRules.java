
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalamodModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> LOGSALL;
	public static GameRules.Key<GameRules.BooleanValue> LOCKEDCRAFT;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		LOGSALL = GameRules.register("logsall", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		LOCKEDCRAFT = GameRules.register("lockedcraft", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
