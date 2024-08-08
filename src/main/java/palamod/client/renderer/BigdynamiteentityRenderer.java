
package palamod.client.renderer;

public class BigdynamiteentityRenderer extends MobRenderer<BigdynamiteentityEntity, ModelBIG_dynamite2<BigdynamiteentityEntity>> {

	public BigdynamiteentityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBIG_dynamite2(context.bakeLayer(ModelBIG_dynamite2.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(BigdynamiteentityEntity entity) {
		return new ResourceLocation("palamod:textures/entities/pala_dyna.png");
	}

}
