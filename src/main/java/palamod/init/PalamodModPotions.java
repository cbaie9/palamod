
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

public class PalamodModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, PalamodMod.MODID);
	public static final RegistryObject<Potion> ANTIFAKEPOTION = REGISTRY.register("antifakepotion",
			() -> new Potion(new MobEffectInstance(PalamodModMobEffects.ANTIFAKE.get(), 3600, 0, false, true), new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0, false, true)));
}
