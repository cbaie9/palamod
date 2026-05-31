/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class PalamodModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, PalamodMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> LUCKY_ALARM = REGISTRY.register("lucky_alarm", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "lucky_alarm")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MIICHALLENGEMUSIC = REGISTRY.register("miichallengemusic", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "miichallengemusic")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FUZEDISC = REGISTRY.register("fuzedisc", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "fuzedisc")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CLASH_KUMIZ = REGISTRY.register("clash_kumiz", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "clash_kumiz")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANTI_FUZE_CLASH = REGISTRY.register("anti_fuze_clash", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "anti_fuze_clash")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ROULETTE_PALADIENNE = REGISTRY.register("roulette_paladienne", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "roulette_paladienne")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEVEL_UP = REGISTRY.register("level_up", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "level_up")));
	public static final DeferredHolder<SoundEvent, SoundEvent> QUEST_COMPLETE = REGISTRY.register("quest_complete", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "quest_complete")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TOTEM_BREAK1 = REGISTRY.register("totem_break1", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "totem_break1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TOTEM_BREAK2 = REGISTRY.register("totem_break2", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "totem_break2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TOTEM_BREAK3 = REGISTRY.register("totem_break3", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("palamod", "totem_break3")));
}