
package palamod.client.renderer;

import palamod.entity.PrimedendiumtntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedendiumtntRenderer extends MobRenderer<PrimedendiumtntEntity, Modelprimed_tnt_sponge_v4<PrimedendiumtntEntity>> {
	public PrimedendiumtntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrimedendiumtntEntity entity) {
		return new ResourceLocation("palamod:textures/entities/endium_tntmodel.png");
	}
}
