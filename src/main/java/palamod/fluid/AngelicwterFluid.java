package palamod.fluid;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;
import palamod.init.PalamodModBlocks;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class AngelicwterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> PalamodModFluidTypes.ANGELIC_WATER_TYPE.get(), () -> PalamodModFluids.ANGELIC_WATER.get(), () -> PalamodModFluids.FLOWING_ANGELIC_WATER.get())
			.explosionResistance(100f).bucket(() -> PalamodModItems.ANGELIC_WATER_BUCKET.get()).block(() -> (LiquidBlock) PalamodModBlocks.ANGELIC_WATER.get());

	private AngelicwterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends AngelicwterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AngelicwterFluid {
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