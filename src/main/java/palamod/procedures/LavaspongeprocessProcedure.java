package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class LavaspongeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		int horizontalRadiusSphere = (int) 6 - 1;
		int verticalRadiusSphere = (int) 6 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.LAVA) {
							world.levelEvent(2001, BlockPos.containing(x + xi, y + i, z + zi), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
							world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = PalamodModBlocks.WET_LAVA_SPONGE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
						}
					}
				}
			}
		}
	}
}