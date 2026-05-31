package palamod.client.renderer;

import palamod.entity.GodvillagerEntity;

import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import net.minecraft.client.renderer.entity.state.HoldingEntityRenderState;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class GodvillagerRenderer extends MobRenderer<GodvillagerEntity, VillagerRenderState, VillagerModel> {
	private GodvillagerEntity entity = null;
	private final ResourceLocation entityTexture = ResourceLocation.parse("palamod:textures/entities/santa-villager.png");

	public GodvillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new CrossedArmsItemLayer<>(this));
	}

	@Override
	public VillagerRenderState createRenderState() {
		return new VillagerRenderState();
	}

	@Override
	public void extractRenderState(GodvillagerEntity entity, VillagerRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (state instanceof HoldingEntityRenderState holdingState) {
			this.itemModelResolver.updateForLiving(holdingState.heldItem, entity.getMainHandItem(), ItemDisplayContext.GROUND, entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(VillagerRenderState state) {
		return entityTexture;
	}

	@Override
	protected void scale(VillagerRenderState state, PoseStack poseStack) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}
}