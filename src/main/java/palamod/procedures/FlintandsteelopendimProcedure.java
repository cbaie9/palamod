package palamod.procedures;

import palamod.block.MinerdimensionPortalBlock;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FlintandsteelopendimProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getFace(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		execute(null, world, x, y, z, direction, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		double portalX = 0;
		double portalY = 0;
		double portalZ = 0;
		if (Items.FLINT_AND_STEEL == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			portalX = x + direction.getStepX();
			portalY = y + direction.getStepY();
			portalZ = z + direction.getStepZ();
			if (world.isEmptyBlock(BlockPos.containing(portalX, portalY, portalZ))
					|| (world.getBlockState(BlockPos.containing(portalX, portalY, portalZ))).getBlock() == Blocks.FIRE && (world.getBlockState(BlockPos.containing(portalX, portalY, portalZ))).getBlock() == Blocks.SOUL_FIRE) {
				if (world instanceof Level _level)
					MinerdimensionPortalBlock.portalSpawn(_level, BlockPos.containing(portalX, portalY, portalZ));
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}
