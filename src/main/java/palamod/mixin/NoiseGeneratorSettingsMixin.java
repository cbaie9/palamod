package palamod.mixin;

import palamod.init.PalamodModBiomes;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements PalamodModBiomes.PalamodModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> palamod_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.palamod_dimensionTypeReference != null) {
			retval = PalamodModBiomes.adaptSurfaceRule(retval, this.palamod_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setpalamodDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.palamod_dimensionTypeReference = dimensionType;
	}
}