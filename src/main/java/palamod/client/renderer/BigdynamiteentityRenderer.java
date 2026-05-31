package palamod.client.renderer;

import palamod.entity.BigdynamiteentityEntity;

import palamod.client.model.ModelBIG_dynamite2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BigdynamiteentityRenderer extends MobRenderer<BigdynamiteentityEntity, LivingEntityRenderState, ModelBIG_dynamite2> {
	private BigdynamiteentityEntity entity = null;
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/pala_dyna.png");

	public BigdynamiteentityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBIG_dynamite2(context.bakeLayer(ModelBIG_dynamite2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(BigdynamiteentityEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}