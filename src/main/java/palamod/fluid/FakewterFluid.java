
package palamod.fluid;

public abstract class FakewterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> PalamodModFluidTypes.FAKEWTER_TYPE.get(), () -> PalamodModFluids.FAKEWTER.get(), () -> PalamodModFluids.FLOWING_FAKEWTER.get())
			.explosionResistance(100f).slopeFindDistance(5).bucket(() -> PalamodModItems.FAKEWTER_BUCKET.get()).block(() -> (LiquidBlock) PalamodModBlocks.FAKEWTER.get());

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
