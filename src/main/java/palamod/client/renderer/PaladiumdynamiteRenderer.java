package palamod.client.renderer;

import palamod.entity.PaladiumdynamiteEntity;

import palamod.client.model.Modeldynamite_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PaladiumdynamiteRenderer extends MobRenderer<PaladiumdynamiteEntity, LivingEntityRenderState, Modeldynamite_model> {
	private PaladiumdynamiteEntity entity = null;

	public PaladiumdynamiteRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldynamite_model(context.bakeLayer(Modeldynamite_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PaladiumdynamiteEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("palamod:textures/entities/pala_dyna.png");
	}
}