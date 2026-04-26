package palamod.client.renderer;

import palamod.entity.Dankaroctest1Entity;

import palamod.client.model.ModelDancarok_V1_Converted;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Dankaroctest1Renderer extends MobRenderer<Dankaroctest1Entity, ModelDancarok_V1_Converted<Dankaroctest1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/danka2.png");

	public Dankaroctest1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelDancarok_V1_Converted<Dankaroctest1Entity>(context.bakeLayer(ModelDancarok_V1_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Dankaroctest1Entity entity) {
		return entityTexture;
	}
}