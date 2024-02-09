
package palamod.client.renderer;

import palamod.entity.PrimedbigtntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedbigtntRenderer extends MobRenderer<PrimedbigtntEntity, Modelprimed_tnt_sponge_v4<PrimedbigtntEntity>> {
	public PrimedbigtntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrimedbigtntEntity entity) {
		return new ResourceLocation("palamod:textures/entities/big_tntmodel.png");
	}
}
