
package palamod.client.renderer;

import palamod.entity.EndiumdynamiteEntity;

import palamod.client.model.Modeldynamite_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EndiumdynamiteRenderer extends MobRenderer<EndiumdynamiteEntity, Modeldynamite_model<EndiumdynamiteEntity>> {
	public EndiumdynamiteRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldynamite_model(context.bakeLayer(Modeldynamite_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndiumdynamiteEntity entity) {
		return new ResourceLocation("palamod:textures/entities/endium_dyna_t4.png");
	}
}
