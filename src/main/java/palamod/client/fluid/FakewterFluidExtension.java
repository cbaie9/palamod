package palamod.client.fluid;

import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;

import org.joml.Vector4f;

import net.neoforged.neoforge.client.fluid.FluidTintSource;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class FakewterFluidExtension {
	@SubscribeEvent
	public static void registerRegisterFluidModels(RegisterFluidModelsEvent event) {
		event.register(new FluidModel.Unbaked(new Material(Identifier.parse("minecraft:block/water_still")), new Material(Identifier.parse("minecraft:block/water_flow")), null, new FluidTintSource() {
			@Override
			public int color(FluidState state) {
				return -13083194;
			}

			@Override
			public int colorInWorld(FluidState state, BlockState blockState, BlockAndTintGetter world, BlockPos pos) {
				return BiomeColors.getAverageWaterColor(world, pos) | 0xFF000000;
			}
		}), PalamodModFluids.FAKE_WATER, PalamodModFluids.FLOWING_FAKE_WATER);
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final Identifier RENDER_OVERLAY_TEXTURE = Identifier.parse("palamod:textures/water_overlay.png");

			@Override
			public Identifier getRenderOverlayTexture(Minecraft minecraft) {
				return RENDER_OVERLAY_TEXTURE;
			}

			@Override
			public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
				fluidFogColor.set(0.1450980392f, 0.231372549f, 0.4196078431f, fluidFogColor.w);
			}

			@Override
			public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
				float nearDistance = fogData.environmentalStart;
				float farDistance = fogData.environmentalEnd;
				Entity entity = camera.entity();
				Level world = entity.level();
				fogData.environmentalStart = 0f;
				fogData.environmentalEnd = Math.min(48f, renderDistance);
			}
		}, PalamodModFluidTypes.FAKE_WATER_TYPE);
	}
}