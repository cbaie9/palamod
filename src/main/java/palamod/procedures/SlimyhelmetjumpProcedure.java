package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SlimyhelmetjumpProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer || entity instanceof Player) {
			if (PalamodModItems.TRAVEL_ARMOR_HELMET.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()) {
				if ((!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()))).getBlock() == Blocks.AIR)
						|| !((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()))).getBlock() == Blocks.VOID_AIR)
						|| !((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()))).getBlock() == Blocks.CAVE_AIR))
						&& !world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) && !entity.isShiftKeyDown()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 1, true, false));
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeAllEffects();
				}
			}
		}
	}
}