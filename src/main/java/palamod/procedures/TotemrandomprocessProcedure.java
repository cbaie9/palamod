package palamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class TotemrandomprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean apply = false;
		double totem_stock = 0;
		double random_base = 0;
		double random_sound = 0;
		totem_stock = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "totem_stock");
		random_base = Mth.nextInt(RandomSource.create(), 1, 128) + totem_stock;
		apply = false;
		if (random_base > 94) {
			if (apply) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("totem_usure", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "totem_usure") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "totem_usure") > 2) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("totem_stock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "totem_stock") - 1));
							_blockEntity.getPersistentData().putDouble("totem_usure", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					random_sound = Mth.nextInt(RandomSource.create(), 1, 10);
					if (random_sound <= 4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break1")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break1")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					} else if (random_sound <= 8) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break2")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break2")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break3")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("palamod:totem_break3")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}