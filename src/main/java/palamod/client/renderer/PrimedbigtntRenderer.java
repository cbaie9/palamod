package palamod.client.renderer;

import palamod.entity.PrimedbigtntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedbigtntRenderer extends MobRenderer<PrimedbigtntEntity, LivingEntityRenderState, Modelprimed_tnt_sponge_v4> {
	private PrimedbigtntEntity entity = null;
	private final Identifier entityTexture = Identifier.parse("palamod:textures/entities/big_tntmodel.png");

	public PrimedbigtntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PrimedbigtntEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}