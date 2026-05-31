package palamod.client.renderer;

import palamod.entity.PrimedendiumtntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedendiumtntRenderer extends MobRenderer<PrimedendiumtntEntity, LivingEntityRenderState, Modelprimed_tnt_sponge_v4> {
	private PrimedendiumtntEntity entity = null;
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/endium_tntmodel.png");

	public PrimedendiumtntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PrimedendiumtntEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}