package palamod.client.model;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBIG_dynamitev2 extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("palamod", "model_big_dynamitev_2"), "main");
	public final ModelPart bb_main;

	public ModelBIG_dynamitev2(ModelPart root) {
		super(root);
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, -3.0F, -2.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition dyme_r1 = bb_main.addOrReplaceChild("dyme_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0873F, 0.0873F, 0.0F));
		PartDefinition dyme_r1_r1 = dyme_r1.addOrReplaceChild("dyme_r1_r1", CubeListBuilder.create().texOffs(0, 13).addBox(2.0F, -1.0F, 6.0F, 0.0F, 0.0F, 2.0F, new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}