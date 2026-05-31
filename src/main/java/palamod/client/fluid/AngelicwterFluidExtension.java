package palamod.client.fluid;

import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.renderer.block.FluidModel;

@EventBusSubscriber(Dist.CLIENT)
public class AngelicwterFluidExtension {
	@SubscribeEvent
	public static void registerRegisterFluidModels(RegisterFluidModelsEvent event) {
		event.register(new FluidModel.Unbaked(new Material(Identifier.parse("palamod:block/angelicwater_still")), new Material(Identifier.parse("palamod:block/angelicwater_flowing")), null, null), PalamodModFluids.ANGELIC_WATER,
				PalamodModFluids.FLOWING_ANGELIC_WATER);
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
		}, PalamodModFluidTypes.ANGELIC_WATER_TYPE);
	}
}