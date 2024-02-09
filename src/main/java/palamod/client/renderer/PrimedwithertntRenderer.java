
package palamod.client.renderer;

import palamod.entity.PrimedwithertntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedwithertntRenderer extends MobRenderer<PrimedwithertntEntity, Modelprimed_tnt_sponge_v4<PrimedwithertntEntity>> {
	public PrimedwithertntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrimedwithertntEntity entity) {
		return new ResourceLocation("palamod:textures/entities/wither_tntmodel.png");
	}
}
