package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;

public class UnclaimfinderprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double pourcentage = 0;
		double radius = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0) {
			if (itemstack.getItem() == PalamodModItems.UNCLAIM_FINDER.get()) {
				radius = 8;
			} else if (itemstack.getItem() == PalamodModItems.UNCLAIM_FINDER_ORANGE.get()) {
				radius = 16;
			} else if (itemstack.getItem() == PalamodModItems.UNCLAIM_FINDER_RED.get()) {
				radius = 32;
			} else if (itemstack.getItem() == PalamodModItems.UNCLAIM_FINDER_BLUE.get()) {
				radius = 64;
			}
			{
				final String _tagName = "cooldown";
				final String _tagValue = (itemstack.getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "cooldown";
				final double _tagValue = 20;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "pourcentage";
				final double _tagValue = pourcentage;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (!(entity instanceof Player _plr20 && _plr20.gameMode() == GameType.CREATIVE)) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}