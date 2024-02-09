
package palamod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PoisonimbueMobEffect extends MobEffect {
	public PoisonimbueMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737997);
	}

	@Override
	public String getDescriptionId() {
		return "effect.palamod.poisonimbue";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
