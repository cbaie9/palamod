
package palamod.client.renderer;

import palamod.entity.GodvillagerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class GodvillagerRenderer extends MobRenderer<GodvillagerEntity, VillagerModel<GodvillagerEntity>> {
	public GodvillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<GodvillagerEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(GodvillagerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(GodvillagerEntity entity) {
		return ResourceLocation.parse("palamod:textures/entities/santa-villager.png");
	}
}
