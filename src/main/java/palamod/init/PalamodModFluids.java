
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.FakewterFluid;
import palamod.fluid.AngelicwterFluid;

import palamod.PalamodMod;

public class PalamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, PalamodMod.MODID);
	public static final RegistryObject<FlowingFluid> FAKEWTER = REGISTRY.register("fakewter", () -> new FakewterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_FAKEWTER = REGISTRY.register("flowing_fakewter", () -> new FakewterFluid.Flowing());
	public static final RegistryObject<FlowingFluid> ANGELICWTER = REGISTRY.register("angelicwter", () -> new AngelicwterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_ANGELICWTER = REGISTRY.register("flowing_angelicwter", () -> new AngelicwterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FAKEWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FAKEWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ANGELICWTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ANGELICWTER.get(), RenderType.translucent());
		}
	}
}
