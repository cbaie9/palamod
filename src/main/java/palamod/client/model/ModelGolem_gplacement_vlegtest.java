package palamod.client.model;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelGolem_gplacement_vlegtest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("palamod", "model_golem_gplacement_vlegtest"), "main");
	public final ModelPart golem;
	public final ModelPart left_leg;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart right_leg;

	public ModelGolem_gplacement_vlegtest(ModelPart root) {
		this.golem = root.getChild("golem");
		this.left_leg = root.getChild("left_leg");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition golem = partdefinition.addOrReplaceChild("golem", CubeListBuilder.create().texOffs(0, 70).addBox(-3.0F, -20.75F, -1.0F, 9.0F, 4.75F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
				.addBox(-7.0F, -32.75F, -3.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, -42.5F, -4.0F, 8.0F, 9.75F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-3.0F, -8.0F, -2.5F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -8.0F, 1.5F, 3.1416F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(60, 21).addBox(-11.0F, -33.0F, -1.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(60, 58).addBox(11.0F, -33.0F, -1.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r2 = right_leg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 0).addBox(-3.0F, -8.0F, -2.5F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -8.0F, 1.5F, 3.1416F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		golem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
