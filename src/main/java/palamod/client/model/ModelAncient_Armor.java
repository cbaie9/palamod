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

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelAncient_Armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("palamod", "model_ancient_armor"), "main");
	public final ModelPart head;
	public final ModelPart Head_normal;
	public final ModelPart glow3;
	public final ModelPart Head_advanced;
	public final ModelPart top_head;
	public final ModelPart base_head;
	public final ModelPart glow8;
	public final ModelPart Left_Horn;
	public final ModelPart Middle_Horn;
	public final ModelPart Right_Horn;
	public final ModelPart Right_Pannel;
	public final ModelPart Left_Pannel;
	public final ModelPart body;
	public final ModelPart Body_normal;
	public final ModelPart glow4;
	public final ModelPart Body_advanced;
	public final ModelPart glow9;
	public final ModelPart left_arm;
	public final ModelPart LeftArm_normal;
	public final ModelPart leftArm5;
	public final ModelPart leftArm6;
	public final ModelPart leftArm7;
	public final ModelPart shoulder_normal2;
	public final ModelPart glow1;
	public final ModelPart LeftArm_advanced;
	public final ModelPart coudiere2;
	public final ModelPart leftArm4;
	public final ModelPart flame3;
	public final ModelPart glow5;
	public final ModelPart shoulder2;
	public final ModelPart base_arm2;
	public final ModelPart flame4;
	public final ModelPart glow;
	public final ModelPart right_arm;
	public final ModelPart RightArm_normal;
	public final ModelPart rightArm5;
	public final ModelPart rightArm6;
	public final ModelPart rightArm7;
	public final ModelPart shoulder_normal3;
	public final ModelPart glow2;
	public final ModelPart RightArm_advanced;
	public final ModelPart coudiere3;
	public final ModelPart rightArm4;
	public final ModelPart flame2;
	public final ModelPart glow6;
	public final ModelPart shoulder3;
	public final ModelPart base_arm3;
	public final ModelPart flame5;
	public final ModelPart glow7;
	public final ModelPart left_leg;
	public final ModelPart LeftLeg_advanced;
	public final ModelPart left_leg_genou;
	public final ModelPart glow12;
	public final ModelPart base;
	public final ModelPart robe;
	public final ModelPart LeftLeg_normal;
	public final ModelPart LeftLeg_robe;
	public final ModelPart LeftLeg_genoux;
	public final ModelPart right_leg;
	public final ModelPart LeftLeg_advanced2;
	public final ModelPart left_leg_genou2;
	public final ModelPart glow13;
	public final ModelPart base3;
	public final ModelPart robe3;
	public final ModelPart LeftLeg_normal2;
	public final ModelPart LeftLeg_robe2;
	public final ModelPart LeftLeg_genoux2;
	public final ModelPart left_foot;
	public final ModelPart leftfoot_normal;
	public final ModelPart leftfoot_advanced;
	public final ModelPart right_foot;
	public final ModelPart leftfoot_normal2;
	public final ModelPart leftfoot_advanced2;

	public ModelAncient_Armor(ModelPart root) {
		this.head = root.getChild("head");
		this.Head_normal = this.head.getChild("Head_normal");
		this.glow3 = this.Head_normal.getChild("glow3");
		this.Head_advanced = this.head.getChild("Head_advanced");
		this.top_head = this.Head_advanced.getChild("top_head");
		this.base_head = this.Head_advanced.getChild("base_head");
		this.glow8 = this.base_head.getChild("glow8");
		this.Left_Horn = this.Head_advanced.getChild("Left_Horn");
		this.Middle_Horn = this.Head_advanced.getChild("Middle_Horn");
		this.Right_Horn = this.Head_advanced.getChild("Right_Horn");
		this.Right_Pannel = this.Head_advanced.getChild("Right_Pannel");
		this.Left_Pannel = this.Head_advanced.getChild("Left_Pannel");
		this.body = root.getChild("body");
		this.Body_normal = this.body.getChild("Body_normal");
		this.glow4 = this.Body_normal.getChild("glow4");
		this.Body_advanced = this.body.getChild("Body_advanced");
		this.glow9 = this.Body_advanced.getChild("glow9");
		this.left_arm = root.getChild("left_arm");
		this.LeftArm_normal = this.left_arm.getChild("LeftArm_normal");
		this.leftArm5 = this.LeftArm_normal.getChild("leftArm5");
		this.leftArm6 = this.LeftArm_normal.getChild("leftArm6");
		this.leftArm7 = this.LeftArm_normal.getChild("leftArm7");
		this.shoulder_normal2 = this.LeftArm_normal.getChild("shoulder_normal2");
		this.glow1 = this.shoulder_normal2.getChild("glow1");
		this.LeftArm_advanced = this.left_arm.getChild("LeftArm_advanced");
		this.coudiere2 = this.LeftArm_advanced.getChild("coudiere2");
		this.leftArm4 = this.coudiere2.getChild("leftArm4");
		this.flame3 = this.leftArm4.getChild("flame3");
		this.glow5 = this.flame3.getChild("glow5");
		this.shoulder2 = this.LeftArm_advanced.getChild("shoulder2");
		this.base_arm2 = this.LeftArm_advanced.getChild("base_arm2");
		this.flame4 = this.LeftArm_advanced.getChild("flame4");
		this.glow = this.flame4.getChild("glow");
		this.right_arm = root.getChild("right_arm");
		this.RightArm_normal = this.right_arm.getChild("RightArm_normal");
		this.rightArm5 = this.RightArm_normal.getChild("rightArm5");
		this.rightArm6 = this.RightArm_normal.getChild("rightArm6");
		this.rightArm7 = this.RightArm_normal.getChild("rightArm7");
		this.shoulder_normal3 = this.RightArm_normal.getChild("shoulder_normal3");
		this.glow2 = this.shoulder_normal3.getChild("glow2");
		this.RightArm_advanced = this.right_arm.getChild("RightArm_advanced");
		this.coudiere3 = this.RightArm_advanced.getChild("coudiere3");
		this.rightArm4 = this.coudiere3.getChild("rightArm4");
		this.flame2 = this.rightArm4.getChild("flame2");
		this.glow6 = this.flame2.getChild("glow6");
		this.shoulder3 = this.RightArm_advanced.getChild("shoulder3");
		this.base_arm3 = this.RightArm_advanced.getChild("base_arm3");
		this.flame5 = this.RightArm_advanced.getChild("flame5");
		this.glow7 = this.flame5.getChild("glow7");
		this.left_leg = root.getChild("left_leg");
		this.LeftLeg_advanced = this.left_leg.getChild("LeftLeg_advanced");
		this.left_leg_genou = this.LeftLeg_advanced.getChild("left_leg_genou");
		this.glow12 = this.LeftLeg_advanced.getChild("glow12");
		this.base = this.glow12.getChild("base");
		this.robe = this.LeftLeg_advanced.getChild("robe");
		this.LeftLeg_normal = this.left_leg.getChild("LeftLeg_normal");
		this.LeftLeg_robe = this.LeftLeg_normal.getChild("LeftLeg_robe");
		this.LeftLeg_genoux = this.LeftLeg_normal.getChild("LeftLeg_genoux");
		this.right_leg = root.getChild("right_leg");
		this.LeftLeg_advanced2 = this.right_leg.getChild("LeftLeg_advanced2");
		this.left_leg_genou2 = this.LeftLeg_advanced2.getChild("left_leg_genou2");
		this.glow13 = this.LeftLeg_advanced2.getChild("glow13");
		this.base3 = this.glow13.getChild("base3");
		this.robe3 = this.LeftLeg_advanced2.getChild("robe3");
		this.LeftLeg_normal2 = this.right_leg.getChild("LeftLeg_normal2");
		this.LeftLeg_robe2 = this.LeftLeg_normal2.getChild("LeftLeg_robe2");
		this.LeftLeg_genoux2 = this.LeftLeg_normal2.getChild("LeftLeg_genoux2");
		this.left_foot = root.getChild("left_foot");
		this.leftfoot_normal = this.left_foot.getChild("leftfoot_normal");
		this.leftfoot_advanced = this.left_foot.getChild("leftfoot_advanced");
		this.right_foot = root.getChild("right_foot");
		this.leftfoot_normal2 = this.right_foot.getChild("leftfoot_normal2");
		this.leftfoot_advanced2 = this.right_foot.getChild("leftfoot_advanced2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Head_normal = head.addOrReplaceChild("Head_normal",
				CubeListBuilder.create().texOffs(118, 144).addBox(-4.0F, -8.7111F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.62F)).texOffs(150, 144).addBox(-5.0F, -8.7111F, -4.0F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Head_normal_r1 = Head_normal.addOrReplaceChild("Head_normal_r1",
				CubeListBuilder.create().texOffs(238, 235).addBox(-1.0F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.305F)).texOffs(170, 242).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-4.0667F, -9.3556F, -5.3889F, 0.3321F, 0.8449F, 0.2524F));
		PartDefinition Head_normal_r2 = Head_normal.addOrReplaceChild("Head_normal_r2", CubeListBuilder.create().texOffs(132, 244).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9556F, -5.2111F, -5.0333F, 0.0F, 0.3927F, 0.3927F));
		PartDefinition Head_normal_r3 = Head_normal.addOrReplaceChild("Head_normal_r3", CubeListBuilder.create().texOffs(128, 218).addBox(-5.0F, -4.0F, 4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(-0.8889F, -4.7111F, -9.7111F, 0.0F, 0.3927F, 0.0F));
		PartDefinition Head_normal_r4 = Head_normal.addOrReplaceChild("Head_normal_r4", CubeListBuilder.create().texOffs(118, 218).addBox(1.0F, -4.0F, 4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(0.8889F, -4.7111F, -9.7111F, 0.0F, -0.3927F, 0.0F));
		PartDefinition Head_normal_r5 = Head_normal.addOrReplaceChild("Head_normal_r5", CubeListBuilder.create().texOffs(240, 129).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.1333F, -5.2111F, -5.0333F, 0.0F, -0.3927F, -0.3927F));
		PartDefinition Head_normal_r6 = Head_normal.addOrReplaceChild("Head_normal_r6",
				CubeListBuilder.create().texOffs(162, 242).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(238, 157).addBox(-1.0F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.305F)),
				PartPose.offsetAndRotation(4.6444F, -9.5333F, -4.6778F, 0.3321F, -0.8449F, -0.2524F));
		PartDefinition Head_normal_r7 = Head_normal.addOrReplaceChild("Head_normal_r7",
				CubeListBuilder.create().texOffs(236, 173).addBox(-1.0F, -5.0F, -1.5F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.29F)).texOffs(178, 242).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.301F)),
				PartPose.offsetAndRotation(0.4667F, -9.3556F, -6.2111F, 0.2182F, 0.0F, 0.0F));
		PartDefinition Head_normal_r8 = Head_normal.addOrReplaceChild("Head_normal_r8", CubeListBuilder.create().texOffs(118, 173).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(0.0F, -3.7111F, 0.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition glow3 = Head_normal.addOrReplaceChild("glow3", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.62F)), PartPose.offset(0.0F, -4.7111F, 0.0F));
		PartDefinition Head_advanced = head.addOrReplaceChild("Head_advanced", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition top_head = Head_advanced.addOrReplaceChild("top_head", CubeListBuilder.create().texOffs(32, 22).addBox(-4.1111F, -1.4667F, 6.4222F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.offset(-0.8889F, -7.2445F, -10.4222F));
		PartDefinition top_head_r1 = top_head.addOrReplaceChild("top_head_r1", CubeListBuilder.create().texOffs(0, 96).addBox(1.0F, -4.0F, 4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(1.7778F, 0.0F, 0.0F, -0.1886F, -0.3864F, 0.0718F));
		PartDefinition top_head_r2 = top_head.addOrReplaceChild("top_head_r2", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(0.8889F, 3.5333F, 10.4222F, -0.2182F, 0.0F, 0.0F));
		PartDefinition top_head_r3 = top_head.addOrReplaceChild("top_head_r3", CubeListBuilder.create().texOffs(10, 96).addBox(-5.0F, -4.0F, 4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.61F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1886F, 0.3864F, -0.0718F));
		PartDefinition base_head = Head_advanced.addOrReplaceChild("base_head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.7111F, 0.0F));
		PartDefinition glow8 = base_head.addOrReplaceChild("glow8", CubeListBuilder.create().texOffs(0, 22).addBox(-5.5F, -5.5F, -4.0F, 9.5F, 9.5F, 9.5F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.5F, -0.5F));
		PartDefinition Left_Horn = Head_advanced.addOrReplaceChild("Left_Horn", CubeListBuilder.create(), PartPose.offset(-7.3881F, -13.7299F, -4.6362F));
		PartDefinition Left_Horn_r1 = Left_Horn.addOrReplaceChild("Left_Horn_r1",
				CubeListBuilder.create().texOffs(52, 120).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(120, 113).addBox(-1.0F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.305F)),
				PartPose.offsetAndRotation(0.3214F, -1.6256F, -0.7527F, 0.3321F, 0.8449F, 0.2524F));
		PartDefinition Middle_Horn = Head_advanced.addOrReplaceChild("Middle_Horn", CubeListBuilder.create(), PartPose.offset(-0.0333F, -16.1115F, -7.157F));
		PartDefinition Middle_Horn_r1 = Middle_Horn.addOrReplaceChild("Middle_Horn_r1",
				CubeListBuilder.create().texOffs(118, 51).addBox(-1.0F, -5.0F, -1.5F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.29F)).texOffs(60, 120).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.301F)),
				PartPose.offsetAndRotation(0.5F, -0.2441F, -0.0541F, 0.2182F, 0.0F, 0.0F));
		PartDefinition Right_Horn = Head_advanced.addOrReplaceChild("Right_Horn", CubeListBuilder.create(), PartPose.offset(7.3231F, -13.7419F, -4.673F));
		PartDefinition Right_Horn_r1 = Right_Horn.addOrReplaceChild("Right_Horn_r1",
				CubeListBuilder.create().texOffs(120, 35).addBox(-1.0F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.305F)).texOffs(44, 120).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.3214F, -1.7914F, -0.0048F, 0.3321F, -0.8449F, -0.2524F));
		PartDefinition Right_Pannel = Head_advanced.addOrReplaceChild("Right_Pannel", CubeListBuilder.create(), PartPose.offset(7.2814F, -5.4395F, -5.0333F));
		PartDefinition Right_Pannel_r1 = Right_Pannel.addOrReplaceChild("Right_Pannel_r1", CubeListBuilder.create().texOffs(122, 7).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, -0.3927F));
		PartDefinition Left_Pannel = Head_advanced.addOrReplaceChild("Left_Pannel", CubeListBuilder.create(), PartPose.offset(-7.1036F, -5.4395F, -5.0333F));
		PartDefinition Left_Pannel_r1 = Left_Pannel.addOrReplaceChild("Left_Pannel_r1", CubeListBuilder.create().texOffs(14, 122).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.148F, -2.7716F, 0.0F, 0.0F, 0.3927F, 0.3927F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Body_normal = body.addOrReplaceChild("Body_normal", CubeListBuilder.create().texOffs(150, 154).addBox(-4.0F, -0.5333F, -2.0F, 8.0F, 12.0F, 5.0F, new CubeDeformation(0.5F)).texOffs(196, 151)
				.addBox(-2.0F, 1.2889F, -3.1778F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.65F)).texOffs(168, 171).addBox(-3.4998F, 9.308F, -2.491F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.655F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Body_normal_r1 = Body_normal.addOrReplaceChild("Body_normal_r1", CubeListBuilder.create().texOffs(150, 242).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.64F)),
				PartPose.offsetAndRotation(-0.0333F, -0.7539F, 5.7488F, -0.3778F, -0.7537F, 0.2648F));
		PartDefinition Body_normal_r2 = Body_normal.addOrReplaceChild("Body_normal_r2", CubeListBuilder.create().texOffs(202, 230).addBox(-6.0F, 0.0F, 2.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.681F)),
				PartPose.offsetAndRotation(2.8462F, -3.5333F, 1.1F, -0.0928F, -0.3477F, 0.0317F));
		PartDefinition Body_normal_r3 = Body_normal.addOrReplaceChild("Body_normal_r3", CubeListBuilder.create().texOffs(162, 223).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.8222F, -1.6444F, 0.0F, 0.0F, 0.7854F));
		PartDefinition Body_normal_r4 = Body_normal.addOrReplaceChild("Body_normal_r4", CubeListBuilder.create().texOffs(226, 202).addBox(1.0F, 0.0F, 2.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.68F)),
				PartPose.offsetAndRotation(-2.8462F, -3.5333F, 1.1F, -0.0928F, 0.3477F, -0.0317F));
		PartDefinition Body_normal_r5 = Body_normal.addOrReplaceChild("Body_normal_r5", CubeListBuilder.create().texOffs(196, 181).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.55F)),
				PartPose.offsetAndRotation(0.0F, 2.6111F, -2.5333F, 0.2618F, 0.0F, 0.0F));
		PartDefinition Body_normal_r6 = Body_normal.addOrReplaceChild("Body_normal_r6", CubeListBuilder.create().texOffs(194, 190).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.65F)),
				PartPose.offsetAndRotation(0.0F, 2.9333F, 0.9667F, -0.0873F, 0.0F, 0.0F));
		PartDefinition Body_normal_r7 = Body_normal.addOrReplaceChild("Body_normal_r7", CubeListBuilder.create().texOffs(118, 131).addBox(-6.0F, 0.0F, -3.5F, 12.0F, 6.0F, 7.0F, new CubeDeformation(0.68F)),
				PartPose.offsetAndRotation(0.0F, -3.5333F, 1.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition glow4 = Body_normal.addOrReplaceChild("glow4", CubeListBuilder.create(), PartPose.offset(0.0F, 10.8222F, -1.6444F));
		PartDefinition glow4_r1 = glow4.addOrReplaceChild("glow4_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition Body_advanced = body.addOrReplaceChild("Body_advanced", CubeListBuilder.create().texOffs(32, 32).addBox(-4.0F, -11.5333F, 2.0F, 8.0F, 12.0F, 5.0F, new CubeDeformation(0.5F)).texOffs(78, 29)
				.addBox(-2.0F, -9.7111F, 0.8222F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.65F)).texOffs(50, 49).addBox(-3.4998F, -1.692F, 1.509F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.655F)), PartPose.offset(0.0F, 11.0F, -4.0F));
		PartDefinition Body_advanced_r1 = Body_advanced.addOrReplaceChild("Body_advanced_r1", CubeListBuilder.create().texOffs(32, 120).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.64F)),
				PartPose.offsetAndRotation(-0.0333F, -11.7539F, 9.7488F, -0.3778F, -0.7537F, 0.2648F));
		PartDefinition Body_advanced_r2 = Body_advanced.addOrReplaceChild("Body_advanced_r2", CubeListBuilder.create().texOffs(84, 108).addBox(-6.0F, 0.0F, 2.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.681F)),
				PartPose.offsetAndRotation(2.8462F, -14.5333F, 5.1F, -0.0928F, -0.3477F, 0.0317F));
		PartDefinition Body_advanced_r3 = Body_advanced.addOrReplaceChild("Body_advanced_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -1.0F, -3.5F, 13.0F, 1.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.5333F, -15.3548F, 5.0852F, -0.0873F, 0.0F, 0.0F));
		PartDefinition Body_advanced_r4 = Body_advanced.addOrReplaceChild("Body_advanced_r4", CubeListBuilder.create().texOffs(44, 101).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.1778F, 2.3556F, 0.0F, 0.0F, 0.7854F));
		PartDefinition Body_advanced_r5 = Body_advanced.addOrReplaceChild("Body_advanced_r5", CubeListBuilder.create().texOffs(108, 80).addBox(1.0F, 0.0F, 2.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.68F)),
				PartPose.offsetAndRotation(-2.8462F, -14.5333F, 5.1F, -0.0928F, 0.3477F, -0.0317F));
		PartDefinition Body_advanced_r6 = Body_advanced.addOrReplaceChild("Body_advanced_r6", CubeListBuilder.create().texOffs(78, 59).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.55F)),
				PartPose.offsetAndRotation(0.0F, -8.3889F, 1.4667F, 0.2618F, 0.0F, 0.0F));
		PartDefinition Body_advanced_r7 = Body_advanced.addOrReplaceChild("Body_advanced_r7", CubeListBuilder.create().texOffs(76, 68).addBox(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.65F)),
				PartPose.offsetAndRotation(0.0F, -8.0667F, 4.9667F, -0.0873F, 0.0F, 0.0F));
		PartDefinition Body_advanced_r8 = Body_advanced.addOrReplaceChild("Body_advanced_r8", CubeListBuilder.create().texOffs(0, 9).addBox(-6.0F, 0.0F, -3.5F, 12.0F, 6.0F, 7.0F, new CubeDeformation(0.68F)),
				PartPose.offsetAndRotation(0.0F, -14.5333F, 5.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition glow9 = Body_advanced.addOrReplaceChild("glow9", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 12.4667F, 4.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(4.0F, 2.7F, 0.0F));
		PartDefinition LeftArm_normal = left_arm.addOrReplaceChild("LeftArm_normal", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftArm5 = LeftArm_normal.addOrReplaceChild("leftArm5", CubeListBuilder.create(), PartPose.offset(3.6444F, 3.6111F, 0.0F));
		PartDefinition leftArm5_r1 = leftArm5.addOrReplaceChild("leftArm5_r1", CubeListBuilder.create().texOffs(182, 223).mirror().addBox(1.0F, -1.5F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition leftArm5_r2 = leftArm5.addOrReplaceChild("leftArm5_r2", CubeListBuilder.create().texOffs(134, 232).mirror().addBox(4.0F, -2.5F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-0.1778F, 0.0F, 0.5333F, 0.0F, 0.0F, 1.5708F));
		PartDefinition leftArm5_r3 = leftArm5.addOrReplaceChild("leftArm5_r3", CubeListBuilder.create().texOffs(140, 212).mirror().addBox(0.0F, -1.5F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.05F)).mirror(false).texOffs(186, 233).mirror()
				.addBox(0.0F, -2.5F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1778F, -2.0667F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition leftArm6 = LeftArm_normal.addOrReplaceChild("leftArm6", CubeListBuilder.create().texOffs(236, 166).mirror().addBox(-2.4547F, -1.3398F, -3.4092F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(2.1658F, 4.2731F, 0.9425F));
		PartDefinition leftArm6_r1 = leftArm6.addOrReplaceChild("leftArm6_r1", CubeListBuilder.create().texOffs(238, 143).mirror().addBox(-4.0F, -2.99F, -2.4867F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(7.1897F, -5.4509F, 0.1353F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition leftArm7 = LeftArm_normal.addOrReplaceChild("leftArm7", CubeListBuilder.create().texOffs(210, 200).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(2.0667F, 3.4667F, 0.0F));
		PartDefinition shoulder_normal2 = LeftArm_normal.addOrReplaceChild("shoulder_normal2", CubeListBuilder.create(), PartPose.offset(5.7111F, -2.5333F, 0.5444F));
		PartDefinition shoulder_normal2_r1 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r1", CubeListBuilder.create().texOffs(226, 190).mirror().addBox(-4.0F, -3.99F, -2.4867F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.011F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r2 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r2", CubeListBuilder.create().texOffs(218, 122).mirror().addBox(-4.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0332F, 1.416F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r3 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r3", CubeListBuilder.create().texOffs(220, 235).mirror().addBox(-4.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(0.8222F, 0.3556F, 0.5333F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r4 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r4", CubeListBuilder.create().texOffs(168, 233).mirror().addBox(-4.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.8222F, 0.4762F, -2.0381F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r5 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r5", CubeListBuilder.create().texOffs(118, 229).mirror().addBox(-4.0F, -4.0F, -4.2222F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.0041F, 0.108F, -1.6337F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r6 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r6", CubeListBuilder.create().texOffs(118, 222).mirror().addBox(-4.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -2.5111F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r7 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r7", CubeListBuilder.create().texOffs(214, 159).mirror().addBox(-4.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -2.3333F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r8 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r8", CubeListBuilder.create().texOffs(214, 152).mirror().addBox(-4.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0332F, 1.5938F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder_normal2_r9 = shoulder_normal2.addOrReplaceChild("shoulder_normal2_r9", CubeListBuilder.create().texOffs(238, 150).mirror().addBox(-4.0F, -3.0F, -2.2222F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.6444F, 1.4762F, -2.0381F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition glow1 = shoulder_normal2.addOrReplaceChild("glow1", CubeListBuilder.create(), PartPose.offset(0.8222F, 0.4762F, -2.0381F));
		PartDefinition glow1_r1 = glow1.addOrReplaceChild("glow1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition glow1_r2 = glow1.addOrReplaceChild("glow1_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -0.1206F, 2.5714F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition LeftArm_advanced = left_arm.addOrReplaceChild("LeftArm_advanced", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition coudiere2 = LeftArm_advanced.addOrReplaceChild("coudiere2", CubeListBuilder.create().texOffs(118, 44).mirror().addBox(-2.0001F, -0.4999F, -2.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(1.7112F, 3.4332F, 0.2833F));
		PartDefinition leftArm4 = coudiere2.addOrReplaceChild("leftArm4", CubeListBuilder.create(), PartPose.offset(3.1111F, 4.1112F, -0.2833F));
		PartDefinition leftArm4_r1 = leftArm4.addOrReplaceChild("leftArm4_r1", CubeListBuilder.create().texOffs(68, 111).mirror().addBox(0.0F, -2.5F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 90).mirror()
				.addBox(0.0F, -1.5F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -6.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition leftArm4_r2 = leftArm4.addOrReplaceChild("leftArm4_r2", CubeListBuilder.create().texOffs(64, 101).mirror().addBox(1.0F, -1.5F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.1778F, -3.9333F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition leftArm4_r3 = leftArm4.addOrReplaceChild("leftArm4_r3", CubeListBuilder.create().texOffs(16, 110).mirror().addBox(4.0F, -2.5F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.3556F, -3.9333F, 0.5333F, 0.0F, 0.0F, 1.5708F));
		PartDefinition flame3 = leftArm4.addOrReplaceChild("flame3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3889F, -1.0444F, -0.1111F, 0.0F, 0.0F, 1.0472F));
		PartDefinition glow5 = flame3.addOrReplaceChild("glow5", CubeListBuilder.create().texOffs(134, 0).addBox(-5.5F, -5.5F, 0.0F, 9.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0981F, -5.8301F, 0.0F));
		PartDefinition shoulder2 = LeftArm_advanced.addOrReplaceChild("shoulder2", CubeListBuilder.create(), PartPose.offset(1.5333F, -2.0571F, -1.4937F));
		PartDefinition shoulder2_r1 = shoulder2.addOrReplaceChild("shoulder2_r1", CubeListBuilder.create().texOffs(108, 68).mirror().addBox(-4.0F, -3.99F, -2.4867F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.011F)).mirror(false),
				PartPose.offsetAndRotation(4.1778F, -0.4762F, 2.0381F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r2 = shoulder2.addOrReplaceChild("shoulder2_r2", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-4.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(4.1778F, -0.443F, 3.4541F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r3 = shoulder2.addOrReplaceChild("shoulder2_r3", CubeListBuilder.create().texOffs(120, 21).mirror().addBox(-4.0F, -2.99F, -2.4867F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(7.8222F, 0.8794F, 2.5714F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r4 = shoulder2.addOrReplaceChild("shoulder2_r4", CubeListBuilder.create().texOffs(50, 111).mirror().addBox(-4.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r5 = shoulder2.addOrReplaceChild("shoulder2_r5", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-4.0F, -4.0F, -4.2222F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.1736F, -0.3682F, 0.4044F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r6 = shoulder2.addOrReplaceChild("shoulder2_r6", CubeListBuilder.create().texOffs(0, 100).mirror().addBox(-4.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(4.1778F, -0.4762F, -0.473F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r7 = shoulder2.addOrReplaceChild("shoulder2_r7", CubeListBuilder.create().texOffs(96, 37).mirror().addBox(-4.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.1778F, -0.4762F, -0.2952F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r8 = shoulder2.addOrReplaceChild("shoulder2_r8", CubeListBuilder.create().texOffs(96, 30).mirror().addBox(-4.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(4.1778F, -0.443F, 3.6319F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r9 = shoulder2.addOrReplaceChild("shoulder2_r9", CubeListBuilder.create().texOffs(120, 28).mirror().addBox(-4.0F, -3.0F, -2.2222F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(7.8222F, 1.0F, 0.0F, 0.3927F, 0.0F, 0.1309F));
		PartDefinition shoulder2_r10 = shoulder2.addOrReplaceChild("shoulder2_r10", CubeListBuilder.create().texOffs(102, 113).mirror().addBox(-4.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, -0.1206F, 2.5714F, -0.3927F, 0.0F, 0.1309F));
		PartDefinition base_arm2 = LeftArm_advanced.addOrReplaceChild("base_arm2", CubeListBuilder.create().texOffs(92, 78).mirror().addBox(-2.0F, 0.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5667F, -3.5333F, -0.5F));
		PartDefinition flame4 = LeftArm_advanced.addOrReplaceChild("flame4", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, -4.5F, -0.1111F, 0.0F, 0.0F, 0.48F));
		PartDefinition glow = flame4.addOrReplaceChild("glow", CubeListBuilder.create().texOffs(137, 12).addBox(-6.5F, -6.5F, 0.0F, 13.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7775F, -7.1691F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.7F, 0.0F));
		PartDefinition RightArm_normal = right_arm.addOrReplaceChild("RightArm_normal", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightArm5 = RightArm_normal.addOrReplaceChild("rightArm5", CubeListBuilder.create(), PartPose.offset(-3.6444F, 3.6111F, 0.0F));
		PartDefinition rightArm5_r1 = rightArm5.addOrReplaceChild("rightArm5_r1", CubeListBuilder.create().texOffs(182, 223).addBox(-5.0F, -1.5F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition rightArm5_r2 = rightArm5.addOrReplaceChild("rightArm5_r2", CubeListBuilder.create().texOffs(134, 232).addBox(-5.0F, -2.5F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.1778F, 0.0F, 0.5333F, 0.0F, 0.0F, -1.5708F));
		PartDefinition rightArm5_r3 = rightArm5.addOrReplaceChild("rightArm5_r3",
				CubeListBuilder.create().texOffs(140, 212).addBox(-5.0F, -1.5F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.05F)).texOffs(186, 233).addBox(-1.0F, -2.5F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1778F, -2.0667F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition rightArm6 = RightArm_normal.addOrReplaceChild("rightArm6", CubeListBuilder.create().texOffs(236, 166).addBox(-1.5453F, -1.3398F, -3.4092F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-2.1658F, 4.2731F, 0.9425F));
		PartDefinition rightArm6_r1 = rightArm6.addOrReplaceChild("rightArm6_r1", CubeListBuilder.create().texOffs(238, 143).addBox(2.0F, -2.99F, -2.4867F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-7.1897F, -5.4509F, 0.1353F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition rightArm7 = RightArm_normal.addOrReplaceChild("rightArm7", CubeListBuilder.create().texOffs(210, 200).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.0667F, 3.4667F, 0.0F));
		PartDefinition shoulder_normal3 = RightArm_normal.addOrReplaceChild("shoulder_normal3", CubeListBuilder.create(), PartPose.offset(-5.7111F, -2.5333F, 0.5444F));
		PartDefinition shoulder_normal3_r1 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r1", CubeListBuilder.create().texOffs(226, 190).addBox(3.0F, -3.99F, -2.4867F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.011F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r2 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r2", CubeListBuilder.create().texOffs(218, 122).addBox(-3.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0332F, 1.416F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r3 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r3", CubeListBuilder.create().texOffs(220, 235).addBox(1.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-0.8222F, 0.3556F, 0.5333F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r4 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r4", CubeListBuilder.create().texOffs(168, 233).addBox(1.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.8222F, 0.4762F, -2.0381F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r5 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r5", CubeListBuilder.create().texOffs(118, 229).addBox(3.0F, -4.0F, -4.2222F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0041F, 0.108F, -1.6337F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r6 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r6", CubeListBuilder.create().texOffs(118, 222).addBox(-3.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -2.5111F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r7 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r7", CubeListBuilder.create().texOffs(214, 159).addBox(-3.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -2.3333F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r8 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r8", CubeListBuilder.create().texOffs(214, 152).addBox(-3.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 0.0332F, 1.5938F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder_normal3_r9 = shoulder_normal3.addOrReplaceChild("shoulder_normal3_r9", CubeListBuilder.create().texOffs(238, 150).addBox(2.0F, -3.0F, -2.2222F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.6444F, 1.4762F, -2.0381F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition glow2 = shoulder_normal3.addOrReplaceChild("glow2", CubeListBuilder.create(), PartPose.offset(-0.8222F, 0.4762F, -2.0381F));
		PartDefinition glow2_r1 = glow2.addOrReplaceChild("glow2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition glow2_r2 = glow2.addOrReplaceChild("glow2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -0.1206F, 2.5714F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition RightArm_advanced = right_arm.addOrReplaceChild("RightArm_advanced", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition coudiere3 = RightArm_advanced.addOrReplaceChild("coudiere3", CubeListBuilder.create().texOffs(118, 44).addBox(-1.9999F, -0.4999F, -2.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-1.7112F, 3.4332F, 0.2833F));
		PartDefinition rightArm4 = coudiere3.addOrReplaceChild("rightArm4", CubeListBuilder.create(), PartPose.offset(-3.1111F, 4.1112F, -0.2833F));
		PartDefinition rightArm4_r1 = rightArm4.addOrReplaceChild("rightArm4_r1",
				CubeListBuilder.create().texOffs(68, 111).addBox(-1.0F, -2.5F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(22, 90).addBox(-5.0F, -1.5F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(1.0F, -6.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition rightArm4_r2 = rightArm4.addOrReplaceChild("rightArm4_r2", CubeListBuilder.create().texOffs(64, 101).addBox(-5.0F, -1.5F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.1778F, -3.9333F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition rightArm4_r3 = rightArm4.addOrReplaceChild("rightArm4_r3", CubeListBuilder.create().texOffs(16, 110).addBox(-5.0F, -2.5F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.3556F, -3.9333F, 0.5333F, 0.0F, 0.0F, -1.5708F));
		PartDefinition flame2 = rightArm4.addOrReplaceChild("flame2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3889F, -1.0444F, -0.1111F, 0.0F, 0.0F, -1.0472F));
		PartDefinition glow6 = flame2.addOrReplaceChild("glow6", CubeListBuilder.create().texOffs(134, 0).mirror().addBox(-3.5F, -5.5F, 0.0F, 9.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0981F, -5.8301F, 0.0F));
		PartDefinition shoulder3 = RightArm_advanced.addOrReplaceChild("shoulder3", CubeListBuilder.create(), PartPose.offset(-1.5333F, -2.0571F, -1.4937F));
		PartDefinition shoulder3_r1 = shoulder3.addOrReplaceChild("shoulder3_r1", CubeListBuilder.create().texOffs(108, 68).addBox(3.0F, -3.99F, -2.4867F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.011F)),
				PartPose.offsetAndRotation(-4.1778F, -0.4762F, 2.0381F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r2 = shoulder3.addOrReplaceChild("shoulder3_r2", CubeListBuilder.create().texOffs(100, 0).addBox(-3.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-4.1778F, -0.443F, 3.4541F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r3 = shoulder3.addOrReplaceChild("shoulder3_r3", CubeListBuilder.create().texOffs(120, 21).addBox(2.0F, -2.99F, -2.4867F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-7.8222F, 0.8794F, 2.5714F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r4 = shoulder3.addOrReplaceChild("shoulder3_r4", CubeListBuilder.create().texOffs(50, 111).addBox(1.0F, -3.0F, -3.2222F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r5 = shoulder3.addOrReplaceChild("shoulder3_r5", CubeListBuilder.create().texOffs(0, 107).addBox(3.0F, -4.0F, -4.2222F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.1736F, -0.3682F, 0.4044F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r6 = shoulder3.addOrReplaceChild("shoulder3_r6", CubeListBuilder.create().texOffs(0, 100).addBox(-3.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-4.1778F, -0.4762F, -0.473F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r7 = shoulder3.addOrReplaceChild("shoulder3_r7", CubeListBuilder.create().texOffs(96, 37).addBox(-3.0F, -1.0F, -2.6F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.1778F, -0.4762F, -0.2952F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r8 = shoulder3.addOrReplaceChild("shoulder3_r8", CubeListBuilder.create().texOffs(96, 30).addBox(-3.0F, -1.0F, -2.4867F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-4.1778F, -0.443F, 3.6319F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r9 = shoulder3.addOrReplaceChild("shoulder3_r9", CubeListBuilder.create().texOffs(120, 28).addBox(2.0F, -3.0F, -2.2222F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.8222F, 1.0F, 0.0F, 0.3927F, 0.0F, -0.1309F));
		PartDefinition shoulder3_r10 = shoulder3.addOrReplaceChild("shoulder3_r10", CubeListBuilder.create().texOffs(102, 113).addBox(1.0F, -2.99F, -2.4867F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-5.0F, -0.1206F, 2.5714F, -0.3927F, 0.0F, -0.1309F));
		PartDefinition base_arm3 = RightArm_advanced.addOrReplaceChild("base_arm3", CubeListBuilder.create().texOffs(92, 78).addBox(-3.0F, 0.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5667F, -3.5333F, -0.5F));
		PartDefinition flame5 = RightArm_advanced.addOrReplaceChild("flame5", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.5F, -4.5F, -0.1111F, 0.0F, 0.0F, -0.48F));
		PartDefinition glow7 = flame5.addOrReplaceChild("glow7", CubeListBuilder.create().texOffs(137, 12).mirror().addBox(-6.5F, -6.5F, 0.0F, 13.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.7775F, -7.1691F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.1F, 12.0F, 0.0F));
		PartDefinition LeftLeg_advanced = left_leg.addOrReplaceChild("LeftLeg_advanced", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_leg_genou = LeftLeg_advanced.addOrReplaceChild("left_leg_genou", CubeListBuilder.create(), PartPose.offset(0.8556F, 1.9667F, -2.9667F));
		PartDefinition left_leg_genou_r1 = left_leg_genou.addOrReplaceChild("left_leg_genou_r1", CubeListBuilder.create().texOffs(54, 96).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition left_leg_genou_r2 = left_leg_genou.addOrReplaceChild("left_leg_genou_r2", CubeListBuilder.create().texOffs(44, 96).addBox(-3.5F, -3.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.3555F, -0.1778F, 0.0F, 0.0F, 0.7854F));
		PartDefinition left_leg_genou_r3 = left_leg_genou.addOrReplaceChild("left_leg_genou_r3", CubeListBuilder.create().texOffs(94, 55).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition glow12 = LeftLeg_advanced.addOrReplaceChild("glow12", CubeListBuilder.create(), PartPose.offset(0.8333F, 12.1111F, 0.2F));
		PartDefinition base = glow12.addOrReplaceChild("base", CubeListBuilder.create().texOffs(76, 78).addBox(-2.7F, -13.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition robe = LeftLeg_advanced.addOrReplaceChild("robe", CubeListBuilder.create(), PartPose.offset(-4.0333F, -1.8889F, 1.6F));
		PartDefinition robe_r1 = robe.addOrReplaceChild("robe_r1",
				CubeListBuilder.create().texOffs(24, 80).addBox(3.9F, -10.0F, -5.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.559F)).texOffs(58, 32).addBox(-0.1F, -12.0F, -3.6444F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.559F)),
				PartPose.offsetAndRotation(5.8667F, 10.0F, 1.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition robe_r2 = robe.addOrReplaceChild("robe_r2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(0.5F, -4.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.65F)).mirror(false),
				PartPose.offsetAndRotation(2.9331F, 6.7302F, -0.091F, 0.2618F, 0.0F, 0.0F));
		PartDefinition robe_r3 = robe.addOrReplaceChild("robe_r3", CubeListBuilder.create().texOffs(42, 0).addBox(-0.1F, -12.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.559F)),
				PartPose.offsetAndRotation(6.8667F, 10.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition LeftLeg_normal = left_leg.addOrReplaceChild("LeftLeg_normal", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition LeftLeg_robe = LeftLeg_normal.addOrReplaceChild("LeftLeg_robe", CubeListBuilder.create(), PartPose.offset(2.8333F, -1.8889F, 1.6F));
		PartDefinition LeftLeg_robe_r1 = LeftLeg_robe.addOrReplaceChild("LeftLeg_robe_r1", CubeListBuilder.create().texOffs(118, 160).mirror().addBox(0.5F, -4.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.65F)).mirror(false),
				PartPose.offsetAndRotation(-3.9336F, 6.7302F, -0.091F, 0.2618F, 0.0F, 0.0F));
		PartDefinition LeftLeg_robe_r2 = LeftLeg_robe.addOrReplaceChild("LeftLeg_robe_r2", CubeListBuilder.create().texOffs(160, 122).addBox(-0.1F, -12.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.559F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition LeftLeg_robe_r3 = LeftLeg_robe.addOrReplaceChild("LeftLeg_robe_r3",
				CubeListBuilder.create().texOffs(176, 154).addBox(-0.1F, -12.0F, -3.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.559F)).texOffs(142, 202).addBox(3.9F, -10.0F, -2.3556F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.559F)),
				PartPose.offsetAndRotation(-1.0F, 10.0F, 0.3556F, 0.0F, 0.0F, -0.3927F));
		PartDefinition LeftLeg_genoux = LeftLeg_normal.addOrReplaceChild("LeftLeg_genoux", CubeListBuilder.create().texOffs(194, 200).addBox(-2.1417F, -4.377F, 0.5944F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.551F)),
				PartPose.offset(0.775F, 3.4881F, -2.3944F));
		PartDefinition LeftLeg_genoux_r1 = LeftLeg_genoux.addOrReplaceChild("LeftLeg_genoux_r1", CubeListBuilder.create().texOffs(172, 218).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0806F, -1.5214F, -0.5722F, 0.0F, 0.0F, 0.7854F));
		PartDefinition LeftLeg_genoux_r2 = LeftLeg_genoux.addOrReplaceChild("LeftLeg_genoux_r2", CubeListBuilder.create().texOffs(162, 218).addBox(-3.5F, -3.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0806F, 0.8341F, -0.75F, 0.0F, 0.0F, 0.7854F));
		PartDefinition LeftLeg_genoux_r3 = LeftLeg_genoux.addOrReplaceChild("LeftLeg_genoux_r3", CubeListBuilder.create().texOffs(212, 177).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0806F, 0.4786F, -0.5722F, 0.0F, 0.0F, 0.7854F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.1F, 12.0F, 0.0F));
		PartDefinition LeftLeg_advanced2 = right_leg.addOrReplaceChild("LeftLeg_advanced2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_leg_genou2 = LeftLeg_advanced2.addOrReplaceChild("left_leg_genou2", CubeListBuilder.create(), PartPose.offset(-0.8556F, 1.9667F, -2.9667F));
		PartDefinition left_leg_genou2_r1 = left_leg_genou2.addOrReplaceChild("left_leg_genou2_r1", CubeListBuilder.create().texOffs(54, 96).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition left_leg_genou2_r2 = left_leg_genou2.addOrReplaceChild("left_leg_genou2_r2", CubeListBuilder.create().texOffs(44, 96).mirror().addBox(-1.5F, -3.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.3555F, -0.1778F, 0.0F, 0.0F, -0.7854F));
		PartDefinition left_leg_genou2_r3 = left_leg_genou2.addOrReplaceChild("left_leg_genou2_r3", CubeListBuilder.create().texOffs(94, 55).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition glow13 = LeftLeg_advanced2.addOrReplaceChild("glow13", CubeListBuilder.create(), PartPose.offset(-0.8333F, 2.6111F, 0.2F));
		PartDefinition base3 = glow13.addOrReplaceChild("base3", CubeListBuilder.create().texOffs(76, 78).mirror().addBox(-2.3F, -13.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.5F, 0.0F));
		PartDefinition robe3 = LeftLeg_advanced2.addOrReplaceChild("robe3", CubeListBuilder.create(), PartPose.offset(-1.8333F, -1.8889F, 1.6F));
		PartDefinition robe3_r1 = robe3.addOrReplaceChild("robe3_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-4.5F, -4.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.65F)),
				PartPose.offsetAndRotation(2.9336F, 6.7302F, -0.091F, 0.2618F, 0.0F, 0.0F));
		PartDefinition robe3_r2 = robe3.addOrReplaceChild("robe3_r2", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(-4.9F, -12.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.559F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition robe3_r3 = robe3.addOrReplaceChild("robe3_r3", CubeListBuilder.create().texOffs(58, 32).mirror().addBox(-4.9F, -12.0F, -3.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.559F)).mirror(false).texOffs(24, 80).mirror()
				.addBox(-6.9F, -10.0F, -4.3556F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.559F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.3556F, 0.0F, 0.0F, 0.3927F));
		PartDefinition LeftLeg_normal2 = right_leg.addOrReplaceChild("LeftLeg_normal2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition LeftLeg_robe2 = LeftLeg_normal2.addOrReplaceChild("LeftLeg_robe2", CubeListBuilder.create(), PartPose.offset(-2.8333F, -1.8889F, 1.6F));
		PartDefinition LeftLeg_robe2_r1 = LeftLeg_robe2.addOrReplaceChild("LeftLeg_robe2_r1", CubeListBuilder.create().texOffs(118, 160).addBox(-4.5F, -4.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.65F)),
				PartPose.offsetAndRotation(3.9336F, 6.7302F, -0.091F, 0.2618F, 0.0F, 0.0F));
		PartDefinition LeftLeg_robe2_r2 = LeftLeg_robe2.addOrReplaceChild("LeftLeg_robe2_r2", CubeListBuilder.create().texOffs(160, 122).mirror().addBox(-4.9F, -12.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.559F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition LeftLeg_robe2_r3 = LeftLeg_robe2.addOrReplaceChild("LeftLeg_robe2_r3", CubeListBuilder.create().texOffs(176, 154).mirror().addBox(-4.9F, -12.0F, -3.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.559F)).mirror(false)
				.texOffs(142, 202).mirror().addBox(-6.9F, -10.0F, -3.3556F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.559F)).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 0.3556F, 0.0F, 0.0F, 0.3927F));
		PartDefinition LeftLeg_genoux2 = LeftLeg_normal2.addOrReplaceChild("LeftLeg_genoux2", CubeListBuilder.create().texOffs(194, 200).mirror().addBox(-1.8583F, -4.377F, 0.5944F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.551F)).mirror(false),
				PartPose.offset(-0.775F, 3.4881F, -2.3944F));
		PartDefinition LeftLeg_genoux2_r1 = LeftLeg_genoux2.addOrReplaceChild("LeftLeg_genoux2_r1", CubeListBuilder.create().texOffs(172, 218).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.0806F, -1.5214F, -0.5722F, 0.0F, 0.0F, -0.7854F));
		PartDefinition LeftLeg_genoux2_r2 = LeftLeg_genoux2.addOrReplaceChild("LeftLeg_genoux2_r2", CubeListBuilder.create().texOffs(162, 218).mirror().addBox(-1.5F, -3.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.0806F, 0.8341F, -0.75F, 0.0F, 0.0F, -0.7854F));
		PartDefinition LeftLeg_genoux2_r3 = LeftLeg_genoux2.addOrReplaceChild("LeftLeg_genoux2_r3", CubeListBuilder.create().texOffs(212, 177).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.0806F, 0.4786F, -0.5722F, 0.0F, 0.0F, -0.7854F));
		PartDefinition left_foot = partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.offset(-1.1F, 24.5F, 0.0F));
		PartDefinition leftfoot_normal = left_foot.addOrReplaceChild("leftfoot_normal",
				CubeListBuilder.create().texOffs(146, 190).addBox(-3.1F, -6.0667F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(156, 140).addBox(-3.1F, -3.0667F, -4.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition leftfoot_normal_r1 = leftfoot_normal.addOrReplaceChild("leftfoot_normal_r1", CubeListBuilder.create().texOffs(168, 181).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1222F, -5.0667F, -1.0333F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leftfoot_advanced = left_foot.addOrReplaceChild("leftfoot_advanced",
				CubeListBuilder.create().texOffs(28, 68).addBox(-3.1F, -6.0667F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 18).addBox(-3.1F, -3.0667F, -4.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition leftfoot_advanced_r1 = leftfoot_advanced.addOrReplaceChild("leftfoot_advanced_r1", CubeListBuilder.create().texOffs(50, 59).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1222F, -5.0667F, -1.0333F, -0.0873F, 0.0F, 0.0F));
		PartDefinition right_foot = partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.offset(1.1F, 24.5F, 0.0F));
		PartDefinition leftfoot_normal2 = right_foot.addOrReplaceChild("leftfoot_normal2", CubeListBuilder.create().texOffs(146, 190).mirror().addBox(-2.9F, -6.0667F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(156, 140)
				.mirror().addBox(-2.9F, -3.0667F, -4.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition leftfoot_normal2_r1 = leftfoot_normal2.addOrReplaceChild("leftfoot_normal2_r1", CubeListBuilder.create().texOffs(168, 181).mirror().addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1222F, -5.0667F, -1.0333F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leftfoot_advanced2 = right_foot.addOrReplaceChild("leftfoot_advanced2", CubeListBuilder.create().texOffs(28, 68).mirror().addBox(-2.9F, -6.0667F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(38, 18)
				.mirror().addBox(-2.9F, -3.0667F, -4.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition leftfoot_advanced2_r1 = leftfoot_advanced2.addOrReplaceChild("leftfoot_advanced2_r1", CubeListBuilder.create().texOffs(50, 59).mirror().addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1222F, -5.0667F, -1.0333F, -0.0873F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}