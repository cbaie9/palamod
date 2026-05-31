package palamod.client.renderer;

import palamod.entity.PrimedspongetntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedspongetntRenderer extends MobRenderer<PrimedspongetntEntity, LivingEntityRenderState, Modelprimed_tnt_sponge_v4> {
	private PrimedspongetntEntity entity = null;
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/sponge_tntmodel.png");

	public PrimedspongetntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PrimedspongetntEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}