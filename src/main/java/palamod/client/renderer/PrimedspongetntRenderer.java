
package palamod.client.renderer;

import palamod.entity.PrimedspongetntEntity;

import palamod.client.model.Modelprimed_tnt_sponge_v4;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PrimedspongetntRenderer extends MobRenderer<PrimedspongetntEntity, Modelprimed_tnt_sponge_v4<PrimedspongetntEntity>> {
	public PrimedspongetntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelprimed_tnt_sponge_v4(context.bakeLayer(Modelprimed_tnt_sponge_v4.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrimedspongetntEntity entity) {
		return new ResourceLocation("palamod:textures/entities/sponge_tntmodel.png");
	}
}
