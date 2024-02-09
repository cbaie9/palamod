
package palamod.client.renderer;

import palamod.entity.PrimedmagictntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedmagictntRenderer extends MobRenderer<PrimedmagictntEntity, Modelprimed_tnt_sponge_v4<PrimedmagictntEntity>> {
	public PrimedmagictntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrimedmagictntEntity entity) {
		return new ResourceLocation("palamod:textures/entities/magic_tntmodel.png");
	}
}
