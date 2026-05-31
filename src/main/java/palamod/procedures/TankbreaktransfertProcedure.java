package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.CompoundTag;

public class TankbreaktransfertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack output = ItemStack.EMPTY;
		if (!(PalamodModItems.CUSTOM_AIR.get() == (ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, entity.getPersistentData().getCompoundOrEmpty("tank_preload")).result().orElse(ItemStack.EMPTY)).getItem())) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (ItemStack.OPTIONAL_CODEC.parse(NbtOps.INSTANCE, entity.getPersistentData().getCompoundOrEmpty("tank_preload")).result().orElse(ItemStack.EMPTY)));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		entity.getPersistentData().put("tank_preload", (CompoundTag) ItemStack.OPTIONAL_CODEC.encode(new ItemStack(PalamodModItems.CUSTOM_AIR.get()), NbtOps.INSTANCE, new CompoundTag()).result().orElseGet(CompoundTag::new));
	}
}