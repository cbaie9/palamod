package palamod.client.fluid;

import palamod.init.PalamodModFluidTypes;

import org.joml.Vector4f;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class FakewterFluidExtension {
	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("minecraft:block/water_still");
			private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("minecraft:block/water_flow");
			private static final ResourceLocation RENDER_OVERLAY_TEXTURE = ResourceLocation.parse("palamod:textures/water_overlay.png");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}

			@Override
			public ResourceLocation getRenderOverlayTexture(Minecraft minecraft) {
				return RENDER_OVERLAY_TEXTURE;
			}

			@Override
			public Vector4f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
				return new Vector4f(0.1450980392f, 0.231372549f, 0.4196078431f, fluidFogColor.w);
			}

			@Override
			public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
				float nearDistance = fogData.environmentalStart;
				float farDistance = fogData.environmentalEnd;
				Entity entity = camera.getEntity();
				Level world = entity.level();
				fogData.environmentalStart = 0f;
				fogData.environmentalEnd = Math.min(48f, renderDistance);
			}

			@Override
			public int getTintColor() {
				return -13083194;
			}

			@Override
			public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
				return BiomeColors.getAverageWaterColor(world, pos) | 0xFF000000;
			}
		}, PalamodModFluidTypes.FAKE_WATER_TYPE.get());
	}
}