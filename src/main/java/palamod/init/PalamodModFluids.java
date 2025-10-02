/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.FakewterFluid;
import palamod.fluid.AngelicwterFluid;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class PalamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, PalamodMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> FAKE_WATER = REGISTRY.register("fake_water", () -> new FakewterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_FAKE_WATER = REGISTRY.register("flowing_fake_water", () -> new FakewterFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> ANGELIC_WATER = REGISTRY.register("angelic_water", () -> new AngelicwterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ANGELIC_WATER = REGISTRY.register("flowing_angelic_water", () -> new AngelicwterFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FAKE_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FAKE_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ANGELIC_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ANGELIC_WATER.get(), RenderType.translucent());
		}
	}
}