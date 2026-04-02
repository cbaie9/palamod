/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.renderer.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class PalamodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PalamodModEntities.PALADIUMDYNAMITE.get(), PaladiumdynamiteRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.ENDIUMDYNAMITE.get(), EndiumdynamiteRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.BIGDYNAMITEENTITY.get(), BigdynamiteentityRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PALADIUM_GOLEM.get(), PaladiumgolemRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDSPONGETNT.get(), PrimedspongetntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDWITHERTNT.get(), PrimedwithertntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDMAGICTNT.get(), PrimedmagictntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDBIGTNT.get(), PrimedbigtntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDENDIUMTNT.get(), PrimedendiumtntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.SWITCHARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.GODVILLAGER.get(), GodvillagerRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.DANKAROCTEST_1.get(), Dankaroctest1Renderer::new);
	}
}