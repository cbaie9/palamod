
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.procedures.TunnelvisionEffectExpiresProcedure;
import palamod.procedures.Removemultixp2fileProcedure;
import palamod.procedures.Removemultixp10fileProcedure;

import palamod.potion.WitherimbuMobEffect;
import palamod.potion.TunnelvisionMobEffect;
import palamod.potion.PoisonimbueMobEffect;
import palamod.potion.Multiexp2MobEffect;
import palamod.potion.Multiexp10MobEffect;
import palamod.potion.MineurFouMobEffect;
import palamod.potion.FseffectMobEffect;
import palamod.potion.FireimbueMobEffect;
import palamod.potion.AntifakeMobEffect;

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
	public static final DeferredHolder<MobEffect, MobEffect> ANTIFAKE = REGISTRY.register("antifake", () -> new AntifakeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FIREIMBUE = REGISTRY.register("fireimbue", () -> new FireimbueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WITHERIMBU = REGISTRY.register("witherimbu", () -> new WitherimbuMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> POISONIMBUE = REGISTRY.register("poisonimbue", () -> new PoisonimbueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FSEFFECT = REGISTRY.register("fseffect", () -> new FseffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MULTIEXP_2 = REGISTRY.register("multiexp_2", () -> new Multiexp2MobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MULTIEXP_10 = REGISTRY.register("multiexp_10", () -> new Multiexp10MobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINEUR_FOU = REGISTRY.register("mineur_fou", () -> new MineurFouMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TUNNELVISION = REGISTRY.register("tunnelvision", () -> new TunnelvisionMobEffect());

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
			Removemultixp2fileProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(MULTIEXP_10)) {
			Removemultixp10fileProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(TUNNELVISION)) {
			TunnelvisionEffectExpiresProcedure.execute(entity);
		}
	}
}
