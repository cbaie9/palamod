package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;

public class PageDownPalahelpJobsXpGainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(Blocks.AIR.asItem() == GetItemPalahelpJobsXpgainProcedure.execute(entity, true, -1).getItem())) {
			entity.getPersistentData().putDouble("indexSlider", (entity.getPersistentData().getDouble("indexSlider") - 1));
			FillSlotPalahelpXpGainProcedure.execute(entity);
		}
	}
}