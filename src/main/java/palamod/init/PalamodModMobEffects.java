
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.potion.WitherimbuMobEffect;
import palamod.potion.PoisonimbueMobEffect;
import palamod.potion.Multiexp2MobEffect;
import palamod.potion.Multiexp10MobEffect;
import palamod.potion.MineurFouMobEffect;
import palamod.potion.FseffectMobEffect;
import palamod.potion.FireimbueMobEffect;
import palamod.potion.AntifakeMobEffect;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class PalamodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PalamodMod.MODID);
	public static final RegistryObject<MobEffect> ANTIFAKE = REGISTRY.register("antifake", () -> new AntifakeMobEffect());
	public static final RegistryObject<MobEffect> FIREIMBUE = REGISTRY.register("fireimbue", () -> new FireimbueMobEffect());
	public static final RegistryObject<MobEffect> WITHERIMBU = REGISTRY.register("witherimbu", () -> new WitherimbuMobEffect());
	public static final RegistryObject<MobEffect> POISONIMBUE = REGISTRY.register("poisonimbue", () -> new PoisonimbueMobEffect());
	public static final RegistryObject<MobEffect> FSEFFECT = REGISTRY.register("fseffect", () -> new FseffectMobEffect());
	public static final RegistryObject<MobEffect> MULTIEXP_2 = REGISTRY.register("multiexp_2", () -> new Multiexp2MobEffect());
	public static final RegistryObject<MobEffect> MULTIEXP_10 = REGISTRY.register("multiexp_10", () -> new Multiexp10MobEffect());
	public static final RegistryObject<MobEffect> MINEUR_FOU = REGISTRY.register("mineur_fou", () -> new MineurFouMobEffect());
}
