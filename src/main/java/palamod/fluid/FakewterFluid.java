package palamod.fluid;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class FakewterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PalamodModFluidTypes.FAKE_WATER_TYPE.get(), () -> PalamodModFluids.FAKE_WATER.get(), () -> PalamodModFluids.FLOWING_FAKE_WATER.get())
			.explosionResistance(100f).slopeFindDistance(5).bucket(() -> PalamodModItems.FAKE_WATER_BUCKET.get()).block(() -> (LiquidBlock) PalamodModBlocks.FAKE_WATER.get());

	private FakewterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends FakewterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends FakewterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}