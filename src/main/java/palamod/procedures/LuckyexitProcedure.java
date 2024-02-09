package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class LuckyexitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double destroy = 0;
		if (PalamodModVariables.Lucky_destroy == 1) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL) == true) {
				PalamodMod.LOGGER.info(("(" + entity.getDisplayName().getString() + " ) Fermeture de l'interface lucky block apr\u00E8s ouverture [ code 1 ]"));
			}
		} else if (PalamodModVariables.Lucky_destroy == 2) {
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL) == true) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Ferme un lucky block ( Event non Ajout\uFFFD ) [ code 2 ]"));
			}
		} else if (PalamodModVariables.Lucky_destroy == 0) {
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL) == true) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Ferme un lucky block ( echap ) [ code 0 ]"));
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL) == true) {
				PalamodMod.LOGGER.info(("(" + entity.getDisplayName().getString() + " ) Fermeture de l'interface lucky block apr\u00E8s ouverture sans renplacement [ code 3 ]"));
			}
		}
	}
}
