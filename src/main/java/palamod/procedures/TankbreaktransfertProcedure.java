package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class TankbreaktransfertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack output = ItemStack.EMPTY;
		if (!(PalamodModItems.CUSTOM_AIR.get() == (ItemStack.parseOptional(entity.level().registryAccess(), entity.getPersistentData().getCompound("tank_preload"))).getItem())) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (ItemStack.parseOptional(entity.level().registryAccess(), entity.getPersistentData().getCompound("tank_preload"))));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		{
			Entity _entity4 = entity;
			_entity4.getPersistentData().put("tank_preload", new ItemStack(PalamodModItems.CUSTOM_AIR.get()).saveOptional(_entity4.level().registryAccess()));
		}
	}
}