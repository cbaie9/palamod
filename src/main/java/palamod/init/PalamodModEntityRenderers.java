
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.renderer.PrimedwithertntRenderer;
import palamod.client.renderer.PrimedspongetntRenderer;
import palamod.client.renderer.PrimedmagictntRenderer;
import palamod.client.renderer.PrimedendiumtntRenderer;
import palamod.client.renderer.PrimedbigtntRenderer;
import palamod.client.renderer.PaladiumgolemRenderer;
import palamod.client.renderer.PaladiumdynamiteRenderer;
import palamod.client.renderer.EndiumdynamiteRenderer;
import palamod.client.renderer.BigdynamiteentityRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalamodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PalamodModEntities.PALADIUMDYNAMITE.get(), PaladiumdynamiteRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.ENDIUMDYNAMITE.get(), EndiumdynamiteRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.BIGDYNAMITEENTITY.get(), BigdynamiteentityRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PALADIUMGOLEM.get(), PaladiumgolemRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDSPONGETNT.get(), PrimedspongetntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDWITHERTNT.get(), PrimedwithertntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDMAGICTNT.get(), PrimedmagictntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDBIGTNT.get(), PrimedbigtntRenderer::new);
		event.registerEntityRenderer(PalamodModEntities.PRIMEDENDIUMTNT.get(), PrimedendiumtntRenderer::new);
	}
}
