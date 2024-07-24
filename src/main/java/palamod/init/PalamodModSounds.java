
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

public class PalamodModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PalamodMod.MODID);
	public static final RegistryObject<SoundEvent> LUCKY_ALARM = REGISTRY.register("lucky_alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "lucky_alarm")));
	public static final RegistryObject<SoundEvent> MIICHALLENGEMUSIC = REGISTRY.register("miichallengemusic", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "miichallengemusic")));
	public static final RegistryObject<SoundEvent> FUZEDISC = REGISTRY.register("fuzedisc", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "fuzedisc")));
	public static final RegistryObject<SoundEvent> CLASH_KUMIZ = REGISTRY.register("clash_kumiz", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "clash_kumiz")));
	public static final RegistryObject<SoundEvent> ANTI_FUZE_CLASH = REGISTRY.register("anti_fuze_clash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "anti_fuze_clash")));
	public static final RegistryObject<SoundEvent> ROULETTE_PALADIENNE = REGISTRY.register("roulette_paladienne", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("palamod", "roulette_paladienne")));
}
