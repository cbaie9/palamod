package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class CompactedobsidianOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE)) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.OBSIDIAN.defaultBlockState(), 3);
		}
	}
}