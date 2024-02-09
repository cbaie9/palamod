// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelGolem_v1 extends EntityModel<Entity> {
	private final ModelRenderer brasg;
	private final ModelRenderer Jambed;
	private final ModelRenderer tete;
	private final ModelRenderer bb_main;
	private final ModelRenderer brasd;
	private final ModelRenderer jambeg;

	public ModelGolem_v1() {
		textureWidth = 64;
		textureHeight = 64;

		brasg = new ModelRenderer(this);
		brasg.setRotationPoint(0.0F, 24.0F, 0.0F);
		brasg.setTextureOffset(30, 29).addBox(5.0F, -15.0F, 0.0F, 2.0F, 15.0F, 3.0F, 0.0F, false);

		Jambed = new ModelRenderer(this);
		Jambed.setRotationPoint(0.0F, 24.0F, 0.0F);
		Jambed.setTextureOffset(30, 0).addBox(-4.0F, -7.0F, 0.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		tete = new ModelRenderer(this);
		tete.setRotationPoint(0.0F, 24.0F, 0.0F);
		tete.setTextureOffset(0, 0).addBox(-2.0F, -19.0F, 0.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(1, 50).addBox(-5.0F, -15.0F, -1.0F, 10.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(1, 35).addBox(-2.0F, -9.0F, 0.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		brasd = new ModelRenderer(this);
		brasd.setRotationPoint(0.0F, 24.0F, 0.0F);
		brasd.setTextureOffset(30, 11).addBox(-7.0F, -15.0F, 0.0F, 2.0F, 15.0F, 3.0F, 0.0F, false);

		jambeg = new ModelRenderer(this);
		jambeg.setRotationPoint(0.0F, 24.0F, 0.0F);
		jambeg.setTextureOffset(18, 0).addBox(1.0F, -7.0F, 0.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		brasg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Jambed.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tete.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		brasd.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		jambeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.brasd.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}