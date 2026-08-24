package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class Upgradepotgv3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double pickaxe_xp = 0;
		double pickaxe_level = 0;
		double efficiency = 0;
		double fortune = 0;
		double big_hole = 0;
		ItemStack main_hand = ItemStack.EMPTY;
		ItemStack potg = ItemStack.EMPTY;
		boolean smelt = false;
		main_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (main_hand.isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z))))) {
			{
				final String _tagName = "Pickaxe_stone";
				final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			pickaxe_xp = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone");
			pickaxe_level = GetLevelPotgProcedure.execute(pickaxe_xp);
			potg = GetPotGfromLevelProcedure.execute(pickaxe_level).copy();
			if (!(potg.getItem() == main_hand.getItem())) {
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = pickaxe_xp;
					CustomData.update(DataComponents.CUSTOM_DATA, potg, tag -> tag.putDouble(_tagName, _tagValue));
				}
				efficiency = pickaxe_level >= 0 && pickaxe_level <= 13 ? pickaxe_level - 8 : 5;
				fortune = pickaxe_level >= 0 && pickaxe_level <= 16 ? pickaxe_level - 13 : 3;
				big_hole = main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				smelt = main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0;
				if (efficiency > 0) {
					potg.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), (int) efficiency);
				}
				if (fortune > 0) {
					potg.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), (int) fortune);
				}
				if (big_hole > 0) {
					potg.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), (int) big_hole);
				}
				if (smelt) {
					potg.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
				}
				PalamodMod.LOGGER.debug("[Upgrade_potg_v3]: Changing Potg Level");
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack18 = potg.copy();
					_setstack18.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack18);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (!(entity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel && _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())
					&& pickaxe_level >= 12) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (!(entity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel && _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())
					&& pickaxe_level >= 17) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (!(entity instanceof ServerPlayer _plr23 && _plr23.level() instanceof ServerLevel && _plr23.getAdvancements().getOrStartProgress(_plr23.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_20new"))).isDone())
					&& pickaxe_level >= 20) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_20new"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (!(entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_1"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		MoucePogProcessProcedure.execute(entity, true);
		PotgenchantProcedure.execute(world, x, y, z, entity);
	}
}