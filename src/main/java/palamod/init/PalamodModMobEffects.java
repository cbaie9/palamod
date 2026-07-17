/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.procedures.TunnelvisionEffectExpiresProcedure;
import palamod.procedures.Removemultixp2fileProcedure;
import palamod.procedures.Removemultixp10fileProcedure;

import palamod.potion.*;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class PalamodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PalamodMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ANTIFAKE = REGISTRY.register("antifake", AntifakeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> FIREIMBUE = REGISTRY.register("fireimbue", FireimbueMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WITHERIMBU = REGISTRY.register("witherimbu", WitherimbuMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> POISONIMBUE = REGISTRY.register("poisonimbue", PoisonimbueMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> FSEFFECT = REGISTRY.register("fseffect", FseffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MULTIEXP_2 = REGISTRY.register("multiexp_2", Multiexp2MobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MULTIEXP_10 = REGISTRY.register("multiexp_10", Multiexp10MobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MINEUR_FOU = REGISTRY.register("mineur_fou", MineurFouMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TUNNELVISION = REGISTRY.register("tunnelvision", TunnelvisionMobEffect::new);

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(MULTIEXP_2)) {
			Removemultixp2fileProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MULTIEXP_10)) {
			Removemultixp10fileProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(TUNNELVISION)) {
			TunnelvisionEffectExpiresProcedure.execute(entity);
		}
	}
}