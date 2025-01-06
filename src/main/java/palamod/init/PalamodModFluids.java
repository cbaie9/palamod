
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
	public static final DeferredHolder<Fluid, FlowingFluid> FAKEWTER = REGISTRY.register("fakewter", () -> new FakewterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_FAKEWTER = REGISTRY.register("flowing_fakewter", () -> new FakewterFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> ANGELICWTER = REGISTRY.register("angelicwter", () -> new AngelicwterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ANGELICWTER = REGISTRY.register("flowing_angelicwter", () -> new AngelicwterFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FAKEWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FAKEWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ANGELICWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ANGELICWTER.get(), RenderType.translucent());
		}
	}
}
