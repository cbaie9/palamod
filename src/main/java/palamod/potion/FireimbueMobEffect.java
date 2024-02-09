
package palamod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FireimbueMobEffect extends MobEffect {
	public FireimbueMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65536);
	}

	@Override
	public String getDescriptionId() {
		return "effect.palamod.fireimbue";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
