// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBIG_dynamite2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "big_dynamite2"), "main");
	private final ModelPart bb_main;

	public ModelBIG_dynamite2(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 2)
				.addBox(-2.0F, -3.0F, -2.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(1.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition dyme_r1 = bb_main.addOrReplaceChild("dyme_r1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0873F, 0.0873F, 0.0F));

		PartDefinition dyme_r1_r1 = dyme_r1
				.addOrReplaceChild("dyme_r1_r1",
						CubeListBuilder.create().texOffs(0, 14).addBox(2.0F, -1.0F, 6.0F, 0.0F, 0.0F, 2.0F,
								new CubeDeformation(1.0F)),
						PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bb_main.yRot = headPitch / (180F / (float) Math.PI);
	}
}