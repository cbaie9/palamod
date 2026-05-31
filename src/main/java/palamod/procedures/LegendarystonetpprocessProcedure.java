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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class LegendarystonetpprocessProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double x = 0;
		double z = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0 || entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) {
			x = Mth.nextInt(RandomSource.create(), -1000000, 100000);
			z = Mth.nextInt(RandomSource.create(), -1000000, 100000);
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(PalamodModItems.LEGENDARY_STONE_TELEPORTATION.get()));
			{
				Entity _ent = entity;
				double _tx = x;
				double _ty = 255;
				double _tz = z;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 9000, 1, false, true));
			{
				final String _tagName = "name";
				final String _tagValue = (new ItemStack(PalamodModItems.LEGENDARY_STONE_TELEPORTATION.get()).getDisplayName().getString());
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