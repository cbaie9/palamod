
package palamod.potion;

import palamod.procedures.AntifakeOnEffect_delete_nbtProcedure;
import palamod.procedures.AntifakeEffect_add_nbtProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntifakeMobEffect extends MobEffect {
	public AntifakeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13434676);
	}

	@Override
	public String getDescriptionId() {
		return "effect.palamod.antifake";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AntifakeEffect_add_nbtProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AntifakeOnEffect_delete_nbtProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
