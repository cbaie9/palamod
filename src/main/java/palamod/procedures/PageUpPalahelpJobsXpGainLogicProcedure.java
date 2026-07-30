package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;

public class PageUpPalahelpJobsXpGainLogicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(Blocks.AIR.asItem() == GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 6).getItem());
	}
}