
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

public class PalamodModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, PalamodMod.MODID);
	public static final RegistryObject<SimpleParticleType> FLYPARTICLE = REGISTRY.register("flyparticle", () -> new SimpleParticleType(false));
}
