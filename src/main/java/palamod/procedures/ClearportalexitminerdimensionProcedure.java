package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class ClearportalexitminerdimensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int horizontalRadiusSquare = (int) 5 - 1;
		int verticalRadiusSquare = (int) 5 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if (Math.random() < 0.125 && (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == PalamodModBlocks.WITHEREDOBSIDIAN_13.get()) {
						world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), PalamodModBlocks.WITHEREDOBSIDIAN_0.get().defaultBlockState(), 3);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + xi, y + i, z + zi), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.deepslate.break")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x + xi, y + i, z + zi, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.deepslate.break")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
