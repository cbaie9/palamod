package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class TrixiumscoreProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getPersistentData().getStringOr("language", "")).equals("french")) {
			if (entity instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal(("Votre nombre de trixium accumul\u00E9e est de  " + getBlockNBTNumber(world, new BlockPos(0, 11, 0), ("trixium_score_" + entity.getDisplayName().getString())))), false);
		} else {
			if (entity instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal(("Your trxium score is  " + getBlockNBTNumber(world, new BlockPos(0, 11, 0), ("trixium_score_" + entity.getDisplayName().getString())))), false);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}