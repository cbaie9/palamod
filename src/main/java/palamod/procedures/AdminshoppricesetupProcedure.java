package palamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class AdminshoppricesetupProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble(("price_" + "pala" + "_sell"), 120);
				_blockEntity.getPersistentData().putDouble(("price_" + "pala" + "_buy"), 125);
				_blockEntity.getPersistentData().putDouble(("price_" + "titane" + "_buy"), 110);
				_blockEntity.getPersistentData().putDouble(("price_" + "titane" + "_sell"), 100);
				_blockEntity.getPersistentData().putDouble(("price_" + "ame" + "_buy"), 75);
				_blockEntity.getPersistentData().putDouble(("price_" + "ame" + "_sell"), 70);
				_blockEntity.getPersistentData().putDouble(("price_" + "gold" + "_sell"), 30);
				_blockEntity.getPersistentData().putDouble(("price_" + "gold" + "_buy"), 35);
				_blockEntity.getPersistentData().putDouble(("price_" + "diamond" + "_sell"), 40);
				_blockEntity.getPersistentData().putDouble(("price_" + "diamond" + "_buy"), 45);
				_blockEntity.getPersistentData().putDouble(("price_" + "coal" + "_buy"), 5);
				_blockEntity.getPersistentData().putDouble(("price_" + "coal" + "_sell"), 3);
				_blockEntity.getPersistentData().putDouble(("price_" + "iron" + "_sell"), 15);
				_blockEntity.getPersistentData().putDouble(("price_" + "iron" + "_buy"), 20);
				_blockEntity.getPersistentData().putDouble(("price_" + "findium" + "_buy"), 90);
				_blockEntity.getPersistentData().putDouble(("price_" + "findium" + "_sell"), 85);
				_blockEntity.getPersistentData().putDouble(("price_" + "stone" + "_sell"), 0.1);
				_blockEntity.getPersistentData().putDouble(("price_" + "stone" + "_buy"), 10);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}