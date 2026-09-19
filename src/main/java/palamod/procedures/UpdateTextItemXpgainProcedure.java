package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class UpdateTextItemXpgainProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double xloop = 0;
		for (xloop = (double) 0; xloop <= (double) 5; xloop++) {
			entity.getPersistentData().putString(("xpgain_getTextItemName_" + Math.round(xloop)), GetTextNameGainJobsPalahelpProcedure.execute(world, entity, xloop));
			entity.getPersistentData().putDouble(("xpgain_getSpriteNum_" + Math.round(xloop)), GetSpriteNumGainJobsPalahelpProcedure.execute(world, entity, xloop));
		}
		/*POV : when you have to make custom code to write a single loop*/
	}
}