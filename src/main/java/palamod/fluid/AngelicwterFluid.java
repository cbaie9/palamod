
package palamod.fluid;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;
import palamod.init.PalamodModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class AngelicwterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> PalamodModFluidTypes.ANGELICWTER_TYPE.get(), () -> PalamodModFluids.ANGELICWTER.get(), () -> PalamodModFluids.FLOWING_ANGELICWTER.get())
			.explosionResistance(100f).bucket(() -> PalamodModItems.ANGELICWTER_BUCKET.get()).block(() -> (LiquidBlock) PalamodModBlocks.ANGELICWTER.get());

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
