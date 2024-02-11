package palamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class SealedxpbottleprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xp_point = 0;
		double xp_lvl_counter = 0;
		double get_needed_xp = 0;
		double get_precise_xppoint = 0;
		double get_xp_output = 0;
		xp_lvl_counter = entity instanceof Player _plr ? _plr.experienceLevel : 0;
		if (32 <= (entity instanceof Player _plr ? _plr.experienceLevel : 0)) {
			xp_point = 4.5 * xp_lvl_counter * xp_lvl_counter - 162.5 * xp_lvl_counter + 2220;
			get_precise_xppoint = Math.abs((4.5 * xp_lvl_counter * xp_lvl_counter - 162.5 * xp_lvl_counter + 2220 + (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0))
					- (4.5 * (xp_lvl_counter + 1) * (xp_lvl_counter + 1) - 162.5 * (xp_lvl_counter + 1) + 2220));
		} else if (32 > (entity instanceof Player _plr ? _plr.experienceLevel : 0) && 17 <= (entity instanceof Player _plr ? _plr.experienceLevel : 0)) {
			xp_point = 2.5 * xp_lvl_counter * xp_lvl_counter - 40.5 * xp_lvl_counter + 360;
			get_precise_xppoint = Math.abs((2.5 * xp_lvl_counter * xp_lvl_counter - 40.5 * xp_lvl_counter + 360 + (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0))
					- (2.5 * (xp_lvl_counter + 1) * (xp_lvl_counter + 1) - 40.5 * (xp_lvl_counter + 1) + 360));
		} else {
			xp_point = xp_lvl_counter * xp_lvl_counter + 6 * xp_lvl_counter;
			get_precise_xppoint = Math.abs((xp_lvl_counter * xp_lvl_counter + 6 * xp_lvl_counter + (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0)) - ((xp_lvl_counter + 1) * (xp_lvl_counter + 1) + 6 * (xp_lvl_counter + 1)));
		}
		if (entity.isShiftKeyDown()) {
			if (30 <= itemstack.getOrCreateTag().getDouble("levels_stock")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.sealed_xp").getString())), false);
			} else if (29 >= itemstack.getOrCreateTag().getDouble("levels_stock") && 17 <= itemstack.getOrCreateTag().getDouble("levels_stock")) {
				get_needed_xp = (2.5 * (itemstack.getOrCreateTag().getDouble("levels_stock") + 1) * (itemstack.getOrCreateTag().getDouble("levels_stock") + 1) - 40.5 * Math.round(itemstack.getOrCreateTag().getDouble("levels_stock") + 1) + 360)
						- (2.5 * itemstack.getOrCreateTag().getDouble("levels_stock") * itemstack.getOrCreateTag().getDouble("levels_stock") - 40.5 * Math.round(itemstack.getOrCreateTag().getDouble("levels_stock")) + 360);
				if (xp_point + get_precise_xppoint >= get_needed_xp) {
					itemstack.getOrCreateTag().putDouble("levels_stock", (itemstack.getOrCreateTag().getDouble("levels_stock") + 1));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-((int) get_needed_xp));
				}
			} else if (0 < itemstack.getOrCreateTag().getDouble("levels_stock") && 16 >= itemstack.getOrCreateTag().getDouble("levels_stock")) {
				get_needed_xp = ((itemstack.getOrCreateTag().getDouble("levels_stock") + 1) * (itemstack.getOrCreateTag().getDouble("levels_stock") + 1) + 6 * (itemstack.getOrCreateTag().getDouble("levels_stock") + 1))
						- (itemstack.getOrCreateTag().getDouble("levels_stock") * itemstack.getOrCreateTag().getDouble("levels_stock") + 6 * itemstack.getOrCreateTag().getDouble("levels_stock"));
				if (xp_point + get_precise_xppoint >= get_needed_xp) {
					itemstack.getOrCreateTag().putDouble("levels_stock", (itemstack.getOrCreateTag().getDouble("levels_stock") + 1));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-((int) get_needed_xp));
				}
			} else if (0 == itemstack.getOrCreateTag().getDouble("levels_stock")) {
				if (xp_point + get_precise_xppoint >= 7) {
					itemstack.getOrCreateTag().putDouble("levels_stock", (itemstack.getOrCreateTag().getDouble("levels_stock") + 1));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-(7));
				}
			}
		} else {
			if (0 < itemstack.getOrCreateTag().getDouble("levels_stock")) {
				if (30 >= itemstack.getOrCreateTag().getDouble("levels_stock") && 17 <= itemstack.getOrCreateTag().getDouble("levels_stock")) {
					get_xp_output = 2.5 * itemstack.getOrCreateTag().getDouble("levels_stock") * itemstack.getOrCreateTag().getDouble("levels_stock") - 40.5 * itemstack.getOrCreateTag().getDouble("levels_stock") + 360;
				} else {
					get_xp_output = itemstack.getOrCreateTag().getDouble("levels_stock") * itemstack.getOrCreateTag().getDouble("levels_stock") + 6 * itemstack.getOrCreateTag().getDouble("levels_stock");
				}
				itemstack.getOrCreateTag().putDouble("levels_stock", 0);
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) (get_xp_output + 2));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.55);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.55, false);
					}
				}
			}
		}
	}
}
