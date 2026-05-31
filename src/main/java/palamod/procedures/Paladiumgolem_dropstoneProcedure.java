package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class Paladiumgolem_dropstoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		new ItemStack(PalamodModItems.GUARDIAN_STONE.get()).set(DataComponents.CUSTOM_NAME, Component.literal(("Guardian stone - Contain  " + entity.getPersistentData().getDoubleOr("Golem_level", 0) + " level Golem")));
		{
			final String _tagName = "golem_kac";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()), tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			final String _tagName = "golem_level";
			final double _tagValue = (entity.getPersistentData().getDoubleOr("Golem_level", 0));
			CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()), tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (true) {
			{
				final String _tagName = "golem_whitelist";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if (true) {
			{
				final String _tagName = "golem_name";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		{
			final String _tagName = "golem_name";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, new ItemStack(PalamodModItems.GUARDIAN_STONE.get()), tag -> tag.putBoolean(_tagName, _tagValue));
		}
	}
}