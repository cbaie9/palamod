package palamod.client.renderer;

import palamod.entity.PaladiumgolemEntity;

import palamod.client.model.ModelGolem_gplacement_vlegtest;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PaladiumgolemRenderer extends MobRenderer<PaladiumgolemEntity, LivingEntityRenderState, ModelGolem_gplacement_vlegtest> {
	private PaladiumgolemEntity entity = null;
	private final Identifier entityTexture = Identifier.parse("palamod:textures/entities/golem1.12.png");

	public PaladiumgolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGolem_gplacement_vlegtest(context.bakeLayer(ModelGolem_gplacement_vlegtest.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PaladiumgolemEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}