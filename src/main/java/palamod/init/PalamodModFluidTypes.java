/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.types.FakewterFluidType;
import palamod.fluid.types.AngelicwterFluidType;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

public class PalamodModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, PalamodMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> FAKE_WATER_TYPE = REGISTRY.register("fake_water", () -> new FakewterFluidType());
	public static final DeferredHolder<FluidType, FluidType> ANGELIC_WATER_TYPE = REGISTRY.register("angelic_water", () -> new AngelicwterFluidType());
}