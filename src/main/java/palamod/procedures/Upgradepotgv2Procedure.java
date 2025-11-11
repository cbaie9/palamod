package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
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
		Pickaxe_stone_seen = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0);
		potg_fuel = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("potg_fuel", 0);
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GRANITE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIORITE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANDESITE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COBBLESTONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLACKSTONE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERRACK || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:stone")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:multitool_mb")))) {
			{
				final String _tagName = "Pickaxe_stone";
				final double _tagValue = (Pickaxe_stone_seen + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 150000
					&& !(entity instanceof ServerPlayer _plr26 && _plr26.level() instanceof ServerLevel _serverLevel26
							&& _plr26.getAdvancements().getOrStartProgress(_serverLevel26.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack33 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get()).copy();
					_setstack33.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack33);
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
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr46 && _plr46.level() instanceof ServerLevel _serverLevel46
						&& _plr46.getAdvancements().getOrStartProgress(_serverLevel46.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel _serverLevel48
						&& _plr48.getAdvancements().getOrStartProgress(_serverLevel48.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr50 && _plr50.level() instanceof ServerLevel _serverLevel50
						&& _plr50.getAdvancements().getOrStartProgress(_serverLevel50.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_20new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_20new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 88582
					&& !(entity instanceof ServerPlayer _plr54 && _plr54.level() instanceof ServerLevel _serverLevel54
							&& _plr54.getAdvancements().getOrStartProgress(_serverLevel54.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack61 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get()).copy();
					_setstack61.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack61);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = (potg_fuel + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
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
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr76 && _plr76.level() instanceof ServerLevel _serverLevel76
						&& _plr76.getAdvancements().getOrStartProgress(_serverLevel76.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr78 && _plr78.level() instanceof ServerLevel _serverLevel78
						&& _plr78.getAdvancements().getOrStartProgress(_serverLevel78.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 55598
					&& !(entity instanceof ServerPlayer _plr82 && _plr82.level() instanceof ServerLevel _serverLevel82
							&& _plr82.getAdvancements().getOrStartProgress(_serverLevel82.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack89 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get()).copy();
					_setstack89.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack89);
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
				if (!(entity instanceof ServerPlayer _plr102 && _plr102.level() instanceof ServerLevel _serverLevel102
						&& _plr102.getAdvancements().getOrStartProgress(_serverLevel102.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr104 && _plr104.level() instanceof ServerLevel _serverLevel104
						&& _plr104.getAdvancements().getOrStartProgress(_serverLevel104.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 36485
					&& !(entity instanceof ServerPlayer _plr108 && _plr108.level() instanceof ServerLevel _serverLevel108
							&& _plr108.getAdvancements().getOrStartProgress(_serverLevel108.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					auto_smelt = true;
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack115 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get()).copy();
					_setstack115.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack115);
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
				if (!(entity instanceof ServerPlayer _plr130 && _plr130.level() instanceof ServerLevel _serverLevel130
						&& _plr130.getAdvancements().getOrStartProgress(_serverLevel130.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_17new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr132 && _plr132.level() instanceof ServerLevel _serverLevel132
						&& _plr132.getAdvancements().getOrStartProgress(_serverLevel132.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 25242
					&& !(entity instanceof ServerPlayer _plr136 && _plr136.level() instanceof ServerLevel _serverLevel136
							&& _plr136.getAdvancements().getOrStartProgress(_serverLevel136.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack137 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_16.get()).copy();
					_setstack137.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack137);
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
				if (!(entity instanceof ServerPlayer _plr146 && _plr146.level() instanceof ServerLevel _serverLevel146
						&& _plr146.getAdvancements().getOrStartProgress(_serverLevel146.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 14620
					&& !(entity instanceof ServerPlayer _plr150 && _plr150.level() instanceof ServerLevel _serverLevel150
							&& _plr150.getAdvancements().getOrStartProgress(_serverLevel150.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack151 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_15.get()).copy();
					_setstack151.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack151);
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
				if (!(entity instanceof ServerPlayer _plr158 && _plr158.level() instanceof ServerLevel _serverLevel158
						&& _plr158.getAdvancements().getOrStartProgress(_serverLevel158.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 10000
					&& !(entity instanceof ServerPlayer _plr162 && _plr162.level() instanceof ServerLevel _serverLevel162
							&& _plr162.getAdvancements().getOrStartProgress(_serverLevel162.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack163 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_14.get()).copy();
					_setstack163.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack163);
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
				if (!(entity instanceof ServerPlayer _plr170 && _plr170.level() instanceof ServerLevel _serverLevel170
						&& _plr170.getAdvancements().getOrStartProgress(_serverLevel170.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 7804
					&& !(entity instanceof ServerPlayer _plr174 && _plr174.level() instanceof ServerLevel _serverLevel174
							&& _plr174.getAdvancements().getOrStartProgress(_serverLevel174.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack175 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_13.get()).copy();
					_setstack175.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack175);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 5);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr180 && _plr180.level() instanceof ServerLevel _serverLevel180
						&& _plr180.getAdvancements().getOrStartProgress(_serverLevel180.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 6895
					&& !(entity instanceof ServerPlayer _plr184 && _plr184.level() instanceof ServerLevel _serverLevel184
							&& _plr184.getAdvancements().getOrStartProgress(_serverLevel184.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack185 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_12.get()).copy();
					_setstack185.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack185);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 4);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (!(entity instanceof ServerPlayer _plr190 && _plr190.level() instanceof ServerLevel _serverLevel190
						&& _plr190.getAdvancements().getOrStartProgress(_serverLevel190.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("palamod:achmpotg_12new"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 5403
					&& !(entity instanceof ServerPlayer _plr194 && _plr194.level() instanceof ServerLevel _serverLevel194
							&& _plr194.getAdvancements().getOrStartProgress(_serverLevel194.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack195 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_11.get()).copy();
					_setstack195.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack195);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 3);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 4326
					&& !(entity instanceof ServerPlayer _plr202 && _plr202.level() instanceof ServerLevel _serverLevel202
							&& _plr202.getAdvancements().getOrStartProgress(_serverLevel202.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack203 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_10.get()).copy();
					_setstack203.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack203);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 2);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 3542
					&& !(entity instanceof ServerPlayer _plr210 && _plr210.level() instanceof ServerLevel _serverLevel210
							&& _plr210.getAdvancements().getOrStartProgress(_serverLevel210.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack211 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_9.get()).copy();
					_setstack211.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack211);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 1);
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 2138
					&& !(entity instanceof ServerPlayer _plr218 && _plr218.level() instanceof ServerLevel _serverLevel218
							&& _plr218.getAdvancements().getOrStartProgress(_serverLevel218.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack219 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_8.get()).copy();
					_setstack219.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack219);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 1589
					&& !(entity instanceof ServerPlayer _plr224 && _plr224.level() instanceof ServerLevel _serverLevel224
							&& _plr224.getAdvancements().getOrStartProgress(_serverLevel224.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack225 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_7.get()).copy();
					_setstack225.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack225);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 1370
					&& !(entity instanceof ServerPlayer _plr230 && _plr230.level() instanceof ServerLevel _serverLevel230
							&& _plr230.getAdvancements().getOrStartProgress(_serverLevel230.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack231 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_6.get()).copy();
					_setstack231.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack231);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 1172
					&& !(entity instanceof ServerPlayer _plr236 && _plr236.level() instanceof ServerLevel _serverLevel236
							&& _plr236.getAdvancements().getOrStartProgress(_serverLevel236.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack237 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_5.get()).copy();
					_setstack237.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack237);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 757
					&& !(entity instanceof ServerPlayer _plr242 && _plr242.level() instanceof ServerLevel _serverLevel242
							&& _plr242.getAdvancements().getOrStartProgress(_serverLevel242.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack243 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_4.get()).copy();
					_setstack243.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack243);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 250
					&& !(entity instanceof ServerPlayer _plr248 && _plr248.level() instanceof ServerLevel _serverLevel248
							&& _plr248.getAdvancements().getOrStartProgress(_serverLevel248.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack249 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_3.get()).copy();
					_setstack249.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack249);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0) >= 100
					&& !(entity instanceof ServerPlayer _plr254 && _plr254.level() instanceof ServerLevel _serverLevel254
							&& _plr254.getAdvancements().getOrStartProgress(_serverLevel254.getServer().getAdvancements().get(ResourceLocation.parse("palamod:advinvicrea"))).isDone())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack255 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_2.get()).copy();
					_setstack255.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack255);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					final String _tagName = "Pickaxe_stone";
					final double _tagValue = (Pickaxe_stone_seen + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0
				&& (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_MIXED_CHARCOAL.get()))
						|| 0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("potg_fuel", 0))) {
			if (2 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					Bighole2smeltProcedure.execute(world, x, y, z, entity);
				} else {
					Bighole2Procedure.execute(world, x, y, z, entity);
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
					HammersmeltProcedure.execute(world, x, y, z, entity);
				} else {
					HammernormalProcedure.execute(world, x, y, z, entity);
				}
			}
			if (0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("potg_fuel", 0)) {
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("potg_fuel", 0) - 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_MIXED_CHARCOAL.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				{
					final String _tagName = "potg_fuel";
					final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("potg_fuel", 0) + 2500);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0 && world instanceof ServerLevel _level284
				&& _level284.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _level284).isPresent()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())))));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static ItemStack getItemStackFromItemStackSlot(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput, serverLevel.registryAccess()).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}