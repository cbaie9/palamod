/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

public class PalamodModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, PalamodMod.MODID);
	public static final DeferredHolder<Potion, Potion> ANTIFAKEPOTION = REGISTRY.register("antifakepotion",
			() -> new Potion(new MobEffectInstance(PalamodModMobEffects.ANTIFAKE, 3600, 0, false, true), new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> POTION_MINEUR_FOU = REGISTRY.register("potion_mineur_fou", () -> new Potion(new MobEffectInstance(PalamodModMobEffects.MINEUR_FOU, 72000, 0, false, true)));
}