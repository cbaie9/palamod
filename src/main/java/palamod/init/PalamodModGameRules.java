/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class PalamodModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> LOGSALL;
	public static GameRules.Key<GameRules.BooleanValue> LOCKEDCRAFT;
	public static GameRules.Key<GameRules.BooleanValue> LOCKEDUSE;
	public static GameRules.Key<GameRules.BooleanValue> COMMANDFURNACENOPERMACCESS;
	public static GameRules.Key<GameRules.BooleanValue> COMMANDFACTIONNOPERMACCESS;
	public static GameRules.Key<GameRules.BooleanValue> COMMANDFEEDNOPERMACCESS;
	public static GameRules.Key<GameRules.BooleanValue> DISABLEJOBSGAMERULE;
	public static GameRules.Key<GameRules.BooleanValue> DISABLEMONEYGAMERULE;
	public static GameRules.Key<GameRules.BooleanValue> PALAMODDEBUGLOG;
	public static GameRules.Key<GameRules.BooleanValue> COMMAND_CRAFT_NO_PERM_ACCESS;
	public static GameRules.Key<GameRules.IntegerValue> JOBS_XP_BASE_MULTIPLIER;
	public static GameRules.Key<GameRules.BooleanValue> JOBS_LEVEL_BASE;
	public static GameRules.Key<GameRules.IntegerValue> BASE_JOB_LEVEL_MULTIPLIER;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		LOGSALL = GameRules.register("logsall", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		LOCKEDCRAFT = GameRules.register("lockedcraft", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		LOCKEDUSE = GameRules.register("lockeduse", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		COMMANDFURNACENOPERMACCESS = GameRules.register("commandfurnacenopermaccess", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		COMMANDFACTIONNOPERMACCESS = GameRules.register("commandfactionnopermaccess", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		COMMANDFEEDNOPERMACCESS = GameRules.register("commandfeednopermaccess", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		DISABLEJOBSGAMERULE = GameRules.register("disablejobsgamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		DISABLEMONEYGAMERULE = GameRules.register("disablemoneygamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		PALAMODDEBUGLOG = GameRules.register("palamoddebuglog", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
		COMMAND_CRAFT_NO_PERM_ACCESS = GameRules.register("commandCraftNoPermAccess", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		JOBS_XP_BASE_MULTIPLIER = GameRules.register("jobsXpBaseMultiplier", GameRules.Category.PLAYER, GameRules.IntegerValue.create(300));
		JOBS_LEVEL_BASE = GameRules.register("jobsLevelBase", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		BASE_JOB_LEVEL_MULTIPLIER = GameRules.register("baseJobLevelMultiplier", GameRules.Category.PLAYER, GameRules.IntegerValue.create(500));
	}
}