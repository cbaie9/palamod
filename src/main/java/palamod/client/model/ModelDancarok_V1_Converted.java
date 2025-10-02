package palamod.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelDancarok_V1_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("palamod", "model_dancarok_v_1_converted"), "main");
	public final ModelPart head;
	public final ModelPart corn;
	public final ModelPart leg;
	public final ModelPart bone;

	public ModelDancarok_V1_Converted(ModelPart root) {
		this.head = root.getChild("head");
		this.corn = this.head.getChild("corn");
		this.leg = root.getChild("leg");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, -8.0F));
		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-3.8787F, -6.5F, -6.1213F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.1213F, -1.5F, 5.1213F, 0.0F, 0.7854F, 0.0F));
		PartDefinition corn = head.addOrReplaceChild("corn", CubeListBuilder.create().texOffs(0, 0).addBox(-8.75F, -10.0F, 0.5F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.0F)).texOffs(0, 1)
				.addBox(-10.75F, -11.0F, 3.5F, 1.5F, 4.0F, 1.5F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.75F, -11.0F, 3.5F, 1.5F, 4.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leg = partdefinition.addOrReplaceChild("leg",
				CubeListBuilder.create().texOffs(20, 21).mirror().addBox(-5.0F, -4.0F, 5.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(20, 21).mirror().addBox(-5.0F, -4.0F, 12.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(20, 21).mirror().addBox(-14.0F, -4.0F, 12.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(20, 21).mirror().addBox(-14.0F, -4.0F, 4.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offset(8.0F, 24.0F, -8.0F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 3).addBox(-12.0F, -8.0F, 6.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}