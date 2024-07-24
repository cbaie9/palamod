
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.particle.FlyparticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalamodModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PalamodModParticleTypes.FLYPARTICLE.get(), FlyparticleParticle::provider);
	}
}
