package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.Identifier;

public class HasunclaiminhandProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean ouput = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(Identifier.parse("palamod:unclaim_finder")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(Identifier.parse("palamod:unclaim_finder")))) {
			ouput = true;
		} else {
			ouput = false;
		}
		return ouput;
	}
}