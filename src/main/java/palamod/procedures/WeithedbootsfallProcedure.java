package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WeithedbootsfallProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == PalamodModItems.WEIGHTED_BOOTS.get()) {
			PalamodMod.queueServerWork(2, () -> {
				if (entity.onGround() && entity.isAlive()) {
					PalamodModVariables.jump_ecr = PalamodModVariables.jump_y - y;
				}
				if (!(PalamodModVariables.jump_y == PalamodModVariables.jump_ecr || PalamodModVariables.jump_y < PalamodModVariables.jump_ecr)) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, Math.round((PalamodModVariables.jump_ecr / 100) * 16), Level.ExplosionInteraction.TNT);
				}
			});
		}
	}
}
