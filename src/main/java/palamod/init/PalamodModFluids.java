
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.FakewterFluid;
import palamod.fluid.AngelicwterFluid;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class PalamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, PalamodMod.MODID);
	public static final RegistryObject<FlowingFluid> FAKEWTER = REGISTRY.register("fakewter", () -> new FakewterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_FAKEWTER = REGISTRY.register("flowing_fakewter", () -> new FakewterFluid.Flowing());
	public static final RegistryObject<FlowingFluid> ANGELICWTER = REGISTRY.register("angelicwter", () -> new AngelicwterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_ANGELICWTER = REGISTRY.register("flowing_angelicwter", () -> new AngelicwterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
