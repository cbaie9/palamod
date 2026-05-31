/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.core.registries.Registries;

import com.mojang.serialization.Codec;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class PalamodModGameRules {
	public static final DeferredRegister<GameRule<?>> REGISTRY = DeferredRegister.create(Registries.GAME_RULE, PalamodMod.MODID);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> LOGSALL = registerBoolean("logsall", GameRuleCategory.PLAYER, false);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> LOCKEDCRAFT = registerBoolean("lockedcraft", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> LOCKEDUSE = registerBoolean("lockeduse", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> COMMANDFURNACENOPERMACCESS = registerBoolean("commandfurnacenopermaccess", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> COMMANDFACTIONNOPERMACCESS = registerBoolean("commandfactionnopermaccess", GameRuleCategory.PLAYER, false);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> COMMANDFEEDNOPERMACCESS = registerBoolean("commandfeednopermaccess", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> DISABLEJOBSGAMERULE = registerBoolean("disablejobsgamerule", GameRuleCategory.PLAYER, false);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> DISABLEMONEYGAMERULE = registerBoolean("disablemoneygamerule", GameRuleCategory.PLAYER, false);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> PALAMODDEBUGLOG = registerBoolean("palamoddebuglog", GameRuleCategory.UPDATES, false);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> COMMAND_CRAFT_NO_PERM_ACCESS = registerBoolean("command_craft_no_perm_access", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Integer>> JOBS_XP_BASE_MULTIPLIER = registerInteger("jobs_xp_base_multiplier", GameRuleCategory.PLAYER, 100);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> JOBS_LEVEL_BASE = registerBoolean("jobs_level_base", GameRuleCategory.PLAYER, false);
	public static DeferredHolder<GameRule<?>, GameRule<Integer>> BASE_JOB_LEVEL_MULTIPLIER = registerInteger("base_job_level_multiplier", GameRuleCategory.PLAYER, 1000);
	public static DeferredHolder<GameRule<?>, GameRule<Integer>> DEFAULT_FIGHTING_TIME = registerInteger("default_fighting_time", GameRuleCategory.PLAYER, 400);

	private static DeferredHolder<GameRule<?>, GameRule<Boolean>> registerBoolean(String registryname, GameRuleCategory category, boolean value) {
		return REGISTRY.register(registryname, () -> new GameRule<>(category, GameRuleType.BOOL, BoolArgumentType.bool(), GameRuleTypeVisitor::visitBoolean, Codec.BOOL, b -> b ? 1 : 0, value, FeatureFlagSet.of()));
	}

	private static DeferredHolder<GameRule<?>, GameRule<Integer>> registerInteger(String registryname, GameRuleCategory category, int value) {
		return REGISTRY.register(registryname, () -> new GameRule<>(category, GameRuleType.INT, IntegerArgumentType.integer(Integer.MIN_VALUE, Integer.MAX_VALUE), GameRuleTypeVisitor::visitInteger,
				Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE), i -> i, value, FeatureFlagSet.of()));
	}
}