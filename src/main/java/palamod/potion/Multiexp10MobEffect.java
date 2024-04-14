
package palamod.potion;

import palamod.procedures.Removemultixp10fileProcedure;
import palamod.procedures.Addmultixp10fileProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class Multiexp10MobEffect extends MobEffect {
	public Multiexp10MobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027264);
	}

	@Override
	public String getDescriptionId() {
		return "effect.palamod.multiexp_10";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		Addmultixp10fileProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Removemultixp10fileProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
