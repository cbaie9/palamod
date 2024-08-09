
package palamod.client.renderer;

import palamod.entity.PaladiumgolemEntity;

import palamod.client.model.ModelGolem_gplacement_vlegtest;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PaladiumgolemRenderer extends MobRenderer<PaladiumgolemEntity, ModelGolem_gplacement_vlegtest<PaladiumgolemEntity>> {
	public PaladiumgolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGolem_gplacement_vlegtest(context.bakeLayer(ModelGolem_gplacement_vlegtest.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PaladiumgolemEntity entity) {
		return new ResourceLocation("palamod:textures/entities/golem1.12.png");
	}
}
