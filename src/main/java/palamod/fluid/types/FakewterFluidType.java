
package palamod.fluid.types;

import palamod.init.PalamodModFluidTypes;

import org.joml.Vector3f;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.shaders.FogShape;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FakewterFluidType extends FluidType {
	public FakewterFluidType() {
		super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

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
			public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
				return RENDER_OVERLAY_TEXTURE;
			}

			@Override
			public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
				return new Vector3f(0.1450980392f, 0.231372549f, 0.4196078431f);
			}

			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
				Entity entity = camera.getEntity();
				Level world = entity.level();
				RenderSystem.setShaderFogShape(FogShape.SPHERE);
				RenderSystem.setShaderFogStart(0f);
				RenderSystem.setShaderFogEnd(Math.min(48f, renderDistance));
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
