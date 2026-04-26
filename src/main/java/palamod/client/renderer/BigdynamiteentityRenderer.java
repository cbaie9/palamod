package palamod.client.renderer;

import palamod.entity.BigdynamiteentityEntity;

import palamod.client.model.ModelBIG_dynamite2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BigdynamiteentityRenderer extends MobRenderer<BigdynamiteentityEntity, ModelBIG_dynamite2<BigdynamiteentityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/pala_dyna.png");

	public BigdynamiteentityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBIG_dynamite2<BigdynamiteentityEntity>(context.bakeLayer(ModelBIG_dynamite2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BigdynamiteentityEntity entity) {
		return entityTexture;
	}
}