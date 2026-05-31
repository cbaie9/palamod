package palamod.client.renderer;

import palamod.entity.EndiumdynamiteEntity;

import palamod.client.model.Modeldynamite_model;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EndiumdynamiteRenderer extends MobRenderer<EndiumdynamiteEntity, LivingEntityRenderState, Modeldynamite_model> {
	private EndiumdynamiteEntity entity = null;
	private final Identifier entityTexture = Identifier.parse("palamod:textures/entities/endium_dyna_t4.png");

	public EndiumdynamiteRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldynamite_model(context.bakeLayer(Modeldynamite_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(EndiumdynamiteEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}