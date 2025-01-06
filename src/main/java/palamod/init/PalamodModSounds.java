
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class PalamodModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, PalamodMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> LUCKY_ALARM = REGISTRY.register("lucky_alarm", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "lucky_alarm")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MIICHALLENGEMUSIC = REGISTRY.register("miichallengemusic", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "miichallengemusic")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FUZEDISC = REGISTRY.register("fuzedisc", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "fuzedisc")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CLASH_KUMIZ = REGISTRY.register("clash_kumiz", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "clash_kumiz")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANTI_FUZE_CLASH = REGISTRY.register("anti_fuze_clash", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "anti_fuze_clash")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ROULETTE_PALADIENNE = REGISTRY.register("roulette_paladienne", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("palamod", "roulette_paladienne")));
}
