
package palamod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MineurFouMobEffect extends MobEffect {
	public MineurFouMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16776961);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
