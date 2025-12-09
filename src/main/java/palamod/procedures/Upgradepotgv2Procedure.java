package palamod.procedures;

import palamod.init.PalamodModItems;

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
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class Upgradepotgv2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean auto_smelt = false;
		double big_hole = 0;
		double Pickaxe_stone_seen = 0;
		double potg_fuel = 0;
		ItemStack main_hand = ItemStack.EMPTY;
		main_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal((main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") + "" + main_hand.isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z)))))), false);
		Pickaxe_stone_seen = main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone");
		potg_fuel = main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("potg_fuel");
		if (main_hand.isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z))))) {
			if (main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 150000) {
				if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack13 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get()).copy();
					_setstack13.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
				if (auto_smelt) {
					main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
				} else if (0 < big_hole) {
					main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), (int) big_hole);
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, main_hand, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, main_hand, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr20 && _plr20.level() instanceof ServerLevel && _plr20.getAdvancements().getOrStartProgress(_plr20.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
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
				if (!(entity instanceof ServerPlayer _plr22 && _plr22.level() instanceof ServerLevel && _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
				if (!(entity instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_20new"))).isDone())) {
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
			} else if (main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 88582) {
				if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack30 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get()).copy();
					_setstack30.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack30);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, main_hand, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, main_hand, tag -> tag.putDouble(_tagName, _tagValue));
				}
				main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
				if (auto_smelt) {
					main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
				} else if (0 < big_hole) {
					main_hand.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), (int) big_hole);
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, main_hand, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr38 && _plr38.level() instanceof ServerLevel && _plr38.getAdvancements().getOrStartProgress(_plr38.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
				if (!(entity instanceof ServerPlayer _plr40 && _plr40.level() instanceof ServerLevel && _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
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
			} else if (main_hand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 55598) {
				if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if (main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = main_hand.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack46 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get()).copy();
					_setstack46.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack46);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), (int) big_hole);
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel && _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
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
				if (!(entity instanceof ServerPlayer _plr61 && _plr61.level() instanceof ServerLevel && _plr61.getAdvancements().getOrStartProgress(_plr61.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 36485) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack71 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get()).copy();
					_setstack71.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack71);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))), (int) big_hole);
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr86 && _plr86.level() instanceof ServerLevel && _plr86.getAdvancements().getOrStartProgress(_plr86.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
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
				if (!(entity instanceof ServerPlayer _plr88 && _plr88.level() instanceof ServerLevel && _plr88.getAdvancements().getOrStartProgress(_plr88.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 25242) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack92 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_16.get()).copy();
					_setstack92.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack92);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr101 && _plr101.level() instanceof ServerLevel
						&& _plr101.getAdvancements().getOrStartProgress(_plr101.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 14620) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack105 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_15.get()).copy();
					_setstack105.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack105);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 2);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr112 && _plr112.level() instanceof ServerLevel
						&& _plr112.getAdvancements().getOrStartProgress(_plr112.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 10000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack116 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_14.get()).copy();
					_setstack116.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack116);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 1);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr123 && _plr123.level() instanceof ServerLevel
						&& _plr123.getAdvancements().getOrStartProgress(_plr123.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 7804) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack127 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_13.get()).copy();
					_setstack127.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack127);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr132 && _plr132.level() instanceof ServerLevel
						&& _plr132.getAdvancements().getOrStartProgress(_plr132.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 6895) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack136 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_12.get()).copy();
					_setstack136.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack136);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 4);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr141 && _plr141.level() instanceof ServerLevel
						&& _plr141.getAdvancements().getOrStartProgress(_plr141.server.getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
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
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 5403) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack145 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_11.get()).copy();
					_setstack145.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack145);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 3);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 4326) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack152 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_10.get()).copy();
					_setstack152.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack152);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 2);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 3542) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack159 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_9.get()).copy();
					_setstack159.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack159);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 1);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 2138) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack166 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_8.get()).copy();
					_setstack166.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack166);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1589) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack171 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_7.get()).copy();
					_setstack171.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack171);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1370) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack176 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_6.get()).copy();
					_setstack176.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack176);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1172) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack181 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_5.get()).copy();
					_setstack181.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack181);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 757) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack186 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_4.get()).copy();
					_setstack186.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack186);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 250) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack191 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_3.get()).copy();
					_setstack191.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack191);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 100) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack196 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_2.get()).copy();
					_setstack196.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack196);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else {
				PalamodMod.LOGGER.debug("+1potg");
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		}
		PotgenchantProcedure.execute(world, x, y, z, entity);
	}
}