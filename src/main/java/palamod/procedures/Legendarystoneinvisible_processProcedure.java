package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class Legendarystoneinvisible_processProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0 || entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 9000, 1, false, false));
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(PalamodModItems.LEGENDARY_STONE_INVISIBLE.get()));
			{
				final String _tagName = "name";
				final String _tagValue = (new ItemStack(PalamodModItems.LEGENDARY_STONE_INVISIBLE.get()).getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "cooldown";
				final double _tagValue = 48000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}