/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.FakewterFluid;
import palamod.fluid.AngelicwterFluid;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;

public class PalamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, PalamodMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> FAKE_WATER = REGISTRY.register("fake_water", FakewterFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_FAKE_WATER = REGISTRY.register("flowing_fake_water", FakewterFluid.Flowing::new);
	public static final DeferredHolder<Fluid, FlowingFluid> ANGELIC_WATER = REGISTRY.register("angelic_water", AngelicwterFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ANGELIC_WATER = REGISTRY.register("flowing_angelic_water", AngelicwterFluid.Flowing::new);
}