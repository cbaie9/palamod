
package palamod.client.renderer;

import palamod.entity.PaladiumdynamiteEntity;

import palamod.client.model.Modeldynamite_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PaladiumdynamiteRenderer extends MobRenderer<PaladiumdynamiteEntity, Modeldynamite_model<PaladiumdynamiteEntity>> {
	public PaladiumdynamiteRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldynamite_model(context.bakeLayer(Modeldynamite_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PaladiumdynamiteEntity entity) {
		return new ResourceLocation("palamod:textures/entities/pala_dyna.png");
	}
}
