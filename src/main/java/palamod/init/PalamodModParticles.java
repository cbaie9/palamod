/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.particle.FlyparticleParticle;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class PalamodModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PalamodModParticleTypes.FLYPARTICLE.get(), FlyparticleParticle::provider);
	}
}