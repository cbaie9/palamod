package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class OstryasapplinggrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean bone_meal = false;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			bone_meal = true;
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL && Math.random() < 0.5) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 6, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.AIR
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.CAVE_AIR && (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(BlockPos.containing(x, y + 5, z))).getBlock() == Blocks.CAVE_AIR && (world.getBlockState(BlockPos.containing(x, y + 6, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.CAVE_AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.CAVE_AIR && (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.CAVE_AIR) {
					world.addParticle(ParticleTypes.SPIT, x, y, z, 0, 1, 0);
					world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 2, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 3, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 4, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 5, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 6, z), PalamodModBlocks.OSTRYA_WOOD_LOG.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 7, z), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 3, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 3, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 3, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 3, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y + 3, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y + 3, z - 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y + 3, z - 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z - 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 3, z + 2), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 3, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y + 3, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 4, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 0, y + 4, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 4, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 4, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 4, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 4, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 4, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 4, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 4, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 4, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 5, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 5, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 0, y + 5, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 0, y + 5, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y + 6, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y + 6, z + 0), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 0, y + 6, z + 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 0, y + 6, z - 1), PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
