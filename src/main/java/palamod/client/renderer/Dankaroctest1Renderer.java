package palamod.client.renderer;

import palamod.entity.Dankaroctest1Entity;

import palamod.client.model.ModelDancarok_V1_Converted;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Dankaroctest1Renderer extends MobRenderer<Dankaroctest1Entity, LivingEntityRenderState, ModelDancarok_V1_Converted> {
	private Dankaroctest1Entity entity = null;
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/danka2.png");

	public Dankaroctest1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelDancarok_V1_Converted(context.bakeLayer(ModelDancarok_V1_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(Dankaroctest1Entity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}